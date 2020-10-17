package com.dhruba.java8streams.collectors;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.dhruba.java8streams.collectors.model.Actor;
import com.dhruba.java8streams.collectors.model.Movie;

public class MovieActor {

	public static void main(String[] args) {
		
		MovieActor movieActor = new MovieActor();
		Set<Movie> movieSet = movieActor.readMovies();
		System.out.println("# of movies = " + movieSet.size());
		
		//The following is wrong pattern since we are not using set
		long numberOfActors = movieSet
			.stream()
			.flatMap(movie -> movie.getActors().stream()) // Stream<Actor>
			.collect(Collectors.toSet())
			.size();
		
		System.out.println("# of actors = " + numberOfActors);
		
		//The right pattern is 
		numberOfActors = movieSet
			.stream()
			.flatMap(movie -> movie.getActors().stream()) // Stream<Actor>
			.distinct()
			.count();
			
		System.out.println("# of actors = " + numberOfActors);
		
		//Actor that played in greatest number of movies
		
		Map.Entry<Actor, Long> mostViewedActor = 
		movieSet.stream()
				.flatMap(movie -> movie.getActors().stream()) //Stream<Actor>
				.collect(Collectors.groupingBy(Function.identity()/*actor -> actor*/, Collectors.counting()))
				.entrySet()
				.stream() //Stream<Map.Entry<Actor, Long>>
				.max(Map.Entry.comparingByValue())//Comparator.comparing(entry -> entry.getValue()))
				.get();
		
		System.out.println("Most viewed Actor : " + mostViewedActor);
		
		//Actor that played in greatest number of movies during a year
		//Map<release years, Map<Actor, # of movies during that year>>
		
		Entry<Integer, Entry<Actor, AtomicLong>> entry3 
		= movieSet.stream()
				.collect(
						Collectors.groupingBy(
								movie -> movie.getReleaseYear(),
								//we are building the custom collector here
								Collector.of(
										() -> new HashMap<Actor, AtomicLong>(),//supplier
										//accumulator
										(map, movie) -> {
											movie.getActors().forEach(
													actor -> map.computeIfAbsent(actor, a -> new AtomicLong()).incrementAndGet()
											);
										},//accumulator
										//combiner
										(map1, map2) -> {
											map2.entrySet().forEach(
													entry2 -> map1.merge(
														entry2.getKey(), entry2.getValue(),
														(al1, al2) -> {
															al1.addAndGet(al2.get());
															return al1;
														}
													)
											);
											return map1;
										},//combiner
										Collector.Characteristics.IDENTITY_FINISH
								)
						)
				)//Map<Integer, HashMap<Actor, AtomicLong>>
				.entrySet()
				.stream()
				.collect(
					Collectors.toMap(
							entry -> entry.getKey(),
							entry -> entry
										.getValue()
										.entrySet()
										.stream()
										.max(
											Map.Entry.comparingByValue(Comparator.comparing(l -> l.get()))
										)
										.get()
					)
				) //Map<Integer, Map.Entry<Actor, AtomicLong>>
				.entrySet()
				.stream()
				.max(
						Map.Entry.comparingByValue(
							Comparator.comparing(entry -> entry.getValue().get())
						)
				)
				.get();//Map.Entry<Integer, Map.Entry<Actor, AtomicLong>>
		
		System.out.println("Most seen Actor = " + entry3);
		
	}
	
	public Set<Movie> readMovies(){
		try(Stream<String> lines = Files.lines(Paths.get("/Users/dhruba/git/JavaFundamentals/src/main/resources/movies-mpaa.txt"), StandardCharsets.ISO_8859_1)){
			
			Set<Movie> movies = lines.map((String line) -> {
				String[] elements = line.split("/");
				String title = extractTitle(elements[0]);
				String releaseYear = extractReleaseYear(elements[0]);
				
				Movie movie = new Movie(title, Integer.valueOf(releaseYear));
				Arrays.stream(elements).skip(1).map(MovieActor::extractActor).forEach(movie::addActor);
				return movie;
			}).collect(Collectors.toSet());
			
			return movies;
		}catch(IOException iex) {
			System.out.println(iex.getMessage());
		}
		return null;
	}
	
	
	
	public static Actor extractActor(String elements) {
		String[] nameElements = elements.split(", ");
		String lastName = extractLastName(nameElements);
		String firstName = extractFirstName(nameElements);
		return new Actor(lastName, firstName);
	}
	
	private static String extractFirstName(String[] nameElements) {
		String firstName = "";
		if (nameElements.length > 1) {
			firstName = nameElements[1].trim();
		}
		return firstName;
	}

	private static String extractLastName(String[] name) {
		return name[0].trim();
	}

	private static String extractReleaseYear(String element) {
		String releaseYear = element.substring(element.lastIndexOf("(") + 1, element.lastIndexOf(")"));
		if (releaseYear.contains(","))
			releaseYear = releaseYear.substring(0, releaseYear.indexOf(","));
		return releaseYear;
	}

	private static String extractTitle(String element) {
		return element.substring(0, element.lastIndexOf("(")).trim();
	}

}
