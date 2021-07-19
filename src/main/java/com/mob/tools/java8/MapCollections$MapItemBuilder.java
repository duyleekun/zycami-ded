/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.MapCollections$MapBulder;

public class MapCollections$MapItemBuilder {
    private MapCollections$MapBulder builder;
    private Object key;

    public MapCollections$MapItemBuilder(MapCollections$MapBulder mapCollections$MapBulder, Object object) {
        this.builder = mapCollections$MapBulder;
        this.key = object;
    }

    public void withValue(Object object) {
        MapCollections$MapBulder mapCollections$MapBulder = this.builder;
        Object object2 = this.key;
        mapCollections$MapBulder.putItem(object2, object);
    }
}

