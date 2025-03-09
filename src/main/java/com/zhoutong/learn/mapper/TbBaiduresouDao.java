package com.zhoutong.learn.mapper;

import com.zhoutong.learn.model.TbBaiduresou;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TbBaiduresouDao {
    Integer insertData(TbBaiduresou tbBaiduresou);

    List<TbBaiduresou> list();

    List<TbBaiduresou> listLimit(@Param("page") int page, @Param("pageSize") int pageSize);

    List<TbBaiduresou> getBetweenId(@Param("beginId") int beginId, @Param("endId") int endId);

    void deleteIds(@Param("ids") List<Integer> ids);
}
