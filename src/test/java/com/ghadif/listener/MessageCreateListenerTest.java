package com.ghadif.listener;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@ExtendWith(MockitoExtension.class)
public class MessageCreateListenerTest {

    @InjectMocks
    private MessageCreateListener messageCreateListener;

    @Test
    void eventTypeIsOfMessageCreateEvent() {
        assertEquals(MessageCreateEvent.class, messageCreateListener.getEventType());
    }
}
