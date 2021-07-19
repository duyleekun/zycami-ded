/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Sets$5$1$1;
import java.io.Serializable;
import java.util.BitSet;

public class Sets$5$1$1$1
extends AbstractIterator {
    public int i = -1;
    public final /* synthetic */ Sets$5$1$1 this$2;

    public Sets$5$1$1$1(Sets$5$1$1 sets$5$1$1) {
        this.this$2 = sets$5$1$1;
    }

    public Object computeNext() {
        int n10;
        Serializable serializable = this.this$2.val$copy;
        int n11 = this.i + 1;
        this.i = n10 = ((BitSet)serializable).nextSetBit(n11);
        n11 = -1;
        if (n10 == n11) {
            return this.endOfData();
        }
        serializable = this.this$2.this$1.this$0.val$index.keySet().asList();
        n11 = this.i;
        return serializable.get(n11);
    }
}

