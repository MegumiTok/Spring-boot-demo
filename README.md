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


