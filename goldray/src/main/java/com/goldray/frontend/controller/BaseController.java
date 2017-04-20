package com.goldray.frontend.controller;

import com.goldray.frontend.service.IBannerService;
import com.goldray.frontend.service.ICategoriesService;
import com.goldray.frontend.service.INewsService;
import com.goldray.frontend.service.IProductService;
import com.goldray.frontend.service.IRichTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zwb on 2017/3/30.
 */
@Controller
public class BaseController {

    protected static final Map<String, Integer> NAV_TYPE = new HashMap<String, Integer>() {{
        put("aboutUs", 0);
        put("techSupport", 1);
        put("contactUs", 2);
    }};

    protected static final Map<Integer, String> RICHTEXT_TYPE = new HashMap<Integer, String>() {{
        put(0, "关于我们");
        put(1, "技术支持");
        put(2, "联系我们");
    }};

    @Autowired
    protected IBannerService iBannerService;

    @Autowired
    protected IRichTextService iRichTextService;

    @Autowired
    protected INewsService iNewsService;

    @Autowired
    protected ICategoriesService iCategoriesService;

    @Autowired
    protected IProductService iProductService;
}
