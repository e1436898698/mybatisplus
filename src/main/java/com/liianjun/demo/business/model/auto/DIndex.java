package com.liianjun.demo.business.model.auto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;


/**
 * <p>
 * 
 * </p>
 *
 * @author astupidcoder
 * @since 2020-11-17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("d_index")
@Accessors(chain=true)
public class DIndex extends Model {

    private static final long serialVersionUID=1L;

    /**
     * ָ指标id
     */
    @TableId(value = "i_id",type = IdType.INPUT)
    private String iId;

    /**
     * ָ指标名称
     */
    @TableField("i_name")
    private String iName;

    /**
     * 是否是省级指标(1是0否)
     */
    @TableField("is_provincial")
    private Integer isProvincial;

    /**
     * 省||市id
     */
    @TableField("pc_id")
    private String pcId;

    /**
     * ָ日期
     */
    @TableField("i_date")
    private String iDate;


}
