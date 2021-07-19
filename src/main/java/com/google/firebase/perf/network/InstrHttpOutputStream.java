/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.network;

import com.google.firebase.perf.impl.NetworkRequestMetricBuilder;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.OutputStream;

public final class InstrHttpOutputStream
extends OutputStream {
    public NetworkRequestMetricBuilder mBuilder;
    public long mBytesWritten = -1;
    private OutputStream mOutputStream;
    private final Timer mTimer;

    public InstrHttpOutputStream(OutputStream outputStream, NetworkRequestMetricBuilder networkRequestMetricBuilder, Timer timer) {
        this.mOutputStream = outputStream;
        this.mBuilder = networkRequestMetricBuilder;
        this.mTimer = timer;
    }

    public void close() {
        long l10 = this.mBytesWritten;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            networkRequestMetricBuilder.setRequestPayloadBytes(l10);
        }
        Object object2 = this.mBuilder;
        Object object3 = this.mTimer;
        long l13 = ((Timer)object3).getDurationMicros();
        ((NetworkRequestMetricBuilder)object2).setTimeToRequestCompletedMicros(l13);
        try {
            object2 = this.mOutputStream;
        }
        catch (IOException iOException) {
            object3 = this.mBuilder;
            l11 = this.mTimer.getDurationMicros();
            ((NetworkRequestMetricBuilder)object3).setTimeToResponseCompletedMicros(l11);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        ((OutputStream)object2).close();
    }

    public void flush() {
        OutputStream outputStream;
        try {
            outputStream = this.mOutputStream;
        }
        catch (IOException iOException) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            long l10 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l10);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        outputStream.flush();
    }

    public void write(int n10) {
        Object object;
        try {
            object = this.mOutputStream;
        }
        catch (IOException iOException) {
            object = this.mBuilder;
            long l10 = this.mTimer.getDurationMicros();
            ((NetworkRequestMetricBuilder)object).setTimeToResponseCompletedMicros(l10);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        ((OutputStream)object).write(n10);
        long l11 = this.mBytesWritten;
        long l12 = 1L;
        l11 += l12;
        this.mBytesWritten = l11;
        NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
        networkRequestMetricBuilder.setRequestPayloadBytes(l11);
    }

    public void write(byte[] object) {
        Object object2;
        try {
            object2 = this.mOutputStream;
        }
        catch (IOException iOException) {
            object2 = this.mBuilder;
            long l10 = this.mTimer.getDurationMicros();
            ((NetworkRequestMetricBuilder)object2).setTimeToResponseCompletedMicros(l10);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        ((OutputStream)object2).write((byte[])object);
        long l11 = this.mBytesWritten;
        int n10 = ((byte[])object).length;
        long l12 = n10;
        l11 += l12;
        this.mBytesWritten = l11;
        object = this.mBuilder;
        ((NetworkRequestMetricBuilder)object).setRequestPayloadBytes(l11);
    }

    public void write(byte[] byArray, int n10, int n11) {
        long l10;
        OutputStream outputStream;
        try {
            outputStream = this.mOutputStream;
        }
        catch (IOException iOException) {
            NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
            l10 = this.mTimer.getDurationMicros();
            networkRequestMetricBuilder.setTimeToResponseCompletedMicros(l10);
            NetworkRequestMetricBuilderUtil.logError(this.mBuilder);
            throw iOException;
        }
        outputStream.write(byArray, n10, n11);
        long l11 = this.mBytesWritten;
        l10 = n11;
        l11 += l10;
        this.mBytesWritten = l11;
        NetworkRequestMetricBuilder networkRequestMetricBuilder = this.mBuilder;
        networkRequestMetricBuilder.setRequestPayloadBytes(l11);
    }
}

