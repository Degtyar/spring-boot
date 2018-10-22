package ru.degtyar.springboot.integration;


import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import ru.degtyar.springboot.dto.WelcomeMessage;

import java.util.logging.Logger;

@MessageEndpoint
public class WelcomeNullableListener {

    private static final Logger LOGGER = Logger.getLogger(WelcomeNullableListener.class.getSimpleName());

    @ServiceActivator(inputChannel = "welcomeNullableChannel")
    public void handler(WelcomeMessage message){LOGGER.info("HELLO NONE!");}
}