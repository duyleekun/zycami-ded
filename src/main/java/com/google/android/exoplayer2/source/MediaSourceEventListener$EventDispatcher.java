/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher$ListenerAndHandler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.m0.c;
import d.h.a.a.m0.d;
import d.h.a.a.m0.e;
import d.h.a.a.m0.f;
import d.h.a.a.m0.g;
import d.h.a.a.m0.h;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MediaSourceEventListener$EventDispatcher {
    private final CopyOnWriteArrayList listenerAndHandlers;
    public final MediaSource$MediaPeriodId mediaPeriodId;
    private final long mediaTimeOffsetMs;
    public final int windowIndex;

    public MediaSourceEventListener$EventDispatcher() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this(copyOnWriteArrayList, 0, null, 0L);
    }

    private MediaSourceEventListener$EventDispatcher(CopyOnWriteArrayList copyOnWriteArrayList, int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long l10) {
        this.listenerAndHandlers = copyOnWriteArrayList;
        this.windowIndex = n10;
        this.mediaPeriodId = mediaSource$MediaPeriodId;
        this.mediaTimeOffsetMs = l10;
    }

    private /* synthetic */ void a(MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
        int n10 = this.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        mediaSourceEventListener.onDownstreamFormatChanged(n10, mediaSource$MediaPeriodId, mediaLoadData);
    }

    private long adjustMediaTime(long l10) {
        long l11;
        long l12 = (l10 = C.usToMs(l10)) - (l11 = -9223372036854775807L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l11 = this.mediaTimeOffsetMs + l10;
        }
        return l11;
    }

    private /* synthetic */ void c(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        int n10 = this.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        mediaSourceEventListener.onLoadCanceled(n10, mediaSource$MediaPeriodId, loadEventInfo, mediaLoadData);
    }

    private /* synthetic */ void e(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        int n10 = this.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        mediaSourceEventListener.onLoadCompleted(n10, mediaSource$MediaPeriodId, loadEventInfo, mediaLoadData);
    }

    private /* synthetic */ void g(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
        int n10 = this.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        mediaSourceEventListener.onLoadError(n10, mediaSource$MediaPeriodId, loadEventInfo, mediaLoadData, iOException, bl2);
    }

    private /* synthetic */ void i(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        int n10 = this.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        mediaSourceEventListener.onLoadStarted(n10, mediaSource$MediaPeriodId, loadEventInfo, mediaLoadData);
    }

    private /* synthetic */ void k(MediaSourceEventListener mediaSourceEventListener, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, MediaLoadData mediaLoadData) {
        int n10 = this.windowIndex;
        mediaSourceEventListener.onUpstreamDiscarded(n10, mediaSource$MediaPeriodId, mediaLoadData);
    }

    public void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(mediaSourceEventListener);
        CopyOnWriteArrayList copyOnWriteArrayList = this.listenerAndHandlers;
        MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler = new MediaSourceEventListener$EventDispatcher$ListenerAndHandler(handler, mediaSourceEventListener);
        copyOnWriteArrayList.add(mediaSourceEventListener$EventDispatcher$ListenerAndHandler);
    }

    public /* synthetic */ void b(MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
        this.a(mediaSourceEventListener, mediaLoadData);
    }

    public /* synthetic */ void d(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.c(mediaSourceEventListener, loadEventInfo, mediaLoadData);
    }

    public void downstreamFormatChanged(int n10, Format format, int n11, Object object, long l10) {
        long l11 = this.adjustMediaTime(l10);
        MediaLoadData mediaLoadData = new MediaLoadData(1, n10, format, n11, object, l11, -9223372036854775807L);
        this.downstreamFormatChanged(mediaLoadData);
    }

    public void downstreamFormatChanged(MediaLoadData mediaLoadData) {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler = (MediaSourceEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.listener;
            mediaSourceEventListener$EventDispatcher$ListenerAndHandler = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.handler;
            f f10 = new f(this, mediaSourceEventListener, mediaLoadData);
            Util.postOrRun((Handler)mediaSourceEventListener$EventDispatcher$ListenerAndHandler, f10);
        }
    }

    public /* synthetic */ void f(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.e(mediaSourceEventListener, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void h(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
        this.g(mediaSourceEventListener, loadEventInfo, mediaLoadData, iOException, bl2);
    }

    public /* synthetic */ void j(MediaSourceEventListener mediaSourceEventListener, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        this.i(mediaSourceEventListener, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void l(MediaSourceEventListener mediaSourceEventListener, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, MediaLoadData mediaLoadData) {
        this.k(mediaSourceEventListener, mediaSource$MediaPeriodId, mediaLoadData);
    }

    public void loadCanceled(LoadEventInfo loadEventInfo, int n10) {
        this.loadCanceled(loadEventInfo, n10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public void loadCanceled(LoadEventInfo loadEventInfo, int n10, int n11, Format format, int n12, Object object, long l10, long l11) {
        long l12 = this.adjustMediaTime(l10);
        long l13 = this.adjustMediaTime(l11);
        MediaLoadData mediaLoadData = new MediaLoadData(n10, n11, format, n12, object, l12, l13);
        this.loadCanceled(loadEventInfo, mediaLoadData);
    }

    public void loadCanceled(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler = (MediaSourceEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.listener;
            mediaSourceEventListener$EventDispatcher$ListenerAndHandler = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.handler;
            h h10 = new h(this, mediaSourceEventListener, loadEventInfo, mediaLoadData);
            Util.postOrRun((Handler)mediaSourceEventListener$EventDispatcher$ListenerAndHandler, h10);
        }
    }

    public void loadCompleted(LoadEventInfo loadEventInfo, int n10) {
        this.loadCompleted(loadEventInfo, n10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public void loadCompleted(LoadEventInfo loadEventInfo, int n10, int n11, Format format, int n12, Object object, long l10, long l11) {
        long l12 = this.adjustMediaTime(l10);
        long l13 = this.adjustMediaTime(l11);
        MediaLoadData mediaLoadData = new MediaLoadData(n10, n11, format, n12, object, l12, l13);
        this.loadCompleted(loadEventInfo, mediaLoadData);
    }

    public void loadCompleted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler = (MediaSourceEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.listener;
            mediaSourceEventListener$EventDispatcher$ListenerAndHandler = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.handler;
            e e10 = new e(this, mediaSourceEventListener, loadEventInfo, mediaLoadData);
            Util.postOrRun((Handler)mediaSourceEventListener$EventDispatcher$ListenerAndHandler, e10);
        }
    }

    public void loadError(LoadEventInfo loadEventInfo, int n10, int n11, Format format, int n12, Object object, long l10, long l11, IOException iOException, boolean bl2) {
        long l12 = this.adjustMediaTime(l10);
        long l13 = this.adjustMediaTime(l11);
        MediaLoadData mediaLoadData = new MediaLoadData(n10, n11, format, n12, object, l12, l13);
        this.loadError(loadEventInfo, mediaLoadData, iOException, bl2);
    }

    public void loadError(LoadEventInfo loadEventInfo, int n10, IOException iOException, boolean bl2) {
        this.loadError(loadEventInfo, n10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L, iOException, bl2);
    }

    public void loadError(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
        boolean bl3;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl3 = iterator2.hasNext()) {
            MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler = (MediaSourceEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.listener;
            mediaSourceEventListener$EventDispatcher$ListenerAndHandler = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.handler;
            d d10 = new d(this, mediaSourceEventListener, loadEventInfo, mediaLoadData, iOException, bl2);
            Util.postOrRun((Handler)mediaSourceEventListener$EventDispatcher$ListenerAndHandler, d10);
        }
    }

    public void loadStarted(LoadEventInfo loadEventInfo, int n10) {
        this.loadStarted(loadEventInfo, n10, -1, null, 0, null, -9223372036854775807L, -9223372036854775807L);
    }

    public void loadStarted(LoadEventInfo loadEventInfo, int n10, int n11, Format format, int n12, Object object, long l10, long l11) {
        long l12 = this.adjustMediaTime(l10);
        long l13 = this.adjustMediaTime(l11);
        MediaLoadData mediaLoadData = new MediaLoadData(n10, n11, format, n12, object, l12, l13);
        this.loadStarted(loadEventInfo, mediaLoadData);
    }

    public void loadStarted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler = (MediaSourceEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.listener;
            mediaSourceEventListener$EventDispatcher$ListenerAndHandler = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.handler;
            g g10 = new g(this, mediaSourceEventListener, loadEventInfo, mediaLoadData);
            Util.postOrRun((Handler)mediaSourceEventListener$EventDispatcher$ListenerAndHandler, g10);
        }
    }

    public void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler = (MediaSourceEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            Object object = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.listener;
            if (object != mediaSourceEventListener) continue;
            object = this.listenerAndHandlers;
            ((CopyOnWriteArrayList)object).remove(mediaSourceEventListener$EventDispatcher$ListenerAndHandler);
        }
    }

    public void upstreamDiscarded(int n10, long l10, long l11) {
        long l12 = this.adjustMediaTime(l10);
        long l13 = this.adjustMediaTime(l11);
        MediaLoadData mediaLoadData = new MediaLoadData(1, n10, null, 3, null, l12, l13);
        this.upstreamDiscarded(mediaLoadData);
    }

    public void upstreamDiscarded(MediaLoadData mediaLoadData) {
        boolean bl2;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = (MediaSource$MediaPeriodId)Assertions.checkNotNull(this.mediaPeriodId);
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            MediaSourceEventListener$EventDispatcher$ListenerAndHandler mediaSourceEventListener$EventDispatcher$ListenerAndHandler = (MediaSourceEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            MediaSourceEventListener mediaSourceEventListener = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.listener;
            mediaSourceEventListener$EventDispatcher$ListenerAndHandler = mediaSourceEventListener$EventDispatcher$ListenerAndHandler.handler;
            c c10 = new c(this, mediaSourceEventListener, mediaSource$MediaPeriodId, mediaLoadData);
            Util.postOrRun((Handler)mediaSourceEventListener$EventDispatcher$ListenerAndHandler, c10);
        }
    }

    public MediaSourceEventListener$EventDispatcher withParameters(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long l10) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.listenerAndHandlers;
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = new MediaSourceEventListener$EventDispatcher(copyOnWriteArrayList, n10, mediaSource$MediaPeriodId, l10);
        return mediaSourceEventListener$EventDispatcher;
    }
}

