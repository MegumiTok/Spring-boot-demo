# Rest docs

参考：[Restdocs で API ドキュメント作成](https://spring.pleiades.io/guides/gs/testing-restdocs/)

[HTTPステータスコード 完全に理解した](https://qiita.com/unsoluble_sugar/items/b080a16701946fcfce70)

## HTTPレスポンス

レスポンスメッセージは大きく３種類の情報に分けられる。

- HTTPレスポンスヘッダ
- HTTPレスポンスボディ

### 200番台 😊成功レスポンス


#### 200 OK

> GET：ボディにリソースが含まれる

> PUT, POST：ボディに処理結果が含まれる

#### 201 Created

> POSTの場合はレスポンスのLocationヘッダにURIが入る

> ボディには新しく作成したリソースを入れることが多いが、特に何も入れなくても良い

#### 204 No Content

> レスポンスボディが空のときに返す

```java
@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePet(@PathVariable Long id) {
		this.pets.deleteById(id);
		return ResponseEntity.noContent().build();
	}
```
