/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

public interface ShuffleOrder {
    public ShuffleOrder cloneAndClear();

    public ShuffleOrder cloneAndInsert(int var1, int var2);

    public ShuffleOrder cloneAndRemove(int var1, int var2);

    public int getFirstIndex();

    public int getLastIndex();

    public int getLength();

    public int getNextIndex(int var1);

    public int getPreviousIndex(int var1);
}

