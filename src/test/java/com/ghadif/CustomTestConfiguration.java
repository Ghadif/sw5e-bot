package com.ghadif;

import discord4j.core.GatewayDiscordClient;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@TestConfiguration
public class CustomTestConfiguration {

    @MockBean
    private GatewayDiscordClient gatewayDiscordClient;
}
