= JavaのテストにはAssertJがオススメ

[公式docs](https://joel-costigliola.github.io/assertj/assertj-assertions-generator.html#philosophy)

== org.assertj.core.api.Assertions.assertThat

> 個人的には現時点での本命。これからJUnit実装始めるならこれを使いたいです。
JUnitのassertThatとの大きな違いは、引数が実測値のみであり、その後の期待値検証がメソッドチェーンで行えることでしょう。

[参考](https://qiita.com/gengogo5/items/317b6f260b6fecc184fc)

[⭐️ AssertJ版：テストでよく使う検証メソッド一覧](https://qiita.com/naotawool/items/6512ecbe2fd006dacfd2)


== おまけ：JUnit4 からJUnit5へ書き換える

JUnit4 を使っているプロジェクトでは `@RunWith` を見かけるが毎回これがなんなのか忘れる。 これは JUnit4  のアノテーションだよー、というのを覚えときたい。

> JUnit5のアノテーションは、JUnit4のものとは別物になっています。これは共存して利用できるようにするために意図的に流用しなかったのだと思います。 そのため、今までのJUnit4をJUnit5に書き換えるには、アノテーションを変更していく必要があります。 基本的にはパッケージ名が変わっているのでそれを一括で置換します。そ

- @RunWith、@Ruleを@ExtendWithで置き換える
