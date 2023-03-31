package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.ProposeMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.Propose;
import com.yayangchun.traditionalchinesemedicinemuseum.service.ProposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Propose)表服务实现类
 *
 * @author 崖洋春
 * @since 2023-03-19 16:21:38
 */
@Service("proposeService")
public class ProposeServiceImpl extends ServiceImpl<ProposeMapper, Propose> implements ProposeService {

    @Autowired
    private ProposeMapper proposeMapper;

    @Override
    public Integer addPropose(Propose propose) {
        return proposeMapper.insert(propose);
    }

    @Override
    public List<Propose> findAll() {
        return list();
    }

    @Override
    public List<Propose> findByUserid(String id) {
        return lambdaQuery()
                .eq(Propose::getUserId,id)
                .list();
    }

    @Override
    public List<Propose> findByName(String name) {
        return lambdaQuery().like(Propose::getName,name).list();
    }

    @Override
    public List<Propose> findByAdmin() {
        return lambdaQuery().orderByDesc(Propose::getAddtime).list();
    }
}

