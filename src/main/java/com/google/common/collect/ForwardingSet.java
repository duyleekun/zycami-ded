/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingCollection;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Set;

public abstract class ForwardingSet
extends ForwardingCollection
implements Set {
    public abstract Set delegate();

    public boolean equals(Object object) {
        Object object2;
        boolean bl2;
        if (object != this && !(bl2 = (object2 = this.delegate()).equals(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        return this.delegate().hashCode();
    }

    public boolean standardEquals(Object object) {
        return Sets.equalsImpl(this, object);
    }

    public int standardHashCode() {
        return Sets.hashCodeImpl(this);
    }

    public boolean standardRemoveAll(Collection collection) {
        collection = (Collection)Preconditions.checkNotNull(collection);
        return Sets.removeAllImpl((Set)this, collection);
    }
}

