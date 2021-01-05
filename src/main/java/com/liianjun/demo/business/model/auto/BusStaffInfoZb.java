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
 * @since 2021-01-05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("bus_staff_info_zb")
public class BusStaffInfoZb extends Model {

    private static final long serialVersionUID=1L;

    /**
     * 员工编号
     */
    private String staffId;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 员工4A账号
     */
    private String staffNo;

    /**
     * 组织机构编码
     */
    private String orgId;

    /**
     * 岗位编码
     */
    private String positionId;

    /**
     * 岗位名称
     */
    private String positionName;

    /**
     * 发展人编码
     */
    private String developPerson;

    /**
     * 字取消数据未空
     */
    private String levelId;

    /**
     * 员工级别
     */
    private String staffType;

    /**
     * 员工来源
     */
    private String staffSource;

    /**
     * 描述
     */
    private String remark;

    /**
     * 电话号码
     */
    private String reserved1;

    /**
     * 人员状态1有效0失效
     */
    private String reserved2;


}
