/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory;
import com.google.android.datatransport.runtime.dagger.internal.DaggerCollections;
import com.google.android.datatransport.runtime.dagger.internal.DelegateFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import java.util.LinkedHashMap;
import javax.inject.Provider;

public abstract class AbstractMapFactory$Builder {
    public final LinkedHashMap map;

    public AbstractMapFactory$Builder(int n10) {
        LinkedHashMap linkedHashMap;
        this.map = linkedHashMap = DaggerCollections.newLinkedHashMapWithExpectedSize(n10);
    }

    public AbstractMapFactory$Builder put(Object object, Provider object2) {
        LinkedHashMap linkedHashMap = this.map;
        object = Preconditions.checkNotNull(object, "key");
        object2 = Preconditions.checkNotNull(object2, "provider");
        linkedHashMap.put(object, object2);
        return this;
    }

    public AbstractMapFactory$Builder putAll(Provider object) {
        boolean bl2 = object instanceof DelegateFactory;
        if (bl2) {
            object = ((DelegateFactory)object).getDelegate();
            return this.putAll((Provider)object);
        }
        object = (AbstractMapFactory)object;
        LinkedHashMap linkedHashMap = this.map;
        object = AbstractMapFactory.access$000((AbstractMapFactory)object);
        linkedHashMap.putAll(object);
        return this;
    }
}

