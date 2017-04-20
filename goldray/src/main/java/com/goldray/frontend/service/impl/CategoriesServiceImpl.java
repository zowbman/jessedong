package com.goldray.frontend.service.impl;

import com.goldray.frontend.mapper.CategoriesMapper;
import com.goldray.frontend.model.po.PdCategoriesPo;
import com.goldray.frontend.service.ICategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
@Service
public class CategoriesServiceImpl implements ICategoriesService {

    @Autowired
    private CategoriesMapper categoriesMapper;

    @Override
    public List<PdCategoriesPo> countGroupByPd() {
        return categoriesMapper.countGroupByPd();
    }
}
