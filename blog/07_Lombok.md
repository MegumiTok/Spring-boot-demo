# Lombok

```java
@Entity
@Table
@Data // ゲッター、セッター、equals(), hashCode(), toString() メソッドを自動的に生成
@NoArgsConstructor(force = true, access = AccessLevel.PROTECTED)
public class Pet implements Serializable {}
```
のように書こうとしたらこちらの質問と同じような suggest が出た
[Why JPA Buddy complains about @Data annotation over JPA Entity?](https://stackoverflow.com/questions/75181366/why-jpa-buddy-complains-about-data-annotation-over-jpa-entity)

entity クラスに lombok を使うのは避けた方が良さそう..?
