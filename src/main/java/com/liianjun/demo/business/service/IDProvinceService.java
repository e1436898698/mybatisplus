package com.liianjun.demo.business.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.liianjun.demo.business.model.auto.DProvince;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2020-11-17
 */
public interface IDProvinceService extends IService<DProvince> {
    List<DProvince> incomeexp(DProvince dProvince);


}
