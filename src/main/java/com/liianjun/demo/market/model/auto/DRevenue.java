package com.liianjun.demo.market.model.auto;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.liianjun.demo.market.annotation.Title;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-09
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("d_revenue")
public class DRevenue extends Model {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private String dId;

    /**
     * 城市名称
     */
    @Title(value="城市名称")
    private String dCity;

    /**
     * 区县名称
     */
    @Title(value="区县名称")
    private String dDistrict;

    /**
     * 创新
     */
    @Title(value="创新")
    private BigDecimal dInnovation;

    /**
     * 主营
     */
    @Title(value="主营")
    private BigDecimal dMain;

    /**
     * 占收比
     */
    @Title(value="占收比")
    private String dPercentage;
    /**
     * 参数 类型 1省2地市3区
     */
    @TableField(exist = false)
    private Integer type;

    /**
     * 参数 地域名称
     */
    @TableField(exist = false)
    private String cityName;


}
