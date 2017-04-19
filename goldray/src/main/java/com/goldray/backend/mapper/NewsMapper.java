package com.goldray.backend.mapper;

import com.goldray.backend.model.po.NewsListPo;
import com.goldray.backend.model.po.NewsPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by zwb on 2017/4/19.
 */
@Mapper
public interface NewsMapper {
    @Select("select id,title,isTop,addTime from t_news")
    List<NewsListPo> findAll();

    @Select("select id,title,text,isTop,addTime from t_news where id=#{id}")
    NewsPo getById(@Param("id") int id);

    @Insert("insert ignore into t_news(title,text,isTop,addTime) values(#{title},#{text},#{isTop},#{addTime})")
    boolean save(@Param("title") String title, @Param("text") String text, @Param("isTop") int isTop, @Param("addTime") int addTime);

    @Update("update t_news set title=#{title},text=#{text},isTop=#{isTop},addTime=#{addTime} where id=#{id}")
    boolean update(@Param("id") int id, @Param("title") String title, @Param("text") String text, @Param("isTop") int isTop, @Param("addTime") int addTime);

    @Delete("delete from t_news where id=#{id}")
    boolean deleteById(@Param("id") int id);

    @Update("update t_news set isTop=0 where isTop=1")
    boolean updateByIsTop();

    @Update("update t_news set isTop=0 where isTop=1 and id!=#{id}")
    boolean updateByIsTopAndNotMe(@Param("id") int id);
}
