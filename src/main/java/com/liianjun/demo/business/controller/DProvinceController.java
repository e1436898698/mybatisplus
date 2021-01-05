package com.liianjun.demo.business.controller;


import com.liianjun.demo.business.model.auto.DProvince;
import com.liianjun.demo.business.service.IDProvinceService;
import com.liianjun.demo.common.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2020-11-17
 */
@RestController
@RequestMapping("/digi/province")
public class DProvinceController {

    private final static String url1="/list";
    private final static String url2="/list";
    private final static String url3="/list";
    private final static String url4="/list";

    @Autowired
    private IDProvinceService idProvinceService;


   /* @PostMapping(url1)
    public Response  list(@RequestBody DProvince dProvince){
         List<DProvince> list=idProvinceService.incomeexp(dProvince);
         return Response(list,200,"成功",url1);

    }*/


}

