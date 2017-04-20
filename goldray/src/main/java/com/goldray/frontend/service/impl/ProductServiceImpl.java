package com.goldray.frontend.service.impl;

import com.goldray.frontend.mapper.ProductMapper;
import com.goldray.frontend.model.po.OrderStyleEnum;
import com.goldray.frontend.model.po.ProductDetailPo;
import com.goldray.frontend.model.po.ProductPo;
import com.goldray.frontend.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<ProductPo> findAllOrderByAddTime(OrderStyleEnum orderStyleEnum) {
        return productMapper.findAllOrderByAddTime(orderStyleEnum);
    }

    @Override
    public ProductDetailPo getByCode(String code) {
        return productMapper.getByCode(code);
    }
}
