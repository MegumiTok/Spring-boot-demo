package com.example.demo.pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

/**
 * Restdocs を生成するまでについて学習
 */

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer" }) // https://qiita.com/niwasawa/items/9735d5dc4a4a71e84ccd
public class Pet implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private PetType type;

	public Pet(String name, PetType type) {
		this.name = name;
		this.type = type;
	}

	public enum PetType {

		AFFECTIONATE, ASSERTIVE, EASYGOING, GENTLE

	}

}
