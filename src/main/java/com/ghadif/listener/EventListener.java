package com.ghadif.listener;

import discord4j.core.event.domain.Event;
import reactor.core.publisher.Mono;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public interface EventListener<T extends Event> {

    Class<T> getEventType();

    Mono<Void> execute(T event);

    Mono<Void> handleError(Throwable error);
}
