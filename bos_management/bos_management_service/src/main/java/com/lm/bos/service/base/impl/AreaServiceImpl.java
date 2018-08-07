package com.lm.bos.service.base.impl;

import com.lm.bos.dao.base.IAreaDao;
import com.lm.bos.domain.base.Area;
import com.lm.bos.service.base.IAreaService;
import com.lm.bos.utils.PinYin4jUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AreaServiceImpl implements IAreaService {

    @Resource
    private IAreaDao areaDao;

    /**
     * 上传excel文件业务解析
     * @param areaFile
     */
    @Override
    public void importXls(File areaFile) throws IOException {
        //获取excel对象
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(areaFile));
        //获取excel第一页
        HSSFSheet sheetAt = hssfWorkbook.getSheetAt(0);
        List<Area> areas = new ArrayList<>();

        //循环sheet页，遍历每一行数据
        for (Row row : sheetAt) {
            //如果是第一行则跳过，不写入数据库
            int rowNum = row.getRowNum();
            if(rowNum == 0){
                continue;
            }
            String id = row.getCell(0).getStringCellValue();//区域编号
            String province = row.getCell(1).getStringCellValue();//省份
            String city = row.getCell(2).getStringCellValue();//城市
            String district = row.getCell(3).getStringCellValue();//区域
            String postcode = row.getCell(4).getStringCellValue();//邮编

            String province2 = province.substring(0,province.length()-1);//湖南省-->湖南
            String city2 = city.substring(0,city.length()-1);//长沙市-->长沙
            String district2 = district.substring(0,district.length()-1);//芙蓉区-->芙蓉
            //获取汉字首字母
            String[] headByString = PinYin4jUtils.getHeadByString(province2+city2+district2);
            //将字符串数组转换成字符串  城市编码
            String citycode = PinYin4jUtils.stringArrayToString(headByString,"");
            //深圳市  简码
            String shortcode= PinYin4jUtils.hanziToPinyin(city2,"");
            Area area = new Area(id, province, city, district, postcode, citycode, shortcode, null);
            areas.add(area);
        }

        areaDao.save(areas);
        hssfWorkbook.close();
    }

    @Override
    public Page<Area> pageQuery(Pageable pageable) {
        return areaDao.findAll(pageable);
    }

    @Override
    public List<Area> findAll() {
        return areaDao.findAll();
    }

    @Override
    public List<Area> findByQ(String q) {
        return areaDao.findByQ(q);
    }
}
