/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource$1;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$PlayerEmsgCallback;

public final class DashMediaSource$DefaultPlayerEmsgCallback
implements PlayerEmsgHandler$PlayerEmsgCallback {
    public final /* synthetic */ DashMediaSource this$0;

    private DashMediaSource$DefaultPlayerEmsgCallback(DashMediaSource dashMediaSource) {
        this.this$0 = dashMediaSource;
    }

    public /* synthetic */ DashMediaSource$DefaultPlayerEmsgCallback(DashMediaSource dashMediaSource, DashMediaSource$1 dashMediaSource$1) {
        this(dashMediaSource);
    }

    public void onDashManifestPublishTimeExpired(long l10) {
        this.this$0.onDashManifestPublishTimeExpired(l10);
    }

    public void onDashManifestRefreshRequested() {
        this.this$0.onDashManifestRefreshRequested();
    }
}

