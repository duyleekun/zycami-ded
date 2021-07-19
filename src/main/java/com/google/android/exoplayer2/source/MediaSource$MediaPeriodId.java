/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.MediaPeriodId;

public final class MediaSource$MediaPeriodId
extends MediaPeriodId {
    public MediaSource$MediaPeriodId(MediaPeriodId mediaPeriodId) {
        super(mediaPeriodId);
    }

    public MediaSource$MediaPeriodId(Object object) {
        super(object);
    }

    public MediaSource$MediaPeriodId(Object object, int n10, int n11, long l10) {
        super(object, n10, n11, l10);
    }

    public MediaSource$MediaPeriodId(Object object, long l10) {
        super(object, l10);
    }

    public MediaSource$MediaPeriodId(Object object, long l10, int n10) {
        super(object, l10, n10);
    }

    public MediaSource$MediaPeriodId copyWithPeriodUid(Object object) {
        object = super.copyWithPeriodUid(object);
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId((MediaPeriodId)object);
        return mediaSource$MediaPeriodId;
    }
}

