package com.example.demo.pet.web;

import com.example.demo.pet.Pet;
import com.example.demo.pet.Pets;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

	private final Pets pets;

	@GetMapping
	public ResponseEntity<List<Pet>> getPets() {
		List<Pet> allPets = this.pets.findAll();
		return ResponseEntity.ok(allPets);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPetById(@PathVariable Long id) {
		var pet = this.pets.getReferenceById(id); //<-- @Deprecated T getById(ID id);
		return ResponseEntity.ok(pet);
	}

	@PostMapping
	public ResponseEntity<?> createPet(@RequestBody Pet pet) {
		Pet target = this.pets.save(pet);
		var location = URI.create("/pets/" + target.getId());
		return ResponseEntity.created(location).body(target);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePet(@PathVariable Long id) {
		this.pets.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updatePet(@PathVariable Long id, @RequestBody Pet updatedPet) {
		try {
			updatedPet.setId(id);
			this.pets.save(updatedPet);
			return ResponseEntity.noContent().build();
		} catch (IllegalArgumentException ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}
}
