/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableMultimap$KeysSerializedForm;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Map;

public class ImmutableMultimap$Keys
extends ImmutableMultiset {
    public final /* synthetic */ ImmutableMultimap this$0;

    public ImmutableMultimap$Keys(ImmutableMultimap immutableMultimap) {
        this.this$0 = immutableMultimap;
    }

    public boolean contains(Object object) {
        return this.this$0.containsKey(object);
    }

    public int count(Object object) {
        int n10;
        ImmutableMap immutableMap = this.this$0.map;
        if ((object = (Collection)immutableMap.get(object)) == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.size();
        }
        return n10;
    }

    public ImmutableSet elementSet() {
        return this.this$0.keySet();
    }

    public Multiset$Entry getEntry(int n10) {
        Map.Entry entry = (Map.Entry)this.this$0.map.entrySet().asList().get(n10);
        Object k10 = entry.getKey();
        n10 = ((Collection)entry.getValue()).size();
        return Multisets.immutableEntry(k10, n10);
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.this$0.size();
    }

    public Object writeReplace() {
        ImmutableMultimap immutableMultimap = this.this$0;
        ImmutableMultimap$KeysSerializedForm immutableMultimap$KeysSerializedForm = new ImmutableMultimap$KeysSerializedForm(immutableMultimap);
        return immutableMultimap$KeysSerializedForm;
    }
}

