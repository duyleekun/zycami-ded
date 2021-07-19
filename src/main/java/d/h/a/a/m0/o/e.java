/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.o;

import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper$Callback;

public final class e
implements Runnable {
    public final /* synthetic */ HlsSampleStreamWrapper$Callback a;

    public /* synthetic */ e(HlsSampleStreamWrapper$Callback callback) {
        this.a = callback;
    }

    public final void run() {
        this.a.onPrepared();
    }
}

