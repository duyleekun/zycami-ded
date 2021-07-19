/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.AbstractHashFunction;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.common.hash.SipHashFunction$SipHasher;
import java.io.Serializable;

public final class SipHashFunction
extends AbstractHashFunction
implements Serializable {
    public static final HashFunction SIP_HASH_24;
    private static final long serialVersionUID;
    private final int c;
    private final int d;
    private final long k0;
    private final long k1;

    static {
        SipHashFunction sipHashFunction = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
        SIP_HASH_24 = sipHashFunction;
    }

    public SipHashFunction(int n10, int n11, long l10, long l11) {
        boolean bl2 = true;
        boolean bl3 = n10 > 0 ? bl2 : false;
        String string2 = "The number of SipRound iterations (c=%s) during Compression must be positive.";
        Preconditions.checkArgument(bl3, string2, n10);
        if (n11 <= 0) {
            bl2 = false;
        }
        Preconditions.checkArgument(bl2, "The number of SipRound iterations (d=%s) during Finalization must be positive.", n11);
        this.c = n10;
        this.d = n11;
        this.k0 = l10;
        this.k1 = l11;
    }

    public int bits() {
        return 64;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof SipHashFunction;
        boolean bl2 = false;
        if (n10 != 0) {
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            object = (SipHashFunction)object;
            n10 = this.c;
            int n11 = ((SipHashFunction)object).c;
            if (n10 == n11 && (n10 = this.d) == (n11 = ((SipHashFunction)object).d) && (n10 = (int)((l14 = (l13 = this.k0) - (l12 = ((SipHashFunction)object).k0)) == 0L ? 0 : (l14 < 0L ? -1 : 1))) == 0 && (l11 = (l10 = (l13 = this.k1) - (l12 = ((SipHashFunction)object).k1)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = SipHashFunction.class.hashCode();
        int n11 = this.c;
        n10 ^= n11;
        n11 = this.d;
        long l10 = n10 ^ n11;
        long l11 = this.k0;
        l10 ^= l11;
        l11 = this.k1;
        return (int)(l10 ^ l11);
    }

    public Hasher newHasher() {
        int n10 = this.c;
        int n11 = this.d;
        long l10 = this.k0;
        long l11 = this.k1;
        SipHashFunction$SipHasher sipHashFunction$SipHasher = new SipHashFunction$SipHasher(n10, n11, l10, l11);
        return sipHashFunction$SipHasher;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hashing.sipHash");
        int n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append("");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append("(");
        long l10 = this.k0;
        stringBuilder.append(l10);
        stringBuilder.append(", ");
        l10 = this.k1;
        stringBuilder.append(l10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

