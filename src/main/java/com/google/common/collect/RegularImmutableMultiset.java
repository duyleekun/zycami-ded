/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.ObjectCountHashMap;
import com.google.common.collect.RegularImmutableMultiset$ElementSet;
import com.google.common.collect.RegularImmutableMultiset$SerializedForm;
import com.google.common.primitives.Ints;

public class RegularImmutableMultiset
extends ImmutableMultiset {
    public static final RegularImmutableMultiset EMPTY;
    public final transient ObjectCountHashMap contents;
    private transient ImmutableSet elementSet;
    private final transient int size;

    static {
        RegularImmutableMultiset regularImmutableMultiset;
        ObjectCountHashMap objectCountHashMap = ObjectCountHashMap.create();
        EMPTY = regularImmutableMultiset = new RegularImmutableMultiset(objectCountHashMap);
    }

    public RegularImmutableMultiset(ObjectCountHashMap objectCountHashMap) {
        int n10;
        int n11;
        this.contents = objectCountHashMap;
        long l10 = 0L;
        for (int i10 = 0; i10 < (n11 = objectCountHashMap.size()); ++i10) {
            n11 = objectCountHashMap.getValue(i10);
            long l11 = n11;
            l10 += l11;
        }
        this.size = n10 = Ints.saturatedCast(l10);
    }

    public int count(Object object) {
        return this.contents.get(object);
    }

    public ImmutableSet elementSet() {
        ImmutableSet immutableSet = this.elementSet;
        if (immutableSet == null) {
            this.elementSet = immutableSet = new RegularImmutableMultiset$ElementSet(this, null);
        }
        return immutableSet;
    }

    public Multiset$Entry getEntry(int n10) {
        return this.contents.getEntry(n10);
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.size;
    }

    public Object writeReplace() {
        RegularImmutableMultiset$SerializedForm regularImmutableMultiset$SerializedForm = new RegularImmutableMultiset$SerializedForm(this);
        return regularImmutableMultiset$SerializedForm;
    }
}

