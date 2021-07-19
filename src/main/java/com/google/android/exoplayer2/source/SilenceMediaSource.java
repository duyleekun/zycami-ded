/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.SilenceMediaSource$1;
import com.google.android.exoplayer2.source.SilenceMediaSource$SilenceMediaPeriod;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class SilenceMediaSource
extends BaseMediaSource {
    private static final int CHANNEL_COUNT = 2;
    private static final Format FORMAT;
    public static final String MEDIA_ID = "SilenceMediaSource";
    private static final MediaItem MEDIA_ITEM;
    private static final int PCM_ENCODING = 2;
    private static final int SAMPLE_RATE_HZ = 44100;
    private static final byte[] SILENCE_SAMPLE;
    private final long durationUs;
    private final MediaItem mediaItem;

    static {
        Object object = new Format$Builder();
        object = ((Format$Builder)object).setSampleMimeType("audio/raw");
        int n10 = 2;
        FORMAT = object = ((Format$Builder)object).setChannelCount(n10).setSampleRate(44100).setPcmEncoding(n10).build();
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        mediaItem$Builder = mediaItem$Builder.setMediaId(MEDIA_ID);
        Uri uri = Uri.EMPTY;
        mediaItem$Builder = mediaItem$Builder.setUri(uri);
        object = ((Format)object).sampleMimeType;
        MEDIA_ITEM = mediaItem$Builder.setMimeType((String)object).build();
        SILENCE_SAMPLE = new byte[Util.getPcmFrameSize(n10, n10) * 1024];
    }

    public SilenceMediaSource(long l10) {
        MediaItem mediaItem = MEDIA_ITEM;
        this(l10, mediaItem);
    }

    private SilenceMediaSource(long l10, MediaItem mediaItem) {
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        l12 = l12 >= 0 ? (long)1 : (long)0;
        Assertions.checkArgument((boolean)l12);
        this.durationUs = l10;
        this.mediaItem = mediaItem;
    }

    public /* synthetic */ SilenceMediaSource(long l10, MediaItem mediaItem, SilenceMediaSource$1 silenceMediaSource$1) {
        this(l10, mediaItem);
    }

    public static /* synthetic */ MediaItem access$000() {
        return MEDIA_ITEM;
    }

    public static /* synthetic */ Format access$200() {
        return FORMAT;
    }

    public static /* synthetic */ long access$300(long l10) {
        return SilenceMediaSource.getAudioByteCount(l10);
    }

    public static /* synthetic */ long access$400(long l10) {
        return SilenceMediaSource.getAudioPositionUs(l10);
    }

    public static /* synthetic */ byte[] access$500() {
        return SILENCE_SAMPLE;
    }

    private static long getAudioByteCount(long l10) {
        l10 = l10 * 44100L / 1000000L;
        int n10 = 2;
        return (long)Util.getPcmFrameSize(n10, n10) * l10;
    }

    private static long getAudioPositionUs(long l10) {
        int n10 = 2;
        long l11 = Util.getPcmFrameSize(n10, n10);
        return l10 / l11 * 1000000L / 44100L;
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId object, Allocator allocator, long l10) {
        long l11 = this.durationUs;
        object = new SilenceMediaSource$SilenceMediaPeriod(l11);
        return object;
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public Object getTag() {
        return ((MediaItem$PlaybackProperties)Assertions.checkNotNull((Object)this.mediaItem.playbackProperties)).tag;
    }

    public void maybeThrowSourceInfoRefreshError() {
    }

    public void prepareSourceInternal(TransferListener object) {
        long l10 = this.durationUs;
        MediaItem mediaItem = this.mediaItem;
        object = new SinglePeriodTimeline(l10, true, false, false, null, mediaItem);
        this.refreshSourceInfo((Timeline)object);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
    }

    public void releaseSourceInternal() {
    }
}

