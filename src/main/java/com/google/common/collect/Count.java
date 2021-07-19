/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import java.io.Serializable;

public final class Count
implements Serializable {
    private int value;

    public Count(int n10) {
        this.value = n10;
    }

    public void add(int n10) {
        int n11;
        this.value = n11 = this.value + n10;
    }

    public int addAndGet(int n10) {
        int n11;
        this.value = n11 = this.value + n10;
        return n11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        int n10 = object instanceof Count;
        if (n10 == 0) return 0 != 0;
        object = (Count)object;
        int n11 = ((Count)object).value;
        n10 = this.value;
        if (n11 != n10) return 0 != 0;
        return 1 != 0;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int n10) {
        int n11 = this.value;
        this.value = n10;
        return n11;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int n10) {
        this.value = n10;
    }

    public String toString() {
        return Integer.toString(this.value);
    }
}

