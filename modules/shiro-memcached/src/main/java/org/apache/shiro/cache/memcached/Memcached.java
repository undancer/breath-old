package org.apache.shiro.cache.memcached;

import net.spy.memcached.MemcachedClient;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * Created by undancer on 14-1-1.
 */
public class Memcached<K, V> implements Cache<K, V> {

    private static final Logger log = LoggerFactory.getLogger(Memcached.class);


    private MemcachedClient cache;

    public Memcached(MemcachedClient cache) {
        if (cache == null) {
            throw new IllegalArgumentException("Cache argument cannot be null.");
        }
        this.cache = cache;
    }

    public static void main(String[] args) throws IOException {
        InetSocketAddress addr = InetSocketAddress.createUnresolved("453fd7f4190111e3.m.cnhzalicm10pub001.ocs.aliyuncs.com", 11211);
        MemcachedClient memcachedClient = new MemcachedClient(addr);
        memcachedClient.get("test");
    }

    public V get(K key) throws CacheException {
        try {
            if (log.isTraceEnabled()) {
//                log.trace("Getting object from cache [" + cache.getName() + "] for key [" + key + "]");
            }
            if (key == null) {
                return null;
            } else {
                return (V) cache.get(key.toString());
            }
        } catch (Throwable e) {
            throw new CacheException(e);
        }
    }

    @Override
    public V put(K key, V value) throws CacheException {
        try {
            V previous = get(key);
            cache.set(key.toString(), 0, value);
            return previous;
        } catch (Throwable e) {
            throw new CacheException(e);
        }
    }

    @Override
    public V remove(K key) throws CacheException {
        try {
            V previous = get(key);
            cache.delete(key.toString());
            return previous;
        } catch (Throwable e) {
            throw new CacheException(e);
        }
    }

    @Override
    public void clear() throws CacheException {

        cache.flush();
        throw new CacheException("未实现");
    }

    @Override
    public int size() {
        try {
            return 0;
        } catch (Throwable e) {
            throw new CacheException(e);
        }
    }

    @Override
    public Set<K> keys() {
        try {
            return Collections.emptySet();
        } catch (Throwable e) {
            throw new CacheException(e);
        }
    }

    @Override
    public Collection<V> values() {
        try {
            return Collections.emptyList();
        } catch (Throwable e) {
            throw new CacheException(e);
        }
    }
}
