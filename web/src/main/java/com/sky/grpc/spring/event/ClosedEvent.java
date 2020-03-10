package com.sky.grpc.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019/12/12 8:50 下午
 */
public class ClosedEvent extends ContextClosedEvent {

    /**
     * Create a new ContextRefreshedEvent.
     *
     * @param source the {@code ApplicationContext} that has been initialized
     *               or refreshed (must not be {@code null})
     */
    public ClosedEvent(ApplicationContext source) {
        super(source);
    }
}
