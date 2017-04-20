package com.goldray.backend.service.impl;

import com.goldray.backend.mapper.BBannerMapper;
import com.goldray.backend.model.po.BannerPo;
import com.goldray.backend.service.IBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwb on 2017/4/11.
 */
@Service("BBannerServiceImpl")
public class BannerServiceImpl implements IBannerService {

    @Autowired
    private BBannerMapper bannerMapper;

    @Override
    public List<BannerPo> findAll() {
        return bannerMapper.findAll();
    }

    @Override
    public BannerPo getById(int id) {
        return bannerMapper.getById(id);
    }

    @Override
    public boolean save(BannerPo bannerPo) {
        return bannerMapper.save(bannerPo.getTitle(), bannerPo.getPath(), bannerPo.getImgName(), bannerPo.getUrl(), bannerPo.getIsShow(), bannerPo.getIsBlank(), (int) (System.currentTimeMillis() / 1000L));
    }

    @Override
    public boolean edit(BannerPo bannerPo) {
        return bannerMapper.edit(bannerPo.getId(), bannerPo.getTitle(), bannerPo.getPath(), bannerPo.getImgName(), bannerPo.getUrl(), bannerPo.getIsShow(), bannerPo.getIsBlank());
    }

    @Override
    public boolean deleteById(int id) {
        return bannerMapper.deleteById(id);
    }
}
