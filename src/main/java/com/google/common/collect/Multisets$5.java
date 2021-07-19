/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;

public final class Multisets$5
extends TransformedIterator {
    public Multisets$5(Iterator iterator2) {
        super(iterator2);
    }

    public Object transform(Multiset$Entry multiset$Entry) {
        return multiset$Entry.getElement();
    }
}

