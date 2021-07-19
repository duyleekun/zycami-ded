/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.MapCollections$MapItemBuilder;
import java.util.HashMap;
import java.util.Map;

public class MapCollections$MapBulder {
    private HashMap map;

    public MapCollections$MapBulder() {
        new HashMap();
    }

    public Map build() {
        return this.map;
    }

    public MapCollections$MapBulder putItem(Object object, Object object2) {
        this.map.put(object, object2);
        return this;
    }

    public MapCollections$MapItemBuilder set(Object object) {
        this.map.put(object, null);
        MapCollections$MapItemBuilder mapCollections$MapItemBuilder = new MapCollections$MapItemBuilder(this, object);
        return mapCollections$MapItemBuilder;
    }
}

