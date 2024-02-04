# JUnit 5を用いたテスト

## JavaのテストにはAssertJがオススメ

[公式docs](https://joel-costigliola.github.io/assertj/assertj-assertions-generator.html#philosophy)

## org.assertj.core.api.Assertions.assertThat

> 個人的には現時点での本命。これからJUnit実装始めるならこれを使いたいです。
JUnitのassertThatとの大きな違いは、引数が実測値のみであり、その後の期待値検証がメソッドチェーンで行えることでしょう。

[参考](https://qiita.com/gengogo5/items/317b6f260b6fecc184fc)

[⭐️ AssertJ版：テストでよく使う検証メソッド一覧](https://qiita.com/naotawool/items/6512ecbe2fd006dacfd2)


## おまけ：JUnit4 からJUnit5へ書き換える

JUnit4 を使っているプロジェクトでは `@RunWith` を見かけるが毎回これがなんなのか忘れる。 これは JUnit4  のアノテーションだよー、というのを覚えときたい。

> JUnit5のアノテーションは、JUnit4のものとは別物になっています。これは共存して利用できるようにするために意図的に流用しなかったのだと思います。 そのため、今までのJUnit4をJUnit5に書き換えるには、アノテーションを変更していく必要があります。 基本的にはパッケージ名が変わっているのでそれを一括で置換します。そ

- @RunWith、@Ruleを@ExtendWithで置き換える

## public @interface AutoConfigureMockMvc

```text
org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'com.example.demo.PetApiDocTests': Unsatisfied dependency expressed through field 'mvc': No qualifying bean of type 'org.springframework.test.web.servlet.MockMvc' available: expected at least 1 bean which qualifies as autowire candidate. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
```

MockMvc の自動構成を有効にして構成するためにテストクラスに適用できるアノテーション。

```java
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc //<-- for MockMvc
@AutoConfigureRestDocs
public class PetApiDocTests {

    @Autowired
    MockMvc mvc; //<-- for MockMvc

    @Autowired
    Pets pets;

    @Test
    public void getPets() throws Exception {
        this.pets.save(new Pet(1L, "showdy", LocalDate.of(2000, Month.APRIL, 25), 20));
        this.pets.save(new Pet(2L, "star", LocalDate.of(2018, Month.JANUARY, 18), 5));

        this.mvc.perform(get("/pets")).andExpect(status().isOk()).andDo(document("get-pets"));
    }

}
```
