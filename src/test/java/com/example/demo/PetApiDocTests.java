package com.example.demo;

import com.example.demo.pet.Pet;
import com.example.demo.pet.Pets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.Month;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // <-- for MockMvc
@AutoConfigureRestDocs
public class PetApiDocTests {

	@Autowired
	MockMvc mvc; // <-- for MockMvc

	@Autowired
	Pets pets;

	@Test
	public void getPets() throws Exception {
		this.pets.save(new Pet(1L, "showdy", Pet.PetType.AFFECTIONATE));
		this.pets.save(new Pet(2L, "star", Pet.PetType.GENTLE));

		this.mvc.perform(get("/pets")) //
			.andExpect(status().isOk()) //
			.andDo(document("get-pets"));
	}

	@Test
	public void getPet() throws Exception {
		var pet = this.pets.save(new Pet(1L, "showdy", Pet.PetType.AFFECTIONATE));
		this.mvc.perform(get("/pets/{id}", pet.getId())) //
			.andExpect(status().isOk()) //
			.andDo(document("get-pet"));
	}

}
