/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.UriUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.List;

public class SsManifest$StreamElement {
    private static final String URL_PLACEHOLDER_BITRATE_1 = "{bitrate}";
    private static final String URL_PLACEHOLDER_BITRATE_2 = "{Bitrate}";
    private static final String URL_PLACEHOLDER_START_TIME_1 = "{start time}";
    private static final String URL_PLACEHOLDER_START_TIME_2 = "{start_time}";
    private final String baseUri;
    public final int chunkCount;
    private final List chunkStartTimes;
    private final long[] chunkStartTimesUs;
    private final String chunkTemplate;
    public final int displayHeight;
    public final int displayWidth;
    public final Format[] formats;
    public final String language;
    private final long lastChunkDurationUs;
    public final int maxHeight;
    public final int maxWidth;
    public final String name;
    public final String subType;
    public final long timescale;
    public final int type;

    public SsManifest$StreamElement(String string2, String string3, int n10, String string4, long l10, String string5, int n11, int n12, int n13, int n14, String string6, Format[] formatArray, List list, long l11) {
        long l12 = 1000000L;
        Object object = list;
        object = Util.scaleLargeTimestamps(list, l12, l10);
        long l13 = Util.scaleLargeTimestamp(l11, l12, l10);
        this(string2, string3, n10, string4, l10, string5, n11, n12, n13, n14, string6, formatArray, list, (long[])object, l13);
    }

    private SsManifest$StreamElement(String string2, String string3, int n10, String string4, long l10, String string5, int n11, int n12, int n13, int n14, String string6, Format[] formatArray, List list, long[] lArray, long l11) {
        this.baseUri = string2;
        this.chunkTemplate = string3;
        int n15 = n10;
        this.type = n10;
        this.subType = string4;
        this.timescale = l10;
        this.name = string5;
        n15 = n11;
        this.maxWidth = n11;
        n15 = n12;
        this.maxHeight = n12;
        n15 = n13;
        this.displayWidth = n13;
        n15 = n14;
        this.displayHeight = n14;
        this.language = string6;
        this.formats = formatArray;
        this.chunkStartTimes = list;
        this.chunkStartTimesUs = lArray;
        this.lastChunkDurationUs = l11;
        this.chunkCount = n15 = list.size();
    }

    public Uri buildRequestUri(int n10, int n11) {
        int n12;
        Object object = this.formats;
        int n13 = 1;
        if (object != null) {
            n12 = n13;
        } else {
            n12 = 0;
            object = null;
        }
        Assertions.checkState(n12 != 0);
        object = this.chunkStartTimes;
        if (object != null) {
            n12 = n13;
        } else {
            n12 = 0;
            object = null;
        }
        Assertions.checkState(n12 != 0);
        object = this.chunkStartTimes;
        n12 = object.size();
        if (n11 >= n12) {
            n13 = 0;
        }
        Assertions.checkState(n13 != 0);
        String string2 = Integer.toString(this.formats[n10].bitrate);
        String string3 = ((Long)this.chunkStartTimes.get(n11)).toString();
        string2 = this.chunkTemplate.replace(URL_PLACEHOLDER_BITRATE_1, string2).replace(URL_PLACEHOLDER_BITRATE_2, string2).replace(URL_PLACEHOLDER_START_TIME_1, string3).replace(URL_PLACEHOLDER_START_TIME_2, string3);
        return UriUtil.resolveToUri(this.baseUri, string2);
    }

    public SsManifest$StreamElement copy(Format[] object) {
        SsManifest$StreamElement ssManifest$StreamElement;
        Format[] formatArray = object;
        String string2 = this.baseUri;
        String string3 = this.chunkTemplate;
        int n10 = this.type;
        String string4 = this.subType;
        long l10 = this.timescale;
        String string5 = this.name;
        int n11 = this.maxWidth;
        int n12 = this.maxHeight;
        int n13 = this.displayWidth;
        int n14 = this.displayHeight;
        String string6 = this.language;
        List list = this.chunkStartTimes;
        object = ssManifest$StreamElement;
        long[] lArray = this.chunkStartTimesUs;
        long l11 = this.lastChunkDurationUs;
        ssManifest$StreamElement = new SsManifest$StreamElement(string2, string3, n10, string4, l10, string5, n11, n12, n13, n14, string6, formatArray, list, lArray, l11);
        return ssManifest$StreamElement;
    }

    public long getChunkDurationUs(int n10) {
        long l10;
        int n11 = this.chunkCount + -1;
        if (n10 == n11) {
            l10 = this.lastChunkDurationUs;
        } else {
            long[] lArray = this.chunkStartTimesUs;
            int n12 = n10 + 1;
            long l11 = lArray[n12];
            long l12 = lArray[n10];
            l10 = l11 - l12;
        }
        return l10;
    }

    public int getChunkIndex(long l10) {
        long[] lArray = this.chunkStartTimesUs;
        boolean bl2 = true;
        return Util.binarySearchFloor(lArray, l10, bl2, bl2);
    }

    public long getStartTimeUs(int n10) {
        return this.chunkStartTimesUs[n10];
    }
}

