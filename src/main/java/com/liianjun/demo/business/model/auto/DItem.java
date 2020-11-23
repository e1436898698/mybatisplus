package com.liianjun.demo.business.model.auto;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("d_item")
@Accessors(chain=true)
public class DItem extends Model {

    private static final long serialVersionUID=1L;

    /**
     * ָ指标项id
     */
    @TableId(value = "i_id",type = IdType.INPUT)
    private String iId;

    /**
     * ָ指标项名称
     */
    @TableField("i_name")
    private String iName;

    /**
     * ָ指标id
     */
    @TableField("index_id")
    private String indexId;




}
