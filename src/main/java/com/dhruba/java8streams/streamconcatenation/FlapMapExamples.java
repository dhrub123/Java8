package com.dhruba.java8streams.streamconcatenation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FlapMapExamples {
	
	public static void main(String[] args) {
		
		try {
			Stream<String> stream1 = Files.lines(Paths.get("src/main/resources/Text1.txt"));
			Stream<String> stream2 = Files.lines(Paths.get("src/main/resources/Text2.txt"));
			Stream<String> stream3 = Files.lines(Paths.get("src/main/resources/Text3.txt"));
			Stream<String> stream4 = Files.lines(Paths.get("src/main/resources/Text4.txt"));
			
			//System.out.println("Stream 1 : " + stream1.count());//10
			//System.out.println("Stream 2 : " + stream2.count());//12
			//System.out.println("Stream 3 : " + stream3.count());//7
			//System.out.println("Stream 4 : " + stream4.count());//7
			
			Stream<Stream<String>> streamofStreams = Stream.of(stream1, stream2, stream3, stream4);
			//System.out.println("# streams: " + streamofStreams.count());
			
			
			//count number of lines
			//it will take contents of 4 stream and put it to a new stream
			//Stream<String> streamOfLines = streamofStreams.flatMap(stream -> stream);
			//below does the same as above
			Stream<String> streamOfLines = streamofStreams.flatMap(Function.identity());
			//System.out.println("# lines: " + streamOfLines.count());
			
			
			//count words
			Function<String, Stream<String>> lineSplitter = line -> Pattern.compile(" ").splitAsStream(line);
			//Stream<String> streamOfWords = streamOfLines.flatMap(lineSplitter);
			//System.out.println("# words: " + streamOfWords.count());//354
			
			/*Stream streamOfWords = streamOfLines.
										flatMap(lineSplitter).
										map(word -> word.toLowerCase()).
										distinct();
			System.out.println("# words: " + streamOfWords.count());//187 lower case words
			*/
			
			Stream streamOfWords = streamOfLines.
					flatMap(lineSplitter).
					map(word -> word.toLowerCase()).
					filter(word -> word.length() == 4).
					distinct();
			System.out.println("# words: " + streamOfWords.count());//24 lower case words with alphabets = 4
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
