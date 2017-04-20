package com.goldray.backend.mapper;

import com.goldray.backend.model.po.ProductListPo;
import com.goldray.backend.model.po.ProductPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by zwb on 2017/4/19.
 */
@Mapper
public interface BProductMapper {
    @Select("select code,categoriesId,title,path,coverImgName,addTime from t_product")
    List<ProductListPo> findAll();

    @Select("select id,code,title,categoriesId,introduction,addTime,path,coverImgName,firstImgName,secondImgName,thirdImgName,text from t_product where code=#{code}")
    ProductPo getByCode(String code);

    @Insert("insert ignore into t_product(code,title,categoriesId,introduction,addTime,path,coverImgName,firstImgName,secondImgName,thirdImgName,text) values(#{productPo.code},#{productPo.title},#{productPo.categoriesId},#{productPo.introduction},#{productPo.addTime},#{productPo.path},#{productPo.coverImgName},#{productPo.firstImgName},#{productPo.secondImgName},#{productPo.thirdImgName},#{productPo.text})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "productPo.id", before = false, resultType = Integer.class)
    boolean save(@Param("productPo") ProductPo productPo);

    @Update("update t_product set code=#{newCode} where code=#{oldCode}")
    boolean updateCodeByCode(@Param("oldCode") String oldCode, @Param("newCode") String newCode);

    @Update("update t_product set code=#{code},title=#{title},categoriesId=#{categoriesId},introduction=#{introduction},addTime=#{addTime},path=#{path},coverImgName=#{coverImgName},firstImgName=#{firstImgName},secondImgName=#{secondImgName},thirdImgName=#{thirdImgName},text=#{text} where id=#{id}")
    boolean update(@Param("id") int id, @Param("code") String code, @Param("title") String title, @Param("categoriesId") int categoriesId, @Param("introduction") String introduction, @Param("addTime") int addTime, @Param("path") String path, @Param("coverImgName") String coverImgName, @Param("firstImgName") String firstImgName, @Param("secondImgName") String secondImgName, @Param("thirdImgName") String thirdImgName, @Param("text") String text);

    @Delete("delete from t_product where code=#{code}")
    boolean deleteByCode(@Param("code") String code);

    @Update("update t_product set ${imgName}='' where code=#{code}")
    boolean rmPdImgByCode(@Param("code") String code, @Param("imgName") String imgName);
}
