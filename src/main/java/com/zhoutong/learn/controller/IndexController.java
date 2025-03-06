package com.zhoutong.learn.controller;

import com.zhoutong.learn.mapper.DepartDao;
import com.zhoutong.learn.mapper.TbBaiduresouDao;
import com.zhoutong.learn.mapper.TbUserinfoDao;
import com.zhoutong.learn.model.*;
import com.zhoutong.learn.service.TbBaiduresouService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * depart CRUD
 * @author zhoutc
 * @date 2019-08-01
 */
@RestController
public class IndexController {
    @Autowired
    private Logger log;



    @Autowired
    private TbBaiduresouDao tbBaiduresouDao;

    @Autowired
    private DepartDao departDao;

    @Autowired
    private TbUserinfoDao tb_userinfoDao;
    @GetMapping("/depart")
    public Result getDepart(){
        List<Depart> list = departDao.list();
        Result r = ResultImpl.okResult(list);
        System.out.println(r);
        return r;
    }
    @GetMapping("/depart/{id}")
    public Result getDepartById(@PathVariable(name="id")int id){
        List<Depart> depart = departDao.getDepartById(id);
        Result r = ResultImpl.okResult(depart);
        System.out.println(r);
        return r;
    }
    @GetMapping("/user")
    public Result list(){
        log.info(this.getClass().toString());
//        log.info("sjflsafjldsajflksdjafl;jhdslafjldsj;aflj;sdlafjlsdaf");
        List<TbUserinfo> list = tb_userinfoDao.list();
        Result r = ResultImpl.okResult(list);
        System.out.println(r);
        return r;
    }
    @GetMapping("/user/{id}")
    public Result getUserById(@PathVariable(name="id") int id){
        List<TbUserinfo>  user = tb_userinfoDao.getUserById(id);
        Result r = ResultImpl.okResult(user);
        System.out.println(r);
        return r;
    }
    @PostMapping("/user/insert")
    public Result insertUser(@RequestBody TbUserinfo tb_userinfo){
        int result = tb_userinfoDao.insertUser(tb_userinfo);   //update_ numbers
        if(result>0){
            return ResultImpl.okResult("插入字段的主键id:"+tb_userinfo.getId());
        }
       return ResultImpl.errorResult("插入字段失败");
    }

}
