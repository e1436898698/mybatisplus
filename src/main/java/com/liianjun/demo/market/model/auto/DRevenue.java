package com.liianjun.demo.market.model.auto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.SqlCondition;
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

    @Title(value = "主键")
    private String dId;

    @Title(value="城市名称")
    private String dCity;

    @Title(value="区县名称")
    @TableField(condition = SqlCondition.LIKE)
    private String dDistrict;

    @Title(value="创新")
    private BigDecimal dInnovation;

    @Title(value="主营")
    private BigDecimal dMain;

    @Title(value="占收比")
    private String dPercentage;

    @TableField(exist = false)
    private Integer type;

    @TableField(exist = false)
    private String cityName;

    @Title(value="创建时间")
    private String createTime;


}
