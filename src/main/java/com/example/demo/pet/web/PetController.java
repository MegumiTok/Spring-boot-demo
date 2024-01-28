package com.example.demo.pet.web;

import com.example.demo.pet.Pet;
import com.example.demo.pet.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

	private final PetService petService;

	@GetMapping
	public List<Pet> getPets() {
		return petService.getPets();
	}

}
