```java
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/orders")
    public List<Object[]> getOrders() {
        Query query = entityManager.createNativeQuery("SELECT * FROM orders LIMIT 10");
        return query.getResultList();
    }
}
```