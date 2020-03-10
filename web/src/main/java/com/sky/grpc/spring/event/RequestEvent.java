package com.sky.grpc.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.context.support.RequestHandledEvent;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019/12/12 8:50 下午
 */
public class RequestEvent extends RequestHandledEvent {

    public RequestEvent(Object source, String sessionId, String userName,
            long processingTimeMillis) {
        super(source, sessionId, userName, processingTimeMillis);
    }

    public RequestEvent(Object source, String sessionId, String userName, long processingTimeMillis,
            Throwable failureCause) {
        super(source, sessionId, userName, processingTimeMillis, failureCause);
    }
}
