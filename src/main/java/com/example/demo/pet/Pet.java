package com.example.demo.pet;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Pet {

	private Long id;

	private String name;

	private LocalDate dob;

	private Integer age;

	@Builder
	public Pet(Long id, String name, LocalDate dob, Integer age) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Pet{" + "id=" + this.id + ", name='" + this.name + '\'' + ", dob=" + this.dob + ", age=" + this.age
				+ '}';
	}

}
