package com.redemption.link;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@MapperScan("com/redemption/link/mapper")
public class LinkApplication {

  public static void main(String[] args) {
    SpringApplication.run(LinkApplication.class, args);
  }

}
