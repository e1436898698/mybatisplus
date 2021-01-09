package com.liianjun.demo.market.model.auto;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 收入预测
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("d_income")
public class DIncome extends Model {

    private static final long serialVersionUID=1L;

    private String id;

    /**
     * 城市
     */
    private String city;

    /**
     * 传统主营业务收入——本月预测
     */
    private BigDecimal thisMonthReport;

    /**
     * 上月财务列收
     */
    private BigDecimal lastMonthReport;

    /**
     * 增量
     */
    private BigDecimal increment;

    /**
     * 增幅
     */
    private BigDecimal rateIncrease;

    /**
     * 创新业务收入
     */
    private BigDecimal innvoateIncome;

    /**
     * 管理账面收入
     */
    private BigDecimal paperIncome;

    /**
     * 省级关联收入
     */
    private BigDecimal provinceIncome;

    /**
     * 本月财务收入
     */
    private BigDecimal thisMonthFinance;

    /**
     * 上月财务收入
     */
    private BigDecimal lastMonthFinance;

    /**
     * 预测增幅
     */
    private BigDecimal forecastRate;


}
