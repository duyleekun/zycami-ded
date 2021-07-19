/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo;
import java.io.IOException;

public interface LoadErrorHandlingPolicy {
    default public long getBlacklistDurationMsFor(int n10, long l10, IOException iOException, int n11) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    default public long getBlacklistDurationMsFor(LoadErrorHandlingPolicy$LoadErrorInfo loadErrorHandlingPolicy$LoadErrorInfo) {
        int n10 = loadErrorHandlingPolicy$LoadErrorInfo.mediaLoadData.dataType;
        long l10 = loadErrorHandlingPolicy$LoadErrorInfo.loadEventInfo.loadDurationMs;
        IOException iOException = loadErrorHandlingPolicy$LoadErrorInfo.exception;
        int n11 = loadErrorHandlingPolicy$LoadErrorInfo.errorCount;
        return this.getBlacklistDurationMsFor(n10, l10, iOException, n11);
    }

    public int getMinimumLoadableRetryCount(int var1);

    default public long getRetryDelayMsFor(int n10, long l10, IOException iOException, int n11) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    default public long getRetryDelayMsFor(LoadErrorHandlingPolicy$LoadErrorInfo loadErrorHandlingPolicy$LoadErrorInfo) {
        int n10 = loadErrorHandlingPolicy$LoadErrorInfo.mediaLoadData.dataType;
        long l10 = loadErrorHandlingPolicy$LoadErrorInfo.loadEventInfo.loadDurationMs;
        IOException iOException = loadErrorHandlingPolicy$LoadErrorInfo.exception;
        int n11 = loadErrorHandlingPolicy$LoadErrorInfo.errorCount;
        return this.getRetryDelayMsFor(n10, l10, iOException, n11);
    }

    default public void onLoadTaskConcluded(long l10) {
    }
}

