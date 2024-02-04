package com.example.demo.pet;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
class PetsTests {

	final Pets pets;

	@Test
	void save() {
		var pet1 = new Pet("showdy", Pet.PetType.AFFECTIONATE);
		var pet2 = new Pet("star", Pet.PetType.GENTLE);
		List<Pet> savedPets = this.pets.saveAllAndFlush(List.of(pet1, pet2));
		assertThat(savedPets).hasSize(2);
	}

}
