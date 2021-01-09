package com.liianjun.demo.market.controller;


import com.liianjun.demo.common.Response;
import com.liianjun.demo.market.model.auto.DRevenue;
import com.liianjun.demo.market.model.auto.vo.PopUpsVo;
import com.liianjun.demo.market.service.IDRevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-09
 */
@RestController
@RequestMapping("/dRevenue")
public class DRevenueController {
    @Autowired
    private IDRevenueService idRevenueService;

    @PostMapping("/getPopUps")
    public PopUpsVo   getPopUps(@RequestBody DRevenue dRevenue){
           return  idRevenueService.getPopUps(dRevenue);
    }

}

