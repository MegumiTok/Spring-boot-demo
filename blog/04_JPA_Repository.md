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

