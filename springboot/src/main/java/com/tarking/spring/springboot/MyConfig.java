package com.tarking.spring.springboot;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;

/**
 * Created by tuojinguo on 2018/2/26.
 * 1.SpringBootConfiguration和Configuration作用一样
 */

//@SpringBootConfiguration
public class MyConfig {

    @Bean
    public List createList() {
        return new ArrayList();
    }

    @Bean
    public List updateList() {
        return new ArrayList();
    }
}
