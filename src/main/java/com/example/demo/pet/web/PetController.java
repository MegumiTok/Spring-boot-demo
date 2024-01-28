package com.example.demo.pet.web;

import com.example.demo.pet.Pet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

	@GetMapping
	public List<Pet> getPets() {
		var pet = Pet.builder().id(1L).name("showdy").dob(LocalDate.of(2000, Month.APRIL, 25)).age(20).build();
		return List.of(pet);
	}

}
