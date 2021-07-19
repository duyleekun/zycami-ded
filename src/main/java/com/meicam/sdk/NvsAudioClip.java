/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsAudioFx;
import com.meicam.sdk.NvsClip;
import com.meicam.sdk.NvsCustomAudioFx$Renderer;
import com.meicam.sdk.NvsUtils;

public class NvsAudioClip
extends NvsClip {
    private native NvsAudioFx nativeAppendFx(long var1, String var3);

    private native long nativeGetFadeInDuration(long var1);

    private native long nativeGetFadeOutDuration(long var1);

    private native NvsAudioFx nativeGetFxByIndex(long var1, int var3);

    private native NvsAudioFx nativeInsertCustomFx(long var1, NvsCustomAudioFx$Renderer var3, int var4);

    private native NvsAudioFx nativeInsertFx(long var1, String var3, int var4);

    private native boolean nativeRemoveFx(long var1, int var3);

    private native void nativeSetFadeInDuration(long var1, long var3);

    private native void nativeSetFadeOutDuration(long var1, long var3);

    public NvsAudioFx appendCustomFx(NvsCustomAudioFx$Renderer nvsCustomAudioFx$Renderer) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        int n10 = this.getFxCount();
        return this.nativeInsertCustomFx(l10, nvsCustomAudioFx$Renderer, n10);
    }

    public NvsAudioFx appendFx(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeAppendFx(l10, string2);
    }

    public long getFadeInDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFadeInDuration(l10);
    }

    public long getFadeOutDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFadeOutDuration(l10);
    }

    public NvsAudioFx getFxByIndex(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFxByIndex(l10, n10);
    }

    public NvsAudioFx insertCustomFx(NvsCustomAudioFx$Renderer nvsCustomAudioFx$Renderer, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertCustomFx(l10, nvsCustomAudioFx$Renderer, n10);
    }

    public NvsAudioFx insertFx(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertFx(l10, string2, n10);
    }

    public boolean removeFx(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveFx(l10, n10);
    }

    public void setFadeInDuration(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeSetFadeInDuration(l11, l10);
    }

    public void setFadeOutDuration(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeSetFadeOutDuration(l11, l10);
    }
}

