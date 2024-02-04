# Getting Started

## Requirements
- JDK 17

```shell
asdf install
```

## Build Project

```shell
./mvnw clean package
```

## Run locally

```shell
./mvnw spring-boot:run
```

## Format and validate code

```shell
./mvnw spring-javaformat:apply validate
```

## Connect to DB

```shell
docker-compose exec postgres psql -h localhost -U postgres
```

## Blog

- [01 Intro](./blog/01_Intro.md)
- [02 API layer & Dependency Injection](./blog/02_API_layer.md)
- [03 Connecting to DB & Creating tables](./blog/03_Connecting_to_DB.md)
- [04 JPA Repository](./blog/04_JPA_Repository.md)
- [06 JUnit5 で書くテストコード](./blog/06_test_JUnit5.md)
- [07 Lombok のトレードオフ](./blog/07_Lombok.md)
- [08 Jackson](./blog/08_Jackson.md)
- [09 リフレクションとプロキシについて](./blog/09_リフレクションとプロキシについて.md)

## メモ

間違えて push してしまった時、ローカルでの変更等は残して、git pushだけ取り消したいという場合は以下のコマンド：

[参考](https://qiita.com/S42100254h/items/db435c98c2fc9d4a68c2)

```shell
git reset --soft HEAD^
```
