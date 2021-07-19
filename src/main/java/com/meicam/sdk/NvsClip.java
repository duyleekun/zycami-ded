/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsObject;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsVolume;

public class NvsClip
extends NvsObject {
    public static final int CLIP_TYPE_AUDIO = 1;
    public static final int CLIP_TYPE_VIDEO;

    private native boolean nativeChangeCurvesVariableSpeed(long var1, String var3, boolean var4);

    private native boolean nativeChangeFilePath(long var1, String var3);

    private native void nativeChangeSpeed(long var1, double var3, boolean var5);

    private native long nativeChangeTrimInPoint(long var1, long var3, boolean var5);

    private native long nativeChangeTrimOutPoint(long var1, long var3, boolean var5);

    private native long nativeGetClipPosByTimelinePosCurvesVariableSpeed(long var1, long var3);

    private native String nativeGetClipVariableSpeedCurvesString(long var1);

    private native String nativeGetFilePath(long var1);

    private native int nativeGetFxCount(long var1);

    private native long nativeGetInPoint(long var1);

    private native int nativeGetIndex(long var1);

    private native boolean nativeGetLoopAudio(long var1);

    private native long nativeGetOutPoint(long var1);

    private native double nativeGetSpeed(long var1);

    private native long nativeGetTimelinePosByClipPosCurvesVariableSpeed(long var1, long var3);

    private native long nativeGetTrimIn(long var1);

    private native long nativeGetTrimOut(long var1);

    private native int nativeGetType(long var1);

    private native NvsVolume nativeGetVolumeGain(long var1);

    private native boolean nativeMoveTrimPoint(long var1, long var3);

    private native void nativeSetLoopAudio(long var1, boolean var3);

    private native void nativeSetVolumeGain(long var1, float var3, float var4);

    public long GetClipPosByTimelinePosCurvesVariableSpeed(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetClipPosByTimelinePosCurvesVariableSpeed(l11, l10);
    }

    public long GetTimelinePosByClipPosCurvesVariableSpeed(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetTimelinePosByClipPosCurvesVariableSpeed(l11, l10);
    }

    public boolean changeCurvesVariableSpeed(String string2, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeChangeCurvesVariableSpeed(l10, string2, bl2);
    }

    public boolean changeFilePath(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeChangeFilePath(l10, string2);
    }

    public void changeSpeed(double d10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeChangeSpeed(l10, d10, false);
    }

    public void changeSpeed(double d10, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeChangeSpeed(l10, d10, bl2);
    }

    public long changeTrimInPoint(long l10, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeChangeTrimInPoint(l11, l10, bl2);
    }

    public long changeTrimOutPoint(long l10, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeChangeTrimOutPoint(l11, l10, bl2);
    }

    public String getClipVariableSpeedCurvesString() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetClipVariableSpeedCurvesString(l10);
    }

    public String getFilePath() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFilePath(l10);
    }

    public int getFxCount() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFxCount(l10);
    }

    public long getInPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetInPoint(l10);
    }

    public int getIndex() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetIndex(l10);
    }

    public boolean getLoopAudio() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetLoopAudio(l10);
    }

    public long getOutPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOutPoint(l10);
    }

    public double getSpeed() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetSpeed(l10);
    }

    public long getTrimIn() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTrimIn(l10);
    }

    public long getTrimOut() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTrimOut(l10);
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

    public boolean moveTrimPoint(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeMoveTrimPoint(l11, l10);
    }

    public void setLoopAudio(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetLoopAudio(l10, bl2);
    }

    public void setVolumeGain(float f10, float f11) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetVolumeGain(l10, f10, f11);
    }
}

