# Jackson

## 概要

> ・JSONをJavaオブジェクトに変換できる </br>
・JavaオブジェクトをJSONに変換できる

## Reading and Writing Using ObjectMapper

```java
@Component
@ToString
@NoArgsConstructor
@Getter //<---
@AllArgsConstructor
public class Pra1 {

    private String color;

    private String type;

}
```

```java
package com.example.demo.pra.pra1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class Pra1Service {

    private final ObjectMapper objectMapper;
    
    public String convertObjectToJson(Object obj) throws JsonProcessingException {
        return this.objectMapper.writeValueAsString(obj);
    }
}
```

ObjectMapperは、JavaオブジェクトのフィールドやプロパティをJSON形式に変換するために、対象のJavaオブジェクトに対してアクセスする必要がある。

上記の例ではフィールドが private になっているので、getter メソッドで外部からアクセスできるようにする必要がある。

