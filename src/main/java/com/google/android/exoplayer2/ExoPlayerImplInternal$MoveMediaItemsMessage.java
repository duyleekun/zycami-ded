/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.ShuffleOrder;

public class ExoPlayerImplInternal$MoveMediaItemsMessage {
    public final int fromIndex;
    public final int newFromIndex;
    public final ShuffleOrder shuffleOrder;
    public final int toIndex;

    public ExoPlayerImplInternal$MoveMediaItemsMessage(int n10, int n11, int n12, ShuffleOrder shuffleOrder) {
        this.fromIndex = n10;
        this.toIndex = n11;
        this.newFromIndex = n12;
        this.shuffleOrder = shuffleOrder;
    }
}

