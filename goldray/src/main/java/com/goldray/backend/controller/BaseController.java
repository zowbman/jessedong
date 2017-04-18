package com.goldray.backend.controller;

import com.goldray.backend.service.IBannerService;
import com.goldray.backend.service.ICategoriesService;
import com.goldray.backend.service.IRichTextService;
import com.goldray.backend.service.impl.RichTextServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zwb on 2017/3/30.
 */
@Controller("BBaseController")
public class BaseController {
    protected static final List<String> TYPES = Arrays.asList("add", "edit");

    protected static final Map<Integer, String> RICHTEXT_TYPE = new HashMap<Integer, String>() {{
        put(0, "关于我们");
        put(1, "技术支持");
        put(2, "联系我们");
    }};

    @Resource(name = "BCategoriesServiceImpl")
    protected ICategoriesService iCategoriesService;

    @Resource(name = "BBannerServiceImpl")
    protected IBannerService iBannerService;

    @Resource(name = "BRichTextServiceImpl")
    protected IRichTextService iRichTextService;

    @Value("${custom.bannerDir}")
    protected String bannerDir;

    @Value("${custom.richText}")
    protected String richText;

    @Value("${custom.rl.webfilesDir}")
    private String webfilesDir;

    @Value("${custom.prefix}")
    private String prefix;

    /**
     * 获取真实路径
     * @param pyPath
     * @return
     */
    protected String getSavePyPath(String pyPath){
        return webfilesDir + pyPath;
    }

    /**
     * 获取存db中的路径
     * @param dbPath
     * @return
     */
    protected String getSaveDbPath(String dbPath){
        return prefix + dbPath;
    }
}
