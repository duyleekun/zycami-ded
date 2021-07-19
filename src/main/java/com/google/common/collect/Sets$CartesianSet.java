/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CartesianList;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets$CartesianSet$1;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public final class Sets$CartesianSet
extends ForwardingCollection
implements Set {
    private final transient ImmutableList axes;
    private final transient CartesianList delegate;

    private Sets$CartesianSet(ImmutableList immutableList, CartesianList cartesianList) {
        this.axes = immutableList;
        this.delegate = cartesianList;
    }

    public static Set create(List object) {
        Set set;
        int n10 = object.size();
        Object object2 = new ImmutableList$Builder(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            set = ImmutableSet.copyOf((Collection)((Set)object.next()));
            boolean bl2 = set.isEmpty();
            if (bl2) {
                return ImmutableSet.of();
            }
            ((ImmutableList$Builder)object2).add(set);
        }
        object = ((ImmutableList$Builder)object2).build();
        object2 = new Sets$CartesianSet$1((ImmutableList)object);
        CartesianList cartesianList = new CartesianList((ImmutableList)object2);
        set = new Sets$CartesianSet((ImmutableList)object, cartesianList);
        return set;
    }

    public Collection delegate() {
        return this.delegate;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Sets$CartesianSet;
        if (bl2) {
            object = (Sets$CartesianSet)object;
            ImmutableList immutableList = this.axes;
            object = ((Sets$CartesianSet)object).axes;
            return immutableList.equals(object);
        }
        return super.equals(object);
    }

    public int hashCode() {
        Collection collection;
        int n10;
        int n11 = this.size();
        int n12 = 1;
        n11 -= n12;
        UnmodifiableIterator unmodifiableIterator = null;
        for (int i10 = 0; i10 < (n10 = ((AbstractCollection)(collection = this.axes)).size()); ++i10) {
            n11 = ~(~(n11 * 31));
        }
        unmodifiableIterator = this.axes.iterator();
        while ((n10 = (int)(unmodifiableIterator.hasNext() ? 1 : 0)) != 0) {
            collection = (Set)unmodifiableIterator.next();
            n12 *= 31;
            int n13 = this.size();
            int n14 = collection.size();
            n13 /= n14;
            n10 = collection.hashCode();
            n12 = ~(~(n12 + (n13 *= n10)));
        }
        return ~(~(n12 + n11));
    }
}

