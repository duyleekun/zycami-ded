/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.AbstractList;

public final class Lists$CharSequenceAsList
extends AbstractList {
    private final CharSequence sequence;

    public Lists$CharSequenceAsList(CharSequence charSequence) {
        this.sequence = charSequence;
    }

    public Character get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        return Character.valueOf(this.sequence.charAt(n10));
    }

    public int size() {
        return this.sequence.length();
    }
}

