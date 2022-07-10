package pers.boyuan.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * bean创建工具类，解决new出来的对象内部属性不可被spring管理的问题
 *
 * @author ZhangBoyuan
 * @date 2022-06-27
 */
@Component
public class CreateBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (Objects.isNull(CreateBeanUtil.applicationContext)) {
            CreateBeanUtil.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> c) {
        return applicationContext.getBean(c);
    }

    public static <T> T getBean(String beanName, Class<T> c) {
        return applicationContext.getBean(beanName, c);
    }

}
