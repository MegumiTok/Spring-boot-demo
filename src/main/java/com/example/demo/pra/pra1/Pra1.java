package com.example.demo.pra.pra1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * Jackson について学習
 */
@Component
@ToString
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Pra1 {

	private String color;

	private String type;

}
