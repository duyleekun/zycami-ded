/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsObject;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsVolume;

public class NvsTrack
extends NvsObject {
    public static final int TRACK_TYPE_AUDIO = 1;
    public static final int TRACK_TYPE_VIDEO;

    private native long nativeChangeInPoint(long var1, int var3, long var4);

    private native long nativeChangeOutPoint(long var1, int var3, long var4);

    private native int nativeGetClipCount(long var1);

    private native long nativeGetDuration(long var1);

    private native int nativeGetIndex(long var1);

    private native int nativeGetType(long var1);

    private native NvsVolume nativeGetVolumeGain(long var1);

    private native boolean nativeMoveClip(long var1, int var3, int var4);

    private native boolean nativeMoveClipByPosition(long var1, int var3, long var4, boolean var6, boolean var7);

    private native boolean nativeRemoveAllClips(long var1);

    private native boolean nativeRemoveClip(long var1, int var3, boolean var4);

    private native boolean nativeRemoveRange(long var1, long var3, long var5, boolean var7);

    private native void nativeSetVolumeGain(long var1, float var3, float var4);

    private native boolean nativeSplitClip(long var1, int var3, long var4);

    public long changeInPoint(int n10, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeChangeInPoint(l11, n10, l10);
    }

    public long changeOutPoint(int n10, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeChangeOutPoint(l11, n10, l10);
    }

    public int getClipCount() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetClipCount(l10);
    }

    public long getDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetDuration(l10);
    }

    public int getIndex() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetIndex(l10);
    }

    public int getType() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetType(l10);
    }

    public NvsVolume getVolumeGain() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVolumeGain(l10);
    }

    public boolean moveClip(int n10, int n11) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeMoveClip(l10, n10, n11);
    }

    public boolean moveClip(int n10, long l10, boolean bl2, boolean bl3) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeMoveClipByPosition(l11, n10, l10, bl2, bl3);
    }

    public boolean removeAllClips() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveAllClips(l10);
    }

    public boolean removeClip(int n10, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveClip(l10, n10, bl2);
    }

    public boolean removeRange(long l10, long l11, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeRemoveRange(l12, l10, l11, bl2);
    }

    public void setVolumeGain(float f10, float f11) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetVolumeGain(l10, f10, f11);
    }

    public boolean splitClip(int n10, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeSplitClip(l11, n10, l10);
    }
}

