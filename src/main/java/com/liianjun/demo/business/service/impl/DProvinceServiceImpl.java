package com.liianjun.demo.business.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.liianjun.demo.business.mapper.auto.DProvinceMapper;
import com.liianjun.demo.business.model.auto.DProvince;
import com.liianjun.demo.business.service.IDProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2020-11-17
 */
@Service
public class DProvinceServiceImpl extends ServiceImpl<DProvinceMapper, DProvince> implements IDProvinceService {
    @Autowired
    private DProvinceServiceImpl dProvinceService;
}
