/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.auth.api.signin.internal;

public class HashAccumulator {
    private static int zaah = 31;
    private int zaai = 1;

    public HashAccumulator addObject(Object object) {
        int n10;
        int n11 = zaah;
        int n12 = this.zaai;
        n11 *= n12;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        this.zaai = n11 += n10;
        return this;
    }

    public int hash() {
        return this.zaai;
    }

    public final HashAccumulator zaa(boolean bl2) {
        int n10 = zaah;
        int n11 = this.zaai;
        this.zaai = n10 = n10 * n11 + bl2;
        return this;
    }
}

