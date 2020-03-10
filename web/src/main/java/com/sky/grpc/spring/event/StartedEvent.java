package com.sky.grpc.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextStartedEvent;

/**
 * DESCRIPTION:
 * <P>
 * </p>
 *
 * @author WangMin
 * @since 2019/12/12 8:51 下午
 */
public class StartedEvent extends ContextStartedEvent {

    /**
     * Create a new ContextStartedEvent.
     *
     * @param source the {@code ApplicationContext} that has been started
     *               (must not be {@code null})
     */
    public StartedEvent(ApplicationContext source) {
        super(source);
    }
}
