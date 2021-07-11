package com.ghadif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@SpringBootApplication
@EnableConfigurationProperties
public class StarWarsFifthEditionDiscordBotApp {
    public static void main(String[] args) {
        SpringApplication.run(StarWarsFifthEditionDiscordBotApp.class, args);
    }
}
