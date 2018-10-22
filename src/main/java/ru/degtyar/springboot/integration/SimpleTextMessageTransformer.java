package ru.degtyar.springboot.integration;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import ru.degtyar.springboot.dto.SimpleMessage;
import ru.degtyar.springboot.dto.TextMessage;

@MessageEndpoint
public class SimpleTextMessageTransformer {

    @Transformer(inputChannel = SimpleMessageGateway.CHANNEL, outputChannel = TextMessageGateway.CHANNEL)
    public TextMessage transform(SimpleMessage simpleMessage){
        System.out.println("SimpleTextMessageTransformer");
        return new TextMessage(simpleMessage.getDate().toString());
    }
}