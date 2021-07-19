/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls;

import java.io.IOException;

public final class SampleQueueMappingException
extends IOException {
    public SampleQueueMappingException(String string2) {
        int n10 = String.valueOf(string2).length() + 60;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Unable to bind a sample queue to TrackGroup with mime type ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        string2 = stringBuilder.toString();
        super(string2);
    }
}

