/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$FilteredMultiset$1;
import com.google.common.collect.Multisets$ViewMultiset;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import java.util.Set;

public final class Multisets$FilteredMultiset
extends Multisets$ViewMultiset {
    public final Predicate predicate;
    public final Multiset unfiltered;

    public Multisets$FilteredMultiset(Multiset object, Predicate predicate) {
        super(null);
        object = (Multiset)Preconditions.checkNotNull(object);
        this.unfiltered = object;
        this.predicate = object = (Predicate)Preconditions.checkNotNull(predicate);
    }

    public int add(Object object, int n10) {
        boolean bl2 = this.predicate.apply(object);
        Predicate predicate = this.predicate;
        Preconditions.checkArgument(bl2, "Element %s does not match predicate %s", object, (Object)predicate);
        return this.unfiltered.add(object, n10);
    }

    public int count(Object object) {
        Multiset multiset = this.unfiltered;
        int n10 = multiset.count(object);
        if (n10 > 0) {
            Predicate predicate = this.predicate;
            boolean bl2 = predicate.apply(object);
            if (!bl2) {
                n10 = 0;
                multiset = null;
            }
            return n10;
        }
        return 0;
    }

    public Set createElementSet() {
        Set set = this.unfiltered.elementSet();
        Predicate predicate = this.predicate;
        return Sets.filter(set, predicate);
    }

    public Set createEntrySet() {
        Set set = this.unfiltered.entrySet();
        Multisets$FilteredMultiset$1 multisets$FilteredMultiset$1 = new Multisets$FilteredMultiset$1(this);
        return Sets.filter(set, (Predicate)multisets$FilteredMultiset$1);
    }

    public Iterator elementIterator() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public Iterator entryIterator() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public UnmodifiableIterator iterator() {
        Iterator iterator2 = this.unfiltered.iterator();
        Predicate predicate = this.predicate;
        return Iterators.filter(iterator2, predicate);
    }

    public int remove(Object object, int n10) {
        int n11;
        Object object2 = "occurrences";
        CollectPreconditions.checkNonnegative(n10, (String)object2);
        if (n10 == 0) {
            return this.count(object);
        }
        boolean bl2 = this.contains(object);
        if (bl2) {
            object2 = this.unfiltered;
            n11 = object2.remove(object, n10);
        } else {
            n11 = 0;
            object = null;
        }
        return n11;
    }
}

