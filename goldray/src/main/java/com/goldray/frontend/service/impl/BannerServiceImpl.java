package com.goldray.frontend.service.impl;

import com.goldray.frontend.mapper.BannerMapper;
import com.goldray.frontend.model.po.BannerPo;
import com.goldray.frontend.model.po.OrderStyleEnum;
import com.goldray.frontend.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwb on 2017/4/11.
 */
@Service
public class BannerServiceImpl implements IBannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<BannerPo> findByIsShowAndOderByAddTime(int isShow, OrderStyleEnum orderStyleEnum) {
        return bannerMapper.findByIsShowAndOderByAddTime(isShow, orderStyleEnum);
    }
}
