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
@TableName("d_province")
@Accessors(chain=true)
public class DProvince extends Model {

    private static final long serialVersionUID=1L;

    /**
     * 省id
     */
    @TableId(value = "p_id",type = IdType.INPUT)
    private String pId;

    /**
     * 省名称
     */
    @TableField("p_name")
    private String pName;


}
