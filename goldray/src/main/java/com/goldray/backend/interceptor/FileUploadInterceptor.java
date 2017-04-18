package com.goldray.backend.interceptor;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by zwb on 2016/12/6.
 */
public class FileUploadInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(FileUploadInterceptor.class);

    private long imgMaxSize;

    private long videoMaxSize;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request != null && ServletFileUpload.isMultipartContent(request)){
            MultipartRequest multipartRequest = (MultipartRequest)request;
            Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
            if(fileMap != null){
                MultipartFile file;
                long uploadFileSize = 0;
                for (Map.Entry<String, MultipartFile> multipartFile : fileMap.entrySet()) {
                    file = multipartFile.getValue();
                    uploadFileSize += file.getSize(); //累加附件的大小（字节）
                }
                logger.info("限制附件大小(imgMaxSize:" + imgMaxSize + "b,videoMaxSize:" + videoMaxSize + "b);上传附件数量:"+ fileMap.size() +"个,总大小:" + uploadFileSize + "b");
                String requestUri = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);

                /*if(requestUri.indexOf("/kefufile/video/v1/form_upload") > -1){//视频上传
                    if (uploadFileSize > videoMaxSize) {
                        throw new CustomException(CodeHelper.ERROR_MAXFILESIZE, "请求文件大小超出范围限制，requesrtSize:" + uploadFileSize + "b,maxSize:" + videoMaxSize + "b");
                    }
                }else {
                    if (uploadFileSize > maxSize) {
                        throw new CustomException(CodeHelper.ERROR_MAXFILESIZE, "请求文件大小超出范围限制，requesrtSize:" + uploadFileSize + "b,maxSize:" + maxSize + "b");
                    }
                }*/
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public void setImgMaxSize(long imgMaxSize) {
        this.imgMaxSize = imgMaxSize;
    }

    public void setVideoMaxSize(long videoMaxSize) {
        this.videoMaxSize = videoMaxSize;
    }
}
