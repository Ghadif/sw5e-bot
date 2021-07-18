package com.ghadif.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.validation.Validator;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Configuration
@EnableMongoRepositories
public class MongoDbConfiguration {

    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener(Validator validator) {
        return new ValidatingMongoEventListener(validator);
    }

}
