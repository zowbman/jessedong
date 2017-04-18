package com.goldray.backend.service;

import com.goldray.backend.model.po.CategoriesPo;
import com.goldray.backend.model.vo.CategoriesVo;

import java.util.List;

/**
 * Created by zwb on 2017/3/30.
 */
public interface ICategoriesService {

    /**
     * 查询全部产品分类
     *
     * @return
     */
    List<CategoriesPo> findAll();

    /**
     * 查询产品分类
     *
     * @param id
     * @return
     */
    CategoriesPo getById(int id);

    /**
     * 添加
     *
     * @param categoriesVo
     * @return
     */
    boolean save(CategoriesVo categoriesVo);

    /**
     * 修改
     *
     * @param categoriesPo
     * @return
     */
    boolean edit(CategoriesPo categoriesPo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean deleteById(int id);
}
