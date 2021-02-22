package com.my.hutool.service;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.CharsetUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Assert;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: xzb
 */
@Service
public class HuToolService {

    public static void convert(){
//TODO 转字符串
        int a = 1;
        Convert.toStr(a);
//TODO 数组中的类型转化
        String[] b = { "1", "2", "3", "4" };
        //结果为Integer数组
        Integer[] intArray = Convert.toIntArray(b);
//TODO 数组中的类型转化
        long[] c = {1,2,3,4,5};
        //结果为Integer数组
        Integer[] intArray2 = Convert.toIntArray(c);
//TODO 字符串转时间Date
        String d = "2017-05-06";
        Date value = Convert.toDate(a);
//TODO 数组转集合
        String[] e = {"a", "你", "好", "", "1"};
        List<String> objects = (List<String>) Convert.toList(e);
        List<String> ts = Convert.convert(new TypeReference<List<String>>() {}, e);
//TODO 半角转全角：
        String f = "123456789";
        String sbc = Convert.toSBC(f);
        //结果为："１２３４５６７８９"
//TODO 全角转半角：
        String g = "１２３４５６７８９";
        String dbc = Convert.toDBC(g);
        //结果为"123456789"
//TODO 全16进制（Hex）
        String hixStr = "我是一个小小的可爱的字符串";
        //结果："e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2"
        String hex = Convert.toHex(hixStr, CharsetUtil.CHARSET_UTF_8);

//TODO  将16进制（Hex）字符串转为普通字符串:
        String hexTAype = "e68891e698afe4b880e4b8aae5b08fe5b08fe79a84e58fafe788b1e79a84e5ad97e7aca6e4b8b2";
        //注意：在4.1.11之后hexStrToStr将改名为hexToStr
        String raw = Convert.hexToStr(hexTAype, CharsetUtil.CHARSET_UTF_8);

//TODO      Unicode和字符串转换  与16进制类似，Convert类同样可以在字符串和Unicode之间轻松转换：
        String str = "我是一个小小的可爱的字符串";
        //结果为："\\u6211\\u662f\\u4e00\\u4e2a\\u5c0f\\u5c0f\\u7684\\u53ef\\u7231\\u7684\\u5b57\\u7b26\\u4e32"
        String unicode = Convert.strToUnicode(str);
        //结果为："我是一个小小的可爱的字符串"
        String srtRe = Convert.unicodeToStr(unicode);

//TODO      编码转换
        String abc = "我不是乱码";
        //转换后result为乱码
        String result = Convert.convertCharset(abc, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        String rawAtr = Convert.convertCharset(result, CharsetUtil.ISO_8859_1, "UTF-8");
        Assert.assertEquals(rawAtr, abc);
    }

    public static void main(String[] args) {
        convert();
    }
}
