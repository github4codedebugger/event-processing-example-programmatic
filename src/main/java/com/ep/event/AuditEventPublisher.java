package com.ep.event;

import com.ep.utils.CommonUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AuditEventPublisher implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishEvent(String message) {

        Map<String, String> data = CommonUtils.requestData();
        data.put("message", message);


        applicationEventPublisher.publishEvent(new AuditEvent<LogData>(LogData.builder().dataMap(data).build()));
    }
}
