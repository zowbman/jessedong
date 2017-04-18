package com.goldray.backend.service;

import com.goldray.backend.model.po.BannerPo;

import java.util.List;

/**
 * Created by zwb on 2017/4/11.
 */
public interface IBannerService {

    /**
     * 列表
     *
     * @return
     */
    List<BannerPo> findAll();

    /**
     * @param id
     * @return
     */
    BannerPo getById(int id);

    /**
     * 添加
     *
     * @param bannerPo
     * @return
     */
    boolean save(BannerPo bannerPo);

    /**
     * 修改
     *
     * @param bannerPo
     * @return
     */
    boolean edit(BannerPo bannerPo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    boolean deleteById(int id);
}
