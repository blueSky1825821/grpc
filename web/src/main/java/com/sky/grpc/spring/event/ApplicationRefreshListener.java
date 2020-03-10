package com.sky.grpc.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019/12/12 8:53 下午
 */
@Component
public class ApplicationRefreshListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("ContextRefreshedEvent我的父容器为：" + event.getApplicationContext().getParent());
        //root application context 没有parent
        if (event.getApplicationContext().getParent() == null) {
            System.out.println("do it!");
        }
        System.out.println("初始化时我被调用了。");
    }
}
