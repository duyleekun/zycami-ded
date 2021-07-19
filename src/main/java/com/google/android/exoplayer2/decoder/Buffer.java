/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.decoder;

public abstract class Buffer {
    private int flags;

    public final void addFlag(int n10) {
        int n11 = this.flags;
        this.flags = n10 |= n11;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void clearFlag(int n10) {
        int n11 = this.flags;
        this.flags = n10 = ~n10 & n11;
    }

    public final boolean getFlag(int n10) {
        int n11 = this.flags & n10;
        n10 = n11 == n10 ? 1 : 0;
        return n10 != 0;
    }

    public final boolean hasSupplementalData() {
        return this.getFlag(0x10000000);
    }

    public final boolean isDecodeOnly() {
        return this.getFlag(-1 << -1);
    }

    public final boolean isEndOfStream() {
        return this.getFlag(4);
    }

    public final boolean isKeyFrame() {
        return this.getFlag(1);
    }

    public final void setFlags(int n10) {
        this.flags = n10;
    }
}

