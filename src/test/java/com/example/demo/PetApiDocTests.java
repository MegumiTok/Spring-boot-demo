package com.example.demo;

import com.example.demo.pet.Pet;
import com.example.demo.pet.service.PetService;
import com.example.demo.pet.web.PetController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PetController.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class PetApiDocTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PetService petService;

	@Test
	public void getPets() throws Exception {

		List<Pet> pets = List.of(new Pet(1L, "showdy", LocalDate.of(2000, Month.APRIL, 25), 20),
				new Pet(2L, "star", LocalDate.of(2018, Month.JANUARY, 18), 5));
		given(this.petService.getPets()).willReturn(pets);

		this.mvc.perform(get("/pets"))
			.andExpect(status().isOk())
			.andDo(document("get-pets",
					responseFields(fieldWithPath("[].id").description("The ID of the pet"),
							fieldWithPath("[].name").description("The name of the pet"),
							fieldWithPath("[].dob").description("The date of birth of the pet"),
							fieldWithPath("[].age").description("The age of the pet"))));
	}

}
