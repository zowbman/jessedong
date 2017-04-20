package com.goldray.backend.service.impl;

import com.goldray.backend.mapper.BCategoriesMapper;
import com.goldray.backend.model.po.CategoriesPo;
import com.goldray.backend.model.vo.CategoriesVo;
import com.goldray.backend.service.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwb on 2017/3/30.
 */
@Service("BCategoriesServiceImpl")
public class CategoriesServiceImpl implements ICategoriesService {

    @Autowired
    private BCategoriesMapper categoriesMapper;

    @Override
    public List<CategoriesPo> findAll() {
        return categoriesMapper.findAll();
    }

    @Override
    public CategoriesPo getById(int id) {
        return categoriesMapper.getById(id);
    }

    @Override
    public boolean save(CategoriesVo categoriesVo) {
        return categoriesMapper.save(categoriesVo.getCategoriesName(), categoriesVo.getcAbbreviate());
    }

    @Override
    public boolean edit(CategoriesPo categoriesPo) {
        return categoriesMapper.edit(categoriesPo.getId(), categoriesPo.getCategoriesName(), categoriesPo.getcAbbreviate());
    }

    @Override
    public boolean deleteById(int id) {
        return categoriesMapper.deleteById(id);
    }
}
