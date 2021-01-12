package com.liianjun.demo.market.model.auto;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 创新收入
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("d_innovation")
public class DInnovation extends Model {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 地市
     */
    private String cityName;

    /**
     * 区县
     */
    private String district;

    /**
     * 主营当月
     */
    private BigDecimal mainMonth;

    /**
     * 创新当月
     */
    private BigDecimal innovationMonth;

    /**
     * 主营上月
     */
    private BigDecimal mainMonthl;

    /**
     * 创新上月
     */
    private BigDecimal innovationMonthl;

    /**
     * 月份
     */
    private String month;

    @TableField(exist = false)
    private Integer type;


    private String createTime;


}
