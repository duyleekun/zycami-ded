/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

public final class Hashing$LinearCongruentialGenerator {
    private long state;

    public Hashing$LinearCongruentialGenerator(long l10) {
        this.state = l10;
    }

    public double nextDouble() {
        long l10;
        this.state = l10 = this.state * 2862933555777941757L + 1L;
        return (double)((int)(l10 >>> 33) + 1) / 2.147483648E9;
    }
}

