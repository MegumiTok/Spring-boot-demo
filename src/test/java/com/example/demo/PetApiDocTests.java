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
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class PetApiDocTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private Pets pets;

	@Test
	public void getPets() throws Exception {
		this.pets.save(new Pet(1L, "showdy", LocalDate.of(2000, Month.APRIL, 25), 20));
		this.pets.save(new Pet(2L, "star", LocalDate.of(2018, Month.JANUARY, 18), 5));

		this.mvc.perform(get("/pets")).andExpect(status().isOk()).andDo(document("get-pets"));
	}

}
