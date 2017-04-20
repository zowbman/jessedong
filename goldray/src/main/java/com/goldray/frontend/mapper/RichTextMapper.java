package com.goldray.frontend.mapper;

import com.goldray.frontend.model.po.RichTextPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by zwb on 2017/4/20.
 */
@Mapper
public interface RichTextMapper {

    @Select("select text from t_rich_text where type=#{type}")
    RichTextPo getByType(@Param("type") int type);
}
