/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0;

import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;

public final class f
implements Runnable {
    public final /* synthetic */ MediaSourceEventListener$EventDispatcher a;
    public final /* synthetic */ MediaSourceEventListener b;
    public final /* synthetic */ MediaLoadData c;

    public /* synthetic */ f(MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
        this.a = mediaSourceEventListener$EventDispatcher;
        this.b = mediaSourceEventListener;
        this.c = mediaLoadData;
    }

    public final void run() {
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.a;
        MediaSourceEventListener mediaSourceEventListener = this.b;
        MediaLoadData mediaLoadData = this.c;
        mediaSourceEventListener$EventDispatcher.b(mediaSourceEventListener, mediaLoadData);
    }
}

