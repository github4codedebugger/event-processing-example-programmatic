package com.ep.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;


@Getter
public class AuditEvent extends ApplicationEvent {
    private final LogData data;

    public AuditEvent(Object source, LogData data) {
        super(source);
        this.data = data;
    }
}
