package com.liianjun.demo.market.district;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.liianjun.demo.market.model.auto.DInnovation;
import com.liianjun.demo.market.model.auto.DMain;
import com.liianjun.demo.market.model.auto.DRevenue;
import com.liianjun.demo.market.service.IDInnovationService;
import com.liianjun.demo.market.service.IDRevenueService;
import com.liianjun.demo.market.util.CalculationUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Component
public class District {

    @Autowired
    private IDRevenueService idRevenueService;
    @Autowired
    private IDInnovationService idInnovationService;

    @Test
    public  void  readExcil() throws Exception {
/*        test1();*/

        test2();
    }

    /**
     * 创新业务收入
     */
    private void test2() throws Exception {
        ExcelReader excil = ExcelUtil.getReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\主营业务.xlsx")), "Sheet1");
        List<List<Object>> read = excil.read();
        List<DInnovation> list=new ArrayList<>();
        for (int i = 1; i < read.size(); i++) {
           list.add(DInnovation.builder()
                   .id(UUid.getUUID())
                   .cityName(String.valueOf(read.get(i).get(1)))
                   .district(String.valueOf(read.get(i).get(2)))
                   .mainMonth(BigDecimal.valueOf(Double.valueOf(String.valueOf(read.get(i).get(3)))))
                   .innovationMonth(BigDecimal.valueOf(Double.valueOf(String.valueOf(read.get(i).get(4)))))
                   .mainMonthl(BigDecimal.valueOf(Double.valueOf(String.valueOf(read.get(i).get(5)))))
                   .innovationMonthl(BigDecimal.valueOf(Double.valueOf(String.valueOf(read.get(i).get(6)))))
                   .month(String.valueOf(read.get(i).get(0)))
                   .createTime(DateUtils.getDateTo(LocalDateTime.now()))
                   .build());
        }
        idInnovationService.saveBatch(list);
    }



    /**
     * 区县占收比
     */
    private void test1() throws Exception {
        ExcelReader excil = ExcelUtil.getReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\创新收入占收比.xls")), "创新收入占比");
        List<List<Object>> read = excil.read();
        List<DRevenue> list=new ArrayList<>();
        for (int i = 1; i < read.size(); i++) {
            Double dInnovation = Double.valueOf(String.valueOf(read.get(i).get(2)));
            Double main = Double.valueOf(String.valueOf(read.get(i).get(3)));
            list.add(DRevenue.builder().dId(UUid.getUUID())
                    .dCity(String.valueOf(read.get(i).get(0)))
                    .dDistrict(String.valueOf(read.get(i).get(1)))
                    .dInnovation(BigDecimal.valueOf(dInnovation))
                    .dMain(BigDecimal.valueOf(main))
                    .createTime(DateUtils.getDate(LocalDateTime.now()))
                    .dPercentage(CalculationUtils.getPercentage(dInnovation,main))
                    .build());

        }
        idRevenueService.saveBatch(list);
    }

}
