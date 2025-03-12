package com.zhoutong.learn.controller;

import ch.qos.logback.classic.Logger;
import com.zhoutong.learn.aop.AOP;
import com.zhoutong.learn.configuration.DefineLogger;
import com.zhoutong.learn.mapper.DepartDao;
import com.zhoutong.learn.mapper.TbBaiduresouDao;
import com.zhoutong.learn.mapper.TbUserinfoDao;
import com.zhoutong.learn.model.*;
import lombok.extern.slf4j.Slf4j;
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
    @DefineLogger
    private Logger logger;

    @Autowired
    private TbBaiduresouDao tbBaiduresouDao;

    @Autowired
    private DepartDao departDao;

    @Autowired
    private TbUserinfoDao tb_userinfoDao;
    @GetMapping
    @AOP
    public Result getDepart(){
        List<Depart> list = departDao.list();
        Result r = Result.okResult(list);
        logger.info("查询所有部门:{}",r);
        return r;
    }
    @GetMapping("/{id}")
    @AOP
    public Result getDepartById(@PathVariable(name="id")int id){
        logger.info("getDepartById");
        List<Depart> depart = departDao.getDepartById(id);
        Result r = Result.okResult(depart);
        logger.info("根据id查询部门:{}",r);
        return r;
    }


}
