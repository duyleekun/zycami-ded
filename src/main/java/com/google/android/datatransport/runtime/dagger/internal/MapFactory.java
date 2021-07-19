/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory;
import com.google.android.datatransport.runtime.dagger.internal.DaggerCollections;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.MapFactory$1;
import com.google.android.datatransport.runtime.dagger.internal.MapFactory$Builder;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

public final class MapFactory
extends AbstractMapFactory {
    private static final Provider EMPTY = InstanceFactory.create(Collections.emptyMap());

    private MapFactory(Map map) {
        super(map);
    }

    public /* synthetic */ MapFactory(Map map, MapFactory$1 mapFactory$1) {
        this(map);
    }

    public static MapFactory$Builder builder(int n10) {
        MapFactory$Builder mapFactory$Builder = new MapFactory$Builder(n10, null);
        return mapFactory$Builder;
    }

    public static Provider emptyMapProvider() {
        return EMPTY;
    }

    public Map get() {
        boolean bl2;
        int n10 = this.contributingMap().size();
        LinkedHashMap linkedHashMap = DaggerCollections.newLinkedHashMapWithExpectedSize(n10);
        Iterator iterator2 = this.contributingMap().entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            Object k10 = object.getKey();
            object = ((Provider)object.getValue()).get();
            linkedHashMap.put(k10, object);
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}

