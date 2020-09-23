package org.mylike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Administrator on 2020/9/22.
 */
@SpringBootApplication
@MapperScan(basePackages = "org.mylike.dao")
public class MyLikeApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyLikeApplication.class);
    }
}
