/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.DaggerCollections;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.dagger.internal.SetFactory$1;
import com.google.android.datatransport.runtime.dagger.internal.SetFactory$Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

public final class SetFactory
implements Factory {
    private static final Factory EMPTY_FACTORY = InstanceFactory.create(Collections.emptySet());
    private final List collectionProviders;
    private final List individualProviders;

    private SetFactory(List list, List list2) {
        this.individualProviders = list;
        this.collectionProviders = list2;
    }

    public /* synthetic */ SetFactory(List list, List list2, SetFactory$1 setFactory$1) {
        this(list, list2);
    }

    public static SetFactory$Builder builder(int n10, int n11) {
        SetFactory$Builder setFactory$Builder = new SetFactory$Builder(n10, n11, null);
        return setFactory$Builder;
    }

    public static Factory empty() {
        return EMPTY_FACTORY;
    }

    public Set get() {
        Object object;
        int n10;
        Collection<Object> collection = this.individualProviders;
        int n11 = collection.size();
        int n12 = this.collectionProviders.size();
        ArrayList<Collection> arrayList = new ArrayList<Collection>(n12);
        List list = this.collectionProviders;
        n12 = list.size();
        int n13 = 0;
        Iterator iterator2 = null;
        for (n10 = 0; n10 < n12; ++n10) {
            object = (Collection)((Provider)this.collectionProviders.get(n10)).get();
            int n14 = object.size();
            n11 += n14;
            arrayList.add((Collection)object);
        }
        collection = DaggerCollections.newHashSetWithExpectedSize(n11);
        list = this.individualProviders;
        n12 = list.size();
        iterator2 = null;
        for (n10 = 0; n10 < n12; ++n10) {
            object = Preconditions.checkNotNull(((Provider)this.individualProviders.get(n10)).get());
            collection.add(object);
        }
        n12 = arrayList.size();
        while (n13 < n12) {
            boolean bl2;
            iterator2 = ((Collection)arrayList.get(n13)).iterator();
            while (bl2 = iterator2.hasNext()) {
                object = Preconditions.checkNotNull(iterator2.next());
                collection.add(object);
            }
            ++n13;
        }
        return Collections.unmodifiableSet(collection);
    }
}

