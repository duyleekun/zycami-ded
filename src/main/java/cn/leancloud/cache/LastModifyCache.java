/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.cache;

import java.util.Collections;
import java.util.Map;

public class LastModifyCache {
    private static LastModifyCache INSTANCE;
    private boolean lastModifyEnabled = false;
    private Map lastModifyMap;

    private LastModifyCache() {
        Map map = new Map();
        this.lastModifyMap = map = Collections.synchronizedMap(map);
    }

    public static LastModifyCache getInstance() {
        Class<LastModifyCache> clazz = LastModifyCache.class;
        synchronized (clazz) {
            LastModifyCache lastModifyCache = INSTANCE;
            if (lastModifyCache == null) {
                INSTANCE = lastModifyCache = new LastModifyCache();
            }
            lastModifyCache = INSTANCE;
            return lastModifyCache;
        }
    }

    public boolean isLastModifyEnabled() {
        return this.lastModifyEnabled;
    }

    public void setLastModifyEnabled(boolean bl2) {
        this.lastModifyEnabled = bl2;
    }
}

