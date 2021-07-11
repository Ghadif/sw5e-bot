package com.ghadif.configuration;

import com.ghadif.listener.EventListener;
import discord4j.common.util.Snowflake;
import discord4j.core.GatewayDiscordClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
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
        assertEquals(1, eventListeners.size());
    }
}
