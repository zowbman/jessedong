package com.goldray.backend.controller;

import com.goldray.backend.model.po.CategoriesPo;
import com.goldray.backend.model.vo.CategoriesVo;
import com.goldray.util.BackendReMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by zwb on 2017/3/30.
 */
@Controller("BCategoriesController")
@RequestMapping("/backend/categories")
public class CategoriesController extends BaseController {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 分类列表
     *
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String list(Model model) {
        List<CategoriesPo> categoriesPos = iCategoriesService.findAll();
        model.addAttribute("categoriesPos", categoriesPos);
        return "backend/categoriesList";
    }

    /**
     * 分类编辑
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
            CategoriesPo cPo = iCategoriesService.getById(id);
            if (cPo == null) {
                log.error("参数错误,type is edit, id:[{}] is error", id);
                model.addAttribute("msg", BackendReMsg.ID_ERROR);
                return "backend/error";
            }
            model.addAttribute("cPo", cPo);
        }
        model.addAttribute("type", type);
        return "backend/categoriesSave";
    }

    /**
     * 分类编辑保存
     *
     * @param type
     * @param categoriesVo
     * @param model
     * @return
     */
    @PostMapping("/saveSubmit")
    public String saveSubmit(String type, CategoriesVo categoriesVo, Model model) {
        log.info("type:[{}],categoriesVo[{}]", type, categoriesVo.toString());
        if (!TYPES.contains(type)) {
            log.error("参数错误,types:[{}] is not contains type:[{}]", TYPES.toString(), type);
            model.addAttribute("msg", BackendReMsg.TYPE_ERROR);
            return "backend/error";
        }
        if ("edit".equalsIgnoreCase(type) && categoriesVo.getId() == 0) {
            log.error("参数错误,type is edit, id is 0 error");
            model.addAttribute("msg", BackendReMsg.ID_ERROR);
            return "backend/error";
        }
        boolean result = false;
        if ("add".equalsIgnoreCase(type)) {
            result = iCategoriesService.save(categoriesVo);
        } else {
            CategoriesPo cp = iCategoriesService.getById(categoriesVo.getId());
            if (cp != null) {
                cp.setcAbbreviate(categoriesVo.getcAbbreviate());
                cp.setCategoriesName(categoriesVo.getCategoriesName());
                result = iCategoriesService.edit(cp);
            }
        }
        if (!result) {
            log.error(BackendReMsg.CATREGORIESSAVE_ERROR + ",param->type:[{}],categoriesVo[{}]", type, categoriesVo);
            model.addAttribute("msg", BackendReMsg.CATREGORIESSAVE_ERROR);
            return "backend/error";
        }
        model.addAttribute("backUrl", "/backend/categories/list");
        return "backend/success";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(defaultValue = "0") int id, Model model) {
        log.info("id:[{}]", id);
        if (id == 0) {
            log.error("参数错误,id is 0 error");
            model.addAttribute("msg", BackendReMsg.ID_ERROR);
        }
        boolean result = iCategoriesService.deleteById(id);
        if (!result) {
            model.addAttribute("msg", BackendReMsg.CATREGORIESDELETE_ERROR);
            return "backend/error";
        }
        model.addAttribute("backUrl", "/backend/categories/list");
        return "backend/success";
    }
}
