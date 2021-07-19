/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$4$1;
import com.google.common.collect.Multisets$4$2;
import com.google.common.collect.Multisets$ViewMultiset;
import java.util.Iterator;

public final class Multisets$4
extends Multisets$ViewMultiset {
    public final /* synthetic */ Multiset val$multiset1;
    public final /* synthetic */ Multiset val$multiset2;

    public Multisets$4(Multiset multiset, Multiset multiset2) {
        this.val$multiset1 = multiset;
        this.val$multiset2 = multiset2;
        super(null);
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public int count(Object object) {
        Multiset multiset = this.val$multiset1;
        int n10 = multiset.count(object);
        int n11 = 0;
        if (n10 != 0) {
            Multiset multiset2 = this.val$multiset2;
            int n12 = multiset2.count(object);
            n11 = Math.max(0, n10 -= n12);
        }
        return n11;
    }

    public int distinctElements() {
        return Iterators.size(this.entryIterator());
    }

    public Iterator elementIterator() {
        Iterator iterator2 = this.val$multiset1.entrySet().iterator();
        Multisets$4$1 multisets$4$1 = new Multisets$4$1(this, iterator2);
        return multisets$4$1;
    }

    public Iterator entryIterator() {
        Iterator iterator2 = this.val$multiset1.entrySet().iterator();
        Multisets$4$2 multisets$4$2 = new Multisets$4$2(this, iterator2);
        return multisets$4$2;
    }
}

