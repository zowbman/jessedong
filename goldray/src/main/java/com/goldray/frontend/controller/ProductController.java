package com.goldray.frontend.controller;

import com.goldray.frontend.model.po.OrderStyleEnum;
import com.goldray.frontend.model.po.ProductDetailPo;
import com.goldray.frontend.model.po.ProductDetailPoShow;
import com.goldray.frontend.model.po.ProductPo;
import com.goldray.frontend.model.po.PubReturnMsg;
import com.goldray.helper.CodeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
@Controller
@RequestMapping("/product/json")
public class ProductController extends BaseController {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * @return
     */
    @GetMapping("/v1/list")
    @ResponseBody
    public PubReturnMsg list() {
        List<ProductPo> productPos = iProductService.findAllOrderByAddTime(OrderStyleEnum.DESC);
        return new PubReturnMsg(CodeHelper.SUCCESS, productPos);
    }

    /**
     * @return
     */
    @GetMapping("/v1/{code}")
    @ResponseBody
    public PubReturnMsg detail(@PathVariable("code") String code) {
        log.info("param code;[{}]", code);
        if ("".equals(code)) {
            log.error("param code:[{}] is error", code);
            return new PubReturnMsg(CodeHelper.PARAMS_ERROR);
        }
        ProductDetailPo productDetailPo = iProductService.getByCode(code);
        if (productDetailPo == null) {
            log.error("param code:[{}],产品不存在", code);
            return new PubReturnMsg(CodeHelper.PARAMS_ERROR);
        }
        ProductDetailPoShow productDetailPoShow = new ProductDetailPoShow();
        productDetailPoShow.setCode(productDetailPo.getCode());
        productDetailPoShow.setTitle(productDetailPo.getTitle());
        productDetailPoShow.setIntroduction(productDetailPo.getIntroduction());
        productDetailPoShow.setText(productDetailPo.getText());
        List<String> pdImg = new ArrayList<>();
        pdImg.add(productDetailPo.getPath() + productDetailPo.getCoverImgName());
        if (!"".equals(productDetailPo.getFirstImgName())) {
            pdImg.add(productDetailPo.getPath() + productDetailPo.getFirstImgName());
        }
        if (!"".equals(productDetailPo.getSecondImgName())) {
            pdImg.add(productDetailPo.getPath() + productDetailPo.getSecondImgName());
        }
        if (!"".equals(productDetailPo.getThirdImgName())) {
            pdImg.add(productDetailPo.getPath() + productDetailPo.getThirdImgName());
        }
        productDetailPoShow.setPdImg(pdImg);
        return new PubReturnMsg(CodeHelper.SUCCESS, productDetailPoShow);
    }
}
