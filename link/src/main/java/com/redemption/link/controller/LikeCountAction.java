package com.redemption.link.controller;

import com.redemption.link.service.LikeCountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/like/count")
@Tag(name = "likeCount", description = "the likeCount API")
public class LikeCountAction {

    @Autowired
    private LikeCountService likeCountService;

    @GetMapping(value = "/add")
    public ResponseEntity<Object> addLikeCountByRedis(@RequestParam String id) {
        String likeCount = likeCountService.addLikeCountByRedis(id);
        return new ResponseEntity<>(likeCount, HttpStatus.OK);
    }
}
