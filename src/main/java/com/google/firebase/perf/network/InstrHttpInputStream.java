/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;

public final class InstrHttpInputStream
extends InputStream {
    private final NetworkRequestMetricBuilder mBuilder;
    private long mBytesRead;
    private final InputStream mInputStream;
    private long mTimeToResponseInitiated;
    private long mTimeToResponseLastRead;
    private final Timer mTimer;

    public InstrHttpInputStream(InputStream inputStream, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer) {
        long l10;
        long l11;
        this.mBytesRead = l11 = (long)-1;
        this.mTimeToResponseLastRead = l11;
        this.mTimer = timer;
        this.mInputStream = inputStream;
        this.mBuilder = networkRequestMetricBuilder;
        this.mTimeToResponseInitiated = l10 = networkRequestMetricBuilder.getTimeToResponseInitiatedMicros();
    }

    public int available() {
        InputStream inputStream;
        try {
            inputStream = this.mInputStream;
        }
        catch (IOException iOException) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            long l10 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l10);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        return inputStream.available();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Object object = this.mTimer;
        long l10 = ((Timer)object).getDurationMicros();
        long l11 = this.mTimeToResponseLastRead;
        long l12 = -1;
        long l13 = l11 - l12;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 == false) {
            this.mTimeToResponseLastRead = l10;
        }
        try {
            long l14;
            long l15;
            NetworkRequestMetricBuilder networkRequestMetricBuilder;
            object = this.mInputStream;
            ((InputStream)object).close();
            l10 = this.mBytesRead;
            long l16 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (l16 != false) {
                networkRequestMetricBuilder = this.mBuilder;
                networkRequestMetricBuilder.setResponsePayloadBytes(l10);
            }
            if ((l15 = (l14 = (l10 = this.mTimeToResponseInitiated) - l12) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != false) {
                networkRequestMetricBuilder = this.mBuilder;
                networkRequestMetricBuilder.setTimeToResponseInitiatedMicros(l10);
            }
            object = this.mBuilder;
            long l17 = this.mTimeToResponseLastRead;
            ((NetworkRequestMetricBuilder)object).setTimeToResponseCompletedMicros(l17);
            object = this.mBuilder;
            ((NetworkRequestMetricBuilder)object).build();
            return;
        }
        catch (IOException iOException) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            l11 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l11);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
    }

    public void mark(int n10) {
        this.mInputStream.mark(n10);
    }

    public boolean markSupported() {
        return this.mInputStream.markSupported();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int read() {
        try {
            long l10;
            InputStream inputStream = this.mInputStream;
            int n10 = inputStream.read();
            Object object = this.mTimer;
            long l11 = ((Timer)object).getDurationMicros();
            long l12 = this.mTimeToResponseInitiated;
            long l13 = -1;
            long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (l14 == false) {
                this.mTimeToResponseInitiated = l11;
            }
            if (n10 == (l14 = (long)-1) && (l14 = (l10 = (l12 = this.mTimeToResponseLastRead) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
                this.mTimeToResponseLastRead = l11;
                NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
                networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l11);
                object = this.mBuilder;
                ((NetworkRequestMetricBuilder)object).build();
                return n10;
            }
            l11 = this.mBytesRead;
            l12 = 1L;
            this.mBytesRead = l11 += l12;
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            networkRequestMetricBuilder.setResponsePayloadBytes(l11);
            return n10;
        }
        catch (IOException iOException) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            long l15 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l15);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int read(byte[] byArray) {
        try {
            long l10;
            Object object = this.mInputStream;
            int n10 = ((InputStream)object).read(byArray);
            object = this.mTimer;
            long l11 = ((Timer)object).getDurationMicros();
            long l12 = this.mTimeToResponseInitiated;
            long l13 = -1;
            long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (l14 == false) {
                this.mTimeToResponseInitiated = l11;
            }
            if (n10 == (l14 = (long)-1) && (l14 = (l10 = (l12 = this.mTimeToResponseLastRead) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
                this.mTimeToResponseLastRead = l11;
                NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
                networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l11);
                object = this.mBuilder;
                ((NetworkRequestMetricBuilder)object).build();
                return n10;
            }
            l11 = this.mBytesRead;
            l12 = n10;
            this.mBytesRead = l11 += l12;
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            networkRequestMetricBuilder.setResponsePayloadBytes(l11);
            return n10;
        }
        catch (IOException iOException) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            long l15 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l15);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int read(byte[] byArray, int n10, int n11) {
        try {
            long l10;
            Object object = this.mInputStream;
            int n12 = ((InputStream)object).read(byArray, n10, n11);
            Object object2 = this.mTimer;
            long l11 = ((Timer)object2).getDurationMicros();
            long l12 = this.mTimeToResponseInitiated;
            long l13 = -1;
            long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (l14 == false) {
                this.mTimeToResponseInitiated = l11;
            }
            if (n12 == (l14 = (long)-1) && (l14 = (l10 = (l12 = this.mTimeToResponseLastRead) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
                this.mTimeToResponseLastRead = l11;
                object = this.mBuilder;
                ((NetworkRequestMetricBuilder)object).setTimeToResponseCompletedMicros(l11);
                object2 = this.mBuilder;
                ((NetworkRequestMetricBuilder)object2).build();
                return n12;
            }
            l11 = this.mBytesRead;
            l12 = n12;
            this.mBytesRead = l11 += l12;
            object = this.mBuilder;
            ((NetworkRequestMetricBuilder)object).setResponsePayloadBytes(l11);
            return n12;
        }
        catch (IOException iOException) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            long l15 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l15);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
    }

    public void reset() {
        InputStream inputStream;
        try {
            inputStream = this.mInputStream;
        }
        catch (IOException iOException) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            long l10 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l10);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        inputStream.reset();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long skip(long l10) {
        try {
            long l11;
            Object object = this.mInputStream;
            l10 = ((InputStream)object).skip(l10);
            object = this.mTimer;
            long l12 = ((Timer)object).getDurationMicros();
            long l13 = this.mTimeToResponseInitiated;
            long l14 = -1;
            long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
            if (l15 == false) {
                this.mTimeToResponseInitiated = l12;
            }
            if ((l15 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1)) == false && (l15 = (l11 = (l13 = this.mTimeToResponseLastRead) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
                this.mTimeToResponseLastRead = l12;
                NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
                networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l12);
                return l10;
            }
            this.mBytesRead = l12 = this.mBytesRead + l10;
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            networkRequestMetricBuilder.setResponsePayloadBytes(l12);
            return l10;
        }
        catch (IOException iOException) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            long l16 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l16);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
    }
}

