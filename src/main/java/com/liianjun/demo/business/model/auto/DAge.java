package com.liianjun.demo.business.model.auto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
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
