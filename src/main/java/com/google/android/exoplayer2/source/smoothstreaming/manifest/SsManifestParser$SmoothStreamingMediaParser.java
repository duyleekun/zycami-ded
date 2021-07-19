/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.xmlpull.v1.XmlPullParser
 */
package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData$SchemeData;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$ProtectionElement;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$StreamElement;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$ElementParser;
import com.google.android.exoplayer2.util.Assertions;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

public class SsManifestParser$SmoothStreamingMediaParser
extends SsManifestParser$ElementParser {
    private static final String KEY_DURATION = "Duration";
    private static final String KEY_DVR_WINDOW_LENGTH = "DVRWindowLength";
    private static final String KEY_IS_LIVE = "IsLive";
    private static final String KEY_LOOKAHEAD_COUNT = "LookaheadCount";
    private static final String KEY_MAJOR_VERSION = "MajorVersion";
    private static final String KEY_MINOR_VERSION = "MinorVersion";
    private static final String KEY_TIME_SCALE = "TimeScale";
    public static final String TAG = "SmoothStreamingMedia";
    private long duration;
    private long dvrWindowLength;
    private boolean isLive;
    private int lookAheadCount = -1;
    private int majorVersion;
    private int minorVersion;
    private SsManifest$ProtectionElement protectionElement = null;
    private final List streamElements;
    private long timescale;

    public SsManifestParser$SmoothStreamingMediaParser(SsManifestParser$ElementParser linkedList, String string2) {
        super((SsManifestParser$ElementParser)((Object)linkedList), string2, TAG);
        this.streamElements = linkedList = new LinkedList();
    }

    public void addChild(Object object) {
        boolean bl2 = object instanceof SsManifest$StreamElement;
        if (bl2) {
            List list = this.streamElements;
            object = (SsManifest$StreamElement)object;
            list.add(object);
        } else {
            bl2 = object instanceof SsManifest$ProtectionElement;
            if (bl2) {
                SsManifest$ProtectionElement ssManifest$ProtectionElement = this.protectionElement;
                if (ssManifest$ProtectionElement == null) {
                    bl2 = true;
                } else {
                    bl2 = false;
                    ssManifest$ProtectionElement = null;
                }
                Assertions.checkState(bl2);
                this.protectionElement = object = (SsManifest$ProtectionElement)object;
            }
        }
    }

    public Object build() {
        int n10;
        int n11;
        Object object = this.streamElements;
        int n12 = object.size();
        SsManifest$StreamElement[] ssManifest$StreamElementArray = new SsManifest$StreamElement[n12];
        this.streamElements.toArray(ssManifest$StreamElementArray);
        Object object2 = this.protectionElement;
        if (object2 != null) {
            n11 = 1;
            DrmInitData$SchemeData[] drmInitData$SchemeDataArray = new DrmInitData$SchemeData[n11];
            Object object3 = this.protectionElement;
            UUID uUID = ((SsManifest$ProtectionElement)object3).uuid;
            object3 = ((SsManifest$ProtectionElement)object3).data;
            Object object4 = "video/mp4";
            Format[] formatArray = new DrmInitData$SchemeData(uUID, (String)object4, (byte[])object3);
            object3 = null;
            drmInitData$SchemeDataArray[0] = formatArray;
            object2 = new DrmInitData(drmInitData$SchemeDataArray);
            drmInitData$SchemeDataArray = null;
            for (n10 = 0; n10 < n12; ++n10) {
                formatArray = ssManifest$StreamElementArray[n10];
                int n13 = formatArray.type;
                int n14 = 2;
                if (n13 != n14 && n13 != n11) continue;
                formatArray = formatArray.formats;
                uUID = null;
                for (n13 = 0; n13 < (n14 = formatArray.length); ++n13) {
                    formatArray[n13] = object4 = formatArray[n13].buildUpon().setDrmInitData((DrmInitData)object2).build();
                }
            }
        }
        n11 = this.majorVersion;
        n10 = this.minorVersion;
        long l10 = this.timescale;
        long l11 = this.duration;
        long l12 = this.dvrWindowLength;
        int n15 = this.lookAheadCount;
        boolean bl2 = this.isLive;
        SsManifest$ProtectionElement ssManifest$ProtectionElement = this.protectionElement;
        object2 = object;
        object = new SsManifest(n11, n10, l10, l11, l12, n15, bl2, ssManifest$ProtectionElement, ssManifest$StreamElementArray);
        return object;
    }

    public void parseStartTag(XmlPullParser object) {
        boolean bl2;
        int n10;
        long l10;
        int n11;
        this.majorVersion = n11 = this.parseRequiredInt((XmlPullParser)object, KEY_MAJOR_VERSION);
        this.minorVersion = n11 = this.parseRequiredInt((XmlPullParser)object, KEY_MINOR_VERSION);
        String string2 = KEY_TIME_SCALE;
        this.timescale = l10 = this.parseLong((XmlPullParser)object, string2, 10000000L);
        this.duration = l10 = this.parseRequiredLong((XmlPullParser)object, KEY_DURATION);
        this.dvrWindowLength = l10 = this.parseLong((XmlPullParser)object, KEY_DVR_WINDOW_LENGTH, 0L);
        this.lookAheadCount = n10 = this.parseInt((XmlPullParser)object, KEY_LOOKAHEAD_COUNT, -1);
        this.isLive = bl2 = this.parseBoolean((XmlPullParser)object, KEY_IS_LIVE, false);
        object = this.timescale;
        this.putNormalizedAttribute(string2, object);
    }
}

