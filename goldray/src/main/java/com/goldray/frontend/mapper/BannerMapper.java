package com.goldray.frontend.mapper;

import com.goldray.frontend.model.po.BannerPo;
import com.goldray.frontend.model.po.OrderStyleEnum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
@Mapper
public interface BannerMapper {

    @Select("select title,path,imgName,url,isBlank from t_banner where isShow=#{isShow} ORDER BY addTime ${orderStyleEnum}")
    List<BannerPo> findByIsShowAndOderByAddTime(@Param("isShow") int isShow, @Param("orderStyleEnum") OrderStyleEnum orderStyleEnum);
}
