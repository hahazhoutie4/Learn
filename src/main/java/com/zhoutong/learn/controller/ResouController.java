package com.zhoutong.learn.controller;

import com.zhoutong.learn.mapper.TbBaiduresouDao;
import com.zhoutong.learn.model.PageBean;
import com.zhoutong.learn.model.Result;

import com.zhoutong.learn.model.TbBaiduresou;
import com.zhoutong.learn.service.TbBaiduresouService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/resou")
@RestController
public class ResouController {

    private static final Logger log = LoggerFactory.getLogger(ResouController.class);
    @Autowired
    private TbBaiduresouService tbBaiduresouService;

    @Autowired
    private TbBaiduresouDao tbBaiduresouDao;
    @GetMapping
    public Result list() {
        return Result.okResult(tbBaiduresouService.listData());
    }


    @GetMapping("/limit/{page}/{number}")
    public Result resouListLimit(@PathVariable(name = "page") int page,
                                 @PathVariable(name = "number") int number) {
        List<TbBaiduresou> l = tbBaiduresouService.listDataLimit(page - 1, number);
        return Result.okResult(l);
    }

    @PostMapping("/insert")
    public Result inserData(@RequestBody String jsonString) {
        int code = tbBaiduresouService.insertData(jsonString);
        if (code == 0) {
            return Result.errorResult("插入数据失败");
        }
        return Result.okResult("插入字段成功");
    }


    @GetMapping("/{page}/{pageSize}")
    public Result getPage(@PathVariable(name = "page") int page, @PathVariable(name = "pageSize") int pageSize) {
        PageBean pageBean = tbBaiduresouService.getPage(page, pageSize);
        return Result.okResult(pageBean);
    }

    @GetMapping("/getid")
    public Result getById(@RequestParam(name = "beginId", defaultValue = "200") int beginId,
                          @RequestParam(name = "endId", defaultValue = "300") int endId,
                          @RequestParam(name = "page", defaultValue = "1") int page,
                          @RequestParam(name = "pageSize", defaultValue = "10") int pageSize) {
        log.info("根据id分页查询beginId:{} endId:{} page:{} pageSize:{}", beginId, endId, page, pageSize);
        PageBean result = tbBaiduresouService.getBetweenById(beginId, endId, page, pageSize);
        return Result.okResult(result);
    }

    @GetMapping("/deleteid/{ids}")
    public Result deleteByIds(@PathVariable("ids") List<Integer> ids) {
        tbBaiduresouService.deleteIds(ids);
        return Result.okResult("delete success");   //test
    }

    @PostMapping("/insertByModel")
    public Result insertByModel(@RequestBody TbBaiduresou tbBaiduresou) {
        int code = tbBaiduresouService.insertByModel(tbBaiduresou);
        if (code == 0) {
            return Result.errorResult("插入数据失败");
        }
        return Result.okResult("插入字段成功");

    }
}
