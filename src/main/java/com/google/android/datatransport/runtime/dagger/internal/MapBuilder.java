/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.DaggerCollections;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class MapBuilder {
    private final Map contributions;

    private MapBuilder(int n10) {
        LinkedHashMap linkedHashMap = DaggerCollections.newLinkedHashMapWithExpectedSize(n10);
        this.contributions = linkedHashMap;
    }

    public static MapBuilder newMapBuilder(int n10) {
        MapBuilder mapBuilder = new MapBuilder(n10);
        return mapBuilder;
    }

    public Map build() {
        Map map = this.contributions;
        int n10 = map.size();
        if (n10 != 0) {
            return Collections.unmodifiableMap(this.contributions);
        }
        return Collections.emptyMap();
    }

    public MapBuilder put(Object object, Object object2) {
        this.contributions.put(object, object2);
        return this;
    }

    public MapBuilder putAll(Map map) {
        this.contributions.putAll(map);
        return this;
    }
}

