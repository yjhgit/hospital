package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.ReservationYcMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationDot;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationYc;
import com.yayangchun.traditionalchinesemedicinemuseum.service.ReservationYcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (ReservationYc)表服务实现类
 *
 * @author 崖洋春
 * @since 2023-03-19 23:17:55
 */
@Service("reservationYcService")
public class ReservationYcServiceImpl extends ServiceImpl<ReservationYcMapper, ReservationYc> implements ReservationYcService {

    @Autowired
    private ReservationYcMapper reservationYcMapper;


    @Override
    public Integer addYc(ReservationYc reservationYc) {
        return reservationYcMapper.insert(reservationYc);
    }

    @Override
    public List<ReservationYc> findByMyId(String id) {
        return lambdaQuery()
                .eq(ReservationYc::getUserId,id)
                .list();
    }

    @Override
    public List<ReservationYc> findAllByAdmin() {
        return lambdaQuery()
                .orderByDesc(ReservationYc::getTime)
                .list();
    }

    @Override
    public List<ReservationYc> findAllByAdmin(String name) {
        return lambdaQuery()
                .like(ReservationYc::getName,name)
                .list();
    }
}

