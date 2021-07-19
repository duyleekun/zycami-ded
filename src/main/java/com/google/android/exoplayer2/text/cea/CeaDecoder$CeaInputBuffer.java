/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.text.cea;

import com.google.android.exoplayer2.text.SubtitleInputBuffer;
import com.google.android.exoplayer2.text.cea.CeaDecoder$1;

public final class CeaDecoder$CeaInputBuffer
extends SubtitleInputBuffer
implements Comparable {
    private long queuedInputBufferCount;

    private CeaDecoder$CeaInputBuffer() {
    }

    public /* synthetic */ CeaDecoder$CeaInputBuffer(CeaDecoder$1 ceaDecoder$1) {
        this();
    }

    public static /* synthetic */ long access$102(CeaDecoder$CeaInputBuffer ceaDecoder$CeaInputBuffer, long l10) {
        ceaDecoder$CeaInputBuffer.queuedInputBufferCount = l10;
        return l10;
    }

    public int compareTo(CeaDecoder$CeaInputBuffer ceaDecoder$CeaInputBuffer) {
        Object object;
        boolean bl2 = this.isEndOfStream();
        boolean bl3 = ceaDecoder$CeaInputBuffer.isEndOfStream();
        int n10 = 1;
        int n11 = -1;
        if (bl2 != bl3) {
            boolean bl4 = this.isEndOfStream();
            if (!bl4) {
                n10 = n11;
            }
            return n10;
        }
        long l10 = this.timeUs;
        long l11 = ceaDecoder$CeaInputBuffer.timeUs;
        long l12 = (l10 -= l11) - (l11 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            l10 = this.queuedInputBufferCount;
            long l13 = ceaDecoder$CeaInputBuffer.queuedInputBufferCount;
            long l14 = (l10 -= l13) - l11;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object == false) {
                return 0;
            }
        }
        if ((object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) <= 0) {
            n10 = n11;
        }
        return n10;
    }
}

