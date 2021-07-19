/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import java.util.AbstractList;

public final class Joiner$3
extends AbstractList {
    public final /* synthetic */ Object val$first;
    public final /* synthetic */ Object[] val$rest;
    public final /* synthetic */ Object val$second;

    public Joiner$3(Object[] objectArray, Object object, Object object2) {
        this.val$rest = objectArray;
        this.val$first = object;
        this.val$second = object2;
    }

    public Object get(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                Object[] objectArray = this.val$rest;
                return objectArray[n10 += -2];
            }
            return this.val$second;
        }
        return this.val$first;
    }

    public int size() {
        return this.val$rest.length + 2;
    }
}

