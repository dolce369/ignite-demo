package com.dolce369;

import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "ignite")
public class IgniteCacheProperties {
    private Map<String, CacheConfiguration> caches;

    public Map<String, CacheConfiguration> getCaches() {
        return caches;
    }

    public void setCaches(Map<String, CacheConfiguration> caches) {
        this.caches = caches;
    }

    // Method to convert properties into Ignite CacheConfiguration objects
    public Map<String, CacheConfiguration> createCacheConfigurations() {
        Map<String, CacheConfiguration> cacheConfigMap = new HashMap<>();
        caches.forEach((key, value) -> cacheConfigMap.put(key, new CacheConfiguration(key)
                .setCacheMode(value.getCacheMode())
                .setAtomicityMode(value.getAtomicityMode())
                .setBackups(value.getBackups())));
        return cacheConfigMap;
    }
}
