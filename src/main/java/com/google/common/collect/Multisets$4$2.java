/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$4;
import java.util.Iterator;

public class Multisets$4$2
extends AbstractIterator {
    public final /* synthetic */ Multisets$4 this$0;
    public final /* synthetic */ Iterator val$iterator1;

    public Multisets$4$2(Multisets$4 multisets$4, Iterator iterator2) {
        this.this$0 = multisets$4;
        this.val$iterator1 = iterator2;
    }

    public Multiset$Entry computeNext() {
        Object object;
        int n10;
        while ((n10 = (object = this.val$iterator1).hasNext()) != 0) {
            object = (Multiset$Entry)this.val$iterator1.next();
            Object object2 = object.getElement();
            n10 = object.getCount();
            Multiset multiset = this.this$0.val$multiset2;
            int n11 = multiset.count(object2);
            if ((n10 -= n11) <= 0) continue;
            return Multisets.immutableEntry(object2, n10);
        }
        return (Multiset$Entry)this.endOfData();
    }
}

