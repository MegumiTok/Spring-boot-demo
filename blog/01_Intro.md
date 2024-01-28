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
