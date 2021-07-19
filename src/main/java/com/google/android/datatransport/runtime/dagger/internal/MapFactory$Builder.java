/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory$Builder;
import com.google.android.datatransport.runtime.dagger.internal.MapFactory;
import com.google.android.datatransport.runtime.dagger.internal.MapFactory$1;
import java.util.LinkedHashMap;
import javax.inject.Provider;

public final class MapFactory$Builder
extends AbstractMapFactory$Builder {
    private MapFactory$Builder(int n10) {
        super(n10);
    }

    public /* synthetic */ MapFactory$Builder(int n10, MapFactory$1 mapFactory$1) {
        this(n10);
    }

    public MapFactory build() {
        LinkedHashMap linkedHashMap = this.map;
        MapFactory mapFactory = new MapFactory(linkedHashMap, null);
        return mapFactory;
    }

    public MapFactory$Builder put(Object object, Provider provider) {
        super.put(object, provider);
        return this;
    }

    public MapFactory$Builder putAll(Provider provider) {
        super.putAll(provider);
        return this;
    }
}

