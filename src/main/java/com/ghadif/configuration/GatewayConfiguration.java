package com.ghadif.configuration;

import com.ghadif.listener.EventListener;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Data
@Configuration
@Log4j2
public class GatewayConfiguration {

    private final DiscordBotProperties discordBotProperties;

    @Bean
    public <T extends Event> GatewayDiscordClient gatewayDiscordClient(List<EventListener<T>> eventListeners) {
       log.info("Attempting to connect to Discord");
        GatewayDiscordClient client = DiscordClientBuilder.create(discordBotProperties.getToken())
                .build()
                .login()
                .block();
        log.info("Successfully connected to discord");

        for (EventListener<T> listener : eventListeners) {
            if (client != null)
                client.on(listener.getEventType())
                        .log()
                        .flatMap(listener::execute)
                        .onErrorResume(listener::handleError)
                        .subscribe();
        }

        return client;
    }
}
