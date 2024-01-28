# Connecting to DB & Creating tables

- Spring Bootは、データベースアクセスにSpring Dataを使用

[アプリケーションプロパティ設定](https://spring.pleiades.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties.data)

- `spring.datasource.url` :データベースの JDBC URL
- `spring.jpa.hibernate.ddl-auto`：
- `spring.jpa.show-sql`

## Spring Data

[まずはこちらのブログを読むべし](https://qiita.com/crml1206/items/bab47b15342e25343e3c)

メインモジュールの例：
- Spring Data JDBC - の Spring Data リポジトリサポート
  - Java Database Connectivity
  - Javaアプリケーションからデータベースを操作するAPI
- Spring Data JPA - JPA の Spring Data リポジトリサポート
  - Java Persistence API
  - Hibernate は JPA(仕様)の実装の１つ
- Spring Data REST - Spring Data リポジトリをハイパーメディア駆動の RESTful リソースとしてエクスポート

### Spring Data JPA

[公式docs](https://spring.pleiades.io/projects/spring-data-jpa)

- JPA ベース (Java Persistence API) リポジトリを簡単に実装できるようにします
- Spring Data JPA は、実際に必要な量まで労力を削減することで、データアクセスレイヤーの実装を大幅に改善することを目的としています

### Spring Data REST

[公式docs](https://spring.pleiades.io/projects/spring-data-rest)

- [HAL エクスプローラー](https://spring.pleiades.io/spring-data/rest/reference/tools.html#tools.hal-explorer)
- [Jackson の ObjectMapper へのカスタムシリアライザーとデシリアライザーの追加](https://spring.pleiades.io/spring-data/rest/reference/representations.html)


## Connect to DB

## コマンドライン用コマンド

| 用途 | MySQL | PostgreSQL  |
| -------------------------------- | ----- | ----------- |
| 作成済みのデータベース一覧         | SHOW DATABASES            | \l     |
| 作成済みのロールの一覧             | SHOW DATABASES            | \du    |
| DBMSバージョン確認                | mysql -V                  | psql -V                             |
| DB接続                           |   | psql -U {db_user} -w -P 5432 -h localhost -d {database_name}  |
| DB接続（省略形） (1)              | mysql {database_name}      | psql {database_name}  |
| データベース作成                  |                           | CREATE DATABASE name;               |
| データベース削除                  |                           | DROP DATABASE name;                 |
| ユーザ(（より正確にいえばロール）の作成 |                      | CREATE USER miku;                   |
| ロールの削除                      |                           | DROP ROLE miku;                     |
| 権限の確認                       |                           | \z                                  |
| データベースへの接続（変更）       | use {database_name}        | \c {database_name}                  |
| 接続中のデータベースを確認        | \s                        | SELECT current_database();          |
| テーブル一覧                      | SHOW TABLES;              | \dt                                 |


```shell
docker-compose exec postgres psql -h localhost -U postgres

postgres=# \l
                                                      List of databases
   Name    |  Owner   | Encoding | Locale Provider |  Collate   |   Ctype    | ICU Locale | ICU Rules |   Access privileges
-----------+----------+----------+-----------------+------------+------------+------------+-----------+-----------------------
 postgres  | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           |
 template0 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | =c/postgres          +
           |          |          |                 |            |            |            |           | postgres=CTc/postgres
 template1 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | =c/postgres          +
           |          |          |                 |            |            |            |           | postgres=CTc/postgres
(3 rows)

postgres=# CREATE DATABASE pet;
CREATE DATABASE
postgres=# \du
                             List of roles
 Role name |                         Attributes
-----------+------------------------------------------------------------
 postgres  | Superuser, Create role, Create DB, Replication, Bypass RLS

postgres=# GRANT ALL PRIVILEGES ON DATABASE "pet" TO postgres;
GRANT
postgres=# \l
                                                      List of databases
   Name    |  Owner   | Encoding | Locale Provider |  Collate   |   Ctype    | ICU Locale | ICU Rules |   Access privileges
-----------+----------+----------+-----------------+------------+------------+------------+-----------+-----------------------
 pet       | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | =Tc/postgres         +
           |          |          |                 |            |            |            |           | postgres=CTc/postgres
 postgres  | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           |
 template0 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | =c/postgres          +
           |          |          |                 |            |            |            |           | postgres=CTc/postgres
 template1 | postgres | UTF8     | libc            | en_US.utf8 | en_US.utf8 |            |           | =c/postgres          +
           |          |          |                 |            |            |            |           | postgres=CTc/postgres
(4 rows)

postgres=# \c pet
You are now connected to database "pet" as user "postgres".
pet=# \d
Did not find any relations.
```

## JPA and @Entity

[公式docs](https://spring.pleiades.io/spring-boot/docs/current/reference/html/data.html#data.sql.jpa-and-spring-data)

[動画解説](https://youtu.be/9SGDpanrc8U?si=ntyOamLD71swUt3s&t=2546)

一般的なエンティティクラスは、次の例のようになります。

```java
@Entity //<--- for JPA
public class City implements Serializable { //<-- Serializable

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String state;

    // ... additional members, often include @OneToMany mappings

  // @NoArgsConstructor をクラスにつけたらこの引数のないコンストラクタは省略できる
    protected City() {
        // no-args constructor required by JPA spec
        // this one is protected since it should not be used directly
    }

    public City(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public String getName() {
        return this.name;
    }

    public String getState() {
        return this.state;
    }

    // ... etc

}
```

> public Pet() {} コンストラクタが必要になる理由は、JPA（Java Persistence API）がエンティティの永続性（データベースに保存すること）を管理する際、デフォルトコンストラクタを必要とするから

```shell
    create sequence pet_seq start with 1 increment by 50
Hibernate: 
    create sequence pet_seq start with 1 increment by 50
2024-01-29T01:59:32.734+09:00 DEBUG 98045 --- [           main] org.hibernate.SQL                        : 
    create table pet (
        age integer,
        dob date,
        id bigint not null,
        name varchar(255),
        primary key (id)
    )
Hibernate: 
    create table pet (
        age integer,
        dob date,
        id bigint not null,
        name varchar(255),
        primary key (id)
    )
```

