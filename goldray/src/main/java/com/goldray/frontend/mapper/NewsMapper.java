package com.goldray.frontend.mapper;

import com.goldray.backend.model.po.NewsPo;
import com.goldray.frontend.model.po.NewsListPo;
import com.goldray.frontend.model.po.OrderStyleEnum;
import com.goldray.frontend.model.po.TopNews;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
@Mapper
public interface NewsMapper {

    @Select("select id,title,isTop,addTime from t_news ORDER BY isTop Desc,addTime ${orderStyleEnum}")
    List<NewsListPo> findByIsShowAndOderByAddTime(@Param("orderStyleEnum") OrderStyleEnum orderStyleEnum);

    @Select("select title,text,addTime from t_news where id=#{id}")
    NewsPo getById(int id);

    @Select("select id,title,resume from t_news where isTop=1")
    TopNews getTopNews();
}
