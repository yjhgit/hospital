package com.yayangchun.traditionalchinesemedicinemuseum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Drugs;

import java.util.List;

/**
 * (Drugs)表服务接口
 *
 * @author 崖洋春
 * @since 2023-03-19 20:02:46
 */
public interface DrugsService extends IService<Drugs> {

    public List<Drugs> findAll();

    public List<Drugs> findByName(String name);

    public Integer addByAdmin(Drugs drugs);

    public Integer updateByAdmin(Drugs drugs);

    public Integer delAllById(String id);

}

