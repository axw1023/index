package com.redemption.link;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class LinkApplication {

  public static void main(String[] args) {
    SpringApplication.run(LinkApplication.class, args);
  }

}
