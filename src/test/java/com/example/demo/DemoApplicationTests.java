package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = "app.dataloader.enabled=false")
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }
}
