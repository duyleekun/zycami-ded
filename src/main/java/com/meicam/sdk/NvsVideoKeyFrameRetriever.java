/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsVideoKeyFrameRetriever$KeyFrame;

public class NvsVideoKeyFrameRetriever {
    public long m_internalObject = 0L;
    public int m_videoFrameHeight;

    public NvsVideoKeyFrameRetriever(String string2, int n10, boolean bl2) {
        this.nativeCreateVideoRetrieverReader(string2, bl2);
        this.m_videoFrameHeight = n10;
    }

    private native void nativeCleanup(long var1);

    private native void nativeCreateVideoRetrieverReader(String var1, boolean var2);

    private native NvsVideoKeyFrameRetriever$KeyFrame nativeGetNextKeyFrame(long var1, int var3);

    private native void nativeStartGettingKeyFrame(long var1, long var3);

    public void finalize() {
        long l10 = this.m_internalObject;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.nativeCleanup(l10);
            this.m_internalObject = l11;
        }
        super.finalize();
    }

    public NvsVideoKeyFrameRetriever$KeyFrame getNextKeyFrame() {
        long l10 = this.m_internalObject;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return null;
        }
        object = this.m_videoFrameHeight;
        return this.nativeGetNextKeyFrame(l10, (int)object);
    }

    public void release() {
        long l10 = this.m_internalObject;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.nativeCleanup(l10);
            this.m_internalObject = l11;
        }
    }

    public void startGettingKeyFrame(long l10) {
        long l11 = this.m_internalObject;
        this.nativeStartGettingKeyFrame(l11, l10);
    }
}

