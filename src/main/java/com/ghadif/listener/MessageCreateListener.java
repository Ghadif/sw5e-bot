package com.ghadif.listener;

import com.ghadif.exception.NotACommandException;
import com.ghadif.parser.CommandParserFactory;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Log4j2
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
            log.info("Attempting to parse command [{}]", message.getContent());
            final String parsedCommand = commandParserFactory
                    .getCommandParserForMessage(message.getContent())
                    .parseCommand(message.getContent());
            log.info("""
                            Successfully parsed command [{}]:
                                   
                            {}
                            """,
                    message.getContent(), parsedCommand);

            return message
                    .getChannel()
                    .flatMap(messageChannel -> messageChannel.createMessage(parsedCommand));
        } catch (NotACommandException ex) {
            log.info("Command [{}] not recognized. Parsing skipped.", message.getContent());
            return Mono.just(message);
        }
    }
}
