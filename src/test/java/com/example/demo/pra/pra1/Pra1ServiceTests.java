package com.example.demo.pra.pra1;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Pra1Service}.
 */

@SpringBootTest
class Pra1ServiceTests {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    Pra1Service pra1Service;

    @Test
    void testConvertObjectToJson() throws IOException {
        var pra1 = new Pra1("yellow", "renault");
       /*
        * ObjectMapper objectMapper = new ObjectMapper();
        * 上記みたく明示的にインスタンスを生成した場合、それはSpringのDIとは関係なく、手動で生成されたオブジェクトが利用される。
        * Spring Bootのテストコンテキスト（@SpringBootTest が付与されたクラス）では、@Autowired を使用してBeanを注入することが推奨。
        * これにより、Springが管理するBeanが適切にDIされ、テスト時にもSpringのコンテキストが活用される。
        * 一部の特定のケースやコード部分では、手動でオブジェクトを生成することが適切な場合もあるが、Spring boot を使っているなら恩恵に授かった方がいいってことだと思う。
        * それに、DIする場合、通常はアプリケーションのライフサイクル中に1つのオブジェクトが作成され、それが再利用されますルカらメモリ使用量を削減できるみたい。
        */

        // Act
        var actualJson = this.pra1Service.convertObjectToJson(pra1);

        // Assert
        var expectedJson = "{\"color\":\"yellow\",\"type\":\"renault\"}";

        assertThat(actualJson).isEqualTo(expectedJson);

    }

    /*
     * フィールドの可視性が public な場合は、 Getter/Setter は無くても変換できることの確認
     */
    @Test
    void testConvertObjectToJson2() throws IOException {
        var pra1Public = new Pra1Public("yellow", "renault");

        // Act
        var actualJson = this.pra1Service.convertObjectToJson(pra1Public);

        // Assert
        var expectedJson = "{\"color\":\"yellow\",\"type\":\"renault\"}";

        assertThat(actualJson).isEqualTo(expectedJson);

    }

}
