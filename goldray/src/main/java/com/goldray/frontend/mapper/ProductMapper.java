package com.goldray.frontend.mapper;

import com.goldray.frontend.model.po.OrderStyleEnum;
import com.goldray.frontend.model.po.ProductDetailPo;
import com.goldray.frontend.model.po.ProductPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
@Mapper
public interface ProductMapper {

    @Select("select code,title,path,coverImgName from t_product order by addTime ${orderStyleEnum}")
    List<ProductPo> findAllOrderByAddTime(@Param("orderStyleEnum") OrderStyleEnum orderStyleEnum);

    @Select("select code,title,introduction,path,coverImgName,firstImgName,secondImgName,thirdImgName,text from t_product where code=#{code}")
    ProductDetailPo getByCode(@Param("code") String code);
}
