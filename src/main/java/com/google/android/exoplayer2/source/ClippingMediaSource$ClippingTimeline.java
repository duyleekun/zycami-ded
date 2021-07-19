/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.source.ClippingMediaSource$IllegalClippingException;
import com.google.android.exoplayer2.source.ForwardingTimeline;

public final class ClippingMediaSource$ClippingTimeline
extends ForwardingTimeline {
    private final long durationUs;
    private final long endUs;
    private final boolean isDynamic;
    private final long startUs;

    public ClippingMediaSource$ClippingTimeline(Timeline object, long l10, long l11) {
        super((Timeline)object);
        int n10 = ((Timeline)object).getPeriodCount();
        int n11 = 0;
        int n12 = 1;
        if (n10 == n12) {
            Timeline$Window timeline$Window = new Timeline$Window();
            object = ((Timeline)object).getWindow(0, timeline$Window);
            long l12 = 0L;
            l10 = Math.max(l12, l10);
            n10 = (int)(((Timeline$Window)object).isPlaceholder ? 1 : 0);
            if (n10 == 0 && (n10 = (int)(l10 == l12 ? 0 : (l10 < l12 ? -1 : 1))) != 0 && (n10 = (int)(((Timeline$Window)object).isSeekable ? 1 : 0)) == 0) {
                object = new ClippingMediaSource$IllegalClippingException(n12);
                throw object;
            }
            long l13 = Long.MIN_VALUE;
            long l14 = l11 - l13;
            n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            l11 = n10 == 0 ? ((Timeline$Window)object).durationUs : Math.max(l12, l11);
            l12 = ((Timeline$Window)object).durationUs;
            l13 = -9223372036854775807L;
            n10 = (int)(l12 == l13 ? 0 : (l12 < l13 ? -1 : 1));
            if (n10 != 0) {
                n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
                if (n10 > 0) {
                    l11 = l12;
                }
                if ((n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1))) > 0) {
                    object = new ClippingMediaSource$IllegalClippingException(2);
                    throw object;
                }
            }
            this.startUs = l10;
            this.endUs = l11;
            n10 = (int)(l11 == l13 ? 0 : (l11 < l13 ? -1 : 1));
            l10 = n10 == 0 ? l13 : l11 - l10;
            this.durationUs = l10;
            boolean bl2 = ((Timeline$Window)object).isDynamic;
            if (bl2 && (n10 == 0 || (bl2 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1)) && !(bl2 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)))) {
                n11 = n12;
            }
            this.isDynamic = n11;
            return;
        }
        object = new ClippingMediaSource$IllegalClippingException(0);
        throw object;
    }

    public Timeline$Period getPeriod(int n10, Timeline$Period timeline$Period, boolean bl2) {
        Timeline timeline = this.timeline;
        timeline.getPeriod(0, timeline$Period, bl2);
        long l10 = timeline$Period.getPositionInWindowUs();
        long l11 = this.startUs;
        long l12 = l10 - l11;
        l10 = this.durationUs;
        l11 = -9223372036854775807L;
        n10 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        long l13 = n10 == 0 ? l11 : (l10 -= l12);
        Object object = timeline$Period.id;
        Object object2 = timeline$Period.uid;
        return timeline$Period.set(object, object2, 0, l13, l12);
    }

    public Timeline$Window getWindow(int n10, Timeline$Window timeline$Window, long l10) {
        long l11;
        Timeline timeline = this.timeline;
        timeline.getWindow(0, timeline$Window, 0L);
        l10 = timeline$Window.positionInFirstPeriodUs;
        long l12 = this.startUs;
        timeline$Window.positionInFirstPeriodUs = l10 += l12;
        timeline$Window.durationUs = l10 = this.durationUs;
        n10 = (int)(this.isDynamic ? 1 : 0);
        timeline$Window.isDynamic = n10;
        l10 = timeline$Window.defaultPositionUs;
        long l13 = -9223372036854775807L;
        n10 = (int)(l10 == l13 ? 0 : (l10 < l13 ? -1 : 1));
        if (n10 != 0) {
            timeline$Window.defaultPositionUs = l10 = Math.max(l10, l12);
            l12 = this.endUs;
            long l14 = l12 - l13;
            n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            if (n10 != 0) {
                l10 = Math.min(l10, l12);
            }
            timeline$Window.defaultPositionUs = l10;
            l12 = this.startUs;
            timeline$Window.defaultPositionUs = l10 -= l12;
        }
        l10 = C.usToMs(this.startUs);
        l12 = timeline$Window.presentationStartTimeMs;
        long l15 = l12 - l13;
        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n10 != 0) {
            timeline$Window.presentationStartTimeMs = l12 += l10;
        }
        if ((n10 = (int)((l11 = (l12 = timeline$Window.windowStartTimeMs) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
            timeline$Window.windowStartTimeMs = l12 += l10;
        }
        return timeline$Window;
    }
}

