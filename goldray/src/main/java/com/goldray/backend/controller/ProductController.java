package com.goldray.backend.controller;

import com.goldray.backend.model.po.CategoriesPo;
import com.goldray.backend.model.po.ProductListPo;
import com.goldray.backend.model.po.ProductListPoShow;
import com.goldray.backend.model.po.ProductPo;
import com.goldray.backend.model.po.ProductPoShow;
import com.goldray.backend.model.vo.ProductVo;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zwb on 2017/4/19.
 */
@Controller("BProductController")
@RequestMapping("/backend/product")
public class ProductController extends BaseController {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 产品列表列表
     *
     * @param model
     * @return
     */
    @GetMapping("/list")
    public String list(Model model) {
        List<ProductListPo> productListPos = iProductService.findAll();
        List<CategoriesPo> categoriesPos = iCategoriesService.findAll();
        List<ProductListPoShow> productListPoShows = new ArrayList<>();
        productListPos.forEach((productListPo) -> {
            ProductListPoShow plps = new ProductListPoShow();
            plps.setCode(productListPo.getCode());//产品编号
            plps.setCoverImg(productListPo.getPath() + productListPo.getCoverImgName());//封面图片
            plps.setTitle(productListPo.getTitle());//标题
            categoriesPos.stream().filter((categoriesPo) -> categoriesPo.getId() == productListPo.getCategoriesId()).forEach((categoriesPo) -> {
                plps.setCategories(categoriesPo.getCategoriesName());//分类名称
            });
            plps.setAddTime(ConcurrentDateTimeUtil.format(productListPo.getAddTime() * 1000L));
            productListPoShows.add(plps);
        });
        model.addAttribute("productListPos", productListPoShows);
        return "backend/productList";
    }

    /**
     * product编辑
     *
     * @param type
     * @param code
     * @param model
     * @return
     */
    @GetMapping("/save")
    public String save(String type, String code, Model model) {
        log.info("type;[{}],code:[{}]", type, code);
        if (!TYPES.contains(type)) {
            log.error("参数错误,types:[{}] is not contains type:[{}]", TYPES.toString(), type);
            model.addAttribute("msg", BackendReMsg.TYPE_ERROR);
            return "backend/error";
        }
        if ("edit".equalsIgnoreCase(type) && (code == null || "".equals(code))) {
            log.error("参数错误,type is edit, code is error");
            model.addAttribute("msg", BackendReMsg.PRODUCTCODE_ERROR);
            return "backend/error";
        }
        ProductPoShow pps = new ProductPoShow();
        if ("edit".equalsIgnoreCase(type)) {
            ProductPo pp = iProductService.getByCode(code);
            if (pp == null) {
                log.error("参数错误,code:[{}] is error", code);
                model.addAttribute("msg", BackendReMsg.PRODUCTCODE_ERROR);
                return "backend/error";
            }
            pps.setCode(pp.getCode());
            pps.setTitle(pp.getTitle());
            pps.setCategoriesId(pp.getCategoriesId());
            pps.setIntroduction(pp.getIntroduction());
            pps.setAddTime(ConcurrentDateTimeUtil.format(pp.getAddTime() * 1000L));
            pps.setCoverImg(pp.getPath() + pp.getCoverImgName());
            pps.setFirstImg(!"".equals(pp.getFirstImgName()) ? pp.getPath() + pp.getFirstImgName() : pp.getFirstImgName());
            pps.setSecondImg(!"".equals(pp.getSecondImgName()) ? pp.getPath() + pp.getSecondImgName() : pp.getSecondImgName());
            pps.setThirdImg(!"".equals(pp.getThirdImgName()) ? pp.getPath() + pp.getThirdImgName() : pp.getThirdImgName());
            pps.setText(pp.getText());
        } else {
            pps.setAddTime(ConcurrentDateTimeUtil.format(System.currentTimeMillis()));
        }
        List<CategoriesPo> cp = iCategoriesService.findAll();
        model.addAttribute("cp", cp);
        model.addAttribute("pp", pps);
        model.addAttribute("type", type);
        return "backend/productSave";
    }

