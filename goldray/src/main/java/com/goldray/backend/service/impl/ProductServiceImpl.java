package com.goldray.backend.service.impl;

import com.goldray.backend.mapper.BCategoriesMapper;
import com.goldray.backend.mapper.BProductMapper;
import com.goldray.backend.model.po.CategoriesPo;
import com.goldray.backend.model.po.ProductListPo;
import com.goldray.backend.model.po.ProductPo;
import com.goldray.backend.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by zwb on 2017/4/19.
 */
@Service("BProductServiceImpl")
public class ProductServiceImpl implements IProductService {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private BProductMapper productMapper;

    @Autowired
    private BCategoriesMapper categoriesMapper;

    @Override
    public List<ProductListPo> findAll() {
        return productMapper.findAll();
    }

    @Override
    public ProductPo getByCode(String code) {
        return productMapper.getByCode(code);
    }

    @Override
    public boolean save(ProductPo productPo) {
        CategoriesPo categoriesPo = categoriesMapper.getById(productPo.getCategoriesId());
        if (categoriesPo != null) {
            productPo.setCode(categoriesPo.getcAbbreviate() + categoriesPo.getId() + "-" + UUID.randomUUID().toString().replaceAll("\\-", ""));
            boolean result = productMapper.save(productPo);
            if (result) {
                String newCode = productPo.getCode();
                newCode = newCode.substring(0, newCode.lastIndexOf("-") + 1);
                newCode += productPo.getId();
                return productMapper.updateCodeByCode(productPo.getCode(), newCode);
            } else {
                log.error("保存产品失败,productPo;[{}]", productPo.toString());
                return false;
            }
        } else {
            log.error("获取产品分类失败,categoriesId:[{}]", productPo.getCategoriesId());
            return false;
        }
    }

    @Override
    public boolean update(ProductPo productPo) {
        CategoriesPo categoriesPo = categoriesMapper.getById(productPo.getCategoriesId());
        if (categoriesPo != null) {
            productPo.setCode(categoriesPo.getcAbbreviate() + categoriesPo.getId() + "-" + productPo.getId());
            return productMapper.update(productPo.getId(), productPo.getCode(), productPo.getTitle(), productPo.getCategoriesId(), productPo.getIntroduction(), productPo.getAddTime(), productPo.getPath(), productPo.getCoverImgName(), productPo.getFirstImgName(), productPo.getSecondImgName(), productPo.getThirdImgName(), productPo.getText());
        } else {
            log.error("获取产品分类失败,categoriesId:[{}]", productPo.getCategoriesId());
            return false;
        }
    }

    @Override
    public boolean deleteByCode(String code) {
        return productMapper.deleteByCode(code);
    }

    @Override
    public boolean rmPdImg(String code, String imgName) {
        return productMapper.rmPdImgByCode(code, imgName);
    }
}
