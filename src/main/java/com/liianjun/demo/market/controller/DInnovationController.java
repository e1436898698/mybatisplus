package com.liianjun.demo.market.controller;


import com.liianjun.demo.market.model.auto.DInnovation;
import com.liianjun.demo.market.model.auto.DRevenue;
import com.liianjun.demo.market.model.auto.vo.DinnovationVo;
import com.liianjun.demo.market.model.auto.vo.PopUpsVo;
import com.liianjun.demo.market.service.IDInnovationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 创新收入 前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-11
 */
@RestController
@RequestMapping("/dInnovation")
public class DInnovationController {
    @Autowired
    private IDInnovationService idInnovationService;

    @PostMapping("/getPopUps")
    public PopUpsVo getPopUps(@RequestBody DInnovation dInnovation) {
        return idInnovationService.getPopUps(dInnovation);
    }


    @PostMapping("/getPercentage")
    public DinnovationVo getPercentage(@RequestBody DInnovation dInnovation) {
        return idInnovationService.getPercentage(dInnovation);
    }

}

