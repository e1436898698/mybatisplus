package com.liianjun.demo.market.model.auto.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DRevenueVo {

    private String cityName;
    private String Percentage;
    private String dDistrict;
}
