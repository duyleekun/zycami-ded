/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package com.meicam.sdk;

import android.graphics.RectF;
import com.meicam.sdk.NvsClip;
import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsCustomVideoFx$Renderer;
import com.meicam.sdk.NvsPanAndScan;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsVideoFx;

public class NvsVideoClip
extends NvsClip {
    public static final int CLIP_BLENDING_MODE_ADD = 4;
    public static final int CLIP_BLENDING_MODE_BURN = 7;
    public static final int CLIP_BLENDING_MODE_DARKEN = 6;
    public static final int CLIP_BLENDING_MODE_DIFFERENCE = 18;
    public static final int CLIP_BLENDING_MODE_DODGE = 10;
    public static final int CLIP_BLENDING_MODE_EXCLUSION = 5;
    public static final int CLIP_BLENDING_MODE_HARD_LIGHT = 13;
    public static final int CLIP_BLENDING_MODE_HARD_MIX = 17;
    public static final int CLIP_BLENDING_MODE_LIGHTEN = 9;
    public static final int CLIP_BLENDING_MODE_LINEAR_BURN = 8;
    public static final int CLIP_BLENDING_MODE_LINEAR_LIGHT = 16;
    public static final int CLIP_BLENDING_MODE_MULTIPLY = 1;
    public static final int CLIP_BLENDING_MODE_NORMAL = 0;
    public static final int CLIP_BLENDING_MODE_OVERLAY = 11;
    public static final int CLIP_BLENDING_MODE_PIN_LIGHT = 15;
    public static final int CLIP_BLENDING_MODE_SCREEN = 3;
    public static final int CLIP_BLENDING_MODE_SOFT_LIGHT = 12;
    public static final int CLIP_BLENDING_MODE_SUBTRACT = 2;
    public static final int CLIP_BLENDING_MODE_VIVID_LIGHT = 14;
    public static final int CLIP_MOTIONMODE_LETTERBOX_ZOOMIN = 0;
    public static final int CLIP_WRAPMODE_REPEAT_LASTFRAME = 0;
    public static final int ClIP_BACKGROUNDMODE_BLUR = 1;
    public static final int ClIP_BACKGROUNDMODE_COLOR_SOLID = 0;
    public static final int ClIP_EXTRAVIDEOROTATION_0 = 0;
    public static final int ClIP_EXTRAVIDEOROTATION_180 = 2;
    public static final int ClIP_EXTRAVIDEOROTATION_270 = 3;
    public static final int ClIP_EXTRAVIDEOROTATION_90 = 1;
    public static final int ClIP_MOTIONMODE_LETTERBOX_ZOOMOUT = 1;
    public static final int ClIP_WRAPMODE_REPEAT = 2;
    public static final int ClIP_WRAPMODE_REPEAT_FIRSTFRAME = 1;
    public static final int IMAGE_CLIP_MOTIONMMODE_ROI = 2;
    public static final int ROLE_IN_THEME_GENERAL = 0;
    public static final int ROLE_IN_THEME_TITLE = 1;
    public static final int ROLE_IN_THEME_TRAILER = 2;
    public static final int VIDEO_CLIP_DECODE_TEMPORAL_LAYER_1 = 1;
    public static final int VIDEO_CLIP_DECODE_TEMPORAL_LAYER_2 = 2;
    public static final int VIDEO_CLIP_DECODE_TEMPORAL_LAYER_3 = 3;
    public static final int VIDEO_CLIP_DECODE_TEMPORAL_LAYER_BASE = 0;
    public static final int VIDEO_CLIP_DECODE_TEMPORAL_LAYER_NONE = 255;
    public static final int VIDEO_CLIP_TYPE_AV = 0;
    public static final int VIDEO_CLIP_TYPE_IMAGE = 1;

    private native NvsVideoFx nativeAppendBeautyFx(long var1);

    private native NvsVideoFx nativeAppendBuiltinFx(long var1, String var3, boolean var4);

    private native NvsVideoFx nativeAppendPackagedFx(long var1, String var3, boolean var4);

    private native void nativeChangeVariableSpeed(long var1, double var3, double var5, boolean var7);

    private native void nativeDisableAmbiguousCrop(long var1, boolean var3);

    private native void nativeEnableClipFreezeFrame(long var1, boolean var3);

    private native void nativeEnableClipHDR(long var1, boolean var3);

    private native void nativeEnablePropertyVideoFx(long var1, boolean var3);

    private native void nativeEnableSlowMotionBlended(long var1, boolean var3);

    private native void nativeEnableVideoClipROI(long var1, boolean var3);

    private native long nativeGetAudioFadeInDuration(long var1);

    private native long nativeGetAudioFadeOutDuration(long var1);

    private native int nativeGetBlendingMode(long var1);

    private native long nativeGetClipFreezeFrameTrimPosition(long var1);

    private native int nativeGetClipWrapMode(long var1);

    private native RectF nativeGetEndROI(long var1);

    private native double nativeGetEndSpeed(long var1);

    private native int nativeGetExtraVideoRotation(long var1);

    private native NvsVideoFx nativeGetFxByIndex(long var1, int var3, boolean var4);

    private native RectF nativeGetImageMaskROI(long var1);

    private native boolean nativeGetImageMotionAnimationEnabled(long var1);

    private native int nativeGetImageMotionMode(long var1);

    private native float nativeGetOpacity(long var1);

    private native NvsPanAndScan nativeGetPanAndScan(long var1);

    private native boolean nativeGetPlayInReverse(long var1);

    private native NvsVideoFx nativeGetPropertyVideoFx(long var1);

    private native int nativeGetRawFxCount(long var1);

    private native int nativeGetRoleInTheme(long var1);

    private native NvsColor nativeGetSourceBackgroundColor(long var1);

    private native int nativeGetSourceBackgroundMode(long var1);

    private native RectF nativeGetStartROI(long var1);

    private native double nativeGetStartSpeed(long var1);

    private native int nativeGetVideoType(long var1);

    private native NvsVideoFx nativeInsertBeautyFx(long var1, int var3);

    private native NvsVideoFx nativeInsertBuiltinFx(long var1, String var3, int var4, boolean var5);

    private native NvsVideoFx nativeInsertCustomFx(long var1, NvsCustomVideoFx$Renderer var3, int var4, boolean var5);

    private native NvsVideoFx nativeInsertPackagedFx(long var1, String var3, int var4, boolean var5);

    private native boolean nativeIsAmbiguousCropDisabled(long var1);

    private native boolean nativeIsClipFreezeFrameEnabled(long var1);

    private native boolean nativeIsClipHDREnabled(long var1);

    private native boolean nativeIsOriginalRender(long var1);

    private native boolean nativeIsPropertyVideoFxEnabled(long var1);

    private native boolean nativeIsSlowMotionBlended(long var1);

    private native boolean nativeIsSoftWareDeocdingUsed(long var1);

    private native boolean nativeIsVideoClipROIEnabled(long var1);

    private native boolean nativeRemoveAllFx(long var1);

    private native boolean nativeRemoveFx(long var1, int var3, boolean var4);

    private native void nativeSetAudioFadeInDuration(long var1, long var3);

    private native void nativeSetAudioFadeOutDuration(long var1, long var3);

    private native void nativeSetBlendingMode(long var1, int var3);

    private native void nativeSetClipFreezeFrameTrimPosition(long var1, long var3);

    private native void nativeSetClipWrapMode(long var1, int var3);

    private native NvsVideoFx nativeSetCustomPropertyVideoFx(long var1, NvsCustomVideoFx$Renderer var3);

    private native void nativeSetDecodeTemporalLayer(long var1, int var3);

    private native void nativeSetEnableOriginalRender(long var1, boolean var3);

    private native void nativeSetExtraVideoRotation(long var1, int var3);

    private native void nativeSetExtraVideoRotation2(long var1, int var3, boolean var4);

    private native void nativeSetImageMaskROI(long var1, RectF var3);

    private native void nativeSetImageMotionAnimationEnabled(long var1, boolean var3);

    private native void nativeSetImageMotionMode(long var1, int var3);

    private native void nativeSetImageMotionROI(long var1, RectF var3, RectF var4);

    private native void nativeSetOpacity(long var1, float var3);

    private native void nativeSetPanAndScan(long var1, float var3, float var4);

    private native void nativeSetPlayInReverse(long var1, boolean var3);

    private native void nativeSetSoftWareDecoding(long var1, boolean var3);

    private native void nativeSetSourceBackgroundColor(long var1, NvsColor var3);

    private native void nativeSetSourceBackgroundMode(long var1, int var3);

    public NvsVideoFx appendBeautyFx() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeAppendBeautyFx(l10);
    }

    public NvsVideoFx appendBuiltinFx(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeAppendBuiltinFx(l10, string2, false);
    }

    public NvsVideoFx appendCustomFx(NvsCustomVideoFx$Renderer nvsCustomVideoFx$Renderer) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        int n10 = this.getFxCount();
        return this.nativeInsertCustomFx(l10, nvsCustomVideoFx$Renderer, n10, false);
    }

    public NvsVideoFx appendPackagedFx(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeAppendPackagedFx(l10, string2, false);
    }

    public NvsVideoFx appendRawBuiltinFx(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeAppendBuiltinFx(l10, string2, true);
    }

    public NvsVideoFx appendRawCustomFx(NvsCustomVideoFx$Renderer nvsCustomVideoFx$Renderer) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        int n10 = this.getRawFxCount();
        return this.nativeInsertCustomFx(l10, nvsCustomVideoFx$Renderer, n10, true);
    }

    public NvsVideoFx appendRawPackagedFx(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeAppendPackagedFx(l10, string2, true);
    }

    public void changeVariableSpeed(double d10, double d11, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeChangeVariableSpeed(l10, d10, d11, bl2);
    }

    public void disableAmbiguousCrop(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeDisableAmbiguousCrop(l10, bl2);
    }

    public void enableClipFreezeFrame(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeEnableClipFreezeFrame(l10, bl2);
    }

    public void enableClipHDR(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeEnableClipHDR(l10, bl2);
    }

    public void enablePropertyVideoFx(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeEnablePropertyVideoFx(l10, bl2);
    }

    public void enableSlowMotionBlended(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeEnableSlowMotionBlended(l10, bl2);
    }

    public void enableVideoClipROI(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeEnableVideoClipROI(l10, bl2);
    }

    public long getAudioFadeInDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAudioFadeInDuration(l10);
    }

    public long getAudioFadeOutDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAudioFadeOutDuration(l10);
    }

    public int getBlendingMode() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetBlendingMode(l10);
    }

    public long getClipFreezeFrameTrimPosition() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetClipFreezeFrameTrimPosition(l10);
    }

    public int getClipWrapMode() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetClipWrapMode(l10);
    }

    public RectF getEndROI() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetEndROI(l10);
    }

    public double getEndSpeed() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetEndSpeed(l10);
    }

    public int getExtraVideoRotation() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetExtraVideoRotation(l10);
    }

    public NvsVideoFx getFxByIndex(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFxByIndex(l10, n10, false);
    }

    public RectF getImageMaskROI() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetImageMaskROI(l10);
    }

    public boolean getImageMotionAnimationEnabled() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetImageMotionAnimationEnabled(l10);
    }

    public int getImageMotionMode() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetImageMotionMode(l10);
    }

    public float getOpacity() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOpacity(l10);
    }

    public NvsPanAndScan getPanAndScan() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPanAndScan(l10);
    }

    public boolean getPlayInReverse() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPlayInReverse(l10);
    }

    public NvsVideoFx getPropertyVideoFx() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPropertyVideoFx(l10);
    }

    public NvsVideoFx getRawFxByIndex(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFxByIndex(l10, n10, true);
    }

    public int getRawFxCount() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetRawFxCount(l10);
    }

    public int getRoleInTheme() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetRoleInTheme(l10);
    }

    public NvsColor getSourceBackgroundColor() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetSourceBackgroundColor(l10);
    }

    public int getSourceBackgroundMode() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetSourceBackgroundMode(l10);
    }

    public RectF getStartROI() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetStartROI(l10);
    }

    public double getStartSpeed() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetStartSpeed(l10);
    }

    public int getVideoType() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoType(l10);
    }

    public NvsVideoFx insertBeautyFx(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertBeautyFx(l10, n10);
    }

    public NvsVideoFx insertBuiltinFx(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertBuiltinFx(l10, string2, n10, false);
    }

    public NvsVideoFx insertCustomFx(NvsCustomVideoFx$Renderer nvsCustomVideoFx$Renderer, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertCustomFx(l10, nvsCustomVideoFx$Renderer, n10, false);
    }

    public NvsVideoFx insertPackagedFx(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertPackagedFx(l10, string2, n10, false);
    }

    public NvsVideoFx insertRawBuiltinFx(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertBuiltinFx(l10, string2, n10, true);
    }

    public NvsVideoFx insertRawCustomFx(NvsCustomVideoFx$Renderer nvsCustomVideoFx$Renderer, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertCustomFx(l10, nvsCustomVideoFx$Renderer, n10, true);
    }

    public NvsVideoFx insertRawPackagedFx(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInsertPackagedFx(l10, string2, n10, true);
    }

    public boolean isAmbiguousCropDisabled() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsAmbiguousCropDisabled(l10);
    }

    public boolean isClipFreezeFrameEnabled() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsClipFreezeFrameEnabled(l10);
    }

    public boolean isClipHDREnabled() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsClipHDREnabled(l10);
    }

    public boolean isOriginalRender() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsOriginalRender(l10);
    }

    public boolean isPropertyVideoFxEnabled() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsPropertyVideoFxEnabled(l10);
    }

    public boolean isSlowMotionBlended() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsSlowMotionBlended(l10);
    }

    public boolean isSoftWareDeocedUsed() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsSoftWareDeocdingUsed(l10);
    }

    public boolean isVideoClipROIEnabled() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsVideoClipROIEnabled(l10);
    }

    public boolean removeAllFx() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveAllFx(l10);
    }

    public boolean removeFx(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveFx(l10, n10, false);
    }

    public boolean removeRawFx(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeRemoveFx(l10, n10, true);
    }

    public void setAudioFadeInDuration(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeSetAudioFadeInDuration(l11, l10);
    }

    public void setAudioFadeOutDuration(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeSetAudioFadeOutDuration(l11, l10);
    }

    public void setBlendingMode(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetBlendingMode(l10, n10);
    }

    public void setClipFreezeFrameTrimPosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeSetClipFreezeFrameTrimPosition(l11, l10);
    }

    public void setClipWrapMode(int n10) {
        int n11;
        NvsUtils.checkFunctionInMainThread();
        if (n10 >= 0 && n10 <= (n11 = 2)) {
            long l10 = this.m_internalObject;
            this.nativeSetClipWrapMode(l10, n10);
        }
    }

    public NvsVideoFx setCustomPropertyVideoFx(NvsCustomVideoFx$Renderer nvsCustomVideoFx$Renderer) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeSetCustomPropertyVideoFx(l10, nvsCustomVideoFx$Renderer);
    }

    public void setDecodeTemporalLayer(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetDecodeTemporalLayer(l10, n10);
    }

    public void setEnableOriginalRender(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetEnableOriginalRender(l10, bl2);
    }

    public void setExtraVideoRotation(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetExtraVideoRotation(l10, n10);
    }

    public void setExtraVideoRotation(int n10, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetExtraVideoRotation2(l10, n10, bl2);
    }

    public void setImageMaskROI(RectF rectF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetImageMaskROI(l10, rectF);
    }

    public void setImageMotionAnimationEnabled(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetImageMotionAnimationEnabled(l10, bl2);
    }

    public void setImageMotionMode(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetImageMotionMode(l10, n10);
    }

    public void setImageMotionROI(RectF rectF, RectF rectF2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetImageMotionROI(l10, rectF, rectF2);
    }

    public void setOpacity(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetOpacity(l10, f10);
    }

    public void setPanAndScan(float f10, float f11) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetPanAndScan(l10, f10, f11);
    }

    public void setPlayInReverse(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetPlayInReverse(l10, bl2);
    }

    public void setSoftWareDecoding(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetSoftWareDecoding(l10, bl2);
    }

    public void setSourceBackgroundColor(NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetSourceBackgroundColor(l10, nvsColor);
    }

    public void setSourceBackgroundMode(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetSourceBackgroundMode(l10, n10);
    }
}

