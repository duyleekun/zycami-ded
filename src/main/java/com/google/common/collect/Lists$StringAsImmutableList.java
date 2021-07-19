/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public final class Lists$StringAsImmutableList
extends ImmutableList {
    private final String string;

    public Lists$StringAsImmutableList(String string2) {
        this.string = string2;
    }

    public Character get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        return Character.valueOf(this.string.charAt(n10));
    }

    public int indexOf(Object object) {
        int n10;
        boolean bl2 = object instanceof Character;
        if (bl2) {
            String string2 = this.string;
            object = (Character)object;
            n10 = ((Character)object).charValue();
            n10 = string2.indexOf(n10);
        } else {
            n10 = -1;
        }
        return n10;
    }

    public boolean isPartialView() {
        return false;
    }

    public int lastIndexOf(Object object) {
        int n10;
        boolean bl2 = object instanceof Character;
        if (bl2) {
            String string2 = this.string;
            object = (Character)object;
            n10 = ((Character)object).charValue();
            n10 = string2.lastIndexOf(n10);
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int size() {
        return this.string.length();
    }

    public ImmutableList subList(int n10, int n11) {
        int n12 = this.size();
        Preconditions.checkPositionIndexes(n10, n11, n12);
        return Lists.charactersOf(this.string.substring(n10, n11));
    }
}

