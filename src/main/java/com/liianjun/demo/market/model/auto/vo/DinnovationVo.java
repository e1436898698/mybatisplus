package com.liianjun.demo.market.model.auto.vo;

import com.liianjun.demo.market.annotation.Title;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DinnovationVo {

    @Title("主营完成值")
    private Double mainCompletion;

    @Title("主营环比")
    private Double mainSequential;

    @Title("创新完成值")
    private Double innoCompletion;

    @Title("创新环比")
    private Double innoSequential;

    @Title("地市名称")
    private String cityName;

}
