package com.dolce369;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.Collection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main {
    //    @Autowired
//    CacheService cacheService;
    @Autowired
    Ignite ignite;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void runCache() {
        Collection<String> cacheNames = ignite.cacheNames();
        for (String cacheName : cacheNames) {
            IgniteCache cache = ignite.cache(cacheName);
            CacheConfiguration config = (CacheConfiguration) cache.getConfiguration(CacheConfiguration.class);
            System.out.println("cache name: " + config.getName());
            System.out.println("cache mode: " + config.getCacheMode());
            System.out.println("backups: " + config.getBackups());

        }
//        cacheService.buildCaches();
//        Map<String, CacheConfiguration> caches = cacheService.getCaches();
//        for (Map.Entry<String, CacheConfiguration> entry : caches.entrySet()) {
//            String cacheName = entry.getKey(); // Cache name
//            CacheConfiguration cacheConfig = entry.getValue(); // Cache configuration
//
//            // Now you can use cacheName and cacheConfig as needed
//            System.out.println("Cache Name: " + cacheName);
//            System.out.println("Cache Configuration: " + cacheConfig.toString());
//
//            // For example, you can inspect specific configurations
//            // System.out.println("Cache Mode: " + cacheConfig.getCacheMode());
//        }

//        var cache1 = caches.get("cache1");
//        System.out.println("caches size::" + caches.size());
//        System.out.println(cache1.getName());
    }
}