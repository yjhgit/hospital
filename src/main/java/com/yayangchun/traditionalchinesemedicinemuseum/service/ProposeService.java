package com.yayangchun.traditionalchinesemedicinemuseum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Propose;

import java.util.List;

/**
 * (Propose)表服务接口
 *
 * @author 崖洋春
 * @since 2023-03-19 16:21:38
 */
public interface ProposeService extends IService<Propose> {

    public Integer addPropose(Propose propose);

    public List<Propose> findAll();

    public List<Propose> findByUserid(String id);

    public List<Propose> findByName(String name);

    public List<Propose> findByAdmin();



}

