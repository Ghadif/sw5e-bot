package com.ghadif.loader;

import com.ghadif.exception.MessageNotFoundException;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Log4j2
public abstract class GenericMessageLoader implements MessageLoader {

    @Override
    public final String load(String messageName) {
        try {
            return this.loadMessage(messageName);
        } catch (Exception e) {
            log.error("Could not load message {}", messageName);
            throw new MessageNotFoundException("Could not load message %s", messageName);
        }
    }

    protected abstract String loadMessage(String messageName) throws IOException;

}