    /**
     * @param type
     * @param productVo
     * @param model
     * @return
     */
    @PostMapping("/saveSubmit")
    public String saveSubmit(String type, ProductVo productVo, Model model) {
        log.info("type:[{}],productVo[{}]", type, productVo.toString());
        if (!TYPES.contains(type)) {
            log.error("参数错误,types:[{}] is not contains type:[{}]", TYPES.toString(), type);
            model.addAttribute("msg", BackendReMsg.TYPE_ERROR);
            return "backend/error";
        }
        if ("add".equalsIgnoreCase(type) && (productVo.getCoverImg() == null || productVo.getCoverImg().isEmpty())) {
            log.error("参数错误,type is add, coverImg is empty");
            model.addAttribute("msg", BackendReMsg.PRODUCTCOVERIMGEMPTY_ERROR);
            return "backend/error";
        }
        if ("edit".equalsIgnoreCase(type) && (productVo.getCode() == null || "".equals(productVo.getCode()))) {
            log.error("参数错误,type is edit, code is error");
            model.addAttribute("msg", BackendReMsg.PRODUCTCODE_ERROR);
            return "backend/error";
        }
        String coverImgName = null, firstImgName = null, secondImgName = null, thirdImgName = null, path = null;
        //封面
        Map<String, Object> imgData = uploadProImg(productVo.getCoverImg());
        if ((boolean) imgData.get("state")) {
            path = (String) imgData.get("path");
            coverImgName = (String) imgData.get("imgName");
        }
        //图片1
        imgData = uploadProImg(productVo.getFirstImg());
        if ((boolean) imgData.get("state")) {
            firstImgName = (String) imgData.get("imgName");
        }
        //图片2
        imgData = uploadProImg(productVo.getSecondImg());
        if ((boolean) imgData.get("state")) {
            secondImgName = (String) imgData.get("imgName");
        }
        //图片3
        imgData = uploadProImg(productVo.getThirdImg());
        if ((boolean) imgData.get("state")) {
            thirdImgName = (String) imgData.get("imgName");
        }
        boolean result = false;
        if ("add".equalsIgnoreCase(type)) {
            ProductPo productPo = new ProductPo();
            if (coverImgName == null || path == null) {
                log.error(BackendReMsg.PRODUCTIMGUPLOAD_ERROR);
                model.addAttribute("msg", BackendReMsg.PRODUCTIMGUPLOAD_ERROR);
                return "backend/error";
            }
            productPo.setPath(path);
            productPo.setCoverImgName(coverImgName);//封面
            productPo.setFirstImgName(firstImgName);//图片1
            productPo.setSecondImgName(secondImgName);//图片2
            productPo.setThirdImgName(thirdImgName);//图片3
            productPo.setTitle(productVo.getTitle());
            productPo.setCategoriesId(productVo.getCategoriesId());
            productPo.setIntroduction(productVo.getIntroduction());
            productPo.setAddTime((int) (System.currentTimeMillis() / 1000L));
            productPo.setText(productVo.getText());
            result = iProductService.save(productPo);
        } else {
            ProductPo pp = iProductService.getByCode(productVo.getCode());
            if (pp != null) {
                if (path != null) {
                    pp.setPath(path);
                }
                if (coverImgName != null) {
                    pp.setCoverImgName(coverImgName);//封面
                }
                if (firstImgName != null) {
                    pp.setFirstImgName(firstImgName);//图片1
                }
                if (secondImgName != null) {
                    pp.setSecondImgName(secondImgName);//图片2
                }
                if (thirdImgName != null) {
                    pp.setThirdImgName(thirdImgName);//图片3
                }
                pp.setTitle(productVo.getTitle());
                pp.setCategoriesId(productVo.getCategoriesId());
                pp.setIntroduction(productVo.getIntroduction());
                pp.setAddTime((int) (System.currentTimeMillis() / 1000L));
                pp.setText(productVo.getText());
                result = iProductService.update(pp);
            }
        }
        if (!result) {
            log.error(BackendReMsg.PRODUCTSAVE_ERROR + ",param->type:[{}],productVo[{}]", type, productVo.toString());
            model.addAttribute("msg", BackendReMsg.PRODUCTSAVE_ERROR);
            return "backend/error";
        }
        model.addAttribute("backUrl", "/backend/product/list");
        return "backend/success";
    }

    /**
     * @param imgFile
     * @return
     */
    private Map<String, Object> uploadProImg(MultipartFile imgFile) {
        Map<String, Object> data = new HashMap<>();
        data.put("state", false);
        if (imgFile != null && !imgFile.isEmpty()) {
            String path = productDir + ConcurrentDateUtil.format(System.currentTimeMillis()) + "/";
            String imgName = imgFile.getOriginalFilename();
            String extName = imgName.substring(imgName.lastIndexOf("."), imgName.length());
            imgName = UUID.randomUUID().toString().replaceAll("\\-", "") + extName;
            boolean result = FileIoUtil.write(getSavePyPath(path), imgName, imgFile);
            if (result) {
                data.put("state", result);
                data.put("path", getSaveDbPath(path));
                data.put("imgName", imgName);
            } else {
                log.error("上传图片失败");
            }
        }
        return data;
    }

    /**
     *
     * @param code
     * @param model
     * @return
     */
    @GetMapping("/delete")
    public String delete(String code, Model model) {
        log.info("code:[{}]", code);
        if (code == null || "".equals(code)) {
            log.error("参数错误,code is error");
            model.addAttribute("msg", BackendReMsg.PRODUCTCODE_ERROR);
        }
        boolean result = iProductService.deleteByCode(code);
        if (!result) {
            model.addAttribute("msg", BackendReMsg.PRODUCTDELETE_ERROR);
            return "backend/error";
        }
        model.addAttribute("backUrl", "/backend/product/list");
        return "backend/success";
    }

    /**
     *
     * @param code
     * @param imgNum
     * @param model
     * @return
     */
    @GetMapping("/rmPdImg")
    public String rmPdImg(String code, int imgNum, Model model){
        log.info("code:[{}]", code);
        if (code == null || "".equals(code)) {
            log.error("参数错误,code is error");
            model.addAttribute("msg", BackendReMsg.PRODUCTCODE_ERROR);
        }
        if (IMGNAME.get(imgNum) == null) {
            log.error("参数错误,IMGNUM_LIST:[{}] is not contains imgNum:[{}]", IMGNAME.toString(), imgNum);
            model.addAttribute("msg", BackendReMsg.RMPDIMGNUM_ERROR);
            return "backend/error";
        }
        boolean result = iProductService.rmPdImg(code, IMGNAME.get(imgNum));
        if(!result){
            model.addAttribute("msg", BackendReMsg.RMPDIMG_ERROR);
            return "backend/error";
        }
        model.addAttribute("backUrl", "/backend/product/save?type=edit&code=" + code);
        return "backend/success";
    }
}
