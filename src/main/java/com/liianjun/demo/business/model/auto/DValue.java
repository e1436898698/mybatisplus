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
 * @since 2020-11-18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("d_value")
@Accessors(chain=true)
public class DValue extends Model {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "v_id",type = IdType.INPUT)
    private String vId;

    /**
     * 值
     */
    @TableField("v_value")
    private String vValue;

    /**
     * 指标项id
     */
    @TableField("i_id")
    private String iId;

    @TableField("date")
    private String date;


}
