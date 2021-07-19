/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class HttpDataSource$RequestProperties {
    private final Map requestProperties;
    private Map requestPropertiesSnapshot;

    public HttpDataSource$RequestProperties() {
        HashMap hashMap;
        this.requestProperties = hashMap = new HashMap();
    }

    public void clear() {
        synchronized (this) {
            Map map = null;
            this.requestPropertiesSnapshot = null;
            map = this.requestProperties;
            map.clear();
            return;
        }
    }

    public void clearAndSet(Map map) {
        synchronized (this) {
            Map map2 = null;
            this.requestPropertiesSnapshot = null;
            map2 = this.requestProperties;
            map2.clear();
            map2 = this.requestProperties;
            map2.putAll(map);
            return;
        }
    }

    public Map getSnapshot() {
        synchronized (this) {
            Map map = this.requestPropertiesSnapshot;
            if (map == null) {
                Map map2 = this.requestProperties;
                map = new Map(map2);
                this.requestPropertiesSnapshot = map = Collections.unmodifiableMap(map);
            }
            map = this.requestPropertiesSnapshot;
            return map;
        }
    }

    public void remove(String string2) {
        synchronized (this) {
            Map map = null;
            this.requestPropertiesSnapshot = null;
            map = this.requestProperties;
            map.remove(string2);
            return;
        }
    }

    public void set(String string2, String string3) {
        synchronized (this) {
            Map map = null;
            this.requestPropertiesSnapshot = null;
            map = this.requestProperties;
            map.put(string2, string3);
            return;
        }
    }

    public void set(Map map) {
        synchronized (this) {
            Map map2 = null;
            this.requestPropertiesSnapshot = null;
            map2 = this.requestProperties;
            map2.putAll(map);
            return;
        }
    }
}

