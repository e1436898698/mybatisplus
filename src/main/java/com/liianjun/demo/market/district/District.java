package com.liianjun.demo.market.district;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.liianjun.demo.market.model.auto.DRevenue;
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
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@Component
public class District {

    @Autowired
    private IDRevenueService idRevenueService;

    @Test
    public  void  readExcil() throws FileNotFoundException {
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
                    .dPercentage(CalculationUtils.getPercentage(dInnovation,main))
                    .build());

        }
        idRevenueService.saveBatch(list);
    }
}
