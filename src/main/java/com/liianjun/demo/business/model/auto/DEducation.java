package com.liianjun.demo.business.model.auto;

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
 * @since 2020-11-30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("d_education")
public class DEducation extends Model {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private String eId;

    /**
     * 学历
     */
    private String eEducation;

    /**
     * 人数
     */
    private Integer eCount;

    /**
     * 比例
     */
    private String aProportion;


}
