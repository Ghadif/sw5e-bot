package com.ghadif.configuration;

import com.ghadif.listener.EventListener;
import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@SuppressWarnings("rawtypes")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class GatewayConfigurationTest {

    @Autowired
    private GatewayDiscordClient gatewayDiscordClient;
    @Autowired
    private List<EventListener<?>> eventListeners;

    @Test
    void gatewayDiscordClientRunning() {
        Snowflake selfId = gatewayDiscordClient.getSelfId();
        assertEquals(Snowflake.of(863517394349064212L), selfId);
    }

    @Test
    void eventListenersRegisteringCorrectly() {
        Reflections reflections = new Reflections("com.ghadif.listeners");
        Set<Class<? extends EventListener>> classes = reflections.getSubTypesOf(EventListener.class);
        assertEquals(classes.size(), eventListeners.size());
    }
}
