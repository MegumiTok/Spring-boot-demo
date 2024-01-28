# Intro

## start spring 

https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.2&packaging=war&jvmVersion=17&groupId=com.example&artifactId=demo&name=demo&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.demo&dependencies=web,data-jpa,postgresql

## DB の設定

> Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
Reason: Failed to determine a suitable driver class

今はまだ DB のセットアップをしていないので以下の dependency をコメントアウトしておく

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

## Hello World

- [localhost:8080](localhost:8080)
- https://github.com/MegumiTok/Spring-boot-demo/commit/e942ab0080017231ec387c2a4446f469a94f9e92

## クラスにtoStringメソッドを追加

目的：デバッグやログ出力などに便利

参考：[toString()をオーバーライドして自身の情報を親切に伝える](https://qiita.com/NagaokaKenichi/items/78015f53979b2545c2e6)

- 全てのクラスはObjectクラスを継承しています。
- Objectクラスは，Javaの全てのクラスのスーパークラスなので， 全てのクラスはtoStringメソッドを持っています

- Object クラスのメソッド：
```java
public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
```
オーバーライドしないと `Integer.toHexString(hashCode()` のログが見れるだけ。

謎の英数字の羅列を見せらせたとてこまります（笑）

なのでログに情報を見やすくしてあげるために Object クラスの toString メソッドをオーバーライドするんですね

※ 手書きで書く必要なんてありません。自動生成ツール使えば一発で作れます。
```java
@Override
public String toString() {
        return "Pet{" + "id=" + this.id + ", name='" + this.name + '\'' + ", dob=" + this.dob + ", age=" + this.age
        + '}';
        }
```
## ビルダーパターン

```java
@Builder
    public Pet(Long id, String name, LocalDate dob, Integer age) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.age = age;
    }
```

```java
@GetMapping
public List<Pet> hello() {
    return List.of(
        Pet.builder().id(1L).name("showdy").dob(LocalDate.of(2000, Month.APRIL,25)).age(20).build()
    );
}
```

- 任意のフィールドは設定したい場合のみ記述すればよいのでコードの無駄も減ります

```json
[{"id":1,"name":"showdy","dob":"2000-04-25","age":20}]
```

