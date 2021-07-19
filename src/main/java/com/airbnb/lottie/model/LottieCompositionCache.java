/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

public class LottieCompositionCache {
    private static final LottieCompositionCache INSTANCE;
    private final LruCache cache;

    static {
        LottieCompositionCache lottieCompositionCache;
        INSTANCE = lottieCompositionCache = new LottieCompositionCache();
    }

    public LottieCompositionCache() {
        LruCache lruCache;
        this.cache = lruCache = new LruCache(20);
    }

    public static LottieCompositionCache getInstance() {
        return INSTANCE;
    }

    public void clear() {
        this.cache.evictAll();
    }

    public LottieComposition get(String string2) {
        if (string2 == null) {
            return null;
        }
        return (LottieComposition)this.cache.get(string2);
    }

    public void put(String string2, LottieComposition lottieComposition) {
        if (string2 == null) {
            return;
        }
        this.cache.put(string2, lottieComposition);
    }

    public void resize(int n10) {
        this.cache.resize(n10);
    }
}

