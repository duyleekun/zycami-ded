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
import com.meicam.effect.sdk.NvsVideoEffectCaption$MotionParameters;
import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsVideoResolution;
import java.util.List;

public class NvsVideoEffectCaption
extends NvsEffect {
    public static final int BOUNDING_TYPE_FRAME = 2;
    public static final int BOUNDING_TYPE_TEXT = 0;
    public static final int BOUNDING_TYPE_TEXT_FRAME = 1;
    public static final int BOUNDING_TYPE_TEXT_ORIGIN_FRAME = 3;
    public static final int DEFAULT_CATEGORY = 0;
    public static final int LETTER_SPACING_TYPE_ABSOLUTE = 1;
    public static final int LETTER_SPACING_TYPE_PERCENTAGE = 0;
    public static final int NOT_USE_ASSET_DEFAULT_PARAM = 1;
    public static final int ROLE_IN_THEME_GENERAL = 0;
    public static final int ROLE_IN_THEME_TITLE = 1;
    public static final int ROLE_IN_THEME_TRAILER = 2;
    public static final int TEXT_ALIGNMENT_BOTTOM = 4;
    public static final int TEXT_ALIGNMENT_CENTER = 1;
    public static final int TEXT_ALIGNMENT_LEFT = 0;
    public static final int TEXT_ALIGNMENT_RIGHT = 2;
    public static final int TEXT_ALIGNMENT_TOP = 3;
    public static final int TEXT_ALIGNMENT_VCENTER = 5;
    public static final int THEME_CATEGORY = 2;
    public static final int USER_CATEGORY = 1;
    public static final int USE_ASSET_DEFAULT_PARAM;

    private native boolean nativeApplyCaptionAnimation(long var1, String var3);

    private native boolean nativeApplyCaptionContext(long var1, String var3);

    private native boolean nativeApplyCaptionInAnimation(long var1, String var3);

    private native boolean nativeApplyCaptionOutAnimation(long var1, String var3);

    private native boolean nativeApplyCaptionRenderer(long var1, String var3);

    private native boolean nativeApplyCaptionStyle(long var1, String var3, int var4);

    private native long nativeChangeInPoint(long var1, long var3);

    private native long nativeChangeOutPoint(long var1, long var3);

    private native PointF nativeGetAnchorPoint(long var1);

    private native int nativeGetAnimationPeroid(long var1);

    private native NvsColor nativeGetBackgroundColor(long var1);

    private native float nativeGetBackgroundRadius(long var1);

    private native boolean nativeGetBold(long var1);

    private native String nativeGetCaptionAnimationPackageId(long var1);

    private native List nativeGetCaptionBoundingVertices(long var1, int var3, NvsVideoEffectCaption$MotionParameters var4);

    private native String nativeGetCaptionContextPackageId(long var1);

    private native String nativeGetCaptionInAnimationPackageId(long var1);

    private native String nativeGetCaptionOutAnimationPackageId(long var1);

    private native String nativeGetCaptionRendererPackageId(long var1);

    private native String nativeGetCaptionStylePackageId(long var1);

    private native PointF nativeGetCaptionTranslation(long var1);

    private native int nativeGetCategory(long var1);

    private native float nativeGetCenterAzimuthAngle(long var1);

    private native float nativeGetCenterPolarAngle(long var1);

    private native boolean nativeGetDrawOutline(long var1);

    private native boolean nativeGetDrawShadow(long var1);

    private native String nativeGetFontFamily(long var1);

    private native String nativeGetFontFilePath(long var1);

    private native float nativeGetFontSize(long var1);

    private native int nativeGetInAnimationDuration(long var1);

    private native long nativeGetInPoint(long var1);

    private native boolean nativeGetItalic(long var1);

    private native float nativeGetLetterSpacing(long var1);

    private native int nativeGetLetterSpacingType(long var1);

    private native float nativeGetLineSpacing(long var1);

    private native float nativeGetOpacity(long var1);

    private native float nativeGetOrthoAngleRange(long var1);

    private native int nativeGetOutAnimationDuration(long var1);

    private native long nativeGetOutPoint(long var1);

    private native NvsColor nativeGetOutlineColor(long var1);

    private native float nativeGetOutlineWidth(long var1);

    private native float nativeGetPanoramicRotationAngle(long var1);

    private native float nativeGetPanoramicScaleX(long var1);

    private native float nativeGetPanoramicScaleY(long var1);

    private native float nativeGetPolarAngleRange(long var1);

    private native int nativeGetRoleInTheme(long var1);

    private native float nativeGetRotationZ(long var1);

    private native float nativeGetScaleX(long var1);

    private native float nativeGetScaleY(long var1);

    private native NvsColor nativeGetSecondaryColor(long var1);

    private native NvsColor nativeGetShadowColor(long var1);

    private native float nativeGetShadowFeather(long var1);

    private native PointF nativeGetShadowOffset(long var1);

    private native String nativeGetText(long var1);

    private native int nativeGetTextAlignment(long var1);

    private native RectF nativeGetTextBoundingRect(long var1, boolean var3);

    private native float nativeGetTextCenterAzimuthAngle(long var1);

    private native float nativeGetTextCenterPolarAngle(long var1);

    private native NvsColor nativeGetTextColor(long var1);

    private native float nativeGetTextOrthoAngleRange(long var1);

    private native float nativeGetTextPolarAngleRange(long var1);

    private native int nativeGetTextVerticalAlignment(long var1);

    private native boolean nativeGetUnderline(long var1);

    private native boolean nativeGetVerticalLayout(long var1);

    private native int nativeGetWeight(long var1);

    private native float nativeGetZValue(long var1);

    private native boolean nativeIsFrameCaption(long var1);

    private native boolean nativeIsModular(long var1);

    private native boolean nativeIsPanoramic(long var1);

    private native void nativeMovePosition(long var1, long var3);

    private native void nativeRotateCaption(long var1, float var3, PointF var4);

    private native void nativeScaleCaption(long var1, float var3, PointF var4);

    private native void nativeSetAnchorPoint(long var1, PointF var3);

    private native void nativeSetAnimationPeroid(long var1, int var3);

    private native void nativeSetBackgroundColor(long var1, NvsColor var3);

    private native void nativeSetBackgroundRadius(long var1, float var3);

    private native void nativeSetBold(long var1, boolean var3);

    private native void nativeSetCaptionTranslation(long var1, PointF var3);

    private native void nativeSetCenterAzimuthAngle(long var1, float var3);

    private native void nativeSetCenterPolarAngle(long var1, float var3);

    private native void nativeSetCurrentKeyFrameTime(long var1, long var3);

    private native void nativeSetDrawOutline(long var1, boolean var3);

    private native void nativeSetDrawShadow(long var1, boolean var3);

    private native void nativeSetFontByFilePath(long var1, String var3);

    private native void nativeSetFontFamily(long var1, String var3);

    private native void nativeSetFontSize(long var1, float var3);

    private native void nativeSetFrameCaptionMaxFontSize(long var1, float var3);

    private native void nativeSetInAnimationDuration(long var1, int var3);

    private native void nativeSetItalic(long var1, boolean var3);

    private native void nativeSetLetterSpacing(long var1, float var3);

    private native void nativeSetLetterSpacingType(long var1, int var3);

    private native void nativeSetLineSpacing(long var1, float var3);

    private native void nativeSetOpacity(long var1, float var3);

    private native void nativeSetOutAnimationDuration(long var1, int var3);

    private native void nativeSetOutlineColor(long var1, NvsColor var3);

    private native void nativeSetOutlineWidth(long var1, float var3);

    private native void nativeSetPanoramicRotationAngle(long var1, float var3);

    private native void nativeSetPanoramicScaleX(long var1, float var3);

    private native void nativeSetPanoramicScaleY(long var1, float var3);

    private native void nativeSetPolarAngleRange(long var1, float var3);

    private native void nativeSetRecordingUserOperation(long var1, boolean var3);

    private native void nativeSetRotationZ(long var1, float var3);

    private native void nativeSetScaleX(long var1, float var3);

    private native void nativeSetScaleY(long var1, float var3);

    private native void nativeSetSecondaryColor(long var1, NvsColor var3);

    private native void nativeSetShadowColor(long var1, NvsColor var3);

    private native void nativeSetShadowFeather(long var1, float var3);

    private native void nativeSetShadowOffset(long var1, PointF var3);

    private native void nativeSetText(long var1, String var3);

    private native void nativeSetTextAlignment(long var1, int var3);

    private native void nativeSetTextColor(long var1, NvsColor var3);

    private native void nativeSetTextFrameOriginRect(long var1, RectF var3);

    private native void nativeSetTextVerticalAlignment(long var1, int var3);

    private native void nativeSetUnderline(long var1, boolean var3);

    private native void nativeSetVerticalLayout(long var1, boolean var3);

    private native void nativeSetVideoResolution(long var1, NvsVideoResolution var3);

    private native void nativeSetWeight(long var1, int var3);

    private native void nativeSetZValue(long var1, float var3);

    private native void nativeTranslateCaption(long var1, PointF var3);

    public boolean applyCaptionStyle(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeApplyCaptionStyle(l10, string2, 1);
    }

    public boolean applyCaptionStyle(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeApplyCaptionStyle(l10, string2, n10);
    }

    public boolean applyModularCaptionAnimation(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeApplyCaptionAnimation(l10, string2);
    }

    public boolean applyModularCaptionContext(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeApplyCaptionContext(l10, string2);
    }

    public boolean applyModularCaptionInAnimation(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeApplyCaptionInAnimation(l10, string2);
    }

    public boolean applyModularCaptionOutAnimation(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeApplyCaptionOutAnimation(l10, string2);
    }

    public boolean applyModularCaptionRenderer(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeApplyCaptionRenderer(l10, string2);
    }

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

    public NvsColor getBackgroundColor() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetBackgroundColor(l10);
    }

    public float getBackgroundRadius() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetBackgroundRadius(l10);
    }

    public boolean getBold() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetBold(l10);
    }

    public List getCaptionBoundingVertices(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptionBoundingVertices(l10, n10, null);
    }

    public List getCaptionBoundingVertices(int n10, NvsVideoEffectCaption$MotionParameters nvsVideoEffectCaption$MotionParameters) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptionBoundingVertices(l10, n10, nvsVideoEffectCaption$MotionParameters);
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

    public int getCategory() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCategory(l10);
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

    public boolean getDrawOutline() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetDrawOutline(l10);
    }

    public boolean getDrawShadow() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetDrawShadow(l10);
    }

    public String getFontFamily() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFontFamily(l10);
    }

    public String getFontFilePath() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFontFilePath(l10);
    }

    public float getFontSize() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetFontSize(l10);
    }

    public long getInPoint() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetInPoint(l10);
    }

    public boolean getItalic() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetItalic(l10);
    }

    public float getLetterSpacing() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetLetterSpacing(l10);
    }

    public int getLetterSpacingType() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetLetterSpacingType(l10);
    }

    public float getLineSpacing() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetLineSpacing(l10);
    }

    public String getModularCaptionAnimationPackageId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptionAnimationPackageId(l10);
    }

    public int getModularCaptionAnimationPeroid() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAnimationPeroid(l10);
    }

    public String getModularCaptionContextPackageId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptionContextPackageId(l10);
    }

    public int getModularCaptionInAnimationDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetInAnimationDuration(l10);
    }

    public String getModularCaptionInAnimationPackageId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptionInAnimationPackageId(l10);
    }

    public int getModularCaptionOutAnimationDuration() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOutAnimationDuration(l10);
    }

    public String getModularCaptionOutAnimationPackageId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptionOutAnimationPackageId(l10);
    }

    public String getModularCaptionRendererPackageId() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetCaptionRendererPackageId(l10);
    }

    public float getOpacity() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOpacity(l10);
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

    public NvsColor getOutlineColor() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOutlineColor(l10);
    }

    public float getOutlineWidth() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetOutlineWidth(l10);
    }

    public float getPanoramicRotation() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPanoramicRotationAngle(l10);
    }

    public float getPanoramicScaleX() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPanoramicScaleX(l10);
    }

    public float getPanoramicScaleY() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPanoramicScaleY(l10);
    }

    public float getPolarAngleRange() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPolarAngleRange(l10);
    }

    public int getRoleInTheme() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetRoleInTheme(l10);
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

    public NvsColor getSecondaryColor() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetSecondaryColor(l10);
    }

    public NvsColor getShadowColor() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetShadowColor(l10);
    }

    public float getShadowFeather() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetShadowFeather(l10);
    }

    public PointF getShadowOffset() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetShadowOffset(l10);
    }

    public String getText() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetText(l10);
    }

    public int getTextAlignment() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTextAlignment(l10);
    }

    public RectF getTextBoundingRect(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTextBoundingRect(l10, bl2);
    }

    public float getTextCenterAzimuthAngle() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTextCenterAzimuthAngle(l10);
    }

    public float getTextCenterPolarAngle() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTextCenterPolarAngle(l10);
    }

    public NvsColor getTextColor() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTextColor(l10);
    }

    public float getTextOrthoAngleRange() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTextOrthoAngleRange(l10);
    }

    public float getTextPolarAngleRange() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTextPolarAngleRange(l10);
    }

    public int getTextVerticalAlignment() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTextVerticalAlignment(l10);
    }

    public boolean getUnderline() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetUnderline(l10);
    }

    public boolean getVerticalLayout() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVerticalLayout(l10);
    }

    public int getWeight() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetWeight(l10);
    }

    public float getZValue() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetZValue(l10);
    }

    public boolean isFrameCaption() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsFrameCaption(l10);
    }

    public boolean isModular() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsModular(l10);
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

    public void rotateCaption(float f10) {
        NvsUtils.checkFunctionInMainThread();
        RectF rectF = this.getTextBoundingRect(false);
        float f11 = rectF.left;
        float f12 = rectF.right;
        f11 += f12;
        f12 = 2.0f;
        float f13 = rectF.top;
        float f14 = rectF.bottom;
        f13 = (f13 + f14) / f12;
        PointF pointF = new PointF(f11 /= f12, f13);
        this.rotateCaption(f10, pointF);
    }

    public void rotateCaption(float f10, PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeRotateCaption(l10, f10, pointF);
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

    public void setBackgroundColor(NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetBackgroundColor(l10, nvsColor);
    }

    public void setBackgroundRadius(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetBackgroundRadius(l10, f10);
    }

    public void setBold(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetBold(l10, bl2);
    }

    public void setCaptionTranslation(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetCaptionTranslation(l10, pointF);
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

    public void setDrawOutline(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetDrawOutline(l10, bl2);
    }

    public void setDrawShadow(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetDrawShadow(l10, bl2);
    }

    public void setFontByFilePath(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetFontByFilePath(l10, string2);
    }

    public void setFontFamily(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetFontFamily(l10, string2);
    }

    public void setFontSize(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetFontSize(l10, f10);
    }

    public void setFrameCaptionMaxFontSize(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetFrameCaptionMaxFontSize(l10, f10);
    }

    public void setItalic(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetItalic(l10, bl2);
    }

    public void setLetterSpacing(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetLetterSpacing(l10, f10);
    }

    public void setLetterSpacingType(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetLetterSpacingType(l10, n10);
    }

    public void setLineSpacing(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetLineSpacing(l10, f10);
    }

    public void setModularCaptionAnimationPeroid(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetAnimationPeroid(l10, n10);
    }

    public void setModularCaptionInAnimationDuration(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetInAnimationDuration(l10, n10);
    }

    public void setModularCaptionOutAnimationDuration(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetOutAnimationDuration(l10, n10);
    }

    public void setOpacity(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetOpacity(l10, f10);
    }

    public void setOutlineColor(NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetOutlineColor(l10, nvsColor);
    }

    public void setOutlineWidth(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetOutlineWidth(l10, f10);
    }

    public void setPanoramicRotation(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetPanoramicRotationAngle(l10, f10);
    }

    public void setPanoramicScaleX(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetPanoramicScaleX(l10, f10);
    }

    public void setPanoramicScaleY(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetPanoramicScaleY(l10, f10);
    }

    public void setPolarAngleRange(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetPolarAngleRange(l10, f10);
    }

    public void setRecordingUserOperation(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetRecordingUserOperation(l10, bl2);
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

    public void setSecondaryColor(NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetSecondaryColor(l10, nvsColor);
    }

    public void setShadowColor(NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetShadowColor(l10, nvsColor);
    }

    public void setShadowFeather(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetShadowFeather(l10, f10);
    }

    public void setShadowOffset(PointF pointF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetShadowOffset(l10, pointF);
    }

    public void setText(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetText(l10, string2);
    }

    public void setTextAlignment(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetTextAlignment(l10, n10);
    }

    public void setTextColor(NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetTextColor(l10, nvsColor);
    }

    public void setTextFrameOriginRect(RectF rectF) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetTextFrameOriginRect(l10, rectF);
    }

    public void setTextVerticalAlignment(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetTextVerticalAlignment(l10, n10);
    }

    public void setUnderline(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetUnderline(l10, bl2);
    }

    public void setVerticalLayout(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetVerticalLayout(l10, bl2);
    }

    public void setVideoResolution(NvsVideoResolution nvsVideoResolution) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetVideoResolution(l10, nvsVideoResolution);
    }

    public void setWeight(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        this.nativeSetWeight(l10, n10);
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

