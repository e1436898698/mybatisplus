package com.liianjun.demo.business.service.impl;

import com.liianjun.demo.business.model.auto.DValue;
import com.liianjun.demo.business.mapper.auto.DValueMapper;
import com.liianjun.demo.business.service.IDValueService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2020-11-18
 */

@Service
public class DValueServiceImpl extends ServiceImpl<DValueMapper, DValue> implements IDValueService {
    @Autowired
    private DValueServiceImpl dValueService;
}
