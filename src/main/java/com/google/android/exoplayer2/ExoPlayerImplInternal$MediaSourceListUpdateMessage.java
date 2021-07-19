/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayerImplInternal$1;
import com.google.android.exoplayer2.source.ShuffleOrder;
import java.util.List;

public final class ExoPlayerImplInternal$MediaSourceListUpdateMessage {
    private final List mediaSourceHolders;
    private final long positionUs;
    private final ShuffleOrder shuffleOrder;
    private final int windowIndex;

    private ExoPlayerImplInternal$MediaSourceListUpdateMessage(List list, ShuffleOrder shuffleOrder, int n10, long l10) {
        this.mediaSourceHolders = list;
        this.shuffleOrder = shuffleOrder;
        this.windowIndex = n10;
        this.positionUs = l10;
    }

    public /* synthetic */ ExoPlayerImplInternal$MediaSourceListUpdateMessage(List list, ShuffleOrder shuffleOrder, int n10, long l10, ExoPlayerImplInternal.1 var6_5) {
        this(list, shuffleOrder, n10, l10);
    }

    public static /* synthetic */ int access$200(ExoPlayerImplInternal$MediaSourceListUpdateMessage exoPlayerImplInternal$MediaSourceListUpdateMessage) {
        return exoPlayerImplInternal$MediaSourceListUpdateMessage.windowIndex;
    }

    public static /* synthetic */ List access$300(ExoPlayerImplInternal$MediaSourceListUpdateMessage exoPlayerImplInternal$MediaSourceListUpdateMessage) {
        return exoPlayerImplInternal$MediaSourceListUpdateMessage.mediaSourceHolders;
    }

    public static /* synthetic */ ShuffleOrder access$400(ExoPlayerImplInternal$MediaSourceListUpdateMessage exoPlayerImplInternal$MediaSourceListUpdateMessage) {
        return exoPlayerImplInternal$MediaSourceListUpdateMessage.shuffleOrder;
    }

    public static /* synthetic */ long access$500(ExoPlayerImplInternal$MediaSourceListUpdateMessage exoPlayerImplInternal$MediaSourceListUpdateMessage) {
        return exoPlayerImplInternal$MediaSourceListUpdateMessage.positionUs;
    }
}

