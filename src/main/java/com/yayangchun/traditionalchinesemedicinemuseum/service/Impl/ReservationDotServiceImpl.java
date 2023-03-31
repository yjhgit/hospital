package com.yayangchun.traditionalchinesemedicinemuseum.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yayangchun.traditionalchinesemedicinemuseum.dao.ReservationDotMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationDot;
import com.yayangchun.traditionalchinesemedicinemuseum.service.ReservationDotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (ReservationDot)表服务实现类
 *
 * @author 崖洋春
 * @since 2023-03-19 23:17:54
 */
@Service("reservationDotService")
public class ReservationDotServiceImpl extends ServiceImpl<ReservationDotMapper, ReservationDot> implements ReservationDotService {

    @Autowired
    private ReservationDotMapper reservationDotMapper;


    @Override
    public Integer addReYs(ReservationDot reservationDot) {
        return reservationDotMapper.insert(reservationDot);
    }

    @Override
    public List<ReservationDot> findByMyId(String id) {
        return lambdaQuery()
                .eq(ReservationDot::getUserId,id)
                .list();
    }

    @Override
    public List<ReservationDot> findAllByAdmin() {
        return lambdaQuery()
                .orderByDesc(ReservationDot::getReservationTime)
                .list();
    }

    @Override
    public List<ReservationDot> findAllByAdmin(String name) {
        return lambdaQuery()
                .like(ReservationDot::getName,name)
                .list();
    }
}

