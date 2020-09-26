package com.ep.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AuditEventHandler implements ApplicationListener<AuditEvent> {

    @Override
    public void onApplicationEvent(AuditEvent auditEvent) {
        try {
            String data = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(auditEvent.getData());
            System.out.println("sending data to security audit service : " + data);
        } catch (
                Exception ex) {

        }

    }
}
