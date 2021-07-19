/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo;
import com.google.android.exoplayer2.upstream.Loader$UnexpectedLoaderException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DefaultLoadErrorHandlingPolicy
implements LoadErrorHandlingPolicy {
    private static final int DEFAULT_BEHAVIOR_MIN_LOADABLE_RETRY_COUNT = 255;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_PROGRESSIVE_LIVE = 6;
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000L;
    private final int minimumLoadableRetryCount;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    public DefaultLoadErrorHandlingPolicy(int n10) {
        this.minimumLoadableRetryCount = n10;
    }

    public long getBlacklistDurationMsFor(LoadErrorHandlingPolicy$LoadErrorInfo object) {
        object = ((LoadErrorHandlingPolicy$LoadErrorInfo)object).exception;
        int n10 = object instanceof HttpDataSource$InvalidResponseCodeException;
        long l10 = -9223372036854775807L;
        if (n10 != 0) {
            object = (HttpDataSource$InvalidResponseCodeException)object;
            int n11 = ((HttpDataSource$InvalidResponseCodeException)object).responseCode;
            n10 = 403;
            if (n11 == n10 || n11 == (n10 = 404) || n11 == (n10 = 410) || n11 == (n10 = 416) || n11 == (n10 = 500) || n11 == (n10 = 503)) {
                l10 = 60000L;
            }
        }
        return l10;
    }

    public int getMinimumLoadableRetryCount(int n10) {
        int n11 = this.minimumLoadableRetryCount;
        int n12 = -1;
        if (n11 == n12) {
            n11 = 7;
            n10 = n10 == n11 ? 6 : 3;
            return n10;
        }
        return n11;
    }

    public long getRetryDelayMsFor(LoadErrorHandlingPolicy$LoadErrorInfo loadErrorHandlingPolicy$LoadErrorInfo) {
        long l10;
        int n10;
        IOException iOException = loadErrorHandlingPolicy$LoadErrorInfo.exception;
        boolean bl2 = iOException instanceof ParserException;
        if (!(bl2 || (bl2 = iOException instanceof FileNotFoundException) || (bl2 = iOException instanceof HttpDataSource.CleartextNotPermittedException) || (n10 = iOException instanceof Loader$UnexpectedLoaderException) != 0)) {
            int n11 = (loadErrorHandlingPolicy$LoadErrorInfo.errorCount + -1) * 1000;
            n10 = 5000;
            n11 = Math.min(n11, n10);
            l10 = n11;
        } else {
            l10 = -9223372036854775807L;
        }
        return l10;
    }
}

