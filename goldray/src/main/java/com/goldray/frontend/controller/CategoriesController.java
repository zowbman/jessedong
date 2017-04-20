package com.goldray.frontend.controller;

import com.goldray.frontend.model.po.PdCategoriesPo;
import com.goldray.frontend.model.po.PubReturnMsg;
import com.goldray.helper.CodeHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zwb on 2017/4/20.
 */
@Controller
@RequestMapping("/categories/json")
public class CategoriesController extends BaseController {

    /**
     * @return
     */
    @GetMapping("/v1/pdCount")
    @ResponseBody
    public PubReturnMsg pdCount() {
        List<PdCategoriesPo> pdCategoriesPos = iCategoriesService.countGroupByPd();
        PdCategoriesPo all = new PdCategoriesPo();
        all.setId(-1);
        all.setCategoriesName("所有");
        pdCategoriesPos.forEach((pdCategoriesPo) -> {
            {
                all.setCount(all.getCount() + pdCategoriesPo.getCount());
            }
        });
        pdCategoriesPos.add(0, all);
        return new PubReturnMsg(CodeHelper.SUCCESS, pdCategoriesPos);
    }
}
