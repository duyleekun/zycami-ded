/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.util.Util;

public final class ExoPlayerImplInternal$PendingMessageInfo
implements Comparable {
    public final PlayerMessage message;
    public int resolvedPeriodIndex;
    public long resolvedPeriodTimeUs;
    public Object resolvedPeriodUid;

    public ExoPlayerImplInternal$PendingMessageInfo(PlayerMessage playerMessage) {
        this.message = playerMessage;
    }

    public int compareTo(ExoPlayerImplInternal$PendingMessageInfo exoPlayerImplInternal$PendingMessageInfo) {
        int n10;
        Object object = this.resolvedPeriodUid;
        int n11 = 1;
        int n12 = object == null ? n11 : 0;
        Object object2 = exoPlayerImplInternal$PendingMessageInfo.resolvedPeriodUid;
        if (object2 == null) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n12 != n10) {
            if (object != null) {
                n11 = -1;
            }
            return n11;
        }
        if (object == null) {
            return 0;
        }
        int n13 = this.resolvedPeriodIndex;
        n11 = exoPlayerImplInternal$PendingMessageInfo.resolvedPeriodIndex;
        if ((n13 -= n11) != 0) {
            return n13;
        }
        long l10 = this.resolvedPeriodTimeUs;
        long l11 = exoPlayerImplInternal$PendingMessageInfo.resolvedPeriodTimeUs;
        return Util.compareLong(l10, l11);
    }

    public void setResolvedPosition(int n10, long l10, Object object) {
        this.resolvedPeriodIndex = n10;
        this.resolvedPeriodTimeUs = l10;
        this.resolvedPeriodUid = object;
    }
}

