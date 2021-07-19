/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Multisets$1;
import java.util.Iterator;

public abstract class Multisets$ViewMultiset
extends AbstractMultiset {
    private Multisets$ViewMultiset() {
    }

    public /* synthetic */ Multisets$ViewMultiset(Multisets$1 multisets$1) {
        this();
    }

    public void clear() {
        this.elementSet().clear();
    }

    public int distinctElements() {
        return this.elementSet().size();
    }

    public Iterator iterator() {
        return Multisets.iteratorImpl(this);
    }

    public int size() {
        return Multisets.linearTimeSizeImpl(this);
    }
}

