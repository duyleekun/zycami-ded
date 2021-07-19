/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.util.SntpClient;
import com.google.android.exoplayer2.util.SntpClient$InitializationCallback;
import java.io.IOException;

public class DashMediaSource$1
implements SntpClient$InitializationCallback {
    public final /* synthetic */ DashMediaSource this$0;

    public DashMediaSource$1(DashMediaSource dashMediaSource) {
        this.this$0 = dashMediaSource;
    }

    public void onInitializationFailed(IOException iOException) {
        DashMediaSource.access$600(this.this$0, iOException);
    }

    public void onInitialized() {
        DashMediaSource dashMediaSource = this.this$0;
        long l10 = SntpClient.getElapsedRealtimeOffsetMs();
        DashMediaSource.access$500(dashMediaSource, l10);
    }
}

