package com.zhoutong.learn.controller;


import com.zhoutong.learn.mapper.TbUserinfoDao;
import com.zhoutong.learn.model.Result;
import com.zhoutong.learn.model.Result;
import com.zhoutong.learn.model.TbUserinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private TbUserinfoDao tb_userinfoDao;
    @GetMapping
    public Result list(){
 //       log.info(this.getClass().toString());
        log.info("get userinfo list:");
        List<TbUserinfo> list = tb_userinfoDao.list();
        Result r = Result.okResult(list);
        System.out.println(r);
        return r;
    }
    @GetMapping("/{id}")
    public Result getUserById(@PathVariable(name="id") int id){
        List<TbUserinfo>  user = tb_userinfoDao.getUserById(id);
        Result r = Result.okResult(user);
        System.out.println(r);
        return r;
    }
    @PostMapping("/insert")
    public Result insertUser(@RequestBody TbUserinfo tb_userinfo){
        log.info("insert into tb_userinfo : {}",tb_userinfo);
        int result = tb_userinfoDao.insertUser(tb_userinfo);   //update_ numbers
        if(result>0){
            return Result.okResult("插入字段的主键id:"+tb_userinfo.getId());
        }
        return Result.errorResult("插入字段失败");
    }

}
