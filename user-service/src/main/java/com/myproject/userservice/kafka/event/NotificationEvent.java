package com.myproject.userservice.kafka.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author nguyenle
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationEvent {

    private String channel;

    private String recipient;

    private String templateCode;

    private Map<String, Object> params;

    private String subject;

    private String body;

}
