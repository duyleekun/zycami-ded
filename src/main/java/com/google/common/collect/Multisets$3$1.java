/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$3;
import java.util.Iterator;

public class Multisets$3$1
extends AbstractIterator {
    public final /* synthetic */ Multisets$3 this$0;
    public final /* synthetic */ Iterator val$iterator1;
    public final /* synthetic */ Iterator val$iterator2;

    public Multisets$3$1(Multisets$3 multisets$3, Iterator iterator2, Iterator iterator3) {
        this.this$0 = multisets$3;
        this.val$iterator1 = iterator2;
        this.val$iterator2 = iterator3;
    }

    public Multiset$Entry computeNext() {
        Object object = this.val$iterator1;
        int n10 = object.hasNext();
        if (n10 != 0) {
            object = (Multiset$Entry)this.val$iterator1.next();
            Object object2 = object.getElement();
            n10 = object.getCount();
            int n11 = this.this$0.val$multiset2.count(object2);
            return Multisets.immutableEntry(object2, n10 += n11);
        }
        while ((n10 = (object = this.val$iterator2).hasNext()) != 0) {
            Multiset multiset = this.this$0.val$multiset1;
            object = (Multiset$Entry)this.val$iterator2.next();
            Object object3 = object.getElement();
            boolean bl2 = multiset.contains(object3);
            if (bl2) continue;
            n10 = object.getCount();
            return Multisets.immutableEntry(object3, n10);
        }
        return (Multiset$Entry)this.endOfData();
    }
}

