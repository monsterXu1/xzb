package com.my.hutool.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.SortedMap;
import java.util.stream.Stream;

/**
 * @author: xzb
 */
public class IOUtilservice {

    @SneakyThrows
    public void IOUntil(){
        //TODO copy
        BufferedInputStream in = FileUtil.getInputStream("d:/test.txt");
        BufferedOutputStream out = FileUtil.getOutputStream("d:/test2.txt");
        //long copySize = IoUtil.copy(in, out, IoUtil.DEFAULT_BUFFER_SIZE);

        BufferedReader reader = IoUtil.getReader(in, StandardCharsets.UTF_8);
        //一行一行的文件
        Stream<String> lines = reader.lines();

        Charset latin1 = Charset.forName("ISO-8859-1") ;    // 只能表示的英文字符
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets(); // 得到全部可用的字符集
        //IoUtil.readLines(in,stringCharsetSortedMap,)
        //拿到所有数据
        String s = IoUtil.readUtf8(in);

        IoUtil.getWriter(out,StandardCharsets.UTF_8);
        //写入数据
        IoUtil.writeObjects(out,true,s);

        FileInputStream fileInputStream = IoUtil.toStream(new File("d:/test.txt"));
        //字符串转字节数流
        ByteArrayInputStream byteArrayInputStream = IoUtil.toStream(s, StandardCharsets.UTF_8);

    }
}
