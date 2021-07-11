package com.ghadif.listener;

import com.ghadif.parser.CommandParserDecorator;
import discord4j.core.event.domain.message.MessageCreateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Component
@RequiredArgsConstructor
public class MessageCreateListener extends GenericEventListener<MessageCreateEvent> {

    private final CommandParserDecorator commandParserDecorator;

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent messageCreateEvent) {
        return Mono.just(messageCreateEvent)
                .map(MessageCreateEvent::getMessage)
                .filter(message -> message.getAuthor().map(user -> !user.isBot()).orElse(false))
                .flatMap(message -> {
                            String parsedCommand = commandParserDecorator.parseCommand(message.getContent());
                            return message.getChannel()
                                    .filter(messageChannel -> !parsedCommand.isBlank())
                                    .flatMap(messageChannel -> messageChannel.createMessage(parsedCommand));
                        }
                ).then();
    }
}
