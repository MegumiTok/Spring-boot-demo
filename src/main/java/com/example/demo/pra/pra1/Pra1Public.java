package com.example.demo.pra.pra1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;


@Component
@ToString
@NoArgsConstructor
//@Getter <-- フィールドの可視性が public な場合は、 Getter/Setter は無くても変換できる
@AllArgsConstructor
public class Pra1Public {

    public String color;

    public String type;

}
