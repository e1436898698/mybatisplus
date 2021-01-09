package com.liianjun.demo.market.model.auto;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 数据大屏——城市考核得分
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("d_city_score")
public class DCityScore extends Model {

    private static final long serialVersionUID=1L;

    private String id;

    /**
     * 地域
     */
    private String city;

    /**
     * 考核得分
     */
    private BigDecimal score;

    /**
     * 排名
     */
    private Integer ranking;

    private LocalDateTime createTime;


}
