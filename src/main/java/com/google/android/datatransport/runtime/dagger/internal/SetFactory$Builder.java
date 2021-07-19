/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.DaggerCollections;
import com.google.android.datatransport.runtime.dagger.internal.SetFactory;
import com.google.android.datatransport.runtime.dagger.internal.SetFactory$1;
import java.util.List;
import javax.inject.Provider;

public final class SetFactory$Builder {
    public static final /* synthetic */ boolean $assertionsDisabled;
    private final List collectionProviders;
    private final List individualProviders;

    private SetFactory$Builder(int n10, int n11) {
        List list;
        this.individualProviders = list = DaggerCollections.presizedList(n10);
        this.collectionProviders = list = DaggerCollections.presizedList(n11);
    }

    public /* synthetic */ SetFactory$Builder(int n10, int n11, SetFactory$1 setFactory$1) {
        this(n10, n11);
    }

    public SetFactory$Builder addCollectionProvider(Provider provider) {
        this.collectionProviders.add(provider);
        return this;
    }

    public SetFactory$Builder addProvider(Provider provider) {
        this.individualProviders.add(provider);
        return this;
    }

    public SetFactory build() {
        List list = this.individualProviders;
        List list2 = this.collectionProviders;
        SetFactory setFactory = new SetFactory(list, list2, null);
        return setFactory;
    }
}

