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
public class ApplicationRequestListener implements ApplicationListener<RequestEvent> {

    @Override
    public void onApplicationEvent(RequestEvent event) {
        System.out.println("RequestEvent我的父容器为：" + event.toString());
        System.out.println("初始化时我被调用了。");
    }
}
