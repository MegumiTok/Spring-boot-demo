package com.example.demo.pet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table
@Data // ゲッター、セッター、equals(), hashCode(), toString() メソッドを自動的に生成
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
public class Pet implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private LocalDate dob;

	private Integer age;

	public Pet(Long id, String name, LocalDate dob, Integer age) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.age = age;
	}

	public Pet(String name, LocalDate dob, Integer age) {
		this.name = name;
		this.dob = dob;
		this.age = age;
	}

}
