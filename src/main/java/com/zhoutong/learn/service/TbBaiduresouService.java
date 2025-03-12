package com.zhoutong.learn.service;

import ch.qos.logback.classic.Logger;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoutong.learn.configuration.DefineLogger;
import com.zhoutong.learn.mapper.TbBaiduresouDao;
import com.zhoutong.learn.model.PageBean;
import com.zhoutong.learn.model.TbBaiduresou;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TbBaiduresouService {

    @DefineLogger
    private Logger logger;

    @Autowired
    private TbBaiduresouDao tbBaiduresouDao;

    /**
     * 解析json的工具
     * @param json
     * @return List<TbBaiduresou>
     */
    public List<TbBaiduresou> parseJson(String json) {
        List<TbBaiduresou> list = new ArrayList<>();
        JSONObject parse = JSONObject.parse(json);
        Set<String> keyset = parse.keySet();
        for (String key : keyset) {
            JSONArray jsonArray = parse.getJSONArray(key);
            jsonArray.stream().forEach(e ->
            {
                list.add(new TbBaiduresou(key, (String) e));
            });
        }
        return list;
    }

    /**
     * 分页查询，pageHelper实现
     * @param page
     * @param pageSize
     * @return
     */
    public PageBean getPage(int page, int pageSize) {
//        int page_ = (page -1)*pageSize;
        if (page <= 0) page = 1;
        if (pageSize < 1) pageSize = 10;
        Page<TbBaiduresou> pg = PageHelper.startPage(page, pageSize);
        List<TbBaiduresou> list = tbBaiduresouDao.list();
        PageInfo<TbBaiduresou> tb = new PageInfo<>(list);
        logger.info("分页查询数据完毕,数据总条数{}\r\n", tb.getTotal());
//        log.info("分页查询数据:{}\r\n", pg);
//        log.info("分页查询数据完毕,数据:{}\r\n", list);
//        Page<TbBaiduresou> res = (Page<TbBaiduresou>) list;
//        return new PageBean(res.getTotal(),pg.getResult());
        return new PageBean(tb.getTotal(), tb.getList());
    }

    public int insertByModel(TbBaiduresou tbBaiduresou){
        Integer code = tbBaiduresouDao.insertData(tbBaiduresou);
        return code;
}
    /**
     *  插入json格式对象
     * @param jsonString
     * @return int 插入成功返回1，失败返回0
     */
    public int insertData(String jsonString) {
        List<TbBaiduresou> tbBaiduresous = this.parseJson(jsonString);
        AtomicInteger code = new AtomicInteger();
        code.set(0);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                logger.info(Thread.currentThread().getName());
                synchronized (tbBaiduresous){
                    tbBaiduresous.stream().forEach(e->{
                        tbBaiduresouDao.insertData(e);
                        logger.info("插入数据完毕");
                        code.set(1);
                    });
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            logger.info("插入数据错误",e);
        }
        return code.get();
    }

    /**
     * 查询所有热搜数据
     * @return
     */
    public List<TbBaiduresou> listData(){
        return tbBaiduresouDao.list();
    }

    /**
     * 分页查询数据
     * @param page
     * @param pageSize
     * @return
     */
    public List<TbBaiduresou> listDataLimit(int page, int pageSize){
        return tbBaiduresouDao.listLimit(page,pageSize);
    }

    public PageBean getBetweenById(int beginId, int endId, int page, int pageSize) {
        Page<TbBaiduresou> pa = PageHelper.startPage(page,pageSize);
        List<TbBaiduresou> list = tbBaiduresouDao.getBetweenId(beginId,endId);
        PageInfo<TbBaiduresou> info = new PageInfo<>(list);
        return new PageBean(info.getTotal(),info.getList());
    }

    /**
     * 批量删除by id
     * @param ids
     */
    @Transactional(rollbackFor = Exception.class)
    public void deleteIds(List<Integer> ids) {
        tbBaiduresouDao.deleteIds(ids);
    }
}
