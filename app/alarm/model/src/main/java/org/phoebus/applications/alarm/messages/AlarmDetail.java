package org.phoebus.applications.alarm.messages;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.logging.Level;

import static org.phoebus.applications.alarm.AlarmSystem.logger;
import static org.phoebus.applications.alarm.messages.AlarmMessageUtil.objectMapper;

public class AlarmDetail {

    private String title;
    private String details;
    private int delay;

    public AlarmDetail() {
        super();
    }

    public AlarmDetail(String title, String action) {
        super();
        this.title = title;
        this.details = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            logger.log(Level.WARNING, "failed to parse the alarm detail message ", e);
        }
        return "";
    }

}
