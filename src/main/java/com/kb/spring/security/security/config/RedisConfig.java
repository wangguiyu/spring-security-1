package com.kb.spring.security.security.config;

import com.kb.spring.security.security.handler.SessionStrategyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 300)
public class RedisConfig {

    @Autowired
    private FindByIndexNameSessionRepository sessionRepository;

    @Bean
    public SpringSessionBackedSessionRegistry sessionRegistry() {
        return new SpringSessionBackedSessionRegistry(this.sessionRepository);
    }

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new SessionStrategyHandler();
    }
}
