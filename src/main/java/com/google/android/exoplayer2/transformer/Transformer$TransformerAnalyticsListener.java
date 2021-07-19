/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.transformer.MuxerWrapper;
import com.google.android.exoplayer2.transformer.Transformer;
import com.google.android.exoplayer2.util.Assertions;

public final class Transformer$TransformerAnalyticsListener
implements AnalyticsListener {
    private final MediaItem mediaItem;
    private final MuxerWrapper muxerWrapper;
    public final /* synthetic */ Transformer this$0;

    public Transformer$TransformerAnalyticsListener(Transformer transformer, MediaItem mediaItem, MuxerWrapper muxerWrapper) {
        this.this$0 = transformer;
        this.mediaItem = mediaItem;
        this.muxerWrapper = muxerWrapper;
    }

    private void handleTransformationEnded(Exception object) {
        MediaItem mediaItem;
        Object object2;
        block5: {
            object2 = this.this$0;
            mediaItem = null;
            try {
                Transformer.access$1100((Transformer)object2, false);
            }
            catch (IllegalStateException illegalStateException) {
                if (object != null) break block5;
                object = illegalStateException;
            }
        }
        if (object == null) {
            object = Transformer.access$400(this.this$0);
            object2 = this.mediaItem;
            object.onTransformationCompleted((MediaItem)object2);
        } else {
            object2 = Transformer.access$400(this.this$0);
            mediaItem = this.mediaItem;
            object2.onTransformationError(mediaItem, (Exception)object);
        }
    }

    public void onPlaybackStateChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
        int n11 = 4;
        if (n10 == n11) {
            n11 = 0;
            this.handleTransformationEnded(null);
        }
    }

    public void onPlayerError(AnalyticsListener$EventTime analyticsListener$EventTime, ExoPlaybackException exoPlaybackException) {
        this.handleTransformationEnded(exoPlaybackException);
    }

    public void onTimelineChanged(AnalyticsListener$EventTime object, int n10) {
        Object object2 = this.this$0;
        n10 = Transformer.access$900((Transformer)object2);
        if (n10 != 0) {
            return;
        }
        object2 = new Timeline$Window();
        object = ((AnalyticsListener$EventTime)object).timeline;
        Transformer transformer = null;
        ((Timeline)object).getWindow(0, (Timeline$Window)object2);
        int n11 = ((Timeline$Window)object2).isPlaceholder;
        if (n11 == 0) {
            long l10;
            long l11 = ((Timeline$Window)object2).durationUs;
            transformer = this.this$0;
            long l12 = 0L;
            long l13 = l11 - l12;
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            n11 = object3 > 0 && (n11 = (int)((l10 = l11 - (l12 = -9223372036854775807L)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0 ? 1 : 2;
            Transformer.access$902(transformer, n11);
            object = (SimpleExoPlayer)Assertions.checkNotNull(Transformer.access$1000(this.this$0));
            ((BasePlayer)object).play();
        }
    }

    public void onTracksChanged(AnalyticsListener$EventTime object, TrackGroupArray object2, TrackSelectionArray trackSelectionArray) {
        object = this.muxerWrapper;
        int n10 = ((MuxerWrapper)object).getTrackCount();
        if (n10 == 0) {
            object2 = "The output does not contain any tracks. Check that at least one of the input sample formats is supported.";
            object = new IllegalStateException((String)object2);
            this.handleTransformationEnded((Exception)object);
        }
    }
}

