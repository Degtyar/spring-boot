package ru.degtyar.springboot.controller;

//import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.degtyar.springboot.dto.ResultDTO;
import ru.degtyar.springboot.dto.WelcomeMessage;
import ru.degtyar.springboot.dto.SimpleMessage;
import ru.degtyar.springboot.integration.SimpleMessageGateway;
import ru.degtyar.springboot.integration.WelcomeMessageGateway;

import java.util.UUID;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private SimpleMessageGateway simpleMessageGateway;

    @Autowired
    private WelcomeMessageGateway welcomeMessageGateway;

    @RequestMapping(value = "/ping", produces = "application/json")
    public ResultDTO ping(){return new ResultDTO();}

    @RequestMapping(value = "/simple", method = RequestMethod.GET, produces = "application/json")
    public ResultDTO send(){
        simpleMessageGateway.fire(MessageBuilder
                .withPayload(new SimpleMessage())
                .setHeader("REQ_ID", UUID.randomUUID().toString())
                .build());
        return new ResultDTO();
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = "application/json")
    public ResultDTO welcome(@RequestParam(name = "name") String name){
        welcomeMessageGateway.fire(MessageBuilder.withPayload(new WelcomeMessage(name)).build());
        return new ResultDTO();
    }
}