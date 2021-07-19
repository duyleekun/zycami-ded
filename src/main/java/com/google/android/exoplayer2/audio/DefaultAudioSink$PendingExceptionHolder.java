/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.audio;

import android.os.SystemClock;

public final class DefaultAudioSink$PendingExceptionHolder {
    private Exception pendingException;
    private long throwDeadlineMs;
    private final long throwDelayMs;

    public DefaultAudioSink$PendingExceptionHolder(long l10) {
        this.throwDelayMs = l10;
    }

    public void clear() {
        this.pendingException = null;
    }

    public void throwExceptionIfDeadlineIsReached(Exception exception) {
        long l10;
        long l11;
        long l12;
        long l13 = SystemClock.elapsedRealtime();
        Exception exception2 = this.pendingException;
        if (exception2 == null) {
            this.pendingException = exception;
            this.throwDeadlineMs = l12 = this.throwDelayMs + l13;
        }
        if ((l11 = (l10 = l13 - (l12 = this.throwDeadlineMs)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) >= 0) {
            Exception exception3 = this.pendingException;
            if (exception3 != exception) {
                exception3.addSuppressed(exception);
            }
            exception = this.pendingException;
            this.clear();
            throw exception;
        }
    }
}

