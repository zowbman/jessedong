package com.goldray.frontend.controller;

import com.goldray.frontend.model.po.BannerPo;
import com.goldray.frontend.model.po.OrderStyleEnum;
import com.goldray.frontend.model.po.PubReturnMsg;
import com.goldray.helper.CodeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
@Controller
@RequestMapping("/banner/json")
public class BannerController extends BaseController{

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     *
     * @return
     */
    @GetMapping("/v1/list")
    @ResponseBody
    public PubReturnMsg list() {
        List<BannerPo> bannerPos = iBannerService.findByIsShowAndOderByAddTime(1, OrderStyleEnum.DESC);
        return new PubReturnMsg(CodeHelper.SUCCESS, bannerPos);
    }
}
