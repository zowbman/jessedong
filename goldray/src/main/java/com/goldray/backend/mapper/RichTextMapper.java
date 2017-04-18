package com.goldray.backend.mapper;

import com.goldray.backend.model.po.RichTextPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by zwb on 2017/4/18.
 */
@Mapper
public interface RichTextMapper {
    @Select("select id,type,text,addTime from t_rich_text where type=#{type}")
    RichTextPo getByType(@Param("type") int type);

    @Insert("insert ignore into t_rich_text(type,text,addTime) values(#{type},#{text},#{addTime})")
    boolean save(@Param("type") int type, @Param("text") String text, @Param("addTime") int addTime);

    @Select("select count(1) from t_rich_text where type = #{type}")
    int isExistType(@Param("type") int type);

    @Select("select id,type,text,addTime from t_rich_text where id=#{id}")
    RichTextPo getById(@Param("id") int id);

    @Update("update t_rich_text set text=#{text},addTime=#{addTime} where id=#{id}")
    boolean update(@Param("id") int id, @Param("text") String text, @Param("addTime") int addTime);
}
