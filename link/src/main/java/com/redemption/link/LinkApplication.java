package com.redemption.link;


import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com/redemption/link/mapper", annotationClass = Mapper.class)
public class LinkApplication {

  public static void main(String[] args) {
    SpringApplication.run(LinkApplication.class, args);
  }

}
