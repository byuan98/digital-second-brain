package pers.boyuan.common.util;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * 对象属性工具类
 *
 * @author ZhangBoyuan
 * @date 2022-06-12
 */
public class ObjectFieldUtil {

    /**
     * 判断对象属性是否全部为null
     */
    public static Boolean allNull(Object object) {
        if (Objects.isNull(object)) {
            return Boolean.TRUE;
        }

        Integer nullCount = 0;

        Field[] fieldArray = object.getClass().getDeclaredFields();
        for (Field field : fieldArray) {
            field.setAccessible(Boolean.TRUE);
            try {
                if (Objects.isNull(field.get(object))) {
                    nullCount++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return nullCount.equals(fieldArray.length) ? Boolean.TRUE : Boolean.FALSE;
    }

    /**
     * 判断对象属性是否全部非null
     */
    public static Boolean allNonNull(Object object) {
        return allNull(object) ? Boolean.FALSE : Boolean.TRUE;
    }

    /**
     * 判断对象属性之一是否存在null
     */
    public static Boolean existNull(Object object) {
        if (Objects.isNull(object)) {
            return Boolean.TRUE;
        }

        Field[] fieldArray = object.getClass().getDeclaredFields();
        for (Field field : fieldArray) {
            field.setAccessible(Boolean.TRUE);
            try {
                if (Objects.isNull(field.get(object))) {
                    return Boolean.TRUE;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return Boolean.FALSE;
    }

    /**
     * 判断对象属性是否全部为null或空字符串
     */
    public static Boolean allBlank(Object object) {
        if (Objects.isNull(object)) {
            return Boolean.TRUE;
        }

        Integer nullCount = 0;

        Field[] fieldArray = object.getClass().getDeclaredFields();
        for (Field field : fieldArray) {
            field.setAccessible(Boolean.TRUE);
            try {
                if (Objects.isNull(field.get(object)) || StringUtils.isBlank(field.get(object).toString())) {
                    nullCount++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return nullCount.equals(fieldArray.length) ? Boolean.TRUE : Boolean.FALSE;
    }

}
