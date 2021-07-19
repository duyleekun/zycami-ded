/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import java.io.IOException;

public final class DashMediaSource$ManifestLoadErrorThrower
implements LoaderErrorThrower {
    public final /* synthetic */ DashMediaSource this$0;

    public DashMediaSource$ManifestLoadErrorThrower(DashMediaSource dashMediaSource) {
        this.this$0 = dashMediaSource;
    }

    private void maybeThrowManifestError() {
        IOException iOException = DashMediaSource.access$800(this.this$0);
        if (iOException == null) {
            return;
        }
        throw DashMediaSource.access$800(this.this$0);
    }

    public void maybeThrowError() {
        DashMediaSource.access$700(this.this$0).maybeThrowError();
        this.maybeThrowManifestError();
    }

    public void maybeThrowError(int n10) {
        DashMediaSource.access$700(this.this$0).maybeThrowError(n10);
        this.maybeThrowManifestError();
    }
}

