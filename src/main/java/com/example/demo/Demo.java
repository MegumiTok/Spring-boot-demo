package com.example.demo;

import com.example.demo.pet.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
@RestController
public class Demo {

	public static void main(String[] args) {
		SpringApplication.run(Demo.class, args);
	}

	@GetMapping
	public List<Pet> hello() {
		var pet = Pet.builder().id(1L).name("showdy").dob(LocalDate.of(2000, Month.APRIL, 25)).age(20).build();
		return List.of(pet);
	}

}
