/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableMap$EntrySet;
import java.util.AbstractMap;
import java.util.Map;

public class RegularImmutableMap$EntrySet$1
extends ImmutableList {
    public final /* synthetic */ RegularImmutableMap$EntrySet this$0;

    public RegularImmutableMap$EntrySet$1(RegularImmutableMap$EntrySet regularImmutableMap$EntrySet) {
        this.this$0 = regularImmutableMap$EntrySet;
    }

    public Map.Entry get(int n10) {
        int n11 = RegularImmutableMap$EntrySet.access$000(this.this$0);
        Preconditions.checkElementIndex(n10, n11);
        Object object = RegularImmutableMap$EntrySet.access$100(this.this$0);
        int n12 = RegularImmutableMap$EntrySet.access$200(this.this$0) + (n10 *= 2);
        object = object[n12];
        Object object2 = RegularImmutableMap$EntrySet.access$100(this.this$0);
        int n13 = RegularImmutableMap$EntrySet.access$200(this.this$0) ^ 1;
        Object object3 = object2[n10 += n13];
        object2 = new AbstractMap.SimpleImmutableEntry(object, object3);
        return object2;
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return RegularImmutableMap$EntrySet.access$000(this.this$0);
    }
}

