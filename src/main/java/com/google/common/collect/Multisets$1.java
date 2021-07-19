/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$1$1;
import com.google.common.collect.Multisets$ViewMultiset;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Set;

public final class Multisets$1
extends Multisets$ViewMultiset {
    public final /* synthetic */ Multiset val$multiset1;
    public final /* synthetic */ Multiset val$multiset2;

    public Multisets$1(Multiset multiset, Multiset multiset2) {
        this.val$multiset1 = multiset;
        this.val$multiset2 = multiset2;
        super(null);
    }

    public boolean contains(Object object) {
        boolean bl2;
        Multiset multiset = this.val$multiset1;
        boolean bl3 = multiset.contains(object);
        if (!bl3 && !(bl2 = (multiset = this.val$multiset2).contains(object))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public int count(Object object) {
        int n10 = this.val$multiset1.count(object);
        int n11 = this.val$multiset2.count(object);
        return Math.max(n10, n11);
    }

    public Set createElementSet() {
        Set set = this.val$multiset1.elementSet();
        Set set2 = this.val$multiset2.elementSet();
        return Sets.union(set, set2);
    }

    public Iterator elementIterator() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public Iterator entryIterator() {
        Iterator iterator2 = this.val$multiset1.entrySet().iterator();
        Iterator iterator3 = this.val$multiset2.entrySet().iterator();
        Multisets$1$1 multisets$1$1 = new Multisets$1$1(this, iterator2, iterator3);
        return multisets$1$1;
    }

    public boolean isEmpty() {
        Multiset multiset = this.val$multiset1;
        boolean bl2 = multiset.isEmpty();
        if (bl2 && (bl2 = (multiset = this.val$multiset2).isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            multiset = null;
        }
        return bl2;
    }
}

