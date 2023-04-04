package com.redemption.link.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

  @RequestMapping("/")
  public String home() {
    return "Hello world";
  }

}
