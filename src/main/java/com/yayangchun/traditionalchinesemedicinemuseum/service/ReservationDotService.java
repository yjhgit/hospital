package com.yayangchun.traditionalchinesemedicinemuseum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationDot;

import java.util.List;

/**
 * (ReservationDot)表服务接口
 *
 * @author 崖洋春
 * @since 2023-03-19 23:17:54
 */
public interface ReservationDotService extends IService<ReservationDot> {

    public Integer addReYs(ReservationDot reservationDot);

    public List<ReservationDot> findByMyId(String id);

    public List<ReservationDot> findAllByAdmin();

    public List<ReservationDot> findAllByAdmin(String name);

    void cancel(Integer id);
}

