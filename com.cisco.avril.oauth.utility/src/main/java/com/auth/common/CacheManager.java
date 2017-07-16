package com.auth.common;

/**
 * @author asingha3 Interface to cache Manager.
 */
public interface CacheManager<K, V> {

    /**
     * @param key
     *            String
     */
    void deleteValue(K key);

    /**
     * @param key
     *            String
     * @return Subject
     */
    V getValue(K key);

    /**
     * @param key
     *            String
     * @param value
     *            Subject
     */
    void setValue(K key, V value);

}
