package com.redemption.link.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.redemption.link.service.SubjectService;
import com.redemption.link.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 分组 前端控制器
 * </p>
 *
 * @author axw
 * @since 2023-04-18
 */
@Controller
@RequestMapping("/subject")
public class SubjectAction {


    @Autowired
    private SubjectService subjectService;

    @GetMapping(value = "/")
    public ResponseEntity<Page<Subject>> list(@RequestParam(required = false) Integer current, @RequestParam(required = false) Integer pageSize) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        Page<Subject> aPage = subjectService.page(new Page<>(current, pageSize));
        return new ResponseEntity<>(aPage, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Subject> getById(@PathVariable("id") String id) {
        return new ResponseEntity<>(subjectService.getById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody Subject params) {
        subjectService.save(params);
        return new ResponseEntity<>("created successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        subjectService.removeById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody Subject params) {
        subjectService.updateById(params);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }
}
