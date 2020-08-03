package org.sang.hanzy.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    /**
     * 校验时间格式是否为 yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static final String PATTERN_DEFAULT = "yyyy-MM-dd HH:mm:ss";
    private static Boolean isDateVail(String date) {
        //用于指定 日期/时间 模式
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(PATTERN_DEFAULT);
        boolean flag = true;
        try {
            //Java 8 新添API 用于解析日期和时间
            LocalDateTime.parse(date, dtf);
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
