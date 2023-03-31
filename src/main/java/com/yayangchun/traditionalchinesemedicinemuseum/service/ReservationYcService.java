package com.yayangchun.traditionalchinesemedicinemuseum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationDot;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.ReservationYc;

import java.util.List;

/**
 * (ReservationYc)表服务接口
 *
 * @author 崖洋春
 * @since 2023-03-19 23:17:55
 */
public interface ReservationYcService extends IService<ReservationYc> {

    public Integer addYc(ReservationYc reservationYc);

    public List<ReservationYc> findByMyId(String id);

    public List<ReservationYc> findAllByAdmin();

    public List<ReservationYc> findAllByAdmin(String name);

}

