/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeMediaSource$ForwardingEventListener;
import com.google.android.exoplayer2.source.CompositeMediaSource$MediaSourceAndListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.m0.a;
import java.util.HashMap;
import java.util.Iterator;

public abstract class CompositeMediaSource
extends BaseMediaSource {
    private final HashMap childSources;
    private Handler eventHandler;
    private TransferListener mediaTransferListener;

    public CompositeMediaSource() {
        HashMap hashMap;
        this.childSources = hashMap = new HashMap();
    }

    private /* synthetic */ void a(Object object, MediaSource mediaSource, Timeline timeline) {
        this.onChildSourceInfoRefreshed(object, mediaSource, timeline);
    }

    public /* synthetic */ void b(Object object, MediaSource mediaSource, Timeline timeline) {
        this.a(object, mediaSource, timeline);
    }

    public final void disableChildSource(Object object) {
        object = (CompositeMediaSource$MediaSourceAndListener)Assertions.checkNotNull((CompositeMediaSource$MediaSourceAndListener)this.childSources.get(object));
        MediaSource mediaSource = ((CompositeMediaSource$MediaSourceAndListener)object).mediaSource;
        object = ((CompositeMediaSource$MediaSourceAndListener)object).caller;
        mediaSource.disable((MediaSource$MediaSourceCaller)object);
    }

    public void disableInternal() {
        boolean bl2;
        Iterator iterator2 = this.childSources.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (CompositeMediaSource$MediaSourceAndListener)iterator2.next();
            MediaSource mediaSource = ((CompositeMediaSource$MediaSourceAndListener)object).mediaSource;
            object = ((CompositeMediaSource$MediaSourceAndListener)object).caller;
            mediaSource.disable((MediaSource$MediaSourceCaller)object);
        }
    }

    public final void enableChildSource(Object object) {
        object = (CompositeMediaSource$MediaSourceAndListener)Assertions.checkNotNull((CompositeMediaSource$MediaSourceAndListener)this.childSources.get(object));
        MediaSource mediaSource = ((CompositeMediaSource$MediaSourceAndListener)object).mediaSource;
        object = ((CompositeMediaSource$MediaSourceAndListener)object).caller;
        mediaSource.enable((MediaSource$MediaSourceCaller)object);
    }

    public void enableInternal() {
        boolean bl2;
        Iterator iterator2 = this.childSources.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (CompositeMediaSource$MediaSourceAndListener)iterator2.next();
            MediaSource mediaSource = ((CompositeMediaSource$MediaSourceAndListener)object).mediaSource;
            object = ((CompositeMediaSource$MediaSourceAndListener)object).caller;
            mediaSource.enable((MediaSource$MediaSourceCaller)object);
        }
    }

    public MediaSource$MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(Object object, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        return mediaSource$MediaPeriodId;
    }

    public long getMediaTimeForChildMediaTime(Object object, long l10) {
        return l10;
    }

    public int getWindowIndexForChildWindowIndex(Object object, int n10) {
        return n10;
    }

    public void maybeThrowSourceInfoRefreshError() {
        boolean bl2;
        Iterator iterator2 = this.childSources.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            MediaSource mediaSource = ((CompositeMediaSource$MediaSourceAndListener)iterator2.next()).mediaSource;
            mediaSource.maybeThrowSourceInfoRefreshError();
        }
    }

    public abstract void onChildSourceInfoRefreshed(Object var1, MediaSource var2, Timeline var3);

    public final void prepareChildSource(Object object, MediaSource mediaSource) {
        boolean bl2 = this.childSources.containsKey(object) ^ true;
        Assertions.checkArgument(bl2);
        a a10 = new a(this, object);
        CompositeMediaSource$ForwardingEventListener compositeMediaSource$ForwardingEventListener = new CompositeMediaSource$ForwardingEventListener(this, object);
        HashMap hashMap = this.childSources;
        CompositeMediaSource$MediaSourceAndListener compositeMediaSource$MediaSourceAndListener = new CompositeMediaSource$MediaSourceAndListener(mediaSource, a10, compositeMediaSource$ForwardingEventListener);
        hashMap.put(object, compositeMediaSource$MediaSourceAndListener);
        object = (Handler)Assertions.checkNotNull(this.eventHandler);
        mediaSource.addEventListener((Handler)object, compositeMediaSource$ForwardingEventListener);
        object = (Handler)Assertions.checkNotNull(this.eventHandler);
        mediaSource.addDrmEventListener((Handler)object, compositeMediaSource$ForwardingEventListener);
        object = this.mediaTransferListener;
        mediaSource.prepareSource(a10, (TransferListener)object);
        boolean bl3 = this.isEnabled();
        if (!bl3) {
            mediaSource.disable(a10);
        }
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        this.mediaTransferListener = transferListener;
        transferListener = Util.createHandlerForCurrentLooper();
        this.eventHandler = transferListener;
    }

    public final void releaseChildSource(Object object) {
        object = (CompositeMediaSource$MediaSourceAndListener)Assertions.checkNotNull((CompositeMediaSource$MediaSourceAndListener)this.childSources.remove(object));
        MediaSource mediaSource = ((CompositeMediaSource$MediaSourceAndListener)object).mediaSource;
        MediaSource$MediaSourceCaller mediaSource$MediaSourceCaller = ((CompositeMediaSource$MediaSourceAndListener)object).caller;
        mediaSource.releaseSource(mediaSource$MediaSourceCaller);
        mediaSource = ((CompositeMediaSource$MediaSourceAndListener)object).mediaSource;
        object = ((CompositeMediaSource$MediaSourceAndListener)object).eventListener;
        mediaSource.removeEventListener((MediaSourceEventListener)object);
    }

    public void releaseSourceInternal() {
        boolean bl2;
        Iterator iterator2 = this.childSources.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (CompositeMediaSource$MediaSourceAndListener)iterator2.next();
            MediaSource mediaSource = ((CompositeMediaSource$MediaSourceAndListener)object).mediaSource;
            MediaSource$MediaSourceCaller mediaSource$MediaSourceCaller = ((CompositeMediaSource$MediaSourceAndListener)object).caller;
            mediaSource.releaseSource(mediaSource$MediaSourceCaller);
            mediaSource = ((CompositeMediaSource$MediaSourceAndListener)object).mediaSource;
            object = ((CompositeMediaSource$MediaSourceAndListener)object).eventListener;
            mediaSource.removeEventListener((MediaSourceEventListener)object);
        }
        this.childSources.clear();
    }
}

