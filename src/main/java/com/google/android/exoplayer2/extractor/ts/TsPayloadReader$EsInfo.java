/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import java.util.Collections;
import java.util.List;

public final class TsPayloadReader$EsInfo {
    public final byte[] descriptorBytes;
    public final List dvbSubtitleInfos;
    public final String language;
    public final int streamType;

    public TsPayloadReader$EsInfo(int n10, String string2, List list, byte[] byArray) {
        this.streamType = n10;
        this.language = string2;
        List list2 = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.dvbSubtitleInfos = list2;
        this.descriptorBytes = byArray;
    }
}

