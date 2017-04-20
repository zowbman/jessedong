package com.goldray.frontend.mapper;

import com.goldray.frontend.model.po.PdCategoriesPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
@Mapper
public interface CategoriesMapper {


    @Select("select tc.id,tc.categoriesName,count(tp.id) as count from t_categories tc LEFT JOIN t_product tp on tc.id = tp.categoriesId group by tc.id ORDER BY tc.cAbbreviate")
    List<PdCategoriesPo> countGroupByPd();
}
