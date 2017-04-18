package com.goldray.backend.controller;

import com.goldray.backend.model.po.FUResult;
import com.goldray.util.BackendReMsg;
import com.goldray.util.ConcurrentDateUtil;
import com.goldray.util.FileIoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Created by zwb on 2017/4/18.
 */
@Controller("BFileUploadController")
@RequestMapping("/backend/fileUpload")
public class FileUploadController extends BaseController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/photo")
    @ResponseBody
    public FUResult photo(MultipartFile upfile) {
        log.info("upfile:[{}]", upfile);
        if (upfile == null || upfile.isEmpty()) {
            log.error("参数错误 file is empty");
            return new FUResult("上传图片失败");
        }
        String path = richText + ConcurrentDateUtil.format(System.currentTimeMillis()) + "/";
        String imgName = upfile.getOriginalFilename();
        String extName = imgName.substring(imgName.lastIndexOf("."), imgName.length());
        imgName = UUID.randomUUID().toString().replaceAll("\\-", "") + extName;
        boolean result = FileIoUtil.write(getSavePyPath(path), imgName, upfile);
        if (!result) {
            log.error(BackendReMsg.UEDITORUPLOAD_ERROR);
            return new FUResult(BackendReMsg.UEDITORUPLOAD_ERROR);
        }
        return new FUResult(BackendReMsg.SUCCESS, getSaveDbPath(path) + imgName);
    }

    @RequestMapping("/video")
    @ResponseBody
    public FUResult video(MultipartFile upfile) {
        log.info("upfile:[{}]", upfile);
        if (upfile == null || upfile.isEmpty()) {
            log.error("参数错误 file is empty");
            return new FUResult("上传视频失败");
        }
        String path = richText + ConcurrentDateUtil.format(System.currentTimeMillis()) + "/";
        String videoName = upfile.getOriginalFilename();
        String extName = videoName.substring(videoName.lastIndexOf("."), videoName.length());
        videoName = UUID.randomUUID().toString().replaceAll("\\-", "") + extName;
        boolean result = FileIoUtil.write(getSavePyPath(path), videoName, upfile);
        if (!result) {
            log.error(BackendReMsg.UEDITORUPLOAD_ERROR);
            return new FUResult(BackendReMsg.UEDITORUPLOAD_ERROR);
        }
        return new FUResult(BackendReMsg.SUCCESS, getSaveDbPath(path) + videoName);
    }
}
