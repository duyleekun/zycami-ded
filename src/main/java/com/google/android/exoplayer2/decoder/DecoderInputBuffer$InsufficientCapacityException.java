/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.decoder;

public final class DecoderInputBuffer$InsufficientCapacityException
extends IllegalStateException {
    public final int currentCapacity;
    public final int requiredCapacity;

    public DecoderInputBuffer$InsufficientCapacityException(int n10, int n11) {
        CharSequence charSequence = new StringBuilder(44);
        charSequence.append("Buffer too small (");
        charSequence.append(n10);
        charSequence.append(" < ");
        charSequence.append(n11);
        charSequence.append(")");
        charSequence = charSequence.toString();
        super((String)charSequence);
        this.currentCapacity = n10;
        this.requiredCapacity = n11;
    }
}

