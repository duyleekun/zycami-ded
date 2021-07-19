/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.EnumMultiset;
import com.google.common.collect.EnumMultiset$Itr;

public class EnumMultiset$1
extends EnumMultiset$Itr {
    public final /* synthetic */ EnumMultiset this$0;

    public EnumMultiset$1(EnumMultiset enumMultiset) {
        this.this$0 = enumMultiset;
        super(enumMultiset);
    }

    public Enum output(int n10) {
        return EnumMultiset.access$000(this.this$0)[n10];
    }
}

