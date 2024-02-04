# JPA Repository

[必見講義](https://youtu.be/9SGDpanrc8U?si=J3l2Va1_W-ChTuGj&t=2921)

[こちらの図がわかりやすい](https://terasolunaorg.github.io/guideline/1.0.3.RELEASE/ja/ArchitectureInDetail/DataAccessJpa.html)

### データベースアクセス

before:
```java
@Service
public class PetService {
	public List<Pet> getPets() {
		var pet = Pet.builder().id(1L).name("showdy").dob(LocalDate.of(2000, Month.APRIL, 25)).age(20).build();
		return List.of(pet);
	}

}

```

after:

```java
@Repository
public interface Pets extends JpaRepository<Pet, Long> { //<-- Long は Id の型
}
```

```java
@Service
@AllArgsConstructor
public class PetService {
	
	private final Pets pets;

	public List<Pet> getPets() {
		return this.pets.findAll();
	}
}
```
## EntityManager

[わかりやすい記事](https://terasolunaorg.github.io/guideline/1.0.3.RELEASE/ja/ArchitectureInDetail/DataAccessJpa.html)

## O/Rマッピング（Object/RDB mapping）

- データ形式の相互変換を行う

## 非推奨の API

```java
@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final Pets pets;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPetById(@PathVariable Long id) {
        var pet = this.pets.getById(id); <--- 代わりに JpaRepository.getReferenceById(ID) を使用してください とのこと
        return ResponseEntity.ok(pet); 
    }
}
```

[非推奨の API](https://spring.pleiades.io/spring-data/jpa/docs/current/api/deprecated-list.html)

## JPAエンティティのIDフィールド

```java
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
```

@Id と @GeneratedValue がついたフィールドを final にすることは、JPA（Java Persistence API）において一般的なパターンではないみたい。 代わりにsetterが存在しないようにするとのこと。

[Requirements for Entity Classes](https://docs.oracle.com/javaee/5/tutorial/doc/bnbqa.html#Entities)

An entity class must follow these requirements:

- The class must be annotated with the javax.persistence.Entity annotation.
- The class must have a public or protected, no-argument constructor. The class may have other constructors.
- The class must not be declared final. No methods or persistent instance variables must be declared final.
- If an entity instance be passed by value as a detached object, such as through a session bean’s remote business interface, the class must implement the Serializable interface.
- Entities may extend both entity and non-entity classes, and non-entity classes may extend entity classes.
- Persistent instance variables must be declared private, protected, or package-private, and can only be accessed directly by the entity class’s methods. Clients must access the entity’s state through accessor or business methods.
