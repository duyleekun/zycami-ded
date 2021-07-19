/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Striped;

public abstract class Striped$PowerOfTwoStriped
extends Striped {
    public final int mask;

    public Striped$PowerOfTwoStriped(int n10) {
        super(null);
        int n11 = 1;
        int n12 = n10 > 0 ? n11 : 0;
        String string2 = "Stripes must be positive";
        Preconditions.checkArgument(n12 != 0, string2);
        n12 = 0x40000000;
        n10 = n10 > n12 ? -1 : Striped.access$200(n10) - n11;
        this.mask = n10;
    }

    public final Object get(Object object) {
        int n10 = this.indexFor(object);
        return this.getAt(n10);
    }

    public final int indexFor(Object object) {
        int n10 = Striped.access$300(object.hashCode());
        int n11 = this.mask;
        return n10 & n11;
    }
}

