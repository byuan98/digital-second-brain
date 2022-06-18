package pers.boyuan.common.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

/**
 * 字符串解压工具类
 *
 * @author ZhangBoyuan
 * @date 2022-06-18
 */
public class StringUnzipUtil {

    public static String gzip(String str) {
        try {
            byte[] test = str.getBytes(StandardCharsets.ISO_8859_1);
            InputStream inputStream = new ByteArrayInputStream(test);
            GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gzipInputStream));
            String result = bufferedReader
                    .lines()
                    .collect(Collectors.joining());

            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
