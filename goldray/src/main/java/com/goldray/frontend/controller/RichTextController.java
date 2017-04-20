package com.goldray.frontend.controller;

import com.goldray.frontend.model.po.PubReturnMsg;
import com.goldray.frontend.model.po.RichTextPo;
import com.goldray.helper.CodeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zwb on 2017/4/20.
 */
@Controller
@RequestMapping("/richText/json")
public class RichTextController extends BaseController {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     *
     * @param type
     * @return
     */
    @GetMapping("/v1/{type}")
    @ResponseBody
    public PubReturnMsg detail(@PathVariable("type") int type) {
        if (RICHTEXT_TYPE.get(type) == null) {
            log.error("param type:[{}] is error", type);
            return new PubReturnMsg(CodeHelper.PARAMS_ERROR);
        }
        RichTextPo richTextPo = iRichTextService.getByType(type);
        return new PubReturnMsg(CodeHelper.SUCCESS, richTextPo);
    }
}
