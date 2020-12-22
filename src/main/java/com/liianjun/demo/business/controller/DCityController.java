package com.liianjun.demo.business.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2020-11-17
 */
@RestController
@RequestMapping("/city")
public class DCityController {

    private final static String url1="/list";
    private final static String url2="/list";
    private final static String url3="/list";
    private final static String url4="/list";



    @GetMapping(url1)
    public void  list(HttpServletResponse response){

    }

}

