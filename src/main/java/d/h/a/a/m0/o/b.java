/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.o;

import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;

public final class b
implements Runnable {
    public final /* synthetic */ HlsSampleStreamWrapper a;

    public /* synthetic */ b(HlsSampleStreamWrapper hlsSampleStreamWrapper) {
        this.a = hlsSampleStreamWrapper;
    }

    public final void run() {
        HlsSampleStreamWrapper.a(this.a);
    }
}

