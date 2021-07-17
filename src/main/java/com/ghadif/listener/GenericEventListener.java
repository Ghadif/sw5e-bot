package com.ghadif.listener;

import discord4j.core.event.domain.Event;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Log4j2
public abstract class GenericEventListener<T extends Event> implements EventListener<T> {

    @Override
    public final Mono<Void> handleError(Throwable error) {
        log.error("Unable to process ".concat(this.getEventType().getSimpleName()), error);
        return Mono.empty();
    }

}
