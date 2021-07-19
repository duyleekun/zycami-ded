/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$2$1;
import com.google.common.collect.Multisets$ViewMultiset;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

public final class Multisets$2
extends Multisets$ViewMultiset {
    public final /* synthetic */ Multiset val$multiset1;
    public final /* synthetic */ Multiset val$multiset2;

    public Multisets$2(Multiset multiset, Multiset multiset2) {
        this.val$multiset1 = multiset;
        this.val$multiset2 = multiset2;
        super(null);
    }

    public int count(Object object) {
        int n10;
        Multiset multiset = this.val$multiset1;
        int n11 = multiset.count(object);
        if (n11 == 0) {
            n10 = 0;
            object = null;
        } else {
            Multiset multiset2 = this.val$multiset2;
            n10 = multiset2.count(object);
            n10 = Math.min(n11, n10);
        }
        return n10;
    }

    public Set createElementSet() {
        Set set = this.val$multiset1.elementSet();
        Set set2 = this.val$multiset2.elementSet();
        return Sets.intersection(set, set2);
    }

    public Iterator elementIterator() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public Iterator entryIterator() {
        Iterator iterator2 = this.val$multiset1.entrySet().iterator();
        Multisets$2$1 multisets$2$1 = new Multisets$2$1(this, iterator2);
        return multisets$2$1;
    }
}

