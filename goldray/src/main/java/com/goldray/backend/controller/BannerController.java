package com.goldray.backend.controller;

import com.goldray.backend.model.po.BannerPo;
import com.goldray.backend.model.po.BannerPoShow;
import com.goldray.backend.model.vo.BannerVo;
import com.goldray.util.BackendReMsg;
import com.goldray.util.ConcurrentDateTimeUtil;
import com.goldray.util.ConcurrentDateUtil;
import com.goldray.util.FileIoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zwb on 2017/4/11.
 */
@Controller("BBannerController")
@RequestMapping("/backend/banner")
public class BannerController extends BaseController {
    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * banner列表
     *
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String list(Model model) {
        List<BannerPo> bannerPos = iBannerService.findAll();
        List<BannerPoShow> bannerPoShows = new ArrayList<>();
        bannerPos.forEach((bannerPo) -> {
            BannerPoShow bps = new BannerPoShow();
            bps.setId(bannerPo.getId());
            bps.setTitle(bannerPo.getTitle());
            bps.setImgUrl(bannerPo.getPath() + bannerPo.getImgName());
            bps.setIsShow(bannerPo.getIsShow() == 0 ? "否" : "是");
            bps.setAddTime(ConcurrentDateTimeUtil.format(bannerPo.getAddTime() * 1000L));
            bannerPoShows.add(bps);
        });
        model.addAttribute("bannerPos", bannerPoShows);
        return "backend/bannerList";
    }

    /**
     * banner编辑
     *
     * @param type
     * @return
     */
    @GetMapping("/save")
    public String save(String type, @RequestParam(defaultValue = "0") int id, Model model) {
        log.info("type;[{}],id:[{}]", type, id);
        if (!TYPES.contains(type)) {
            log.error("参数错误,types:[{}] is not contains type:[{}]", TYPES.toString(), type);
            model.addAttribute("msg", BackendReMsg.TYPE_ERROR);
            return "backend/error";
        }
        if ("edit".equalsIgnoreCase(type) && id == 0) {
            log.error("参数错误,type is edit, id is 0 error");
            model.addAttribute("msg", BackendReMsg.ID_ERROR);
            return "backend/error";
        }
        if ("edit".equalsIgnoreCase(type)) {
            BannerPo bp = iBannerService.getById(id);
            if (bp == null) {
                log.error("参数错误,type is edit, id:[{}] is error", id);
                model.addAttribute("msg", BackendReMsg.ID_ERROR);
                return "backend/error";
            }
            model.addAttribute("bp", bp);
        }
        model.addAttribute("type", type);
        return "backend/bannerSave";
    }

    /**
     * banner编辑保存
     *
     * @param type
     * @param bannerVo
     * @param model
     * @return
     */
    @PostMapping("/saveSubmit")
    public String saveSubmit(String type, BannerVo bannerVo, Model model) {
        log.info("type:[{}],bannerVo[{}]", type, bannerVo.toString());
        if (!TYPES.contains(type)) {
            log.error("参数错误,types:[{}] is not contains type:[{}]", TYPES.toString(), type);
            model.addAttribute("msg", BackendReMsg.TYPE_ERROR);
            return "backend/error";
        }
        if ("add".equalsIgnoreCase(type) && (bannerVo.getBannerImg() == null || bannerVo.getBannerImg().isEmpty())) {
            log.error("参数错误,type is edit, file is empty");
            model.addAttribute("msg", BackendReMsg.IMGEMPTY_ERROR);
            return "backend/error";
        }
        if ("edit".equalsIgnoreCase(type) && bannerVo.getId() == 0) {
            log.error("参数错误,type is edit, id is 0 error");
            model.addAttribute("msg", BackendReMsg.ID_ERROR);
            return "backend/error";
        }
        String path = null;
        String imgName = null;
        if (!bannerVo.getBannerImg().isEmpty()) {
            path = bannerDir + ConcurrentDateUtil.format(System.currentTimeMillis()) + "/";
            imgName = bannerVo.getBannerImg().getOriginalFilename();
            String extName = imgName.substring(imgName.lastIndexOf("."), imgName.length());
            imgName = UUID.randomUUID().toString().replaceAll("\\-", "") + extName;
            boolean result = FileIoUtil.write(getSavePyPath(path), imgName, bannerVo.getBannerImg());
            if (!result) {
                log.error(BackendReMsg.BANNERFILEIO_ERROR);
                model.addAttribute("msg", BackendReMsg.BANNERFILEIO_ERROR);
                return "backend/error";
            }
        }
        boolean result = false;
        if ("add".equalsIgnoreCase(type)) {
            BannerPo bp = new BannerPo();
            bp.setTitle(bannerVo.getTitle());
            bp.setPath(getSaveDbPath(path));
            bp.setImgName(imgName);
            bp.setIsShow(bannerVo.getIsShow());
            result = iBannerService.save(bp);
        } else {
            BannerPo bp = iBannerService.getById(bannerVo.getId());
            if (bp != null) {
                bp.setTitle(bannerVo.getTitle());
                if (path != null) {
                    bp.setPath(getSaveDbPath(path));
                }
                if (imgName != null) {
                    bp.setImgName(imgName);
                }
                bp.setIsShow(bannerVo.getIsShow());
                result = iBannerService.edit(bp);
            }
        }
        if (!result) {
            log.error(BackendReMsg.BANNERSAVE_ERROR + ",param->type:[{}],bannerVo[{}]", type, bannerVo.toString());
            model.addAttribute("msg", BackendReMsg.BANNERSAVE_ERROR);
            return "backend/error";
        }
        model.addAttribute("backUrl", "/backend/banner/list");
        return "backend/success";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(defaultValue = "0") int id, Model model) {
        log.info("id:[{}]", id);
        if (id == 0) {
            log.error("参数错误,id is 0 error");
            model.addAttribute("msg", BackendReMsg.ID_ERROR);
        }
        boolean result = iBannerService.deleteById(id);
        if (!result) {
            model.addAttribute("msg", BackendReMsg.BANNERDELETE_ERROR);
            return "backend/error";
        }
        model.addAttribute("backUrl", "/backend/banner/list");
        return "backend/success";
    }
}
