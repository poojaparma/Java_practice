package com.auth.common;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

/**
 * @author asingha3 This is class responsible for managing key/subject map in inMem. CRUD operations
 */
//@Component
public class InMemoryManager<K, V> implements CacheManager<K, V> {

    /**
     * logger for this class.
     */

    /**
     * Map to store token and subject with token as key.
     */
    private Map<K, V> inMemoryMap = null;

    /**
     * Name to identify the cache. This is required because the same implementation of cache
     * (InMemoryManager) is used for caching multiple purposes. We need a way to identify from which
     * cache a key was removed. For example authentication (key is token) and throttling (key is
     * UUID).
     */
    private String cacheName = null;

    /**
     * @param ttl
     * @param maxEntries
     */
    public InMemoryManager(final int ttl, final int maxEntries, final String cacheName) {
        this.cacheName = cacheName;
        init(ttl, maxEntries);
    }

    /**
     * Constructor.
     */
    public InMemoryManager(final String cacheName) {
        this.cacheName = cacheName;
        init(CommonConstants.DEFAULT_TTL, CommonConstants.DEFAULT_MAX_ENTRIES_INMEM);
    }

    public final void deleteValue(final K key) {
        inMemoryMap.remove(key);
    }

    public final V getValue(final K key) {
        return inMemoryMap.get(key);
    }

    /**
     * @param ttl
     * @param maxEntries
     */
    private void init(final int ttl, final int maxEntries) {


        /* This has to be single statement, don't break into sub statement */
        final Cache<K, V> myCache = CacheBuilder.newBuilder().expireAfterWrite(ttl, TimeUnit.SECONDS)
                .maximumSize(maxEntries).removalListener(new RemovalListener<K, V>() {
                    public void onRemoval(final RemovalNotification<K, V> removal) {
                       
                    }
                }).build();
        inMemoryMap = myCache.asMap();
    }

    public final void setValue(final K key, final V value) {
        inMemoryMap.put(key, value);
    }

}
