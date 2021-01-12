package com.liianjun.demo.market.service;

import com.liianjun.demo.common.Response;
import com.liianjun.demo.market.model.auto.DRevenue;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liianjun.demo.market.model.auto.vo.DRevenueVo;
import com.liianjun.demo.market.model.auto.vo.PopUpsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-09
 */
public interface IDRevenueService extends IService<DRevenue> {
    PopUpsVo getPopUps(DRevenue dRevenue);

    List<DRevenueVo> getPercentage(DRevenue dRevenue);
}
