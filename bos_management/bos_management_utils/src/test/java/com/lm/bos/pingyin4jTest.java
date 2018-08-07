package com.lm.bos;

import com.lm.bos.utils.PinYin4jUtils;
import org.junit.Test;

public class pingyin4jTest {
    @Test
    public void test(){
        String province = "广东省";
        String city ="深圳市";
        String district ="宝安区";
        //广东省 深圳市 宝安区 ==> GDSZBA

        province = province.substring(0,province.length()-1);
        city = city.substring(0,city.length()-1);
        district = district.substring(0,district.length()-1);
        //获取汉字首字母
        String[] headByString = PinYin4jUtils.getHeadByString(province+city+district);
        //将字符串数组转换成字符串
        String stringArrayToString = PinYin4jUtils.stringArrayToString(headByString, "");
        System.out.println(stringArrayToString);
        //深圳市
        String hanziToPinyin = PinYin4jUtils.hanziToPinyin(city,"");
        System.out.println(hanziToPinyin);
    }

}
