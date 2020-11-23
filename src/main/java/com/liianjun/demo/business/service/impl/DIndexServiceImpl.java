package com.liianjun.demo.business.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liianjun.demo.business.mapper.auto.DCityMapper;
import com.liianjun.demo.business.mapper.auto.DIndexMapper;


import com.liianjun.demo.business.model.auto.DIndex;
import com.liianjun.demo.business.service.IDIndexService;
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
public class DIndexServiceImpl extends ServiceImpl<DIndexMapper, DIndex> implements IDIndexService {

    @Autowired
    private DIndexServiceImpl dIndexService;

}
