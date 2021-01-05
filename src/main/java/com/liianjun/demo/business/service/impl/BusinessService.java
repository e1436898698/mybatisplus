package com.liianjun.demo.business.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.liianjun.demo.business.constant.Constant;
import com.liianjun.demo.business.model.auto.BusOrganGridJk;
import com.liianjun.demo.business.model.auto.BusStaffInfoZb;
import com.liianjun.demo.business.service.IBusOrganGridJkService;
import com.liianjun.demo.business.service.IBusStaffInfoZbService;
import com.liianjun.demo.business.service.IBusinessService;
import com.liianjun.demo.utils.SftpUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessService implements IBusinessService {

    @Autowired
    private IBusStaffInfoZbService iBusStaffInfoZbService;
    @Autowired
    private IBusOrganGridJkService iBusOrganGridJkService;

    @Override
    public boolean saveData(String str) {
        boolean  flag=false;
        List<BusOrganGridJk> busOrganGridJkList=new ArrayList<>();
        List<BusStaffInfoZb> busStaffInfoZbList=new ArrayList<>();
        if(str.contains(Constant.STAFFINFOZBTYPE)){
            List<String> contents = SftpUtils.getContent(str);
            if(CollUtil.isEmpty(contents)){
                  return flag;
            }
            for (String content : contents) {
                String[] split = content.split("\\|\\|");
                busStaffInfoZbList.add(BusStaffInfoZb.builder()
                        .staffId(split[0])
                        .staffName(split[1])
                        .staffNo(split[2])
                        .orgId(split[3])
                        .positionId(split[4])
                        .positionName(split[5])
                        .developPerson(split[6])
                        .levelId(split[7])
                        .staffType(split[8])
                        .staffSource(split[9])
                        .remark(split[10])
                        .reserved1(split[11])
                        .reserved2(split[12]).build());
            }

        }else if(str.contains(Constant.ORGANGRIDJKTYPE)) {
            List<String> contents = SftpUtils.getContent(str);
            if(CollUtil.isEmpty(contents)){
                return flag;
            }
            for (String content : contents) {
                String[] split = content.split("\\|\\|");
                busOrganGridJkList.add(BusOrganGridJk.builder().parLevelId(split[0]).parLevelName(split[1]).levelId(split[2]).levelName(split[3]).bmLevel(Integer.valueOf(split[4]))
                        .orgrank(split[5])
                        .state(split[6])
                        .cityFlag(split[7])
                        .isZlr(split[8])
                        .orgType(split[9])
                        .updateTime(DateUtil.parseLocalDateTime(split[10]))
                        .updateUser(split[11])
                        .updateDepart(split[12])
                        .ord(split[13])
                        .remark(split[14])
                        .reserved1(split[15])
                        .build());
            }
        }
        if(CollUtil.isEmpty(busOrganGridJkList)){
            iBusOrganGridJkService.saveBatch(busOrganGridJkList);
        }
        if(CollUtil.isEmpty(busStaffInfoZbList)){
            iBusStaffInfoZbService.saveBatch(busStaffInfoZbList);
        }

        return flag;
    }

}
