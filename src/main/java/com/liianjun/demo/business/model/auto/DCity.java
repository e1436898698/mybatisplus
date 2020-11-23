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
@TableName("d_city")
@Accessors(chain=true)
public class DCity extends Model {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "c_id",type = IdType.INPUT)
    private String cId;

    /**
     * 城市名称
     */
    @TableField("c_name")
    private String cName;

    /**
     * 省id
     */
    @TableField("dp_id")
    private String dpId;


}
