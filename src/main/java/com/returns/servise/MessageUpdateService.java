package com.returns.servise;

import discord4j.core.event.domain.message.MessageUpdateEvent;
import reactor.core.publisher.Mono;
import com.returns.listeners.EventListener;
import com.returns.listeners.MessageListener;

/**
 * @author Nikolay Radzivon
 * @Date 19.08.2024
 */
public class MessageUpdateService extends MessageListener implements EventListener<MessageUpdateEvent> {

    @Override
    public Class<MessageUpdateEvent> getEventType() {
        return MessageUpdateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageUpdateEvent event) {
        return Mono.just(event)
                .filter(MessageUpdateEvent::isContentChanged)
                .flatMap(MessageUpdateEvent::getMessage)
                .flatMap(super::processMessage);
    }
}
