package Session15;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreamsConcept {
	
	@Test
	public  void regular() {
		/* Count the number of names starting with the alphabet "A" */
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		
		//Method 1: using iterator() and cnt variable
		Iterator<String> it = names.iterator();
		int cnt=0;
		while(it.hasNext()) {
			String name = it.next();
			if(name.startsWith("A"))
				++cnt;
		}
		System.out.println(cnt); //3
		System.out.println("===============================================");
		cnt=0;
		//Method 2:using for loop and cnt variable
		for(int i=0;i<names.size();i++) {
			String name = names.get(i);
			if(name.startsWith("A"))
				++cnt;
		}
		System.out.println(cnt); //3
		System.out.println("===============================================");
	}
	
	@Test
	public  void usingStreams() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Ram");
		//With lambda expressions
		long cnt = names.stream().filter(s -> s.startsWith("A")).count();
		System.out.println("===============================================");
		
		Stream <String> streamOfArray = Stream.of("Abhijeet", "Don", "Alekhya","Adam","Ram");
		long cnt2 = streamOfArray.filter(s -> s.startsWith("A")).count();
		//names is not changed due to streams.
		System.out.println(cnt); //3
		System.out.println("===============================================");
		System.out.println(cnt2); //3
		System.out.println("===============================================");
		
		long cnt3 = Stream.of("Abhijeet", "Don", "Alekhya","Adam","Ram").filter(s ->
		{
				s.startsWith("A");
				return true;
		}).count();
		System.out.println(cnt3);//prints 5
		
		System.out.println("===============================================");
		
		long cnt4 = Stream.of("Abhijeet", "Don", "Alekhya","Adam","Ram").filter(s ->
		{
				s.startsWith("A");
				return false;
		}).count();
		System.out.println(cnt4);//prints 0
		//There is no life for intermediate operation if there is no terminal on. 
		//We can only use one terminal operation per stream.Hence o/p is 0.
		System.out.println("===============================================");
		//Abhijeet
		//Alekhya
		names.stream().filter(s->s.length()>4).forEach(s -> System.out.println(s));
		System.out.println("==============================================="); 
		
		names.stream().filter(s->s.length()>4).limit(1).forEach(s -> System.out.println(s)); //Abhijeet
		 System.out.println("===============================================");
	}

	@Test
	public void mapStream() {
		//Names ending with 'a' and with Upper-case
		 Stream.of("Abhijeet", "Don", "Alekhya","Adam","Rama")
		 	.filter(s -> s.endsWith("a"))
		 		.map(s->s.toUpperCase())
		 			.forEach(s -> System.out.println(s));
		 
		 System.out.println("========================1======================");
		 
		//Names starts with 'A' and with Upper-case and sorted
		 List<String> names = Arrays.asList("Azharuddin", "Don", "Alekhya", "Adam", "Rama");
		 names.stream()
		 	.filter(s -> s.startsWith("A"))
		 		.sorted()
	 				.map(s->s.toUpperCase())
	 					.forEach(s -> System.out.println(s)); 
		 /*	ADAM
			ALEKHYA
			AZHARUDDIN
		 */
		 System.out.println("========================2======================");
		 
		 
		 List<String> names1 = Arrays.asList("Ramesh", "Suresh", "Agasthya","Arnab","Subramanyam");
		 names1.stream()
		 	.filter(s -> s.endsWith("a"))
		 		.map(s ->s.length())
		 			.forEach(s -> System.out.println(s)); // 8
		 
		 System.out.println("========================3======================");
		 
		 //Merging two different streams 
		 Stream <String> newStream = Stream.concat(names.stream(), names1.stream());
		 newStream.sorted()
		 		.forEach(s -> System.out.println(s));
		 /*	Adam
			Agasthya
			Alekhya
			Arnab
			Azharuddin
			Don
			Rama
			Ramesh
			Subramanyam
			Suresh
		*/
		 
		 System.out.println("========================4======================");
		 
		 boolean flag = Stream.of("Abhijeet", "Daya", "Salunkhe","Freddie","Pradhyumna")
				 .anyMatch(s->s.equalsIgnoreCase("Daya"));
		 System.out.println(flag); //true
		 Assert.assertTrue(flag);
				 
		 System.out.println("========================5======================");
	}

	
	@Test
	public void streamCollect() {
		List<String> names = Stream.of("Ramesh", "Suresh", "Agasthya","Arnab","Subramanyam")
				.filter(s->s.endsWith("a"))
					.map(s->s.toUpperCase())
					.collect(Collectors.toList());
		System.out.println(names.get(0)); //AGASTHYA
		System.out.println("========================x======================");

		Stream.of("Sachin", "Sehwag", "Anushka", "Dhoni","Ajinkya")
				.filter(s->s.endsWith("a"))
						.map(s->s.toUpperCase())
							.limit(1)
								.forEach(s->System.out.println(s)); //ANUSHKA
		System.out.println("========================xx======================");
		
		List<Integer> vals = Arrays.asList(3,2,2,7,5,1,9,7);
		//print unique nums
		//sort the array - give the 3rd index
		vals.stream()
			.distinct()
				.forEach(s->System.out.println(s)); //3 2 7 5 1 9
		System.out.println("========================xxx======================");

		List <Integer> nums = Arrays.asList(3,2,2,7,5,1,9,7);
		nums.stream()
			.distinct()
				.sorted()
					.collect(Collectors.toList()); //1 2 3 5 7 9
		System.out.println(nums.get(2)); //2
		
		System.out.println("========================xxxx======================");
	}
}
