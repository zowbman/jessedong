package com.goldray.backend.service;

import com.goldray.backend.model.po.ProductListPo;
import com.goldray.backend.model.po.ProductPo;

import java.util.List;

/**
 * Created by zwb on 2017/4/19.
 */
public interface IProductService {

    /**
     * @return
     */
    List<ProductListPo> findAll();

    /**
     * @param code
     * @return
     */
    ProductPo getByCode(String code);

    /**
     * @param productPo
     * @return
     */
    boolean save(ProductPo productPo);

    /**
     * @param productPo
     * @return
     */
    boolean update(ProductPo productPo);

    /**
     * @param code
     * @return
     */
    boolean deleteByCode(String code);

    /**
     * @param code
     * @param imgName
     * @return
     */
    boolean rmPdImg(String code, String imgName);
}
