/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$4;
import java.util.Iterator;

public class Multisets$4$1
extends AbstractIterator {
    public final /* synthetic */ Multisets$4 this$0;
    public final /* synthetic */ Iterator val$iterator1;

    public Multisets$4$1(Multisets$4 multisets$4, Iterator iterator2) {
        this.this$0 = multisets$4;
        this.val$iterator1 = iterator2;
    }

    public Object computeNext() {
        Object object;
        int n10;
        while ((n10 = (object = this.val$iterator1).hasNext()) != 0) {
            Multiset multiset;
            int n11;
            object = (Multiset$Entry)this.val$iterator1.next();
            Object object2 = object.getElement();
            n10 = object.getCount();
            if (n10 <= (n11 = (multiset = this.this$0.val$multiset2).count(object2))) continue;
            return object2;
        }
        return this.endOfData();
    }
}

