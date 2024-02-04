package com.example.demo;

import com.example.demo.pet.Pet;
import com.example.demo.pet.Pets;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.web.servlet.MockMvc;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc // <-- for MockMvc
@AutoConfigureRestDocs
public class PetApiDocTests {

	@Autowired
	MockMvc mvc; // <-- for MockMvc

	@Autowired
	Pets pets;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void getPets() throws Exception {
		this.pets.save(new Pet("showdy", Pet.PetType.AFFECTIONATE));
		this.pets.save(new Pet("star", Pet.PetType.GENTLE));

		this.mvc.perform(get("/pets")) //
			.andExpect(status().isOk()) //
			.andDo(document("get-pets"));
	}

	@Test
	public void getPet() throws Exception {
		var pet = this.pets.save(new Pet("showdy", Pet.PetType.AFFECTIONATE));
		this.mvc.perform(get("/pets/{id}", pet.getId())) //
			.andExpect(status().isOk()) //
			.andDo(document("get-pet"));
	}

	@Test
	public void createPet() throws Exception {
		Map<String, Object> createPet = new LinkedHashMap<>();
		createPet.put("id", 1L);
		createPet.put("name", "showdy");
		createPet.put("type", Pet.PetType.ASSERTIVE);

		this.mvc
			.perform(post("/pets").contentType(MediaTypes.HAL_JSON)
				.content(this.objectMapper.writeValueAsString(createPet)))
			.andExpect(status().isCreated())
			.andDo(document("create-pet", requestFields(//
					fieldWithPath("id").description("The id of the Pet"), //
					fieldWithPath("name").description("The name of the Pet"), //
					fieldWithPath("type").description("The type of the Pet") //
			)));
	}

}
