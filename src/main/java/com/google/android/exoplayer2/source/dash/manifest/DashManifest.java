/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.ProgramInformation;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.ServiceDescriptionElement;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DashManifest
implements FilterableManifest {
    public final long availabilityStartTimeMs;
    public final long durationMs;
    public final boolean dynamic;
    public final Uri location;
    public final long minBufferTimeMs;
    public final long minUpdatePeriodMs;
    private final List periods;
    public final ProgramInformation programInformation;
    public final long publishTimeMs;
    public final ServiceDescriptionElement serviceDescription;
    public final long suggestedPresentationDelayMs;
    public final long timeShiftBufferDepthMs;
    public final UtcTimingElement utcTiming;

    public DashManifest(long l10, long l11, long l12, boolean bl2, long l13, long l14, long l15, long l16, ProgramInformation programInformation, UtcTimingElement utcTimingElement, ServiceDescriptionElement serviceDescriptionElement, Uri uri, List list) {
        DashManifest dashManifest = this;
        this.availabilityStartTimeMs = l10;
        this.durationMs = l11;
        this.minBufferTimeMs = l12;
        this.dynamic = bl2;
        this.minUpdatePeriodMs = l13;
        this.timeShiftBufferDepthMs = l14;
        this.suggestedPresentationDelayMs = l15;
        this.publishTimeMs = l16;
        List list2 = programInformation;
        this.programInformation = programInformation;
        list2 = utcTimingElement;
        this.utcTiming = utcTimingElement;
        list2 = uri;
        this.location = uri;
        list2 = serviceDescriptionElement;
        this.serviceDescription = serviceDescriptionElement;
        list2 = list == null ? Collections.emptyList() : list;
        dashManifest.periods = list2;
    }

    public DashManifest(long l10, long l11, long l12, boolean bl2, long l13, long l14, long l15, long l16, UtcTimingElement utcTimingElement, Uri uri, List list) {
        this(l10, l11, l12, bl2, l13, l14, l15, l16, null, utcTimingElement, null, uri, list);
    }

    private static ArrayList copyAdaptationSets(List list, LinkedList linkedList) {
        int n10;
        Object object = (StreamKey)linkedList.poll();
        int n11 = ((StreamKey)object).periodIndex;
        ArrayList<AdaptationSet> arrayList = new ArrayList<AdaptationSet>();
        do {
            int n12;
            n10 = ((StreamKey)object).groupIndex;
            AdaptationSet adaptationSet = (AdaptationSet)list.get(n10);
            List list2 = adaptationSet.representations;
            ArrayList<Object> arrayList2 = new ArrayList<Object>();
            do {
                int n13 = ((StreamKey)object).trackIndex;
                object = (Representation)list2.get(n13);
                arrayList2.add(object);
                object = (StreamKey)linkedList.poll();
                n12 = ((StreamKey)object).periodIndex;
            } while (n12 == n11 && (n12 = ((StreamKey)object).groupIndex) == n10);
            int n14 = adaptationSet.id;
            int n15 = adaptationSet.type;
            List list3 = adaptationSet.accessibilityDescriptors;
            List list4 = adaptationSet.essentialProperties;
            List list5 = adaptationSet.supplementalProperties;
            AdaptationSet adaptationSet2 = new AdaptationSet(n14, n15, arrayList2, list3, list4, list5);
            arrayList.add(adaptationSet2);
        } while ((n10 = ((StreamKey)object).periodIndex) == n11);
        linkedList.addFirst(object);
        return arrayList;
    }

    public final DashManifest copy(List object) {
        long l10;
        long l11;
        DashManifest dashManifest = this;
        ArrayList<Period> arrayList = object;
        Object object2 = new LinkedList(object);
        Collections.sort(object2);
        int n10 = -1;
        arrayList = new ArrayList<Period>(n10, n10, n10);
        ((LinkedList)object2).add(arrayList);
        arrayList = new ArrayList<Period>();
        long l12 = 0L;
        int n11 = 0;
        while (true) {
            int n12 = this.getPeriodCount();
            l11 = -9223372036854775807L;
            if (n11 >= n12) break;
            Object object3 = (StreamKey)((LinkedList)object2).peek();
            n12 = ((StreamKey)object3).periodIndex;
            if (n12 != n11) {
                l10 = dashManifest.getPeriodDurationMs(n11);
                long l13 = l10 - l11;
                n12 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                if (n12 != 0) {
                    l12 += l10;
                }
            } else {
                object3 = dashManifest.getPeriod(n11);
                ArrayList arrayList2 = DashManifest.copyAdaptationSets(((Period)object3).adaptationSets, (LinkedList)object2);
                String string2 = ((Period)object3).id;
                long l14 = ((Period)object3).startMs - l12;
                List list = ((Period)object3).eventStreams;
                Period period = new Period(string2, l14, arrayList2, list);
                arrayList.add(period);
            }
            ++n11;
        }
        long l15 = dashManifest.durationMs;
        long l16 = l15 - l11;
        Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object4 != false) {
            l11 = l15 -= l12;
        }
        l15 = dashManifest.availabilityStartTimeMs;
        l10 = dashManifest.minBufferTimeMs;
        boolean bl2 = dashManifest.dynamic;
        long l17 = dashManifest.minUpdatePeriodMs;
        long l18 = dashManifest.timeShiftBufferDepthMs;
        object = object2;
        long l19 = dashManifest.suggestedPresentationDelayMs;
        l12 = dashManifest.publishTimeMs;
        ProgramInformation programInformation = dashManifest.programInformation;
        UtcTimingElement utcTimingElement = dashManifest.utcTiming;
        ServiceDescriptionElement serviceDescriptionElement = dashManifest.serviceDescription;
        Uri uri = dashManifest.location;
        object2 = new DashManifest(l15, l11, l10, bl2, l17, l18, l19, l12, programInformation, utcTimingElement, serviceDescriptionElement, uri, arrayList);
        return object2;
    }

    public final Period getPeriod(int n10) {
        return (Period)this.periods.get(n10);
    }

    public final int getPeriodCount() {
        return this.periods.size();
    }

    public final long getPeriodDurationMs(int n10) {
        Object object = this.periods;
        int n11 = object.size() + -1;
        long l10 = -9223372036854775807L;
        if (n10 == n11) {
            long l11 = this.durationMs;
            long l12 = l11 - l10;
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 != 0) {
                object = this.periods;
                Period period = (Period)object.get(n10);
                long l13 = period.startMs;
                l10 = l11 - l13;
            }
        } else {
            object = this.periods;
            int n12 = n10 + 1;
            object = (Period)object.get(n12);
            long l14 = ((Period)object).startMs;
            List list = this.periods;
            Period period = (Period)list.get(n10);
            long l15 = period.startMs;
            l10 = l14 - l15;
        }
        return l10;
    }

    public final long getPeriodDurationUs(int n10) {
        return C.msToUs(this.getPeriodDurationMs(n10));
    }
}

