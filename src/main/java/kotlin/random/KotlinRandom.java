/*
 * Decompiled with CFR 0.151.
 */
package kotlin.random;

import f.h2.t.f0;
import f.k2.e;
import java.util.Random;

public final class KotlinRandom
extends Random {
    private final e impl;
    private boolean seedInitialized;

    public KotlinRandom(e e10) {
        f0.p(e10, "impl");
        this.impl = e10;
    }

    public final e getImpl() {
        return this.impl;
    }

    public int next(int n10) {
        return this.impl.b(n10);
    }

    public boolean nextBoolean() {
        return this.impl.c();
    }

    public void nextBytes(byte[] byArray) {
        f0.p(byArray, "bytes");
        this.impl.e(byArray);
    }

    public double nextDouble() {
        return this.impl.h();
    }

    public float nextFloat() {
        return this.impl.k();
    }

    public int nextInt() {
        return this.impl.l();
    }

    public int nextInt(int n10) {
        return this.impl.m(n10);
    }

    public long nextLong() {
        return this.impl.o();
    }

    public void setSeed(long l10) {
        boolean bl2 = this.seedInitialized;
        if (!bl2) {
            this.seedInitialized = true;
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Setting seed is not supported.");
        throw unsupportedOperationException;
    }
}

