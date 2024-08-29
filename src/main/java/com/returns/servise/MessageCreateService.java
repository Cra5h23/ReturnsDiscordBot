package com.returns.servise;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.returns.listeners.EventListener;
import com.returns.listeners.MessageListener;

/**
 * @author Nikolay Radzivon
 * @Date 19.08.2024
 */
@Service
public class MessageCreateService extends MessageListener implements EventListener<MessageCreateEvent> {

    @Override
    public Class<MessageCreateEvent> getEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        return processMessage(event.getMessage());
    }
}
