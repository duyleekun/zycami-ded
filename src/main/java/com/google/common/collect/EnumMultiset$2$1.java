/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.EnumMultiset;
import com.google.common.collect.EnumMultiset$2;
import com.google.common.collect.Multisets$AbstractEntry;

public class EnumMultiset$2$1
extends Multisets$AbstractEntry {
    public final /* synthetic */ EnumMultiset$2 this$1;
    public final /* synthetic */ int val$index;

    public EnumMultiset$2$1(EnumMultiset$2 enumMultiset$2, int n10) {
        this.this$1 = enumMultiset$2;
        this.val$index = n10;
    }

    public int getCount() {
        int[] nArray = EnumMultiset.access$100(this.this$1.this$0);
        int n10 = this.val$index;
        return nArray[n10];
    }

    public Enum getElement() {
        Enum[] enumArray = EnumMultiset.access$000(this.this$1.this$0);
        int n10 = this.val$index;
        return enumArray[n10];
    }
}

