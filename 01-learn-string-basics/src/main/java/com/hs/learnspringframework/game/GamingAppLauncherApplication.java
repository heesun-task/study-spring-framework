package com.hs.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.hs.learnspringframework.game")
public class GamingAppLauncherApplication {

    @Bean
    public GameRunner gameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) {
        return new GameRunner(game);
    }

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class);

        try(context) {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();

        }

    }
}