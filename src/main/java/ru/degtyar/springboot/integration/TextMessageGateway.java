package ru.degtyar.springboot.integration;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import ru.degtyar.springboot.dto.TextMessage;

@MessagingGateway(name = TextMessageGateway.GATEWAY, defaultRequestChannel = TextMessageGateway.CHANNEL)
public interface TextMessageGateway {

    String CHANNEL = "textMessageChannel";

    String GATEWAY = "textMessageGateway";

    @Gateway
    void fire(Message<TextMessage> message);
}