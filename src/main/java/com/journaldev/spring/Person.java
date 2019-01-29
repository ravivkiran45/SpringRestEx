package com.journaldev.spring;

import org.springframework.stereotype.Component;

@Component
public class Person {

	private String name;
	
	private String age;
	
	private String jan2019;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
