/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$ProtectionElement;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$StreamElement;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SsManifest
implements FilterableManifest {
    public static final int UNSET_LOOKAHEAD = 255;
    public final long durationUs;
    public final long dvrWindowLengthUs;
    public final boolean isLive;
    public final int lookAheadCount;
    public final int majorVersion;
    public final int minorVersion;
    public final SsManifest$ProtectionElement protectionElement;
    public final SsManifest$StreamElement[] streamElements;

    private SsManifest(int n10, int n11, long l10, long l11, int n12, boolean bl2, SsManifest$ProtectionElement ssManifest$ProtectionElement, SsManifest$StreamElement[] ssManifest$StreamElementArray) {
        this.majorVersion = n10;
        this.minorVersion = n11;
        this.durationUs = l10;
        this.dvrWindowLengthUs = l11;
        this.lookAheadCount = n12;
        this.isLive = bl2;
        this.protectionElement = ssManifest$ProtectionElement;
        this.streamElements = ssManifest$StreamElementArray;
    }

    public SsManifest(int n10, int n11, long l10, long l11, long l12, int n12, boolean bl2, SsManifest$ProtectionElement ssManifest$ProtectionElement, SsManifest$StreamElement[] ssManifest$StreamElementArray) {
        long l13;
        long l14;
        long l15;
        long l16 = 0L;
        long l17 = l11 == l16 ? 0 : (l11 < l16 ? -1 : 1);
        long l18 = -9223372036854775807L;
        if (l17 == false) {
            l15 = l18;
        } else {
            l14 = 1000000L;
            l13 = l11;
            l15 = l13 = Util.scaleLargeTimestamp(l11, l14, l10);
        }
        long l19 = l12 == l16 ? 0 : (l12 < l16 ? -1 : 1);
        if (l19 != false) {
            l14 = 1000000L;
            l13 = l12;
            l18 = Util.scaleLargeTimestamp(l12, l14, l10);
        }
        this(n10, n11, l15, l18, n12, bl2, ssManifest$ProtectionElement, ssManifest$StreamElementArray);
    }

    public final SsManifest copy(List object) {
        int n10;
        int n11;
        Object object2 = new ArrayList(object);
        Collections.sort(object2);
        object = new ArrayList();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n12 = 0;
        Object object3 = null;
        for (int i10 = 0; i10 < (n11 = object2.size()); ++i10) {
            StreamKey streamKey = (StreamKey)object2.get(i10);
            Object object4 = this.streamElements;
            n10 = streamKey.groupIndex;
            if ((object4 = object4[n10]) != object3 && object3 != null) {
                Format[] formatArray = new Format[]{};
                formatArray = arrayList.toArray(formatArray);
                object3 = ((SsManifest$StreamElement)object3).copy(formatArray);
                object.add(object3);
                arrayList.clear();
            }
            object3 = object4.formats;
            n11 = streamKey.trackIndex;
            object3 = object3[n11];
            arrayList.add(object3);
            object3 = object4;
        }
        if (object3 != null) {
            object2 = new Format[]{};
            object2 = (Format[])arrayList.toArray((T[])object2);
            object2 = ((SsManifest$StreamElement)object3).copy((Format[])object2);
            object.add(object2);
        }
        object2 = new SsManifest$StreamElement[]{};
        object = object.toArray((T[])object2);
        Object[] objectArray = object;
        objectArray = (SsManifest$StreamElement[])object;
        int n13 = this.majorVersion;
        n12 = this.minorVersion;
        long l10 = this.durationUs;
        long l11 = this.dvrWindowLengthUs;
        n10 = this.lookAheadCount;
        boolean bl2 = this.isLive;
        SsManifest$ProtectionElement ssManifest$ProtectionElement = this.protectionElement;
        object2 = object;
        object = new SsManifest(n13, n12, l10, l11, n10, bl2, ssManifest$ProtectionElement, (SsManifest$StreamElement[])objectArray);
        return object;
    }
}

