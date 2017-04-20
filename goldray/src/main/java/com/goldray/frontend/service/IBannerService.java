package com.goldray.frontend.service;

import com.goldray.frontend.model.po.BannerPo;
import com.goldray.frontend.model.po.OrderStyleEnum;

import java.util.List;

/**
 * Created by zwb on 2017/4/11.
 */
public interface IBannerService {
    /**
     *
     * @param isShow
     * @param orderStyleEnum
     * @return
     */
    List<BannerPo> findByIsShowAndOderByAddTime(int isShow, OrderStyleEnum orderStyleEnum);
}
