package com.dolce369;

import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CacheService {

    private final IgniteCacheProperties cacheProperties;
    private final Map<String, CacheConfiguration> caches;

    @Autowired
    public CacheService(IgniteCacheProperties cacheProperties) {
//        this.ignite = ignite;
        this.cacheProperties = cacheProperties;
        this.caches = cacheProperties.createCacheConfigurations();
    }


    public Map<String, CacheConfiguration> getCaches() {
        return this.caches;
    }

    public CacheConfiguration[] getCacheConfigurations() {
        return this.caches.values().toArray(new CacheConfiguration[0]);
    }

}
