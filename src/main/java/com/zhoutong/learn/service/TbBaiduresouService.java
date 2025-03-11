package com.zhoutong.learn.service;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoutong.learn.mapper.TbBaiduresouDao;
import com.zhoutong.learn.model.PageBean;
import com.zhoutong.learn.model.TbBaiduresou;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TbBaiduresouService {

    private static final Logger log = LoggerFactory.getLogger(TbBaiduresouService.class);

    @Autowired
    private TbBaiduresouDao tbBaiduresouDao;

    /**
     * 解析json的方法
     *
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
     * 分页查询pageHelper实现
     *
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
        log.info("分页查询数据:{}", pg);
        log.info("分页查询数据完毕,数据:{}", list);
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
     * @return
     */
    public int insertData(String jsonString) {
        List<TbBaiduresou> tbBaiduresous = this.parseJson(jsonString);
        AtomicInteger code = new AtomicInteger();
        code.set(0);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                synchronized (tbBaiduresous){
                    tbBaiduresous.stream().forEach(e->{
                        tbBaiduresouDao.insertData(e);
                        log.info("插入数据完毕");
                        code.set(1);
                    });
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            log.info("插入数据错误",e);
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
