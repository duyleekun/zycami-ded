/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.EnumMultiset;
import com.google.common.collect.EnumMultiset$2$1;
import com.google.common.collect.EnumMultiset$Itr;
import com.google.common.collect.Multiset$Entry;

public class EnumMultiset$2
extends EnumMultiset$Itr {
    public final /* synthetic */ EnumMultiset this$0;

    public EnumMultiset$2(EnumMultiset enumMultiset) {
        this.this$0 = enumMultiset;
        super(enumMultiset);
    }

    public Multiset$Entry output(int n10) {
        EnumMultiset$2$1 enumMultiset$2$1 = new EnumMultiset$2$1(this, n10);
        return enumMultiset$2$1;
    }
}

