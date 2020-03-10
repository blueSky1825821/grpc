package com.sky.grpc.spring.event;

import org.springframework.context.ApplicationListener;
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
public class ApplicationStopListener implements ApplicationListener<StoppedEvent> {

    @Override
    public void onApplicationEvent(StoppedEvent event) {
        System.out.println("StoppedEvent我的父容器为：" + event.getApplicationContext().getParent());
        System.out.println("初始化时我被调用了。");
    }
}
