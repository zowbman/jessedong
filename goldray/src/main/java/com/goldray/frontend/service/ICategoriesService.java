package com.goldray.frontend.service;

import com.goldray.frontend.model.po.PdCategoriesPo;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
public interface ICategoriesService {

    /**
     * @return
     */
    List<PdCategoriesPo> countGroupByPd();
}
