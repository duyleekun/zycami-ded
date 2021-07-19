/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.Renderer$WakeupListener;

public class ExoPlayerImplInternal$1
implements Renderer$WakeupListener {
    public final /* synthetic */ ExoPlayerImplInternal this$0;

    public ExoPlayerImplInternal$1(ExoPlayerImplInternal exoPlayerImplInternal) {
        this.this$0 = exoPlayerImplInternal;
    }

    public void onSleep(long l10) {
        long l11 = 2000L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            ExoPlayerImplInternal exoPlayerImplInternal = this.this$0;
            boolean bl2 = true;
            ExoPlayerImplInternal.access$602(exoPlayerImplInternal, bl2);
        }
    }

    public void onWakeup() {
        ExoPlayerImplInternal.access$700(this.this$0).sendEmptyMessage(2);
    }
}

