package com.returns.listeners;

import com.returns.Commands;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * @author Nikolay Radzivon
 * @Date 19.08.2024
 */
public abstract class MessageListener {
    private String author; //Имя автора сообщения.
    private String content; //Текст сообщения.

    public Mono<Void> processMessage(final Message eventMessage) {
        return Mono.just(eventMessage)
                .filter(message -> {
                    final Boolean isNotBot = message.getAuthor()
                            .map(user -> !user.isBot())
                            .orElse(false);
                    if (isNotBot) {
                        message.getAuthor().ifPresent(user -> author = user.getUsername());
                        content = message.getContent();
                    }
                    return isNotBot;
                })
                .flatMap(Message::getChannel)
//                .flatMap(channel -> channel.createMessage(String.format("Hello '%s'", author)))
                .flatMap(channel -> channel.createMessage(makeMessage()))
                .then();
    }

    private String makeMessage() {
        if (content.startsWith("-")) {
            return selectCommand(content.substring(1));
        } else {
            return String.format("Hello '%s'", author);
        }
    }

    private String selectCommand(String command) {
        switch (Commands.valueOf(command.toUpperCase())) {
            case COMMANDS: {
                return "Список всех доступных команд:\n" + Arrays.toString(Commands.values());
            }
            case ARMORY: {
                Site site = new Site();

                return site.connect("s");
            }

            default: {
                return "Такой команды нет";
            }
        }
    }
}
