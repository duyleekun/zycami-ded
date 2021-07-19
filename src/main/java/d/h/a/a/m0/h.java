/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;

public final class h
implements Runnable {
    public final /* synthetic */ MediaSourceEventListener$EventDispatcher a;
    public final /* synthetic */ MediaSourceEventListener b;
    public final /* synthetic */ LoadEventInfo c;
    public final /* synthetic */ MediaLoadData d;

    public /* synthetic */ h(MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.a = mediaSourceEventListener$EventDispatcher;
        this.b = mediaSourceEventListener;
        this.c = loadEventInfo;
        this.d = mediaLoadData;
    }

    public final void run() {
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.a;
        MediaSourceEventListener mediaSourceEventListener = this.b;
        LoadEventInfo loadEventInfo = this.c;
        MediaLoadData mediaLoadData = this.d;
        mediaSourceEventListener$EventDispatcher.d(mediaSourceEventListener, loadEventInfo, mediaLoadData);
    }
}

