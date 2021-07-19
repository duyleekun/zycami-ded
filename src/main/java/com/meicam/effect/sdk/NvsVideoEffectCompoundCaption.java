/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package com.meicam.effect.sdk;

import android.graphics.PointF;
import com.meicam.effect.sdk.NvsEffect;
import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsVideoResolution;
import java.util.List;

public class NvsVideoEffectCompoundCaption
extends NvsEffect {
    public static final int BOUNDING_TYPE_FRAME = 2;
    public static final int BOUNDING_TYPE_TEXT = 0;
    public static final int BOUNDING_TYPE_TEXT_FRAME = 1;

    private native long nativeChangeInPoint(long var1, long var3);

    private native long nativeChangeOutPoint(long var1, long var3);

    private native PointF nativeGetAnchorPoint(long var1);

    private native List nativeGetCaptionBoundingVertices(long var1, int var3, int var4);

    private native int nativeGetCaptionCount(long var1);

    private native String nativeGetCaptionStylePackageId(long var1);

    private native PointF nativeGetCaptionTranslation(long var1);

    private native List nativeGetCompoundBoundingVertices(long var1, int var3);

    private native String nativeGetFontFamily(long var1, int var3);

    private native long nativeGetInPoint(long var1);

    private native float nativeGetOpacity(long var1);

    private native long nativeGetOutPoint(long var1);

    private native float nativeGetRotationZ(long var1);

    private native float nativeGetScaleX(long var1);

    private native float nativeGetScaleY(long var1);

    private native String nativeGetText(long var1, int var3);

    private native NvsColor nativeGetTextColor(long var1, int var3);

    private native float nativeGetZValue(long var1);

    private native void nativeMovePosition(long var1, long var3);

    private native void nativeRotateCaption(long var1, float var3, PointF var4);

    private native void nativeScaleCaption(long var1, float var3, PointF var4);

    private native void nativeSetAnchorPoint(long var1, PointF var3);

    private native void nativeSetCaptionTranslation(long var1, PointF var3);

    private native void nativeSetFontFamily(long var1, int var3, String var4);

    private native void nativeSetOpacity(long var1, float var3);

    private native void nativeSetRotationZ(long var1, float var3);

    private native void nativeSetScaleX(long var1, float var3);

    private native void nativeSetScaleY(long var1, float var3);

    private native void nativeSetText(long var1, int var3, String var4);

    private native void nativeSetTextColor(long var1, int var3, NvsColor var4);

    private native void nativeSetVideoResolution(long var1, NvsVideoResolution var3);

    private native void nativeSetZValue(long var1, float var3);

    private native void nativeTranslateCaption(long var1, PointF var3);

    public long changeInPoint(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeChangeInPoint(l11, l10);
    }

    public long changeOutPoint(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        return this.nativeChangeOutPoint(l11, l10);
    }

    public PointF getAnchorPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAnchorPoint(l10);
    }

    public List getCaptionBoundingVertices(int n10, int n11) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptionBoundingVertices(l10, n10, n11);
    }

    public int getCaptionCount() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptionCount(l10);
    }

    public String getCaptionStylePackageId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptionStylePackageId(l10);
    }

    public PointF getCaptionTranslation() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptionTranslation(l10);
    }

    public List getCompoundBoundingVertices(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCompoundBoundingVertices(l10, n10);
    }

    public String getFontFamily(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFontFamily(l10, n10);
    }

    public long getInPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetInPoint(l10);
    }

    public float getOpacity() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOpacity(l10);
    }

    public long getOutPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOutPoint(l10);
    }

    public float getRotationZ() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetRotationZ(l10);
    }

    public float getScaleX() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetScaleX(l10);
    }

    public float getScaleY() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetScaleY(l10);
    }

    public String getText(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetText(l10, n10);
    }

    public NvsColor getTextColor(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTextColor(l10, n10);
    }

    public float getZValue() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetZValue(l10);
    }

    public void movePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeMovePosition(l11, l10);
    }

    public void rotateCaption(float f10, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeRotateCaption(l10, f10, pointF);
    }

    public void rotateCaptionAroundCenter(float f10, int n10) {
        int n11;
        int n12;
        List list = this.getCompoundBoundingVertices(n10);
        if (list != null && (n12 = list.size()) == (n11 = 4)) {
            float f11 = 0.0f;
            float f12 = 0.0f;
            float f13 = 0.0f;
            for (n12 = 0; n12 < n11; ++n12) {
                PointF pointF = (PointF)list.get(n12);
                float f14 = pointF.x;
                f12 += f14;
                float f15 = pointF.y;
                f13 += f15;
            }
            n12 = 0x40800000;
            f11 = 4.0f;
            list = new PointF(f12 /= f11, f13 /= f11);
            this.rotateCaption(f10, (PointF)list);
        }
    }

    public void scaleCaption(float f10, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeScaleCaption(l10, f10, pointF);
    }

    public void setAnchorPoint(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetAnchorPoint(l10, pointF);
    }

    public void setCaptionTranslation(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetCaptionTranslation(l10, pointF);
    }

    public void setFontFamily(int n10, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetFontFamily(l10, n10, string2);
    }

    public void setOpacity(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetOpacity(l10, f10);
    }

    public void setRotationZ(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetRotationZ(l10, f10);
    }

    public void setScaleX(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetScaleX(l10, f10);
    }

    public void setScaleY(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetScaleY(l10, f10);
    }

    public void setText(int n10, String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetText(l10, n10, string2);
    }

    public void setTextColor(int n10, NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetTextColor(l10, n10, nvsColor);
    }

    public void setVideoResolution(NvsVideoResolution nvsVideoResolution) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetVideoResolution(l10, nvsVideoResolution);
    }

    public void setZValue(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetZValue(l10, f10);
    }

    public void translateCaption(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeTranslateCaption(l10, pointF);
    }
}

