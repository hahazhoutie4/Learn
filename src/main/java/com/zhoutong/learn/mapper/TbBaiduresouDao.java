package com.zhoutong.learn.mapper;

import com.zhoutong.learn.model.TbBaiduresou;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbBaiduresouDao {
    public Integer insertData(TbBaiduresou tbBaiduresou);
}
