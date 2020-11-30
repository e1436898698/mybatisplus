package com.liianjun.demo.business.model.auto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 员工年龄结构
 * </p>
 *
 * @author astupidcoder
 * @since 2020-11-30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("d_age")
public class DAge extends Model {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private String aId;

    /**
     * 年龄段
     */
    private String aGeneration;

    /**
     * 人数
     */
    private Integer aCount;

    /**
     * 比例
     */
    private String aProportion;

    /**
     * 平均年龄id
     */
    private String aAvgId;


}
