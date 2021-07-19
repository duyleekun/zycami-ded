/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import java.io.IOException;

public final class d
implements Runnable {
    public final /* synthetic */ MediaSourceEventListener$EventDispatcher a;
    public final /* synthetic */ MediaSourceEventListener b;
    public final /* synthetic */ LoadEventInfo c;
    public final /* synthetic */ MediaLoadData d;
    public final /* synthetic */ IOException e;
    public final /* synthetic */ boolean f;

    public /* synthetic */ d(MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher, MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
        this.a = mediaSourceEventListener$EventDispatcher;
        this.b = mediaSourceEventListener;
        this.c = loadEventInfo;
        this.d = mediaLoadData;
        this.e = iOException;
        this.f = bl2;
    }

    public final void run() {
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.a;
        MediaSourceEventListener mediaSourceEventListener = this.b;
        LoadEventInfo loadEventInfo = this.c;
        MediaLoadData mediaLoadData = this.d;
        IOException iOException = this.e;
        boolean bl2 = this.f;
        mediaSourceEventListener$EventDispatcher.h(mediaSourceEventListener, loadEventInfo, mediaLoadData, iOException, bl2);
    }
}

