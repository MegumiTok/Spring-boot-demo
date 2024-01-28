package com.example.demo.pet;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
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
		var pet1 = new Pet(1L, "showdy", LocalDate.of(2000, Month.APRIL, 25), 20);
		var pet2 = new Pet(1L, "star", LocalDate.of(2018, Month.JANUARY, 18), 5);
		List<Pet> savedPets = this.pets.saveAllAndFlush(List.of(pet1, pet2));
		assertThat(savedPets).hasSize(2);
	}

}
