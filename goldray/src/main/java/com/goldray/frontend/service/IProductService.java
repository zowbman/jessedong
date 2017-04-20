package com.goldray.frontend.service;

import com.goldray.frontend.model.po.OrderStyleEnum;
import com.goldray.frontend.model.po.ProductDetailPo;
import com.goldray.frontend.model.po.ProductPo;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
public interface IProductService {

    /**
     *
     * @param orderStyleEnum
     * @return
     */
    List<ProductPo> findAllOrderByAddTime(OrderStyleEnum orderStyleEnum);

    /**
     *
     * @param code
     * @return
     */
    ProductDetailPo getByCode(String code);
}
