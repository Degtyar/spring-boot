package ru.degtyar.springboot.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;
import ru.degtyar.springboot.dto.WelcomeMessage;

@MessageEndpoint
public class WelcomeRouter {

    @Router(inputChannel = "welcomeChannel")
    public String route(WelcomeMessage message){
        if(message.getName()==null || message.getName().isEmpty()) return "welcomeNullableChannel";
        return "welcomeNotNullChannel";
    }
}