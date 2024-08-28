package com.rsa.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class JavaStreams {
	
	@Test
	public void numbers()
	{
		List<Integer> num=Arrays.asList(4,4,3,4,3,7,9,1,8,3,6,5,5);
		//num.stream().distinct().sorted().forEach(n->System.out.println(n));
		List<Integer>li=num.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(4));
	}
	
	
	
	/*@Test
	public void cityName()
	{
		Stream.of("Manipur","Goa","Berhampur","Ooty","Leh")
		.filter(s->s.contains("pur")).forEach(s->System.out.println(s));
	}
	@Test
	public void cityName2()
	{
		Stream.of("Manipur","Goa","Berhampur","Ooty","Leh")
		.filter(c->c.length()>3).limit(3).map(c->c.toLowerCase())
		.forEach(c->System.out.println(c));
	}*/
	/*@Test
	public void sortName()
	{
		Stream.of("Manipur","Goa","Berhampur","Ooty","Leh")
		.filter(c->c.contains("a")).sorted().forEach(c->System.out.println(c));
	}*/
	
	/*@Test
	public void sortNames() 
	{
	List <String> names=Arrays.asList("Ansu", "Abhi","Anki", "Ayush","Archi");
	names.stream().filter(s->s.startsWith("A")).sorted().forEach(s->System.out.println(s));
	}*/

}
