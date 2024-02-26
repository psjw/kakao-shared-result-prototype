package com.psjw.prototypekakaoshare.common;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiCommonTest {
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp(){
//        if(port == RestAssured.UNDEFINED_PORT){
            RestAssured.port = port;
//        }
    }
}
