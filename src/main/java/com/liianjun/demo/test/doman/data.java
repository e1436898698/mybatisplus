package com.liianjun.demo.test.doman;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;




@Data
@JsonIgnoreProperties(value={"completionValues"})
public class data {

    private String area;
    private Integer completionValue;
    private String incomeProportion;
    private Integer incomeRranking;
    private String proportion;
    private String ranking;
    @JSONField(serialize = false)
    private Double completionValues;
}
