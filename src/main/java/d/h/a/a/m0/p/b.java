/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.p;

import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;

public final class b
implements Runnable {
    public final /* synthetic */ SsMediaSource a;

    public /* synthetic */ b(SsMediaSource ssMediaSource) {
        this.a = ssMediaSource;
    }

    public final void run() {
        SsMediaSource.a(this.a);
    }
}

