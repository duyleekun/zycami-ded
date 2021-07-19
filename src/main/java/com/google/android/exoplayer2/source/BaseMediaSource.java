/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public abstract class BaseMediaSource
implements MediaSource {
    private final DrmSessionEventListener$EventDispatcher drmEventDispatcher;
    private final HashSet enabledMediaSourceCallers;
    private final MediaSourceEventListener$EventDispatcher eventDispatcher;
    private Looper looper;
    private final ArrayList mediaSourceCallers;
    private Timeline timeline;

    public BaseMediaSource() {
        int n10 = 1;
        Object object = new ArrayList(n10);
        this.mediaSourceCallers = object;
        super(n10);
        this.enabledMediaSourceCallers = object;
        this.eventDispatcher = object = new MediaSourceEventListener$EventDispatcher();
        this.drmEventDispatcher = object = new DrmSessionEventListener$EventDispatcher();
    }

    public final void addDrmEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(drmSessionEventListener);
        this.drmEventDispatcher.addEventListener(handler, drmSessionEventListener);
    }

    public final void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
        Assertions.checkNotNull(handler);
        Assertions.checkNotNull(mediaSourceEventListener);
        this.eventDispatcher.addEventListener(handler, mediaSourceEventListener);
    }

    public final DrmSessionEventListener$EventDispatcher createDrmEventDispatcher(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        return this.drmEventDispatcher.withParameters(n10, mediaSource$MediaPeriodId);
    }

    public final DrmSessionEventListener$EventDispatcher createDrmEventDispatcher(MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        return this.drmEventDispatcher.withParameters(0, mediaSource$MediaPeriodId);
    }

    public final MediaSourceEventListener$EventDispatcher createEventDispatcher(int n10, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long l10) {
        return this.eventDispatcher.withParameters(n10, mediaSource$MediaPeriodId, l10);
    }

    public final MediaSourceEventListener$EventDispatcher createEventDispatcher(MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        return this.eventDispatcher.withParameters(0, mediaSource$MediaPeriodId, 0L);
    }

    public final MediaSourceEventListener$EventDispatcher createEventDispatcher(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long l10) {
        Assertions.checkNotNull(mediaSource$MediaPeriodId);
        return this.eventDispatcher.withParameters(0, mediaSource$MediaPeriodId, l10);
    }

    public final void disable(MediaSource$MediaSourceCaller object) {
        boolean bl2;
        HashSet hashSet = this.enabledMediaSourceCallers;
        boolean bl3 = hashSet.isEmpty() ^ true;
        HashSet hashSet2 = this.enabledMediaSourceCallers;
        hashSet2.remove(object);
        if (bl3 && (bl2 = ((HashSet)(object = this.enabledMediaSourceCallers)).isEmpty())) {
            this.disableInternal();
        }
    }

    public void disableInternal() {
    }

    public final void enable(MediaSource$MediaSourceCaller mediaSource$MediaSourceCaller) {
        Assertions.checkNotNull(this.looper);
        HashSet hashSet = this.enabledMediaSourceCallers;
        boolean bl2 = hashSet.isEmpty();
        HashSet hashSet2 = this.enabledMediaSourceCallers;
        hashSet2.add(mediaSource$MediaSourceCaller);
        if (bl2) {
            this.enableInternal();
        }
    }

    public void enableInternal() {
    }

    public final boolean isEnabled() {
        return this.enabledMediaSourceCallers.isEmpty() ^ true;
    }

    public final void prepareSource(MediaSource$MediaSourceCaller mediaSource$MediaSourceCaller, TransferListener transferListener) {
        boolean bl2;
        Object object = Looper.myLooper();
        Object object2 = this.looper;
        if (object2 != null && object2 != object) {
            bl2 = false;
            object2 = null;
        } else {
            bl2 = true;
        }
        Assertions.checkArgument(bl2);
        object2 = this.timeline;
        this.mediaSourceCallers.add(mediaSource$MediaSourceCaller);
        Looper looper = this.looper;
        if (looper == null) {
            this.looper = object;
            object = this.enabledMediaSourceCallers;
            ((HashSet)object).add(mediaSource$MediaSourceCaller);
            this.prepareSourceInternal(transferListener);
        } else if (object2 != null) {
            this.enable(mediaSource$MediaSourceCaller);
            mediaSource$MediaSourceCaller.onSourceInfoRefreshed(this, (Timeline)object2);
        }
    }

    public abstract void prepareSourceInternal(TransferListener var1);

    public final void refreshSourceInfo(Timeline timeline) {
        boolean bl2;
        this.timeline = timeline;
        Iterator iterator2 = this.mediaSourceCallers.iterator();
        while (bl2 = iterator2.hasNext()) {
            MediaSource$MediaSourceCaller mediaSource$MediaSourceCaller = (MediaSource$MediaSourceCaller)iterator2.next();
            mediaSource$MediaSourceCaller.onSourceInfoRefreshed(this, timeline);
        }
    }

    public final void releaseSource(MediaSource$MediaSourceCaller object) {
        this.mediaSourceCallers.remove(object);
        ArrayList arrayList = this.mediaSourceCallers;
        boolean bl2 = arrayList.isEmpty();
        if (bl2) {
            this.looper = null;
            this.timeline = null;
            object = this.enabledMediaSourceCallers;
            ((HashSet)object).clear();
            this.releaseSourceInternal();
        } else {
            this.disable((MediaSource$MediaSourceCaller)object);
        }
    }

    public abstract void releaseSourceInternal();

    public final void removeDrmEventListener(DrmSessionEventListener drmSessionEventListener) {
        this.drmEventDispatcher.removeEventListener(drmSessionEventListener);
    }

    public final void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
        this.eventDispatcher.removeEventListener(mediaSourceEventListener);
    }
}

