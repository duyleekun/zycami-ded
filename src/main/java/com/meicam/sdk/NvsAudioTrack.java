/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsAudioClip;
import com.meicam.sdk.NvsAudioTransition;
import com.meicam.sdk.NvsTrack;
import com.meicam.sdk.NvsUtils;

public class NvsAudioTrack
extends NvsTrack {
    private native NvsAudioClip nativeAddClip(long var1, String var3, long var4);

    private native NvsAudioClip nativeAddClip(long var1, String var3, long var4, long var6, long var8);

    private native NvsAudioClip nativeGetClipByIndex(long var1, int var3);

    private native NvsAudioClip nativeGetClipByTimelinePosition(long var1, long var3);

    private native NvsAudioTransition nativeGetTransitionWithSourceClipIndex(long var1, int var3);

    private native NvsAudioClip nativeInsertClip(long var1, String var3, int var4);

    private native NvsAudioClip nativeInsertClip(long var1, String var3, long var4, long var6, int var8);

    private native NvsAudioTransition nativeSetBuiltinTransition(long var1, int var3, String var4);

    public NvsAudioClip addClip(String string2, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeAddClip(l11, string2, l10);
    }

    public NvsAudioClip addClip(String string2, long l10, long l11, long l12) {
        NvsUtils.checkFunctionInMainThread();
        long l13 = this.m_internalObject;
        return this.nativeAddClip(l13, string2, l10, l11, l12);
    }

    public NvsAudioClip appendClip(String string2) {
        NvsUtils.checkFunctionInMainThread();
        int n10 = this.getClipCount();
        return this.insertClip(string2, n10);
    }

    public NvsAudioClip appendClip(String string2, long l10, long l11) {
        NvsUtils.checkFunctionInMainThread();
        int n10 = this.getClipCount();
        return this.insertClip(string2, l10, l11, n10);
    }

    public NvsAudioClip getClipByIndex(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetClipByIndex(l10, n10);
    }

    public NvsAudioClip getClipByTimelinePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetClipByTimelinePosition(l11, l10);
    }

    public NvsAudioTransition getTransitionWithSourceClipIndex(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTransitionWithSourceClipIndex(l10, n10);
    }

    public NvsAudioClip insertClip(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertClip(l10, string2, n10);
    }

    public NvsAudioClip insertClip(String string2, long l10, long l11, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeInsertClip(l12, string2, l10, l11, n10);
    }

    public NvsAudioTransition setBuiltinTransition(int n10, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeSetBuiltinTransition(l10, n10, string2);
    }
}

