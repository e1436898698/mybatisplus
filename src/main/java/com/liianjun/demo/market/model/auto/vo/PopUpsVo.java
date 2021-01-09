package com.liianjun.demo.market.model.auto.vo;

import com.liianjun.demo.market.model.auto.DRevenue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PopUpsVo {

    public List<Map<String,Object>> title;

    public List<Map<String,Object>> data;
}
