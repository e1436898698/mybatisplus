package com.liianjun.demo.business.service.impl;


import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.liianjun.demo.business.mapper.auto.DProvinceMapper;
import com.liianjun.demo.business.model.auto.DProvince;
import com.liianjun.demo.business.service.IDItemService;
import com.liianjun.demo.business.service.IDProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    private IDItemService idItemService;

    @Override
    public List<DProvince> incomeexp(DProvince dProvince) {
        /*List<DProvince> list = dProvinceService.list();
        if(CollUtil.isEmpty(list)){
             return null;
        }
        DProvince dProvince1 = list.get(0);
        idItemService*/
        return null;
    }
}
