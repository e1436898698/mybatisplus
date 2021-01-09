package com.liianjun.demo.market.model.auto;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据大屏数据——市级指标
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("d_city_index")
public class DCityIndex extends Model {

    private static final long serialVersionUID=1L;

    private String id;

    /**
     * 地域
     */
    private String province;

    /**
     * 指标
     */
    private String index;

    /**
     * 完成值
     */
    private BigDecimal complete;

    /**
     * 同比增长
     */
    private BigDecimal yearGrowth;

    /**
     * 同比排名
     */
    private Integer yearRanking;

    /**
     * 预算完成率
     */
    private BigDecimal budgetRatio;

    /**
     * 预算完成排名
     */
    private Integer budgetRanking;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
