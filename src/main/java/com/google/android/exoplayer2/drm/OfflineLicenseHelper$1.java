/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.OfflineLicenseHelper;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;

public class OfflineLicenseHelper$1
implements DrmSessionEventListener {
    public final /* synthetic */ OfflineLicenseHelper this$0;

    public OfflineLicenseHelper$1(OfflineLicenseHelper offlineLicenseHelper) {
        this.this$0 = offlineLicenseHelper;
    }

    public void onDrmKeysLoaded(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        OfflineLicenseHelper.access$000(this.this$0).open();
    }

    public void onDrmKeysRemoved(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        OfflineLicenseHelper.access$000(this.this$0).open();
    }

    public void onDrmKeysRestored(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        OfflineLicenseHelper.access$000(this.this$0).open();
    }

    public void onDrmSessionManagerError(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Exception exception) {
        OfflineLicenseHelper.access$000(this.this$0).open();
    }
}

