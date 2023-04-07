package com.redemption.link.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.redemption.link.service.LinkService;
import com.redemption.link.entity.Link;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 链接 前端控制器
 * </p>
 *
 * @author axw
 * @since 2023-04-07
 */
@Controller
@RequestMapping("/link")
public class LinkAction {


    @Autowired
    private LinkService linkService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<Link>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<Link> aPage = linkService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Link> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(linkService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody Link params) {
        linkService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        linkService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody Link params) {
        linkService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
