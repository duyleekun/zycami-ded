/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MaskingMediaPeriod$PrepareListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource$AdPrepareListener;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.List;

public final class AdsMediaSource$AdMediaSourceHolder {
    private final List activeMediaPeriods;
    private MediaSource adMediaSource;
    private Uri adUri;
    private final MediaSource$MediaPeriodId id;
    public final /* synthetic */ AdsMediaSource this$0;
    private Timeline timeline;

    public AdsMediaSource$AdMediaSourceHolder(AdsMediaSource arrayList, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        this.this$0 = arrayList;
        this.id = mediaSource$MediaPeriodId;
        this.activeMediaPeriods = arrayList = new ArrayList();
    }

    public MediaPeriod createMediaPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Allocator object, long l10) {
        Object object2;
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(mediaSource$MediaPeriodId, (Allocator)object, l10);
        this.activeMediaPeriods.add(maskingMediaPeriod);
        object = this.adMediaSource;
        if (object != null) {
            maskingMediaPeriod.setMediaSource((MediaSource)object);
            object2 = this.this$0;
            Uri uri = (Uri)Assertions.checkNotNull(this.adUri);
            object = new AdsMediaSource$AdPrepareListener((AdsMediaSource)object2, uri);
            maskingMediaPeriod.setPrepareListener((MaskingMediaPeriod$PrepareListener)object);
        }
        if ((object = this.timeline) != null) {
            object = ((Timeline)object).getUidOfPeriod(0);
            long l11 = mediaSource$MediaPeriodId.windowSequenceNumber;
            object2 = new MediaSource$MediaPeriodId(object, l11);
            maskingMediaPeriod.createPeriod((MediaSource$MediaPeriodId)object2);
        }
        return maskingMediaPeriod;
    }

    public long getDurationUs() {
        long l10;
        Object object = this.timeline;
        if (object == null) {
            l10 = -9223372036854775807L;
        } else {
            Timeline$Period timeline$Period = AdsMediaSource.access$600(this.this$0);
            object = ((Timeline)object).getPeriod(0, timeline$Period);
            l10 = ((Timeline$Period)object).getDurationUs();
        }
        return l10;
    }

    public void handleSourceInfoRefresh(Timeline timeline) {
        Object object;
        int n10 = timeline.getPeriodCount();
        int n11 = 0;
        int n12 = 1;
        if (n10 != n12) {
            n12 = 0;
            object = null;
        }
        Assertions.checkArgument(n12 != 0);
        Object object2 = this.timeline;
        if (object2 == null) {
            object2 = timeline.getUidOfPeriod(0);
            while (n11 < (n12 = (object = this.activeMediaPeriods).size())) {
                object = (MaskingMediaPeriod)this.activeMediaPeriods.get(n11);
                MediaSource$MediaPeriodId mediaSource$MediaPeriodId = ((MaskingMediaPeriod)object).id;
                long l10 = mediaSource$MediaPeriodId.windowSequenceNumber;
                MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = new MediaSource$MediaPeriodId(object2, l10);
                ((MaskingMediaPeriod)object).createPeriod(mediaSource$MediaPeriodId2);
                ++n11;
            }
        }
        this.timeline = timeline;
    }

    public boolean hasMediaSource() {
        boolean bl2;
        MediaSource mediaSource = this.adMediaSource;
        if (mediaSource != null) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaSource = null;
        }
        return bl2;
    }

    public void initializeWithMediaSource(MediaSource mediaSource, Uri object) {
        Object object2;
        int n10;
        this.adMediaSource = mediaSource;
        this.adUri = object;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = null;
        for (int i10 = 0; i10 < (n10 = (object2 = this.activeMediaPeriods).size()); ++i10) {
            object2 = (MaskingMediaPeriod)this.activeMediaPeriods.get(i10);
            ((MaskingMediaPeriod)object2).setMediaSource(mediaSource);
            AdsMediaSource adsMediaSource = this.this$0;
            AdsMediaSource$AdPrepareListener adsMediaSource$AdPrepareListener = new AdsMediaSource$AdPrepareListener(adsMediaSource, (Uri)object);
            ((MaskingMediaPeriod)object2).setPrepareListener(adsMediaSource$AdPrepareListener);
        }
        object = this.this$0;
        mediaSource$MediaPeriodId = this.id;
        AdsMediaSource.access$500((AdsMediaSource)object, mediaSource$MediaPeriodId, mediaSource);
    }

    public boolean isInactive() {
        return this.activeMediaPeriods.isEmpty();
    }

    public void release() {
        boolean bl2 = this.hasMediaSource();
        if (bl2) {
            AdsMediaSource adsMediaSource = this.this$0;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.id;
            AdsMediaSource.access$700(adsMediaSource, mediaSource$MediaPeriodId);
        }
    }

    public void releaseMediaPeriod(MaskingMediaPeriod maskingMediaPeriod) {
        this.activeMediaPeriods.remove(maskingMediaPeriod);
        maskingMediaPeriod.releasePeriod();
    }
}

