/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.graphics.RectF
 */
package com.meicam.effect.sdk;

import android.graphics.PointF;
import android.graphics.RectF;
import com.meicam.effect.sdk.NvsEffect;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsVideoResolution;
import java.util.List;

public class NvsVideoEffectAnimatedSticker
extends NvsEffect {
    private native long nativeChangeInPoint(long var1, long var3);

    private native long nativeChangeOutPoint(long var1, long var3);

    private native String nativeGetAnimatedStickerPackageId(long var1);

    private native List nativeGetBoundingRectangleVertices(long var1);

    private native float nativeGetCenterAzimuthAngle(long var1);

    private native float nativeGetCenterPolarAngle(long var1);

    private native long nativeGetDefaultDuration(long var1);

    private native boolean nativeGetHorizontalFlip(long var1);

    private native long nativeGetInPoint(long var1);

    private native float nativeGetOpacity(long var1);

    private native RectF nativeGetOriginalBoundingRect(long var1);

    private native float nativeGetOrthoAngleRange(long var1);

    private native long nativeGetOutPoint(long var1);

    private native float nativeGetPolarAngleRange(long var1);

    private native float nativeGetRotationZ(long var1);

    private native float nativeGetScale(long var1);

    private native PointF nativeGetTranslation(long var1);

    private native boolean nativeGetVerticalFlip(long var1);

    private native float nativeGetZValue(long var1);

    private native boolean nativeIsPanoramic(long var1);

    private native void nativeMovePosition(long var1, long var3);

    private native void nativeRotateAnimatedSticker(long var1, float var3, PointF var4);

    private native void nativeScaleAnimatedSticker(long var1, float var3, PointF var4);

    private native void nativeSetCenterAzimuthAngle(long var1, float var3);

    private native void nativeSetCenterPolarAngle(long var1, float var3);

    private native void nativeSetCurrentKeyFrameTime(long var1, long var3);

    private native void nativeSetHorizontalFlip(long var1, boolean var3);

    private native void nativeSetOpacity(long var1, float var3);

    private native void nativeSetPolarAngleRange(long var1, float var3);

    private native void nativeSetRotationZ(long var1, float var3);

    private native void nativeSetScale(long var1, float var3);

    private native void nativeSetTranslation(long var1, PointF var3);

    private native void nativeSetVerticalFlip(long var1, boolean var3);

    private native void nativeSetVideoResolution(long var1, NvsVideoResolution var3);

    private native void nativeSetZValue(long var1, float var3);

    private native void nativeTranslateAnimatedSticker(long var1, PointF var3);

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

    public String getAnimatedStickerPackageId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAnimatedStickerPackageId(l10);
    }

    public List getBoundingRectangleVertices() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetBoundingRectangleVertices(l10);
    }

    public float getCenterAzimuthAngle() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCenterAzimuthAngle(l10);
    }

    public float getCenterPolarAngle() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCenterPolarAngle(l10);
    }

    public long getDefaultDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetDefaultDuration(l10);
    }

    public boolean getHorizontalFlip() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetHorizontalFlip(l10);
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

    public RectF getOriginalBoundingRect() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOriginalBoundingRect(l10);
    }

    public float getOrthoAngleRange() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOrthoAngleRange(l10);
    }

    public long getOutPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOutPoint(l10);
    }

    public float getPolarAngleRange() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPolarAngleRange(l10);
    }

    public float getRotationZ() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetRotationZ(l10);
    }

    public float getScale() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetScale(l10);
    }

    public PointF getTranslation() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTranslation(l10);
    }

    public boolean getVerticalFlip() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVerticalFlip(l10);
    }

    public float getZValue() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetZValue(l10);
    }

    public boolean isPanoramic() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsPanoramic(l10);
    }

    public void movePosition(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeMovePosition(l11, l10);
    }

    public void rotateAnimatedSticker(float f10) {
        NvsUtils.checkFunctionInMainThread();
        List list = this.getBoundingRectangleVertices();
        PointF pointF = (PointF)list.get(0);
        float f11 = pointF.x;
        float f12 = pointF.y;
        int n10 = 1;
        float f13 = f11;
        int n11 = n10;
        f11 = f12;
        float f14 = f13;
        while (true) {
            int n12 = 4;
            float f15 = 5.6E-45f;
            if (n11 >= n12) break;
            PointF pointF2 = (PointF)list.get(n11);
            float f16 = pointF2.x;
            float f17 = f16 - f14;
            Object object = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
            if (object < 0) {
                f14 = f16;
            } else {
                object = f16 == f13 ? 0 : (f16 > f13 ? 1 : -1);
                if (object > 0) {
                    f13 = f16;
                }
            }
            f15 = pointF2.y;
            Object object2 = f15 == f11 ? 0 : (f15 < f11 ? -1 : 1);
            if (object2 < 0) {
                f11 = f15;
            } else {
                object2 = f15 == f12 ? 0 : (f15 > f12 ? 1 : -1);
                if (object2 > 0) {
                    f12 = f15;
                }
            }
            ++n11;
        }
        f14 += f13;
        f13 = 2.0f;
        f12 = (f12 + f11) / f13;
        list = new PointF(f14 /= f13, f12);
        this.rotateAnimatedSticker(f10, (PointF)list);
    }

    public void rotateAnimatedSticker(float f10, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeRotateAnimatedSticker(l10, f10, pointF);
    }

    public void scaleAnimatedSticker(float f10, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeScaleAnimatedSticker(l10, f10, pointF);
    }

    public void setCenterAzimuthAngle(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetCenterAzimuthAngle(l10, f10);
    }

    public void setCenterPolarAngle(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetCenterPolarAngle(l10, f10);
    }

    public void setCurrentKeyFrameTime(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.m_internalObject;
        this.nativeSetCurrentKeyFrameTime(l11, l10);
    }

    public void setHorizontalFlip(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetHorizontalFlip(l10, bl2);
    }

    public void setOpacity(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetOpacity(l10, f10);
    }

    public void setPolarAngleRange(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetPolarAngleRange(l10, f10);
    }

    public void setRotationZ(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetRotationZ(l10, f10);
    }

    public void setScale(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetScale(l10, f10);
    }

    public void setTranslation(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetTranslation(l10, pointF);
    }

    public void setVerticalFlip(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetVerticalFlip(l10, bl2);
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

    public void translateAnimatedSticker(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeTranslateAnimatedSticker(l10, pointF);
    }
}

