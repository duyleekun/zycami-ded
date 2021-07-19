/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import java.io.Serializable;

public class ImmutableMultiset$EntrySetSerializedForm
implements Serializable {
    public final ImmutableMultiset multiset;

    public ImmutableMultiset$EntrySetSerializedForm(ImmutableMultiset immutableMultiset) {
        this.multiset = immutableMultiset;
    }

    public Object readResolve() {
        return this.multiset.entrySet();
    }
}

