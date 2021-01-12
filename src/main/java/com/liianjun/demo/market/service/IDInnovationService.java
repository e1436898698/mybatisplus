package com.liianjun.demo.market.service;

import com.liianjun.demo.market.model.auto.DInnovation;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liianjun.demo.market.model.auto.vo.DinnovationVo;
import com.liianjun.demo.market.model.auto.vo.PopUpsVo;

/**
 * <p>
 * 创新收入 服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-11
 */
public interface IDInnovationService extends IService<DInnovation> {

    DinnovationVo getPercentage(DInnovation dInnovation);

    PopUpsVo getPopUps(DInnovation dInnovation);
}
