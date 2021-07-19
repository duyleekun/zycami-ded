/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

public class NvsMultiThumbnailSequenceView$ThumbnailId
implements Comparable {
    public int m_seqIndex;
    public long m_timestamp;

    public NvsMultiThumbnailSequenceView$ThumbnailId(int n10, long l10) {
        this.m_seqIndex = n10;
        this.m_timestamp = l10;
    }

    public int compareTo(NvsMultiThumbnailSequenceView$ThumbnailId nvsMultiThumbnailSequenceView$ThumbnailId) {
        int n10 = this.m_seqIndex;
        int n11 = nvsMultiThumbnailSequenceView$ThumbnailId.m_seqIndex;
        int n12 = -1;
        if (n10 < n11) {
            return n12;
        }
        int n13 = 1;
        if (n10 > n11) {
            return n13;
        }
        long l10 = this.m_timestamp;
        long l11 = nvsMultiThumbnailSequenceView$ThumbnailId.m_timestamp;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            return n12;
        }
        object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object > 0) {
            return n13;
        }
        return 0;
    }
}

