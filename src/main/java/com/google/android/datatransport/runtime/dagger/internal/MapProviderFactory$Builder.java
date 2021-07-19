/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory$Builder;
import com.google.android.datatransport.runtime.dagger.internal.MapProviderFactory;
import com.google.android.datatransport.runtime.dagger.internal.MapProviderFactory$1;
import java.util.LinkedHashMap;
import javax.inject.Provider;

public final class MapProviderFactory$Builder
extends AbstractMapFactory$Builder {
    private MapProviderFactory$Builder(int n10) {
        super(n10);
    }

    public /* synthetic */ MapProviderFactory$Builder(int n10, MapProviderFactory$1 mapProviderFactory$1) {
        this(n10);
    }

    public MapProviderFactory build() {
        LinkedHashMap linkedHashMap = this.map;
        MapProviderFactory mapProviderFactory = new MapProviderFactory(linkedHashMap, null);
        return mapProviderFactory;
    }

    public MapProviderFactory$Builder put(Object object, Provider provider) {
        super.put(object, provider);
        return this;
    }

    public MapProviderFactory$Builder putAll(Provider provider) {
        super.putAll(provider);
        return this;
    }
}

