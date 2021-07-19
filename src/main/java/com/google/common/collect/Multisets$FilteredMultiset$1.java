/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$FilteredMultiset;

public class Multisets$FilteredMultiset$1
implements Predicate {
    public final /* synthetic */ Multisets$FilteredMultiset this$0;

    public Multisets$FilteredMultiset$1(Multisets$FilteredMultiset multisets$FilteredMultiset) {
        this.this$0 = multisets$FilteredMultiset;
    }

    public boolean apply(Multiset$Entry object) {
        Predicate predicate = this.this$0.predicate;
        object = object.getElement();
        return predicate.apply(object);
    }
}

