package com.liianjun.demo.business.model.auto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 年龄结构平均值
 * </p>
 *
 * @author astupidcoder
 * @since 2020-11-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class DAgeavg extends Model {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private String aId;

    /**
     * 平均年龄
     */
    private String aAvg;


}
