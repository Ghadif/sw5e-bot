package com.ghadif.configuration;

import com.ghadif.listener.EventListener;
import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Data
@Configuration
public class GatewayConfiguration {

    private final DiscordBotProperties discordBotProperties;

    @Bean
    public <T extends Event> GatewayDiscordClient gatewayDiscordClient(List<EventListener<T>> eventListeners) {
        GatewayDiscordClient client = DiscordClientBuilder.create(discordBotProperties.getToken())
                .build()
                .login()
                .block();

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
