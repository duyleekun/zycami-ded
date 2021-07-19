/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets$5$1;
import com.google.common.collect.Sets$5$1$1$1;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.BitSet;
import java.util.Iterator;

public class Sets$5$1$1
extends AbstractSet {
    public final /* synthetic */ Sets$5$1 this$1;
    public final /* synthetic */ BitSet val$copy;

    public Sets$5$1$1(Sets$5$1 var1_1, BitSet bitSet) {
        this.this$1 = var1_1;
        this.val$copy = bitSet;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean contains(Object object) {
        Serializable serializable = this.this$1.this$0.val$index;
        if ((object = (Integer)((ImmutableMap)serializable).get(object)) == null) return 0 != 0;
        serializable = this.val$copy;
        int n10 = (Integer)object;
        if ((n10 = (int)(((BitSet)serializable).get(n10) ? 1 : 0)) == 0) return 0 != 0;
        return 1 != 0;
    }

    public Iterator iterator() {
        Sets$5$1$1$1 sets$5$1$1$1 = new Sets$5$1$1$1(this);
        return sets$5$1$1$1;
    }

    public int size() {
        return this.this$1.this$0.val$size;
    }
}

