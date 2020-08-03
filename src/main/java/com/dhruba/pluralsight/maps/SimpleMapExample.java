package com.dhruba.pluralsight.maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleMapExample {
	public static void main(String[] args) {
		
		List<Person> people = StreamUtilForMaps.readFile("peopleWithAgeAndGender.txt");
		
		//create 2 lists out of the sublist
		List<Person> peopleList1 = people.subList(1, 10);
		List<Person> peopleList2 = people.subList(10, people.size());
		
		//create 2 hashmaps
		Map<Integer, List<Person>> map1 = mapByAge(peopleList1);
		System.out.println("-----------");
		Map<Integer, List<Person>> map2 = mapByAge(peopleList2);
		System.out.println("-----------");
		
		//merge2Maps map1 will become superset now
		map2.entrySet().stream()
					   .forEach(//entryset holds an entry which is key and value pair(integer and list)
							   entry -> 
							   map1.merge(
										   entry.getKey(), 
										   entry.getValue(), 
										   (l1,l2) -> {//l1 is existing list associated with key in map1 and l2 is list in entry associated with that key
											   l1.addAll(l2);
											   return l1;
										   }
									   )
				
							   );
		map1.forEach((age, list) -> System.out.println(age + " - " + list));
		System.out.println("-----------");
		
		//bimaps
		Map<Integer, Map<String, List<Person>>> biMap = new HashMap<>();
		people.forEach(
				person ->
				biMap.computeIfAbsent(person.getAge(), HashMap::new)//age of person in people is key and person or new hashmap is value
					 .merge(
								person.getGender(), 
								new ArrayList<>(Arrays.asList(person)),
								(l1,l2) -> {
									l1.addAll(l2);
									return l1;
								}
						   )
					 );
			
		System.out.println("Printing bimap");
		biMap.forEach((age,map) -> System.out.println(age + " " + map));
	}
	
	//We create a hashmap of people grouped by ages
	private static Map<Integer, List<Person>> mapByAge(List<Person> list){
		Map<Integer, List<Person>> map = 
				list.stream().collect(Collectors.groupingBy(Person::getAge));
		map.forEach((age, people) -> System.out.println(age + " - " + people));
		return map;
	}
}
