/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Sets$5;
import com.google.common.collect.Sets$5$1$1;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Set;

public class Sets$5$1
extends AbstractIterator {
    public final BitSet bits;
    public final /* synthetic */ Sets$5 this$0;

    public Sets$5$1(Sets$5 sets$5) {
        BitSet bitSet;
        this.this$0 = sets$5;
        int n10 = sets$5.val$index.size();
        this.bits = bitSet = new BitSet(n10);
    }

    public Set computeNext() {
        BitSet bitSet = this.bits;
        int n10 = bitSet.isEmpty();
        Object object = null;
        if (n10 != 0) {
            bitSet = this.bits;
            Sets$5 sets$5 = this.this$0;
            int n11 = sets$5.val$size;
            bitSet.set(0, n11);
        } else {
            Serializable serializable;
            int n12;
            BitSet bitSet2 = this.bits;
            bitSet = this.bits;
            n10 = bitSet.nextSetBit(0);
            int n13 = bitSet2.nextClearBit(n10);
            if (n13 == (n12 = (serializable = this.this$0.val$index).size())) {
                return (Set)this.endOfData();
            }
            serializable = this.bits;
            n10 = n13 - n10 + -1;
            ((BitSet)serializable).set(0, n10);
            object = this.bits;
            ((BitSet)object).clear(n10, n13);
            bitSet = this.bits;
            bitSet.set(n13);
        }
        bitSet = (BitSet)this.bits.clone();
        object = new Sets$5$1$1(this, bitSet);
        return object;
    }
}

