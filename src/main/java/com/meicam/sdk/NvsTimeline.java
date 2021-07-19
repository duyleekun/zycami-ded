/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsAudioResolution;
import com.meicam.sdk.NvsAudioTrack;
import com.meicam.sdk.NvsCustomVideoFx$Renderer;
import com.meicam.sdk.NvsObject;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsTimeline$PlaybackRateControlRegion;
import com.meicam.sdk.NvsTimelineAnimatedSticker;
import com.meicam.sdk.NvsTimelineCaption;
import com.meicam.sdk.NvsTimelineCompoundCaption;
import com.meicam.sdk.NvsTimelineVideoFx;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsVideoResolution;
import com.meicam.sdk.NvsVideoTrack;
import com.meicam.sdk.NvsVolume;
import java.util.List;

public class NvsTimeline
extends NvsObject {
    public static final int NvsTimelineWatermarkPosition_BottomLeft = 2;
    public static final int NvsTimelineWatermarkPosition_BottomRight = 3;
    public static final int NvsTimelineWatermarkPosition_TopLeft = 1;
    public static final int NvsTimelineWatermarkPosition_TopRight;

    private native NvsTimelineAnimatedSticker nativeAddAnimatedSticker(long var1, long var3, long var5, String var7, boolean var8, boolean var9, String var10);

    private native NvsTimelineVideoFx nativeAddBuiltinTimelineVideoFx(long var1, long var3, long var5, String var7);

    private native NvsTimelineCaption nativeAddCaption(long var1, String var3, long var4, long var6, String var8, boolean var9);

    private native NvsTimelineCompoundCaption nativeAddCompoundCaption(long var1, long var3, long var5, String var7);

    private native NvsTimelineVideoFx nativeAddCustomTimelineVideoFx(long var1, long var3, long var5, NvsCustomVideoFx$Renderer var7);

    private native NvsTimelineCaption nativeAddModularCaption(long var1, String var3, long var4, long var6);

    private native NvsTimelineVideoFx nativeAddPackagedTimelineVideoFx(long var1, long var3, long var5, String var7);

    private native boolean nativeAddWatermark(long var1, String var3, int var4, int var5, float var6, int var7, int var8, int var9);

    private native NvsAudioTrack nativeAppendAudioTrack(long var1);

    private native NvsVideoTrack nativeAppendVideoTrack(long var1);

    private native boolean nativeApplyTheme(long var1, String var3);

    private native int nativeAudioTrackCount(long var1);

    private native void nativeCaptureCaptionParameters(long var1, NvsTimelineCaption var3);

    private native void nativeCaptureCompoundCaptionParameters(long var1, NvsTimelineCompoundCaption var3);

    private native boolean nativeChangeVideoSize(long var1, int var3, int var4);

    private native void nativeDeleteWatermark(long var1);

    private native List nativeGetAnimatedStickersByTimelinePosition(long var1, long var3);

    private native long nativeGetAudioFadeOutDuration(long var1);

    private native NvsAudioResolution nativeGetAudioRes(long var1);

    private native NvsAudioTrack nativeGetAudioTrackByIndex(long var1, int var3);

    private native List nativeGetCaptionsByTimelinePosition(long var1, long var3);

    private native List nativeGetCompoundCaptionsByTimelinePosition(long var1, long var3);

    private native String nativeGetCurrentThemeId(long var1);

    private native long nativeGetDuration(long var1);

    private native NvsTimelineAnimatedSticker nativeGetFirstAnimatedSticker(long var1);

    private native NvsTimelineVideoFx nativeGetFirstTimelineVideoFx(long var1);

    private native NvsTimelineAnimatedSticker nativeGetLastAnimatedSticker(long var1);

    private native NvsTimelineVideoFx nativeGetLastTimelineVideoFx(long var1);

    private native NvsTimelineAnimatedSticker nativeGetNextAnimatedSticker(long var1, NvsTimelineAnimatedSticker var3);

    private native NvsTimelineCaption nativeGetNextCaption(long var1, NvsTimelineCaption var3);

    private native NvsTimelineCompoundCaption nativeGetNextCompoundCaption(long var1, NvsTimelineCompoundCaption var3);

    private native NvsTimelineVideoFx nativeGetNextTimelineVideoFx(long var1, NvsTimelineVideoFx var3);

    private native NvsTimeline$PlaybackRateControlRegion[] nativeGetPlaybackRateControl(long var1);

    private native NvsTimelineAnimatedSticker nativeGetPrevAnimatedSticker(long var1, NvsTimelineAnimatedSticker var3);

    private native NvsTimelineCaption nativeGetPrevCaption(long var1, NvsTimelineCaption var3);

    private native NvsTimelineCompoundCaption nativeGetPrevCompoundCaption(long var1, NvsTimelineCompoundCaption var3);

    private native NvsTimelineVideoFx nativeGetPrevTimelineVideoFx(long var1, NvsTimelineVideoFx var3);

    private native NvsVolume nativeGetThemeMusicVolumeGain(long var1);

    private native List nativeGetTimelineVideoFxByTimelinePosition(long var1, long var3);

    private native NvsRational nativeGetVideoFps(long var1);

    private native NvsVideoResolution nativeGetVideoRes(long var1);

    private native NvsVideoTrack nativeGetVideoTrackByIndex(long var1, int var3);

    private native NvsAudioTrack nativeInsertAudioTrack(long var1, int var3);

    private native NvsVideoTrack nativeInsertVideoTrack(long var1, int var3);

    private native boolean nativeMoveVideoTrack(long var1, int var3, int var4);

    private native NvsTimelineAnimatedSticker nativeRemoveAnimatedSticker(long var1, NvsTimelineAnimatedSticker var3);

    private native boolean nativeRemoveAudioTrack(long var1, int var3);

    private native NvsTimelineCaption nativeRemoveCaption(long var1, NvsTimelineCaption var3);

    private native NvsTimelineCompoundCaption nativeRemoveCompoundCaption(long var1, NvsTimelineCompoundCaption var3);

    private native void nativeRemoveCurrentTheme(long var1);

    private native void nativeRemoveTimelineEndingLogo(long var1);

    private native NvsTimelineVideoFx nativeRemoveTimelineVideoFx(long var1, NvsTimelineVideoFx var3);

    private native boolean nativeRemoveVideoTrack(long var1, int var3);

    private native void nativeSetAudioFadeOutDuration(long var1, long var3);

    private native void nativeSetCaptionBoundingRectMode(long var1, boolean var3);

    private native void nativeSetPlaybackRateControl(long var1, NvsTimeline$PlaybackRateControlRegion[] var3);

    private native void nativeSetThemeMusicVolumeGain(long var1, float var3, float var4);

    private native void nativeSetThemeTitleCaptionText(long var1, String var3);

    private native void nativeSetThemeTrailerCaptionText(long var1, String var3);

    private native boolean nativeSetTimelineEndingLogo(long var1, String var3, int var4, int var5, int var6, int var7);

    private native boolean nativeSetWatermarkOpacity(long var1, float var3);

    private native void nativeSetupInputCacheForCaption(long var1, NvsTimelineCaption var3, long var4);

    private native int nativeVideoTrackCount(long var1);

    private native void natvieEnableRenderOrderByZValue(long var1, boolean var3);

    private native NvsTimelineCaption natvieGetFirstCaption(long var1);

    private native NvsTimelineCompoundCaption natvieGetFirstCompoundCaption(long var1);

    private native NvsTimelineCaption natvieGetLastCaption(long var1);

    private native NvsTimelineCompoundCaption natvieGetLastCompoundCaption(long var1);

    private native boolean natvieIsRenderOrderByZValueEnabled(long var1);

    public NvsTimelineAnimatedSticker addAnimatedSticker(long l10, long l11, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        String string3 = new String();
        return this.nativeAddAnimatedSticker(l12, l10, l11, string2, false, false, string3);
    }

    public NvsTimelineVideoFx addBuiltinTimelineVideoFx(long l10, long l11, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddBuiltinTimelineVideoFx(l12, l10, l11, string2);
    }

    public NvsTimelineCaption addCaption(String string2, long l10, long l11, String string3) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddCaption(l12, string2, l10, l11, string3, false);
    }

    public NvsTimelineCompoundCaption addCompoundCaption(long l10, long l11, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddCompoundCaption(l12, l10, l11, string2);
    }

    public NvsTimelineAnimatedSticker addCustomAnimatedSticker(long l10, long l11, String string2, String string3) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddAnimatedSticker(l12, l10, l11, string2, false, true, string3);
    }

    public NvsTimelineAnimatedSticker addCustomPanoramicAnimatedSticker(long l10, long l11, String string2, String string3) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddAnimatedSticker(l12, l10, l11, string2, true, true, string3);
    }

    public NvsTimelineVideoFx addCustomTimelineVideoFx(long l10, long l11, NvsCustomVideoFx$Renderer nvsCustomVideoFx$Renderer) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddCustomTimelineVideoFx(l12, l10, l11, nvsCustomVideoFx$Renderer);
    }

    public NvsTimelineCaption addModularCaption(String string2, long l10, long l11) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddModularCaption(l12, string2, l10, l11);
    }

    public NvsTimelineVideoFx addPackagedTimelineVideoFx(long l10, long l11, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddPackagedTimelineVideoFx(l12, l10, l11, string2);
    }

    public NvsTimelineAnimatedSticker addPanoramicAnimatedSticker(long l10, long l11, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        String string3 = new String();
        return this.nativeAddAnimatedSticker(l12, l10, l11, string2, true, false, string3);
    }

    public NvsTimelineCaption addPanoramicCaption(String string2, long l10, long l11, String string3) {
        NvsUtils.checkFunctionInMainThread();
        long l12 = this.m_internalObject;
        return this.nativeAddCaption(l12, string2, l10, l11, string3, true);
    }

    public boolean addWatermark(String string2, int n10, int n11, float f10, int n12, int n13, int n14) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeAddWatermark(l10, string2, n10, n11, f10, n12, n13, n14);
    }

    public NvsAudioTrack appendAudioTrack() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeAppendAudioTrack(l10);
    }

    public NvsVideoTrack appendVideoTrack() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeAppendVideoTrack(l10);
    }

    public boolean applyTheme(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeApplyTheme(l10, string2);
    }

    public int audioTrackCount() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeAudioTrackCount(l10);
    }

    public void captureCaptionParameters(NvsTimelineCaption nvsTimelineCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeCaptureCaptionParameters(l10, nvsTimelineCaption);
    }

    public void captureCompoundCaptionParameters(NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeCaptureCompoundCaptionParameters(l10, nvsTimelineCompoundCaption);
    }

    public boolean changeVideoSize(int n10, int n11) {
        long l10 = this.m_internalObject;
        return this.nativeChangeVideoSize(l10, n10, n11);
    }

    public void deleteWatermark() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeDeleteWatermark(l10);
    }

    public void enableRenderOrderByZValue(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.natvieEnableRenderOrderByZValue(l10, bl2);
    }

    public List getAnimatedStickersByTimelinePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetAnimatedStickersByTimelinePosition(l11, l10);
    }

    public long getAudioFadeOutDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAudioFadeOutDuration(l10);
    }

    public NvsAudioResolution getAudioRes() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAudioRes(l10);
    }

    public NvsAudioTrack getAudioTrackByIndex(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAudioTrackByIndex(l10, n10);
    }

    public List getCaptionsByTimelinePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetCaptionsByTimelinePosition(l11, l10);
    }

    public List getCompoundCaptionsByTimelinePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetCompoundCaptionsByTimelinePosition(l11, l10);
    }

    public String getCurrentThemeId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCurrentThemeId(l10);
    }

    public long getDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetDuration(l10);
    }

    public NvsTimelineAnimatedSticker getFirstAnimatedSticker() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFirstAnimatedSticker(l10);
    }

    public NvsTimelineCaption getFirstCaption() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.natvieGetFirstCaption(l10);
    }

    public NvsTimelineCompoundCaption getFirstCompoundCaption() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.natvieGetFirstCompoundCaption(l10);
    }

    public NvsTimelineVideoFx getFirstTimelineVideoFx() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFirstTimelineVideoFx(l10);
    }

    public NvsTimelineAnimatedSticker getLastAnimatedSticker() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetLastAnimatedSticker(l10);
    }

    public NvsTimelineCaption getLastCaption() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.natvieGetLastCaption(l10);
    }

    public NvsTimelineCompoundCaption getLastCompoundCaption() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.natvieGetLastCompoundCaption(l10);
    }

    public NvsTimelineVideoFx getLastTimelineVideoFx() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetLastTimelineVideoFx(l10);
    }

    public NvsTimelineAnimatedSticker getNextAnimatedSticker(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetNextAnimatedSticker(l10, nvsTimelineAnimatedSticker);
    }

    public NvsTimelineCaption getNextCaption(NvsTimelineCaption nvsTimelineCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetNextCaption(l10, nvsTimelineCaption);
    }

    public NvsTimelineCompoundCaption getNextCaption(NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetNextCompoundCaption(l10, nvsTimelineCompoundCaption);
    }

    public NvsTimelineVideoFx getNextTimelineVideoFx(NvsTimelineVideoFx nvsTimelineVideoFx) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetNextTimelineVideoFx(l10, nvsTimelineVideoFx);
    }

    public NvsTimeline$PlaybackRateControlRegion[] getPlaybackRateControl() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPlaybackRateControl(l10);
    }

    public NvsTimelineAnimatedSticker getPrevAnimatedSticker(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPrevAnimatedSticker(l10, nvsTimelineAnimatedSticker);
    }

    public NvsTimelineCaption getPrevCaption(NvsTimelineCaption nvsTimelineCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPrevCaption(l10, nvsTimelineCaption);
    }

    public NvsTimelineCompoundCaption getPrevCaption(NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPrevCompoundCaption(l10, nvsTimelineCompoundCaption);
    }

    public NvsTimelineVideoFx getPrevTimelineVideoFx(NvsTimelineVideoFx nvsTimelineVideoFx) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPrevTimelineVideoFx(l10, nvsTimelineVideoFx);
    }

    public NvsVolume getThemeMusicVolumeGain() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetThemeMusicVolumeGain(l10);
    }

    public List getTimelineVideoFxByTimelinePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeGetTimelineVideoFxByTimelinePosition(l11, l10);
    }

    public NvsRational getVideoFps() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoFps(l10);
    }

    public NvsVideoResolution getVideoRes() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoRes(l10);
    }

    public NvsVideoTrack getVideoTrackByIndex(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoTrackByIndex(l10, n10);
    }

    public NvsAudioTrack insertAudioTrack(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertAudioTrack(l10, n10);
    }

    public NvsVideoTrack insertVideoTrack(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertVideoTrack(l10, n10);
    }

    public boolean isRenderOrderByZValueEnabled() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.natvieIsRenderOrderByZValueEnabled(l10);
    }

    public boolean moveVideoTrack(int n10, int n11) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeMoveVideoTrack(l10, n10, n11);
    }

    public NvsTimelineAnimatedSticker removeAnimatedSticker(NvsTimelineAnimatedSticker nvsTimelineAnimatedSticker) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveAnimatedSticker(l10, nvsTimelineAnimatedSticker);
    }

    public boolean removeAudioTrack(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveAudioTrack(l10, n10);
    }

    public NvsTimelineCaption removeCaption(NvsTimelineCaption nvsTimelineCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveCaption(l10, nvsTimelineCaption);
    }

    public NvsTimelineCompoundCaption removeCompoundCaption(NvsTimelineCompoundCaption nvsTimelineCompoundCaption) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveCompoundCaption(l10, nvsTimelineCompoundCaption);
    }

    public void removeCurrentTheme() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeRemoveCurrentTheme(l10);
    }

    public void removeTimelineEndingLogo() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeRemoveTimelineEndingLogo(l10);
    }

    public NvsTimelineVideoFx removeTimelineVideoFx(NvsTimelineVideoFx nvsTimelineVideoFx) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveTimelineVideoFx(l10, nvsTimelineVideoFx);
    }

    public boolean removeVideoTrack(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveVideoTrack(l10, n10);
    }

    public void setAudioFadeOutDuration(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeSetAudioFadeOutDuration(l11, l10);
    }

    public void setCaptionBoundingRectInActualMode(boolean bl2) {
        long l10 = this.m_internalObject;
        this.nativeSetCaptionBoundingRectMode(l10, bl2);
    }

    public void setPlaybackRateControl(NvsTimeline$PlaybackRateControlRegion[] nvsTimeline$PlaybackRateControlRegionArray) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetPlaybackRateControl(l10, nvsTimeline$PlaybackRateControlRegionArray);
    }

    public void setThemeMusicVolumeGain(float f10, float f11) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetThemeMusicVolumeGain(l10, f10, f11);
    }

    public void setThemeTitleCaptionText(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetThemeTitleCaptionText(l10, string2);
    }

    public void setThemeTrailerCaptionText(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetThemeTrailerCaptionText(l10, string2);
    }

    public boolean setTimelineEndingLogo(String string2, int n10, int n11, int n12, int n13) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeSetTimelineEndingLogo(l10, string2, n10, n11, n12, n13);
    }

    public boolean setWatermarkOpacity(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeSetWatermarkOpacity(l10, f10);
    }

    public void setupInputCacheForCaption(NvsTimelineCaption nvsTimelineCaption, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeSetupInputCacheForCaption(l11, nvsTimelineCaption, l10);
    }

    public int videoTrackCount() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeVideoTrackCount(l10);
    }
}

