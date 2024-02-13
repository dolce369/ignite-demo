package com.dolce369;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteConfig {

    @Autowired
    CacheService cacheService;

    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration cfg = new IgniteConfiguration();
        // Configure Ignite instance (e.g., discovery SPI, cache configuration)
        cfg.setCacheConfiguration(cacheService.getCacheConfigurations());
        return Ignition.start(cfg);
    }
}
