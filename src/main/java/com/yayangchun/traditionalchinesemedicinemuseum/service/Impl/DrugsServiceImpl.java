package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.DrugsMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Drugs;
import com.yayangchun.traditionalchinesemedicinemuseum.service.DrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Drugs)表服务实现类
 *
 * @author 崖洋春
 * @since 2023-03-19 20:02:46
 */
@Service("drugsService")
public class DrugsServiceImpl extends ServiceImpl<DrugsMapper, Drugs> implements DrugsService {

    @Autowired
    private DrugsMapper drugsMapper;

    @Override
    public List<Drugs> findAll() {
        return list();
    }

    @Override
    public List<Drugs> findByName(String name) {
        return lambdaQuery()
                .like(Drugs::getName,name)
                .list();
    }

    @Override
    public Integer addByAdmin(Drugs drugs) {
        return drugsMapper.insert(drugs);
    }

    @Override
    public Integer updateByAdmin(Drugs drugs) {
        return updateById(drugs)?1:0;
    }

    @Override
    public Integer delAllById(String id) {
        return drugsMapper.delAllById(id);
    }
}

