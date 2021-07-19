/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsCustomVideoFx$Renderer;
import com.meicam.sdk.NvsCustomVideoTransition$Renderer;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsTrack;
import com.meicam.sdk.NvsTrackAnimatedSticker;
import com.meicam.sdk.NvsTrackCaption;
import com.meicam.sdk.NvsTrackCompoundCaption;
import com.meicam.sdk.NvsTrackVideoFx;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsVideoClip;
import com.meicam.sdk.NvsVideoTransition;
import java.util.List;

public class NvsVideoTrack
extends NvsTrack {
    private native NvsTrackAnimatedSticker nativeAddAnimatedSticker(long var1, long var3, long var5, String var7, boolean var8, boolean var9, String var10);

    private native NvsTrackVideoFx nativeAddBuiltinTrackVideoFx(long var1, long var3, long var5, String var7);

    private native NvsTrackCaption nativeAddCaption(long var1, String var3, long var4, long var6, String var8, boolean var9);

    private native NvsVideoClip nativeAddClip(long var1, String var3, long var4);

    private native NvsVideoClip nativeAddClip(long var1, String var3, long var4, long var6, long var8);

    private native NvsTrackCompoundCaption nativeAddCompoundCaption(long var1, long var3, long var5, String var7);

    private native NvsTrackVideoFx nativeAddCustomTrackVideoFx(long var1, long var3, long var5, NvsCustomVideoFx$Renderer var7);

    private native NvsTrackCaption nativeAddModularCaption(long var1, String var3, long var4, long var6);

    private native NvsTrackVideoFx nativeAddPackagedTrackVideoFx(long var1, long var3, long var5, String var7);

    private native List nativeGetAnimatedStickersByTimelinePosition(long var1, long var3);

    private native List nativeGetCaptionsByTimelinePosition(long var1, long var3);

    private native NvsVideoClip nativeGetClipByIndex(long var1, int var3);

    private native NvsVideoClip nativeGetClipByTimelinePosition(long var1, long var3);

    private native List nativeGetCompoundCaptionsByTimelinePosition(long var1, long var3);

    private native NvsTrackAnimatedSticker nativeGetFirstAnimatedSticker(long var1);

    private native NvsTrackVideoFx nativeGetFirstTrackVideoFx(long var1);

    private native NvsTrackAnimatedSticker nativeGetLastAnimatedSticker(long var1);

    private native NvsTrackVideoFx nativeGetLastTrackVideoFx(long var1);

    private native NvsTrackAnimatedSticker nativeGetNextAnimatedSticker(long var1, NvsTrackAnimatedSticker var3);

    private native NvsTrackCaption nativeGetNextCaption(long var1, NvsTrackCaption var3);

    private native NvsTrackCompoundCaption nativeGetNextCompoundCaption(long var1, NvsTrackCompoundCaption var3);

    private native NvsTrackVideoFx nativeGetNextTrackVideoFx(long var1, NvsTrackVideoFx var3);

    private native NvsTrackAnimatedSticker nativeGetPrevAnimatedSticker(long var1, NvsTrackAnimatedSticker var3);

    private native NvsTrackCaption nativeGetPrevCaption(long var1, NvsTrackCaption var3);

    private native NvsTrackCompoundCaption nativeGetPrevCompoundCaption(long var1, NvsTrackCompoundCaption var3);

    private native NvsTrackVideoFx nativeGetPrevTrackVideoFx(long var1, NvsTrackVideoFx var3);

    private native NvsRational nativeGetProxyScale(long var1);

    private native List nativeGetTrackVideoFxByPosition(long var1, long var3);

    private native NvsVideoTransition nativeGetTransitionBySourceClipIndex(long var1, int var3);

    private native NvsVideoClip nativeInsertClip(long var1, String var3, int var4);

    private native NvsVideoClip nativeInsertClip(long var1, String var3, long var4, long var6, int var8);

    private native boolean nativeIsOriginalRender(long var1);

    private native NvsTrackAnimatedSticker nativeRemoveAnimatedSticker(long var1, NvsTrackAnimatedSticker var3);

    private native NvsTrackCaption nativeRemoveCaption(long var1, NvsTrackCaption var3);

    private native NvsTrackCompoundCaption nativeRemoveCompoundCaption(long var1, NvsTrackCompoundCaption var3);

    private native NvsTrackVideoFx nativeRemoveTrackVideoFx(long var1, NvsTrackVideoFx var3);

    private native NvsVideoTransition nativeSetBuiltinTransition(long var1, int var3, String var4);

    private native NvsVideoTransition nativeSetCustomVideoTransition(long var1, int var3, NvsCustomVideoTransition$Renderer var4);

    private native void nativeSetEnableOriginalRender(long var1, boolean var3);

    private native NvsVideoTransition nativeSetPackagedTransition(long var1, int var3, String var4);

    private native void nativeSetProxyScale(long var1, NvsRational var3);

    private native NvsTrackCaption natvieGetFirstCaption(long var1);

    private native NvsTrackCompoundCaption natvieGetFirstCompoundCaption(long var1);

    private native NvsTrackCaption natvieGetLastCaption(long var1);

    private native NvsTrackCompoundCaption natvieGetLastCompoundCaption(long var1);

    public NvsTrackAnimatedSticker addAnimatedSticker(long l10, long l11, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        String string3 = new String();
        return this.nativeAddAnimatedSticker(l12, l10, l11, string2, false, false, string3);
    }

    public NvsTrackVideoFx addBuiltinTrackVideoFx(long l10, long l11, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddBuiltinTrackVideoFx(l12, l10, l11, string2);
    }

    public NvsTrackCaption addCaption(String string2, long l10, long l11, String string3) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddCaption(l12, string2, l10, l11, string3, false);
    }

    public NvsVideoClip addClip(String string2, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeAddClip(l11, string2, l10);
    }

    public NvsVideoClip addClip(String string2, long l10, long l11, long l12) {
        NvsUtils.checkFunctionInMainThread();
        long l13 = this.m_internalObject;
        return this.nativeAddClip(l13, string2, l10, l11, l12);
    }

    public NvsTrackCompoundCaption addCompoundCaption(long l10, long l11, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddCompoundCaption(l12, l10, l11, string2);
    }

    public NvsTrackAnimatedSticker addCustomAnimatedSticker(long l10, long l11, String string2, String string3) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddAnimatedSticker(l12, l10, l11, string2, false, true, string3);
    }

    public NvsTrackAnimatedSticker addCustomPanoramicAnimatedSticker(long l10, long l11, String string2, String string3) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddAnimatedSticker(l12, l10, l11, string2, true, true, string3);
    }

    public NvsTrackVideoFx addCustomTrackVideoFx(long l10, long l11, NvsCustomVideoFx$Renderer nvsCustomVideoFx$Renderer) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddCustomTrackVideoFx(l12, l10, l11, nvsCustomVideoFx$Renderer);
    }

    public NvsTrackCaption addModularCaption(String string2, long l10, long l11) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddModularCaption(l12, string2, l10, l11);
    }

    public NvsTrackVideoFx addPackagedTrackVideoFx(long l10, long l11, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddPackagedTrackVideoFx(l12, l10, l11, string2);
    }

    public NvsTrackAnimatedSticker addPanoramicAnimatedSticker(long l10, long l11, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        String string3 = new String();
        return this.nativeAddAnimatedSticker(l12, l10, l11, string2, true, false, string3);
    }

    public NvsTrackCaption addPanoramicCaption(String string2, long l10, long l11, String string3) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddCaption(l12, string2, l10, l11, string3, true);
    }

    public NvsVideoClip appendClip(String string2) {
        NvsUtils.checkFunctionInMainThread();
        int n10 = this.getClipCount();
        return this.insertClip(string2, n10);
    }

    public NvsVideoClip appendClip(String string2, long l10, long l11) {
        NvsUtils.checkFunctionInMainThread();
        int n10 = this.getClipCount();
        return this.insertClip(string2, l10, l11, n10);
    }

    public List getAnimatedStickersByTimelinePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetAnimatedStickersByTimelinePosition(l11, l10);
    }

    public List getCaptionsByTimelinePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetCaptionsByTimelinePosition(l11, l10);
    }

    public NvsVideoClip getClipByIndex(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetClipByIndex(l10, n10);
    }

    public NvsVideoClip getClipByTimelinePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetClipByTimelinePosition(l11, l10);
    }

    public List getCompoundCaptionsByTimelinePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetCompoundCaptionsByTimelinePosition(l11, l10);
    }

    public NvsTrackAnimatedSticker getFirstAnimatedSticker() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFirstAnimatedSticker(l10);
    }

    public NvsTrackCaption getFirstCaption() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.natvieGetFirstCaption(l10);
    }

    public NvsTrackCompoundCaption getFirstCompoundCaption() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.natvieGetFirstCompoundCaption(l10);
    }

    public NvsTrackVideoFx getFirstTrackVideoFx() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFirstTrackVideoFx(l10);
    }

    public NvsTrackAnimatedSticker getLastAnimatedSticker() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetLastAnimatedSticker(l10);
    }

    public NvsTrackCaption getLastCaption() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.natvieGetLastCaption(l10);
    }

    public NvsTrackCompoundCaption getLastCompoundCaption() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.natvieGetLastCompoundCaption(l10);
    }

    public NvsTrackVideoFx getLastTrackVideoFx() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetLastTrackVideoFx(l10);
    }

    public NvsTrackAnimatedSticker getNextAnimatedSticker(NvsTrackAnimatedSticker nvsTrackAnimatedSticker) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetNextAnimatedSticker(l10, nvsTrackAnimatedSticker);
    }

    public NvsTrackCaption getNextCaption(NvsTrackCaption nvsTrackCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetNextCaption(l10, nvsTrackCaption);
    }

    public NvsTrackCompoundCaption getNextCaption(NvsTrackCompoundCaption nvsTrackCompoundCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetNextCompoundCaption(l10, nvsTrackCompoundCaption);
    }

    public NvsTrackVideoFx getNextTrackVideoFx(NvsTrackVideoFx nvsTrackVideoFx) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetNextTrackVideoFx(l10, nvsTrackVideoFx);
    }

    public NvsTrackAnimatedSticker getPrevAnimatedSticker(NvsTrackAnimatedSticker nvsTrackAnimatedSticker) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPrevAnimatedSticker(l10, nvsTrackAnimatedSticker);
    }

    public NvsTrackCaption getPrevCaption(NvsTrackCaption nvsTrackCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPrevCaption(l10, nvsTrackCaption);
    }

    public NvsTrackCompoundCaption getPrevCaption(NvsTrackCompoundCaption nvsTrackCompoundCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPrevCompoundCaption(l10, nvsTrackCompoundCaption);
    }

    public NvsTrackVideoFx getPrevTrackVideoFx(NvsTrackVideoFx nvsTrackVideoFx) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPrevTrackVideoFx(l10, nvsTrackVideoFx);
    }

    public NvsRational getProxyScale() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetProxyScale(l10);
    }

    public List getTrackVideoFxByPosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetTrackVideoFxByPosition(l11, l10);
    }

    public NvsVideoTransition getTransitionBySourceClipIndex(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTransitionBySourceClipIndex(l10, n10);
    }

    public NvsVideoClip insertClip(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertClip(l10, string2, n10);
    }

    public NvsVideoClip insertClip(String string2, long l10, long l11, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeInsertClip(l12, string2, l10, l11, n10);
    }

    public boolean isOriginalRender() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsOriginalRender(l10);
    }

    public NvsTrackAnimatedSticker removeAnimatedSticker(NvsTrackAnimatedSticker nvsTrackAnimatedSticker) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveAnimatedSticker(l10, nvsTrackAnimatedSticker);
    }

    public NvsTrackCaption removeCaption(NvsTrackCaption nvsTrackCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveCaption(l10, nvsTrackCaption);
    }

    public NvsTrackCompoundCaption removeCompoundCaption(NvsTrackCompoundCaption nvsTrackCompoundCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveCompoundCaption(l10, nvsTrackCompoundCaption);
    }

    public NvsTrackVideoFx removeTrackVideoFx(NvsTrackVideoFx nvsTrackVideoFx) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveTrackVideoFx(l10, nvsTrackVideoFx);
    }

    public NvsVideoTransition setBuiltinTransition(int n10, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeSetBuiltinTransition(l10, n10, string2);
    }

    public NvsVideoTransition setCustomVideoTransition(int n10, NvsCustomVideoTransition$Renderer nvsCustomVideoTransition$Renderer) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeSetCustomVideoTransition(l10, n10, nvsCustomVideoTransition$Renderer);
    }

    public void setEnableOriginalRender(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetEnableOriginalRender(l10, bl2);
    }

    public NvsVideoTransition setPackagedTransition(int n10, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeSetPackagedTransition(l10, n10, string2);
    }

    public void setProxyScale(NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetProxyScale(l10, nvsRational);
    }
}

