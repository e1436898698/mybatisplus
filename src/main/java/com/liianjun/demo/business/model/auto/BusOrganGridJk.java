package com.liianjun.demo.business.model.auto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author astupidcoder
 * @since 2021-01-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("bus_organ_grid_jk")
public class BusOrganGridJk extends Model {

    private static final long serialVersionUID=1L;

    /**
     * 父级机构代码
     */
    private String parLevelId;

    /**
     * 父级机构名称
     */
    private String parLevelName;

    /**
     * 机构代码
     */
    private String levelId;

    /**
     * 机构名称
     */
    private String levelName;

    /**
     * 机构层级
     */
    private Integer bmLevel;

    /**
     * 机构路径
     */
    private String orgrank;

    /**
     * 状态1为有效
     */
    private String state;

    /**
     * 市县标志1城区2郊县
     */
    private String cityFlag;

    /**
     * 是否准利润中心1准利润2政企客户事业部0其他
     */
    private String isZlr;

    /**
     * 机构类型6政企网格8包区
     */
    private String orgType;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 修改人工号
     */
    private String updateUser;

    /**
     * 修改人所属部门
     */
    private String updateDepart;

    /**
     * 排序
     */
    private String ord;

    /**
     * 备注
     */
    private String remark;

    /**
     * 预留字段1
     */
    private String reserved1;


}
