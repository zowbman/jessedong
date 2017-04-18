package com.goldray.backend.mapper;

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
public interface CategoriesMapper {

    @Select("select * from t_categories")
    List<CategoriesPo> findAll();

    @Select("select id,categoriesName,cAbbreviate from t_categories where id=#{id}")
    CategoriesPo getById(@Param("id") int id);

    @Insert("insert ignore into t_categories(categoriesName,cAbbreviate) values(#{categoriesName},#{cAbbreviate})")
    boolean save(@Param("categoriesName") String categoriesName, @Param("cAbbreviate") String cAbbreviate);

    @Update("update t_categories set categoriesName=#{categoriesName},cAbbreviate=#{cAbbreviate} where id=#{id}")
    boolean edit(@Param("id") int id, @Param("categoriesName") String categoriesName, @Param("cAbbreviate") String cAbbreviate);

    @Delete("delete from t_categories where id=#{id}")
    boolean deleteById(@Param("id") int id);
}
