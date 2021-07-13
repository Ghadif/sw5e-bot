package com.ghadif.listener;

import com.ghadif.exception.NotACommandException;
import com.ghadif.parser.CommandParserFactory;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Component
@RequiredArgsConstructor
public class MessageCreateListener extends GenericEventListener<MessageCreateEvent> {

    private final CommandParserFactory commandParserFactory;

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent messageCreateEvent) {
        return Mono.just(messageCreateEvent)
                .map(MessageCreateEvent::getMessage)
                .filter(message -> message
                        .getAuthor()
                        .map(user -> !user.isBot())
                        .orElse(false))
                .flatMap(this::reactToMessage)
                .then();
    }

    private Mono<Message> reactToMessage(Message message) {
        try {
            String parsedCommand = commandParserFactory
                    .getCommandParserForMessage(message.getContent())
                    .parseCommand(message.getContent());
            return message.getChannel().flatMap(messageChannel -> messageChannel.createMessage(parsedCommand));
        } catch (NotACommandException ex) {
            return Mono.just(message);
        }
    }
}
