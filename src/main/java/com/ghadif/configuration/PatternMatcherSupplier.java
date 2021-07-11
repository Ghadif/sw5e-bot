package com.ghadif.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "discord.bot.message.matcher")
public class PatternMatcherSupplier {

    private String help;
    private String roll;

}
