package com.zhoutong.learn.controller;

import com.zhoutong.learn.mapper.DepartDao;
import com.zhoutong.learn.mapper.TbBaiduresouDao;
import com.zhoutong.learn.mapper.TbUserinfoDao;
import com.zhoutong.learn.model.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * depart CRUD
 * @author zhoutc
 * @date 2019-08-01
 */
@RestController
@RequestMapping("/depart")
public class IndexController {
    @Autowired
    private Logger log;

    @Autowired
    private TbBaiduresouDao tbBaiduresouDao;

    @Autowired
    private DepartDao departDao;

    @Autowired
    private TbUserinfoDao tb_userinfoDao;
    @GetMapping
    public Result getDepart(){
        List<Depart> list = departDao.list();
        Result r = Result.okResult(list);
        System.out.println(r);
        return r;
    }
    @GetMapping("/{id}")
    public Result getDepartById(@PathVariable(name="id")int id){
        log.info("getDepartById");
        List<Depart> depart = departDao.getDepartById(id);
        Result r = Result.okResult(depart);
        System.out.println(r);
        return r;
    }


}
