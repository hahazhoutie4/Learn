package com.zhoutong.learn.controller;


import com.zhoutong.learn.mapper.TbUserinfoDao;
import com.zhoutong.learn.model.Result;
import com.zhoutong.learn.model.TbUserinfo;
import com.zhoutong.learn.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbUserinfoDao tbUserinfoDao;
    @GetMapping
    public Result list(){
 //       log.info(this.getClass().toString());
        log.info("get userinfo list:");
        List<TbUserinfo> list = tbUserinfoDao.list();
        Result r = Result.okResult(list);
        System.out.println(r);
        return r;
    }
    @GetMapping("/{id}")
    public Result getUserById(@PathVariable(name="id") int id){
        List<TbUserinfo>  user = tbUserinfoDao.getUserById(id);
        Result r = Result.okResult(user);
        System.out.println(r);
        return r;
    }
    @PostMapping("/insert")
    public Result insertUser(@RequestBody TbUserinfo tb_userinfo){
        log.info("insert into tb_userinfo : {}",tb_userinfo);
        int result = tbUserinfoDao.insertUser(tb_userinfo);   //update_ numbers
        if(result>0){
            return Result.okResult("插入字段的主键id:"+tb_userinfo.getId());
        }
        return Result.errorResult("插入字段失败");
    }

    @PostMapping
    public Result login(@RequestBody TbUserinfo tb_userinfo){

        log.info("登录操作:{}",tb_userinfo);
        TbUserinfo user = tbUserService.login(tb_userinfo);
        //插入JWT令牌生成，利用user
        return user!=null?Result.okResult("test"):Result.errorResult("error");
    }


}
