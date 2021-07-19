/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.meicam.sdk;

import android.graphics.Bitmap;

public class NvsVideoFrameRetriever {
    public static final int VIDEO_FRAME_HEIGHT_GRADE_360 = 0;
    public static final int VIDEO_FRAME_HEIGHT_GRADE_480 = 1;
    public static final int VIDEO_FRAME_HEIGHT_GRADE_720 = 2;
    public long m_internalReader;
    public long m_internalReaderFactory;

    public NvsVideoFrameRetriever(String string2) {
        long l10;
        this.m_internalReader = l10 = 0L;
        this.m_internalReaderFactory = l10;
        this.nativeCreateVideoRetrieverReader(string2);
    }

    private native void nativeCleanup(long var1, long var3);

    private native void nativeCreateVideoRetrieverReader(String var1);

    private native Bitmap nativeGetFrameAtTime(long var1, long var3, int var5, int var6);

    private native void nativeSetFrameTimeTolerance(long var1, long var3);

    public void finalize() {
        this.release();
        super.finalize();
    }

    public Bitmap getFrameAtTime(long l10, int n10) {
        long l11 = this.m_internalReader;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return null;
        }
        l12 = l10;
        return this.nativeGetFrameAtTime(l11, l10, n10, 0);
    }

    public Bitmap getFrameAtTimeWithCustomVideoFrameHeight(long l10, int n10) {
        long l11 = this.m_internalReader;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false && n10 > 0) {
            l12 = l10;
            return this.nativeGetFrameAtTime(l11, l10, 0, n10);
        }
        return null;
    }

    public void release() {
        long l10 = this.m_internalReader;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            long l13 = this.m_internalReaderFactory;
            this.nativeCleanup(l10, l13);
            this.m_internalReader = l11;
            this.m_internalReaderFactory = l11;
        }
    }

    public void setFrameTimeTolerance(long l10) {
        long l11 = this.m_internalReader;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        this.nativeSetFrameTimeTolerance(l11, l10);
    }
}

