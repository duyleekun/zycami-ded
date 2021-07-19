/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory;
import com.google.android.datatransport.runtime.dagger.internal.MapProviderFactory$1;
import com.google.android.datatransport.runtime.dagger.internal.MapProviderFactory$Builder;
import java.util.Map;

public final class MapProviderFactory
extends AbstractMapFactory
implements Lazy {
    private MapProviderFactory(Map map) {
        super(map);
    }

    public /* synthetic */ MapProviderFactory(Map map, MapProviderFactory$1 mapProviderFactory$1) {
        this(map);
    }

    public static MapProviderFactory$Builder builder(int n10) {
        MapProviderFactory$Builder mapProviderFactory$Builder = new MapProviderFactory$Builder(n10, null);
        return mapProviderFactory$Builder;
    }

    public Map get() {
        return this.contributingMap();
    }
}

