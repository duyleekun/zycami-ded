/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.dash.manifest.RangedUri;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$MultiSegmentBase;
import com.google.android.exoplayer2.source.dash.manifest.SegmentBase$SegmentTimelineElement;
import com.google.android.exoplayer2.source.dash.manifest.UrlTemplate;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

public final class SegmentBase$SegmentTemplate
extends SegmentBase$MultiSegmentBase {
    public final long endNumber;
    public final UrlTemplate initializationTemplate;
    public final UrlTemplate mediaTemplate;

    public SegmentBase$SegmentTemplate(RangedUri rangedUri, long l10, long l11, long l12, long l13, long l14, List list, long l15, UrlTemplate urlTemplate, UrlTemplate urlTemplate2, long l16, long l17) {
        super(rangedUri, l10, l11, l12, l14, list, l15, l16, l17);
        this.initializationTemplate = urlTemplate;
        this.mediaTemplate = urlTemplate2;
        this.endNumber = l13;
    }

    public RangedUri getInitialization(Representation object) {
        UrlTemplate urlTemplate = this.initializationTemplate;
        if (urlTemplate != null) {
            object = ((Representation)object).format;
            String string2 = ((Format)object).id;
            int n10 = ((Format)object).bitrate;
            String string3 = urlTemplate.buildUri(string2, 0L, n10, 0L);
            object = new RangedUri(string3, 0L, -1);
            return object;
        }
        return super.getInitialization((Representation)object);
    }

    public int getSegmentCount(long l10) {
        List list = this.segmentTimeline;
        if (list != null) {
            return list.size();
        }
        long l11 = this.endNumber;
        long l12 = -1;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            l10 = this.startNumber;
            return (int)(l11 - l10 + 1L);
        }
        l11 = -9223372036854775807L;
        long l14 = l10 - l11;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 != false) {
            l11 = this.duration * 1000000L;
            l12 = this.timescale;
            return (int)Util.ceilDivide(l10, l11 /= l12);
        }
        return -1;
    }

    public RangedUri getSegmentUrl(Representation representation, long l10) {
        long l11;
        long l12;
        SegmentBase$SegmentTemplate segmentBase$SegmentTemplate = this;
        Object object = this.segmentTimeline;
        if (object != null) {
            long l13 = this.startNumber;
            l13 = l10 - l13;
            int n10 = (int)l13;
            object = (SegmentBase$SegmentTimelineElement)object.get(n10);
            l12 = ((SegmentBase$SegmentTimelineElement)object).startTime;
        } else {
            l12 = this.startNumber;
            l12 = l10 - l12;
            l11 = this.duration;
            l12 *= l11;
        }
        object = segmentBase$SegmentTemplate.mediaTemplate;
        Object object2 = representation;
        object2 = representation.format;
        String string2 = ((Format)object2).id;
        int n11 = ((Format)object2).bitrate;
        object2 = string2;
        l11 = l10;
        String string3 = ((UrlTemplate)object).buildUri(string2, l10, n11, l12);
        object = new RangedUri(string3, 0L, -1);
        return object;
    }
}

