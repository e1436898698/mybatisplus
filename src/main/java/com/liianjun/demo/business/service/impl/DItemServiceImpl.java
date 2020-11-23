package com.liianjun.demo.business.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liianjun.demo.business.mapper.auto.DCityMapper;
import com.liianjun.demo.business.mapper.auto.DItemMapper;

import com.liianjun.demo.business.model.auto.DItem;
import com.liianjun.demo.business.service.IDItemService;
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
public class DItemServiceImpl extends ServiceImpl<DItemMapper, DItem> implements IDItemService {
    @Autowired
    private DItemServiceImpl dItemService;

}
