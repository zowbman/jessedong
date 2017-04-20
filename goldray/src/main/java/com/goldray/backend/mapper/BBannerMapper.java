package com.goldray.backend.mapper;

import com.goldray.backend.model.po.BannerPo;
import com.goldray.backend.model.po.CategoriesPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by zwb on 2017/3/30.
 */
@Mapper
public interface BBannerMapper {

    @Select("select id,title,path,imgName,isShow,addTime from t_banner")
    List<BannerPo> findAll();

    @Select("select id,title,path,imgName,url,isShow,isBlank from t_banner where id=#{id}")
    BannerPo getById(@Param("id") int id);

    @Insert("insert ignore into t_banner(title,path,imgName,url,isShow,isBlank,addTime) values(#{title},#{path},#{imgName},#{url},#{isShow},#{isBlank},#{addTime})")
    boolean save(@Param("title") String title, @Param("path") String path, @Param("imgName") String imgName, @Param("url") String url, @Param("isShow") int isShow, @Param("isBlank") int isBlank, @Param("addTime") int addTime);

    @Update("update t_banner set title=#{title},path=#{path},imgName=#{imgName},url=#{url},isShow=#{isShow},isBlank=#{isBlank} where id=#{id}")
    boolean edit(@Param("id") int id, @Param("title") String title, @Param("path") String path, @Param("imgName") String imgName, @Param("url") String url, @Param("isShow") int isShow, @Param("isBlank") int isBlank);

    @Delete("delete from t_banner where id=#{id}")
    boolean deleteById(@Param("id") int id);
}