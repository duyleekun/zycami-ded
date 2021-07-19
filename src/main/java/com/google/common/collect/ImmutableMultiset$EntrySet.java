/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableMultiset$1;
import com.google.common.collect.ImmutableMultiset$EntrySetSerializedForm;
import com.google.common.collect.IndexedImmutableSet;
import com.google.common.collect.Multiset$Entry;

public final class ImmutableMultiset$EntrySet
extends IndexedImmutableSet {
    private static final long serialVersionUID;
    public final /* synthetic */ ImmutableMultiset this$0;

    private ImmutableMultiset$EntrySet(ImmutableMultiset immutableMultiset) {
        this.this$0 = immutableMultiset;
    }

    public /* synthetic */ ImmutableMultiset$EntrySet(ImmutableMultiset immutableMultiset, ImmutableMultiset$1 immutableMultiset$1) {
        this(immutableMultiset);
    }

    public boolean contains(Object object) {
        int n10 = object instanceof Multiset$Entry;
        boolean bl2 = false;
        if (n10 != 0) {
            int n11;
            n10 = (object = (Multiset$Entry)object).getCount();
            if (n10 <= 0) {
                return false;
            }
            ImmutableMultiset immutableMultiset = this.this$0;
            Object object2 = object.getElement();
            n10 = immutableMultiset.count(object2);
            if (n10 == (n11 = object.getCount())) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public Multiset$Entry get(int n10) {
        return this.this$0.getEntry(n10);
    }

    public int hashCode() {
        return this.this$0.hashCode();
    }

    public boolean isPartialView() {
        return this.this$0.isPartialView();
    }

    public int size() {
        return this.this$0.elementSet().size();
    }

    public Object writeReplace() {
        ImmutableMultiset immutableMultiset = this.this$0;
        ImmutableMultiset$EntrySetSerializedForm immutableMultiset$EntrySetSerializedForm = new ImmutableMultiset$EntrySetSerializedForm(immutableMultiset);
        return immutableMultiset$EntrySetSerializedForm;
    }
}

