package com.goldray.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by zwb on 2016/12/5.
 */
public class FileIoUtil {

    private static Logger logger = LoggerFactory.getLogger(FileIoUtil.class);

    /**
     * 写文件
     *
     * @param fullRootPath 保存目录
     * @param newFileName  文件名
     * @param fileBody     文件
     * @return
     */
    public static boolean write(String fullRootPath, String newFileName, MultipartFile fileBody) {
        boolean isOk = true;
        FileOutputStream fos = null;
        try {
            File f = new File(fullRootPath);
            if (!f.exists() && !f.isDirectory()) {//创建文件夹
                f.mkdirs();
                logger.info("create directory:" + fullRootPath);
            }
            byte[] bytes = fileBody.getBytes();
            fos = new FileOutputStream(new File(fullRootPath + newFileName));
            BufferedOutputStream buffStream = new BufferedOutputStream(fos);
            buffStream.write(bytes);
            buffStream.close();
            fos.close();
        } catch (Exception e) {
            logger.error("write file exception:", e);
            isOk = false;
        }
        return isOk;
    }

    /**
     * 写文件
     *
     * @param target   目标文件
     * @param fileBody 文件
     * @return
     * @throws IOException
     */
    public static boolean write(File target, MultipartFile fileBody) {
        boolean isOk = true;
        FileOutputStream fos = null;
        try {
            byte[] bytes = fileBody.getBytes();
            fos = new FileOutputStream(target);
            BufferedOutputStream buffStream = new BufferedOutputStream(fos);
            buffStream.write(bytes);
            buffStream.close();
            fos.close();
        } catch (Exception e) {
            logger.error("write file exception:", e);
            isOk = false;
        }
        return isOk;
    }
}
