package ru.degtyar.springboot.integration;


import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;
import ru.degtyar.springboot.dto.WelcomeMessage;

@MessagingGateway(name = WelcomeMessageGateway.GATEWAY, defaultRequestChannel = WelcomeMessageGateway.CHANNEL)
public interface WelcomeMessageGateway {

    String CHANNEL = "welcomeMessageChannel";

    String GATEWAY = "welcomeMessageGateway";

    @Gateway
    void fire(Message<WelcomeMessage> message);
}