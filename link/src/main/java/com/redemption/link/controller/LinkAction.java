package com.redemption.link.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.redemption.link.vo.LinkVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;
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
@Tag(name = "link", description = "the link API")
public class LinkAction {


    @Autowired
    private LinkService linkService;

    @Operation(summary = "查询列表", tags = {"link"})
    @GetMapping(value = "/list")
    public ResponseEntity<IPage<LinkVo>> list(@RequestParam(required = false) Integer current,
        @RequestParam(required = false) Integer pageSize, @RequestParam(required = false) Map map) {
        if (current == null) {
            current = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }
        IPage<LinkVo> aPage = linkService.linkVoPage(new Page<>(current, pageSize), null);
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

    @Operation(summary = "删除链接", description = "通过此接口删除", tags = {"link"})
    @ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "提供的id无效"),
        @ApiResponse(responseCode = "404", description = "未找到要删除的链接")
    })
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
