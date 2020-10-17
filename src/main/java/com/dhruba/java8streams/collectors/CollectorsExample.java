package com.dhruba.java8streams.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

	public static void main(String[] args) {
		
		Path shakespearePath = Paths.get("src/main/resources/words.shakespeare.txt");
		Path ospdPath = Paths.get("src/main/resources/ospd.txt");
		
		try(
			Stream<String> shakespeare = Files.lines(shakespearePath);
			Stream<String> scrabble = Files.lines(ospdPath);
		){
			
			Set<String> shakespeareWords = shakespeare.collect(Collectors.toSet());
			Set<String> scrabbleWords = scrabble.collect(Collectors.toSet());
				
			System.out.println("# words of Shakespeare : " + shakespeareWords.size());//23688
			System.out.println("# words of Scrabble : " + scrabbleWords.size());//79339
			
			final int [] letterScores = {
					//a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p, q,r,s,t,u,v,w,x,y,z
					  1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10	
			};
			
			Function<String, Integer> score = word -> word.toLowerCase().chars()
					  .map(letter -> letterScores[letter - 'a'])
					  .sum();
			
			Map<Integer, List<String>> histogramWordsByScore = 
					shakespeareWords
							.stream()
							.filter(scrabbleWords::contains)//.filter( words -> scrabbleWords.contains(words))
							.collect(Collectors.groupingBy(score));
			
			System.out.println("# histogramWordsByScore = " + histogramWordsByScore.size());
			
			histogramWordsByScore.entrySet() //Set<Map.Entry<Integer, List<String>>>
								 .stream()
								 .sorted(Comparator.comparing(entry -> -entry.getKey()))//sort by keys descending
								 .limit(3)
								 .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
			
			int [] scrabbleEndDistribution = {
					//a,b,c,d,e ,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
					  9,2,2,1,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1
			};
			
			Function<String, Map<Integer, Long>> histogramWord = 
					word -> word.chars().boxed()
								.collect(Collectors.groupingBy(letter -> letter,Collectors.counting()));
			
			Function<String , Long> numberOfBlanks = 
					word -> histogramWord.apply(word)//Map<Integer, Long> Map<letter, # of Letters>
										 .entrySet()
										 .stream() //Map.Entry<Integer, Long>
										 .mapToLong(
												 	entry -> 
												 		Long.max(
												 				entry.getValue() - 
															 	(long)scrabbleEndDistribution[entry.getKey() - 'a'],
															 	0L
												 		)
												 )
										 .sum();
			System.out.println("# of blanks for whizzing = " + numberOfBlanks.apply("whizzing"));
			
			Function<String, Integer> updatedScore = 
					word -> histogramWord.apply(word)
										 .entrySet()
										 .stream()
										 .mapToInt(
												 entry ->
												 		letterScores[entry.getKey() - 'a']*
												 		Integer.min(	
													 		entry.getValue().intValue(),
													 		scrabbleEndDistribution[entry.getKey() - 'a']
												 		)
												 )
										 .sum();
			
			System.out.println("updated score of whizzing = " + updatedScore.apply("whizzing"));	
			
			//Map<Integer, List<String>> updatedHistogramWordsByScore = 
					shakespeareWords
							.stream()
							.filter(scrabbleWords::contains)
							.filter(word -> numberOfBlanks.apply(word) <= 2)
							.collect(Collectors.groupingBy(updatedScore))
							.entrySet() //Set<Map.Entry<Integer, List<String>>>
							.stream()
							.sorted(Comparator.comparing(entry -> -entry.getKey()))//sort by keys descending
							.limit(3)
							.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
