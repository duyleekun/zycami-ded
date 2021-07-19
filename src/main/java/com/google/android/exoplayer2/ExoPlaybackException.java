/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;

public final class ExoPlaybackException
extends Exception {
    public static final int TYPE_REMOTE = 3;
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    private final Throwable cause;
    public final boolean isRecoverable;
    public final MediaPeriodId mediaPeriodId;
    public final Format rendererFormat;
    public final int rendererFormatSupport;
    public final int rendererIndex;
    public final String rendererName;
    public final long timestampMs;
    public final int type;

    private ExoPlaybackException(int n10, String string2) {
        this(n10, null, string2, null, -1, null, 4, false);
    }

    private ExoPlaybackException(int n10, Throwable throwable) {
        this(n10, throwable, null, null, -1, null, 4, false);
    }

    private ExoPlaybackException(int n10, Throwable throwable, String string2, String string3, int n11, Format format, int n12, boolean bl2) {
        String string4 = string3;
        string4 = ExoPlaybackException.deriveMessage(n10, string2, string3, n11, format, n12);
        long l10 = SystemClock.elapsedRealtime();
        this(string4, throwable, n10, string3, n11, format, n12, null, l10, bl2);
    }

    private ExoPlaybackException(String string2, Throwable throwable, int n10, String string3, int n11, Format format, int n12, MediaPeriodId mediaPeriodId, long l10, boolean bl2) {
        super(string2, throwable);
        this.type = n10;
        this.cause = throwable;
        this.rendererName = string3;
        this.rendererIndex = n11;
        this.rendererFormat = format;
        this.rendererFormatSupport = n12;
        this.mediaPeriodId = mediaPeriodId;
        this.timestampMs = l10;
        this.isRecoverable = bl2;
    }

    public static ExoPlaybackException createForRemote(String string2) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(3, string2);
        return exoPlaybackException;
    }

    public static ExoPlaybackException createForRenderer(Exception exception) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(1, exception, null, null, -1, null, 4, false);
        return exoPlaybackException;
    }

    public static ExoPlaybackException createForRenderer(Throwable throwable, String string2, int n10, Format format, int n11) {
        return ExoPlaybackException.createForRenderer(throwable, string2, n10, format, n11, false);
    }

    public static ExoPlaybackException createForRenderer(Throwable throwable, String string2, int n10, Format format, int n11, boolean bl2) {
        if (format == null) {
            n11 = 4;
        }
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(1, throwable, null, string2, n10, format, n11, bl2);
        return exoPlaybackException;
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(0, (Throwable)iOException);
        return exoPlaybackException;
    }

    public static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(2, (Throwable)runtimeException);
        return exoPlaybackException;
    }

    private static String deriveMessage(int n10, String string2, String string3, int n11, Format object, int n12) {
        String string4;
        int n13;
        if (n10 != 0) {
            int n14 = 1;
            if (n10 != n14) {
                n13 = 3;
                string4 = n10 != n13 ? "Unexpected runtime error" : "Remote error";
            } else {
                string4 = String.valueOf(object);
                object = C.getFormatSupportString(n12);
                String string5 = String.valueOf(string3);
                n12 = string5.length() + 53;
                n14 = String.valueOf(string4).length();
                n12 += n14;
                n14 = String.valueOf(object).length();
                StringBuilder stringBuilder = new StringBuilder(n12 += n14);
                stringBuilder.append(string3);
                stringBuilder.append(" error, index=");
                stringBuilder.append(n11);
                string3 = ", format=";
                stringBuilder.append(string3);
                stringBuilder.append(string4);
                stringBuilder.append(", format_supported=");
                stringBuilder.append((String)object);
                string4 = stringBuilder.toString();
            }
        } else {
            string4 = "Source error";
        }
        n13 = TextUtils.isEmpty((CharSequence)string2);
        if (n13 == 0) {
            string4 = String.valueOf(string4);
            string3 = String.valueOf(string4);
            n13 = string3.length() + 2;
            n11 = String.valueOf(string2).length();
            StringBuilder stringBuilder = new StringBuilder(n13 += n11);
            stringBuilder.append(string4);
            stringBuilder.append(": ");
            stringBuilder.append(string2);
            string4 = stringBuilder.toString();
        }
        return string4;
    }

    public ExoPlaybackException copyWithMediaPeriodId(MediaPeriodId mediaPeriodId) {
        String string2 = this.getMessage();
        Throwable throwable = this.cause;
        int n10 = this.type;
        String string3 = this.rendererName;
        int n11 = this.rendererIndex;
        Format format = this.rendererFormat;
        int n12 = this.rendererFormatSupport;
        long l10 = this.timestampMs;
        boolean bl2 = this.isRecoverable;
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(string2, throwable, n10, string3, n11, format, n12, mediaPeriodId, l10, bl2);
        return exoPlaybackException;
    }

    public Exception getRendererException() {
        int n10 = this.type;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        Assertions.checkState(n11 != 0);
        return (Exception)Assertions.checkNotNull(this.cause);
    }

    public IOException getSourceException() {
        int n10 = this.type;
        n10 = n10 == 0 ? 1 : 0;
        Assertions.checkState(n10 != 0);
        return (IOException)Assertions.checkNotNull(this.cause);
    }

    public RuntimeException getUnexpectedException() {
        int n10 = this.type;
        int n11 = 2;
        n10 = n10 == n11 ? 1 : 0;
        Assertions.checkState(n10 != 0);
        return (RuntimeException)Assertions.checkNotNull(this.cause);
    }
}

