package com.example.demo.pet.service;

import com.example.demo.pet.Pet;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class PetService {

	public List<Pet> getPets() {
		var pet = Pet.builder().id(1L).name("showdy").dob(LocalDate.of(2000, Month.APRIL, 25)).age(20).build();
		return List.of(pet);
	}

}
