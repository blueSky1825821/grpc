package com.sky.grpc.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019/12/12 8:50 下午
 */
public class StoppedEvent extends ContextStoppedEvent {

    /**
     * Create a new ContextRefreshedEvent.
     *
     * @param source the {@code ApplicationContext} that has been initialized
     *               or refreshed (must not be {@code null})
     */
    public StoppedEvent(ApplicationContext source) {
        super(source);
    }
}
