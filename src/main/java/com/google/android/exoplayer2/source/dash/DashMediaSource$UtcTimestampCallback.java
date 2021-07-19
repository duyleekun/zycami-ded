/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource$1;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import java.io.IOException;

public final class DashMediaSource$UtcTimestampCallback
implements Loader$Callback {
    public final /* synthetic */ DashMediaSource this$0;

    private DashMediaSource$UtcTimestampCallback(DashMediaSource dashMediaSource) {
        this.this$0 = dashMediaSource;
    }

    public /* synthetic */ DashMediaSource$UtcTimestampCallback(DashMediaSource dashMediaSource, DashMediaSource$1 dashMediaSource$1) {
        this(dashMediaSource);
    }

    public void onLoadCanceled(ParsingLoadable parsingLoadable, long l10, long l11, boolean bl2) {
        this.this$0.onLoadCanceled(parsingLoadable, l10, l11);
    }

    public void onLoadCompleted(ParsingLoadable parsingLoadable, long l10, long l11) {
        this.this$0.onUtcTimestampLoadCompleted(parsingLoadable, l10, l11);
    }

    public Loader$LoadErrorAction onLoadError(ParsingLoadable parsingLoadable, long l10, long l11, IOException iOException, int n10) {
        return this.this$0.onUtcTimestampLoadError(parsingLoadable, l10, l11, iOException);
    }
}

