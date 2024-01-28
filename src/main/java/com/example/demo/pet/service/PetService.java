package com.example.demo.pet.service;

import com.example.demo.pet.Pet;
import com.example.demo.pet.Pets;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PetService {

	private final Pets pets;

	public List<Pet> getPets() {
		return this.pets.findAll();
	}

}
