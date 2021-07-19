/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

public final class TsPayloadReader$DvbSubtitleInfo {
    public final byte[] initializationData;
    public final String language;
    public final int type;

    public TsPayloadReader$DvbSubtitleInfo(String string2, int n10, byte[] byArray) {
        this.language = string2;
        this.type = n10;
        this.initializationData = byArray;
    }
}

