/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import java.io.IOException;

public final class LoadErrorHandlingPolicy$LoadErrorInfo {
    public final int errorCount;
    public final IOException exception;
    public final LoadEventInfo loadEventInfo;
    public final MediaLoadData mediaLoadData;

    public LoadErrorHandlingPolicy$LoadErrorInfo(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, int n10) {
        this.loadEventInfo = loadEventInfo;
        this.mediaLoadData = mediaLoadData;
        this.exception = iOException;
        this.errorCount = n10;
    }
}

