package com.example.demo.pet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
@JsonIgnoreProperties({ "hibernateLazyInitializer" }) // https://qiita.com/niwasawa/items/9735d5dc4a4a71e84ccd
public class Pet implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private PetType type;

	public Pet(Long id, String name, PetType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public enum PetType {

		AFFECTIONATE, ASSERTIVE, EASYGOING, GENTLE

	}

}
