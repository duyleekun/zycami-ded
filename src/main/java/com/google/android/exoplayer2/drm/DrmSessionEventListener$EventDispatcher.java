/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.drm;

import android.os.Handler;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher$ListenerAndHandler;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.g0.e;
import d.h.a.a.g0.f;
import d.h.a.a.g0.g;
import d.h.a.a.g0.h;
import d.h.a.a.g0.i;
import d.h.a.a.g0.j;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class DrmSessionEventListener$EventDispatcher {
    private final CopyOnWriteArrayList listenerAndHandlers;
    public final MediaSource$MediaPeriodId mediaPeriodId;
    public final int windowIndex;

    public DrmSessionEventListener$EventDispatcher() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this(copyOnWriteArrayList, 0, null);
    }

    private DrmSessionEventListener$EventDispatcher(CopyOnWriteArrayList copyOnWriteArrayList, int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        this.listenerAndHandlers = copyOnWriteArrayList;
        this.windowIndex = n10;
        this.mediaPeriodId = mediaSource$MediaPeriodId;
    }

    private /* synthetic */ void a(DrmSessionEventListener drmSessionEventListener) {
        int n10 = this.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        drmSessionEventListener.onDrmKeysLoaded(n10, mediaSource$MediaPeriodId);
    }

    private /* synthetic */ void c(DrmSessionEventListener drmSessionEventListener) {
        int n10 = this.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        drmSessionEventListener.onDrmKeysRemoved(n10, mediaSource$MediaPeriodId);
    }

    private /* synthetic */ void e(DrmSessionEventListener drmSessionEventListener) {
        int n10 = this.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        drmSessionEventListener.onDrmKeysRestored(n10, mediaSource$MediaPeriodId);
    }

    private /* synthetic */ void g(DrmSessionEventListener drmSessionEventListener) {
        int n10 = this.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        drmSessionEventListener.onDrmSessionAcquired(n10, mediaSource$MediaPeriodId);
    }

    private /* synthetic */ void i(DrmSessionEventListener drmSessionEventListener, Exception exception) {
        int n10 = this.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        drmSessionEventListener.onDrmSessionManagerError(n10, mediaSource$MediaPeriodId, exception);
    }

    private /* synthetic */ void k(DrmSessionEventListener drmSessionEventListener) {
        int n10 = this.windowIndex;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodId;
        drmSessionEventListener.onDrmSessionReleased(n10, mediaSource$MediaPeriodId);
    }

    public void addEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(drmSessionEventListener);
        CopyOnWriteArrayList copyOnWriteArrayList = this.listenerAndHandlers;
        DrmSessionEventListener$EventDispatcher$ListenerAndHandler drmSessionEventListener$EventDispatcher$ListenerAndHandler = new DrmSessionEventListener$EventDispatcher$ListenerAndHandler(handler, drmSessionEventListener);
        copyOnWriteArrayList.add(drmSessionEventListener$EventDispatcher$ListenerAndHandler);
    }

    public /* synthetic */ void b(DrmSessionEventListener drmSessionEventListener) {
        this.a(drmSessionEventListener);
    }

    public /* synthetic */ void d(DrmSessionEventListener drmSessionEventListener) {
        this.c(drmSessionEventListener);
    }

    public void drmKeysLoaded() {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            DrmSessionEventListener$EventDispatcher$ListenerAndHandler drmSessionEventListener$EventDispatcher$ListenerAndHandler = (DrmSessionEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            DrmSessionEventListener drmSessionEventListener = drmSessionEventListener$EventDispatcher$ListenerAndHandler.listener;
            drmSessionEventListener$EventDispatcher$ListenerAndHandler = drmSessionEventListener$EventDispatcher$ListenerAndHandler.handler;
            h h10 = new h(this, drmSessionEventListener);
            Util.postOrRun((Handler)drmSessionEventListener$EventDispatcher$ListenerAndHandler, h10);
        }
    }

    public void drmKeysRemoved() {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            DrmSessionEventListener$EventDispatcher$ListenerAndHandler drmSessionEventListener$EventDispatcher$ListenerAndHandler = (DrmSessionEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            DrmSessionEventListener drmSessionEventListener = drmSessionEventListener$EventDispatcher$ListenerAndHandler.listener;
            drmSessionEventListener$EventDispatcher$ListenerAndHandler = drmSessionEventListener$EventDispatcher$ListenerAndHandler.handler;
            g g10 = new g(this, drmSessionEventListener);
            Util.postOrRun((Handler)drmSessionEventListener$EventDispatcher$ListenerAndHandler, g10);
        }
    }

    public void drmKeysRestored() {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            DrmSessionEventListener$EventDispatcher$ListenerAndHandler drmSessionEventListener$EventDispatcher$ListenerAndHandler = (DrmSessionEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            DrmSessionEventListener drmSessionEventListener = drmSessionEventListener$EventDispatcher$ListenerAndHandler.listener;
            drmSessionEventListener$EventDispatcher$ListenerAndHandler = drmSessionEventListener$EventDispatcher$ListenerAndHandler.handler;
            i i10 = new i(this, drmSessionEventListener);
            Util.postOrRun((Handler)drmSessionEventListener$EventDispatcher$ListenerAndHandler, i10);
        }
    }

    public void drmSessionAcquired() {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            DrmSessionEventListener$EventDispatcher$ListenerAndHandler drmSessionEventListener$EventDispatcher$ListenerAndHandler = (DrmSessionEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            DrmSessionEventListener drmSessionEventListener = drmSessionEventListener$EventDispatcher$ListenerAndHandler.listener;
            drmSessionEventListener$EventDispatcher$ListenerAndHandler = drmSessionEventListener$EventDispatcher$ListenerAndHandler.handler;
            e e10 = new e(this, drmSessionEventListener);
            Util.postOrRun((Handler)drmSessionEventListener$EventDispatcher$ListenerAndHandler, e10);
        }
    }

    public void drmSessionManagerError(Exception exception) {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            DrmSessionEventListener$EventDispatcher$ListenerAndHandler drmSessionEventListener$EventDispatcher$ListenerAndHandler = (DrmSessionEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            DrmSessionEventListener drmSessionEventListener = drmSessionEventListener$EventDispatcher$ListenerAndHandler.listener;
            drmSessionEventListener$EventDispatcher$ListenerAndHandler = drmSessionEventListener$EventDispatcher$ListenerAndHandler.handler;
            j j10 = new j(this, drmSessionEventListener, exception);
            Util.postOrRun((Handler)drmSessionEventListener$EventDispatcher$ListenerAndHandler, j10);
        }
    }

    public void drmSessionReleased() {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            DrmSessionEventListener$EventDispatcher$ListenerAndHandler drmSessionEventListener$EventDispatcher$ListenerAndHandler = (DrmSessionEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            DrmSessionEventListener drmSessionEventListener = drmSessionEventListener$EventDispatcher$ListenerAndHandler.listener;
            drmSessionEventListener$EventDispatcher$ListenerAndHandler = drmSessionEventListener$EventDispatcher$ListenerAndHandler.handler;
            f f10 = new f(this, drmSessionEventListener);
            Util.postOrRun((Handler)drmSessionEventListener$EventDispatcher$ListenerAndHandler, f10);
        }
    }

    public /* synthetic */ void f(DrmSessionEventListener drmSessionEventListener) {
        this.e(drmSessionEventListener);
    }

    public /* synthetic */ void h(DrmSessionEventListener drmSessionEventListener) {
        this.g(drmSessionEventListener);
    }

    public /* synthetic */ void j(DrmSessionEventListener drmSessionEventListener, Exception exception) {
        this.i(drmSessionEventListener, exception);
    }

    public /* synthetic */ void l(DrmSessionEventListener drmSessionEventListener) {
        this.k(drmSessionEventListener);
    }

    public void removeEventListener(DrmSessionEventListener drmSessionEventListener) {
        boolean bl2;
        Iterator iterator2 = this.listenerAndHandlers.iterator();
        while (bl2 = iterator2.hasNext()) {
            DrmSessionEventListener$EventDispatcher$ListenerAndHandler drmSessionEventListener$EventDispatcher$ListenerAndHandler = (DrmSessionEventListener$EventDispatcher$ListenerAndHandler)iterator2.next();
            Object object = drmSessionEventListener$EventDispatcher$ListenerAndHandler.listener;
            if (object != drmSessionEventListener) continue;
            object = this.listenerAndHandlers;
            ((CopyOnWriteArrayList)object).remove(drmSessionEventListener$EventDispatcher$ListenerAndHandler);
        }
    }

    public DrmSessionEventListener$EventDispatcher withParameters(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.listenerAndHandlers;
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = new DrmSessionEventListener$EventDispatcher(copyOnWriteArrayList, n10, mediaSource$MediaPeriodId);
        return drmSessionEventListener$EventDispatcher;
    }
}

