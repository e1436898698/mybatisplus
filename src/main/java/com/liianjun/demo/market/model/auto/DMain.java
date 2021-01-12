package com.liianjun.demo.market.model.auto;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 主营业务收入
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("d_main")
public class DMain extends Model {

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
     * 主营
     */
    private BigDecimal main;

    /**
     * 创新
     */
    private BigDecimal innovation;

    /**
     * 月份
     */
    private String month;


}
