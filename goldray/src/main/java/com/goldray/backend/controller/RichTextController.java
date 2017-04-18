package com.goldray.backend.controller;

import com.goldray.backend.model.po.RichTextPo;
import com.goldray.backend.model.po.RichTextPoShow;
import com.goldray.backend.model.vo.BannerVo;
import com.goldray.backend.model.vo.RichTextVo;
import com.goldray.util.BackendReMsg;
import com.goldray.util.ConcurrentDateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zwb on 2017/4/18.
 */
@Controller("BRichTextController")
@RequestMapping("/backend/richText")
public class RichTextController extends BaseController {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * @param richType 类型
     * @return
     */
    @GetMapping("/save")
    public String save(@RequestParam(defaultValue = "-1") int richType, Model model) {
        log.info("richType;[{}]", richType);
        if (RICHTEXT_TYPE.get(richType) == null) {
            log.error("参数错误,types:[{}] is not contains type:[{}]", RICHTEXT_TYPE.toString(), richType);
            model.addAttribute("msg", BackendReMsg.RICHTYPE_ERROR);
            return "backend/error";
        }
        RichTextPo rtp = iRichTextService.getByType(richType);
        RichTextPoShow rtps = new RichTextPoShow();
        if (rtp == null) {
            rtps.setAddTime(ConcurrentDateTimeUtil.format(System.currentTimeMillis()));
            model.addAttribute("type", "add");
        } else {
            rtps.setId(rtp.getId());
            rtps.setText(rtp.getText());
            rtps.setAddTime(ConcurrentDateTimeUtil.format(rtp.getAddTime() * 1000L));
            model.addAttribute("type", "edit");
        }
        model.addAttribute("richType", richType);
        model.addAttribute("rtps", rtps);
        return "backend/richTextSave";
    }

    /**
     * @param type
     * @param richTextVo
     * @param model
     * @return
     */
    @PostMapping("/saveSubmit")
    public String saveSubmit(String type, RichTextVo richTextVo, Model model) {
        log.info("type:[{}],richTextVo[{}]", type, richTextVo.toString());
        if (!TYPES.contains(type)) {
            log.error("参数错误,types:[{}] is not contains type:[{}]", TYPES.toString(), type);
            model.addAttribute("msg", BackendReMsg.TYPE_ERROR);
            return "backend/error";
        }
        if ("edit".equalsIgnoreCase(type) && richTextVo.getId() == 0) {
            log.error("参数错误,type is edit, id is 0 error");
            model.addAttribute("msg", BackendReMsg.ID_ERROR);
            return "backend/error";
        }
        boolean result = false;
        if ("add".equalsIgnoreCase(type)) {
            RichTextPo rtp = new RichTextPo();
            rtp.setType(richTextVo.getRichType());
            rtp.setText(richTextVo.getText());
            rtp.setAddTime((int) (richTextVo.getAddTime().getTime() / 1000L));
            result = iRichTextService.save(rtp);
        } else {
            RichTextPo rtp = iRichTextService.getById(richTextVo.getId());
            if (rtp != null) {
                rtp.setText(richTextVo.getText());
                rtp.setAddTime((int) (richTextVo.getAddTime().getTime() / 1000L));
                result = iRichTextService.update(rtp);
            }
        }
        if (!result) {
            log.error(BackendReMsg.RICHTEXTSAVE_ERROR + ",param->type:[{}],richTextVo[{}]", type, richTextVo.toString());
            model.addAttribute("msg", BackendReMsg.RICHTEXTSAVE_ERROR);
            return "backend/error";
        }
        model.addAttribute("backUrl", "/backend/richText/save?richType=" + richTextVo.getRichType());
        return "backend/success";
    }
}
