/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class SetBuilder {
    private static final String SET_CONTRIBUTIONS_CANNOT_BE_NULL = "Set contributions cannot be null";
    private final List contributions;

    private SetBuilder(int n10) {
        ArrayList arrayList;
        this.contributions = arrayList = new ArrayList(n10);
    }

    public static SetBuilder newSetBuilder(int n10) {
        SetBuilder setBuilder = new SetBuilder(n10);
        return setBuilder;
    }

    public SetBuilder add(Object object) {
        List list = this.contributions;
        object = Preconditions.checkNotNull(object, SET_CONTRIBUTIONS_CANNOT_BE_NULL);
        list.add(object);
        return this;
    }

    public SetBuilder addAll(Collection collection) {
        boolean bl2;
        Iterator iterator2 = collection.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            String string2 = SET_CONTRIBUTIONS_CANNOT_BE_NULL;
            Preconditions.checkNotNull(e10, string2);
        }
        this.contributions.addAll(collection);
        return this;
    }

    public Set build() {
        Collection collection = this.contributions;
        int n10 = collection.size();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                List list = this.contributions;
                collection = new HashSet(list);
                return Collections.unmodifiableSet(collection);
            }
            return Collections.singleton(this.contributions.get(0));
        }
        return Collections.emptySet();
    }
}

