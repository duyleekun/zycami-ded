/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsARFaceContext;
import com.meicam.sdk.NvsARSceneManipulate;
import com.meicam.sdk.NvsArbitraryData;
import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsControlPointPair;
import com.meicam.sdk.NvsFxDescription;
import com.meicam.sdk.NvsMaskRegionInfo;
import com.meicam.sdk.NvsObject;
import com.meicam.sdk.NvsPaintingEffectContext;
import com.meicam.sdk.NvsParticleSystemContext;
import com.meicam.sdk.NvsPosition2D;
import com.meicam.sdk.NvsPosition3D;
import com.meicam.sdk.NvsUtils;

public class NvsFx
extends NvsObject {
    public static final int FACE_WARP_EFFECT_STRATEGY_CUSTOM = Integer.MAX_VALUE;
    public static final int KEY_FRAME_FIND_MODE_INPUT_TIME_AFTER = 2;
    public static final int KEY_FRAME_FIND_MODE_INPUT_TIME_BEFORE = 1;
    public static final int REGION_COORDINATE_SYSTEM_TYPE_NDC = 0;
    public static final int REGION_COORDINATE_SYSTEM_TYPE_TIMELINE = 1;

    private native void nativeClearExprVar(long var1, String var3);

    private native void nativeClearExprVarCtx(long var1);

    private native long nativeFindKeyframeTime(long var1, String var3, long var4, int var6);

    private native NvsARFaceContext nativeGetARFaceContext(long var1);

    private native NvsARSceneManipulate nativeGetARSceneManipulate(long var1);

    private native NvsArbitraryData nativeGetArbDataVal(long var1, String var3, long var4);

    private native boolean nativeGetBooleanVal(long var1, String var3, long var4);

    private native NvsColor nativeGetColorVal(long var1, String var3, long var4);

    private native NvsFxDescription nativeGetDescription(long var1);

    private native String nativeGetExprStringVar(long var1, String var3);

    private native double nativeGetExprVar(long var1, String var3);

    private native float nativeGetFilterIntensity(long var1);

    private native boolean nativeGetFilterMask(long var1);

    private native double nativeGetFloatVal(long var1, String var3, long var4);

    private native boolean nativeGetIgnoreBackground(long var1);

    private native int nativeGetIntVal(long var1, String var3, long var4);

    private native boolean nativeGetInverseRegion(long var1);

    private native NvsControlPointPair nativeGetKeyFrameControlPoint(long var1, String var3, long var4);

    private native String nativeGetMenuVal(long var1, String var3, long var4);

    private native NvsPaintingEffectContext nativeGetPaintingEffectContext(long var1);

    private native NvsParticleSystemContext nativeGetParticleSystemContext(long var1);

    private native NvsPosition2D nativeGetPosition2DVal(long var1, String var3, long var4);

    private native NvsPosition3D nativeGetPosition3DVal(long var1, String var3, long var4);

    private native float[] nativeGetRegion(long var1);

    private native int nativeGetRegionCoordinateSystemType(long var1);

    private native NvsMaskRegionInfo nativeGetRegionInfo(long var1, long var3);

    private native boolean nativeGetRegional(long var1);

    private native float nativeGetRegionalFeatherWidth(long var1);

    private native float nativeGetRegionalFeatherWidthAtTime(long var1, long var3);

    private native String nativeGetStringVal(long var1, String var3, long var4);

    private native boolean nativeHasKeyframeList(long var1, String var3);

    private native boolean nativeRemoveAllKeyframe(long var1, String var3);

    private native boolean nativeRemoveKeyframeAtTime(long var1, String var3, long var4);

    private native void nativeSetArbDataVal(long var1, String var3, NvsArbitraryData var4, long var5);

    private native void nativeSetBooleanVal(long var1, String var3, boolean var4, long var5);

    private native void nativeSetColorVal(long var1, String var3, NvsColor var4, long var5);

    private native void nativeSetExprStringVar(long var1, String var3, String var4);

    private native void nativeSetExprVar(long var1, String var3, double var4);

    private native void nativeSetFilterIntensity(long var1, float var3);

    private native void nativeSetFilterMask(long var1, boolean var3);

    private native void nativeSetFloatVal(long var1, String var3, double var4, long var6);

    private native void nativeSetIgnoreBackground(long var1, boolean var3);

    private native void nativeSetIntVal(long var1, String var3, int var4, long var5);

    private native void nativeSetInverseRegion(long var1, boolean var3);

    private native boolean nativeSetKeyFrameControlPoint(long var1, String var3, long var4, NvsControlPointPair var6);

    private native void nativeSetMenuVal(long var1, String var3, String var4, long var5);

    private native void nativeSetPosition2DVal(long var1, String var3, NvsPosition2D var4, long var5);

    private native void nativeSetPosition3DVal(long var1, String var3, NvsPosition3D var4, long var5);

    private native void nativeSetRegion(long var1, float[] var3);

    private native void nativeSetRegionCoordinateSystemType(long var1, int var3);

    private native void nativeSetRegionInfo(long var1, NvsMaskRegionInfo var3, long var4);

    private native void nativeSetRegional(long var1, boolean var3);

    private native void nativeSetRegionalFeatherWidth(long var1, float var3);

    private native void nativeSetRegionalFeatherWidthAtTime(long var1, float var3, long var4);

    private native void nativeSetStringVal(long var1, String var3, String var4, long var5);

    public void clearExprVar(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeClearExprVar(l10, string2);
    }

    public void clearExprVarCtx() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeClearExprVarCtx(l10);
    }

    public long findKeyframeTime(String string2, long l10, int n10) {
        long l11 = this.getInternalObject();
        return this.nativeFindKeyframeTime(l11, string2, l10, n10);
    }

    public NvsARFaceContext getARFaceContext() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetARFaceContext(l10);
    }

    public NvsARSceneManipulate getARSceneManipulate() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetARSceneManipulate(l10);
    }

    public NvsArbitraryData getArbDataVal(String string2) {
        long l10 = this.getInternalObject();
        return this.nativeGetArbDataVal(l10, string2, -1);
    }

    public NvsArbitraryData getArbDataValAtTime(String string2, NvsArbitraryData nvsArbitraryData, long l10) {
        long l11 = this.getInternalObject();
        return this.nativeGetArbDataVal(l11, string2, l10);
    }

    public boolean getBooleanVal(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetBooleanVal(l10, string2, -1);
    }

    public boolean getBooleanValAtTime(String string2, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        return this.nativeGetBooleanVal(l11, string2, l10);
    }

    public NvsColor getColorVal(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetColorVal(l10, string2, -1);
    }

    public NvsColor getColorValAtTime(String string2, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        return this.nativeGetColorVal(l11, string2, l10);
    }

    public NvsFxDescription getDescription() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetDescription(l10);
    }

    public String getExprStringVar(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetExprStringVar(l10, string2);
    }

    public double getExprVar(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetExprVar(l10, string2);
    }

    public float getFilterIntensity() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetFilterIntensity(l10);
    }

    public boolean getFilterMask() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetFilterMask(l10);
    }

    public double getFloatVal(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetFloatVal(l10, string2, -1);
    }

    public double getFloatValAtTime(String string2, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        return this.nativeGetFloatVal(l11, string2, l10);
    }

    public boolean getIgnoreBackground() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetIgnoreBackground(l10);
    }

    public int getIntVal(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetIntVal(l10, string2, -1);
    }

    public int getIntValAtTime(String string2, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        return this.nativeGetIntVal(l11, string2, l10);
    }

    public boolean getInverseRegion() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetInverseRegion(l10);
    }

    public NvsControlPointPair getKeyFrameControlPoint(String string2, long l10) {
        long l11 = this.getInternalObject();
        return this.nativeGetKeyFrameControlPoint(l11, string2, l10);
    }

    public String getMenuVal(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetMenuVal(l10, string2, -1);
    }

    public String getMenuValAtTime(String string2, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        return this.nativeGetMenuVal(l11, string2, l10);
    }

    public NvsPaintingEffectContext getPaintingEffectContext() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetPaintingEffectContext(l10);
    }

    public NvsParticleSystemContext getParticleSystemContext() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetParticleSystemContext(l10);
    }

    public NvsPosition2D getPosition2DVal(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetPosition2DVal(l10, string2, -1);
    }

    public NvsPosition2D getPosition2DValAtTime(String string2, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        return this.nativeGetPosition2DVal(l11, string2, l10);
    }

    public NvsPosition3D getPosition3DVal(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetPosition3DVal(l10, string2, -1);
    }

    public NvsPosition3D getPosition3DValAtTime(String string2, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        return this.nativeGetPosition3DVal(l11, string2, l10);
    }

    public float[] getRegion() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetRegion(l10);
    }

    public int getRegionCoordinateSystemType() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetRegionCoordinateSystemType(l10);
    }

    public NvsMaskRegionInfo getRegionInfo() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetRegionInfo(l10, -1);
    }

    public NvsMaskRegionInfo getRegionInfoAtTime(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        return this.nativeGetRegionInfo(l11, l10);
    }

    public boolean getRegional() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetRegional(l10);
    }

    public float getRegionalFeatherWidth() {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetRegionalFeatherWidth(l10);
    }

    public float getRegionalFeatherWidthAtTime(long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        return this.nativeGetRegionalFeatherWidthAtTime(l11, l10);
    }

    public String getStringVal(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        return this.nativeGetStringVal(l10, string2, -1);
    }

    public String getStringValAtTime(String string2, long l10, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        return this.nativeGetStringVal(l11, string2, l10);
    }

    public boolean hasKeyframeList(String string2) {
        long l10 = this.getInternalObject();
        return this.nativeHasKeyframeList(l10, string2);
    }

    public boolean removeAllKeyframe(String string2) {
        long l10 = this.getInternalObject();
        return this.nativeRemoveAllKeyframe(l10, string2);
    }

    public boolean removeKeyframeAtTime(String string2, long l10) {
        long l11 = this.getInternalObject();
        return this.nativeRemoveKeyframeAtTime(l11, string2, l10);
    }

    public void setArbDataVal(String string2, NvsArbitraryData nvsArbitraryData) {
        long l10 = this.getInternalObject();
        this.nativeSetArbDataVal(l10, string2, nvsArbitraryData, -1);
    }

    public void setArbDataValAtTime(String string2, NvsArbitraryData nvsArbitraryData, long l10) {
        long l11 = this.getInternalObject();
        this.nativeSetArbDataVal(l11, string2, nvsArbitraryData, l10);
    }

    public void setBooleanVal(String string2, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetBooleanVal(l10, string2, bl2, -1);
    }

    public void setBooleanValAtTime(String string2, boolean bl2, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        this.nativeSetBooleanVal(l11, string2, bl2, l10);
    }

    public void setColorVal(String string2, NvsColor nvsColor) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetColorVal(l10, string2, nvsColor, -1);
    }

    public void setColorValAtTime(String string2, NvsColor nvsColor, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        this.nativeSetColorVal(l11, string2, nvsColor, l10);
    }

    public void setExprStringVar(String string2, String string3) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetExprStringVar(l10, string2, string3);
    }

    public void setExprVar(String string2, double d10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetExprVar(l10, string2, d10);
    }

    public void setFilterIntensity(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetFilterIntensity(l10, f10);
    }

    public void setFilterMask(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetFilterMask(l10, bl2);
    }

    public void setFloatVal(String string2, double d10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetFloatVal(l10, string2, d10, -1);
    }

    public void setFloatValAtTime(String string2, double d10, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        this.nativeSetFloatVal(l11, string2, d10, l10);
    }

    public void setIgnoreBackground(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetIgnoreBackground(l10, bl2);
    }

    public void setIntVal(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetIntVal(l10, string2, n10, -1);
    }

    public void setIntValAtTime(String string2, int n10, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        this.nativeSetIntVal(l11, string2, n10, l10);
    }

    public void setInverseRegion(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetInverseRegion(l10, bl2);
    }

    public boolean setKeyFrameControlPoint(String string2, long l10, NvsControlPointPair nvsControlPointPair) {
        long l11 = this.getInternalObject();
        return this.nativeSetKeyFrameControlPoint(l11, string2, l10, nvsControlPointPair);
    }

    public void setMenuVal(String string2, String string3) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetMenuVal(l10, string2, string3, -1);
    }

    public void setMenuValAtTime(String string2, String string3, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        this.nativeSetMenuVal(l11, string2, string3, l10);
    }

    public void setPosition2DVal(String string2, NvsPosition2D nvsPosition2D) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetPosition2DVal(l10, string2, nvsPosition2D, -1);
    }

    public void setPosition2DValAtTime(String string2, NvsPosition2D nvsPosition2D, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        this.nativeSetPosition2DVal(l11, string2, nvsPosition2D, l10);
    }

    public void setPosition3DVal(String string2, NvsPosition3D nvsPosition3D) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetPosition3DVal(l10, string2, nvsPosition3D, -1);
    }

    public void setPosition3DValAtTime(String string2, NvsPosition3D nvsPosition3D, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        this.nativeSetPosition3DVal(l11, string2, nvsPosition3D, l10);
    }

    public void setRegion(float[] fArray) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetRegion(l10, fArray);
    }

    public void setRegionCoordinateSystemType(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetRegionCoordinateSystemType(l10, n10);
    }

    public void setRegionInfo(NvsMaskRegionInfo nvsMaskRegionInfo) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetRegionInfo(l10, nvsMaskRegionInfo, -1);
    }

    public void setRegionInfoAtTime(NvsMaskRegionInfo nvsMaskRegionInfo, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        this.nativeSetRegionInfo(l11, nvsMaskRegionInfo, l10);
    }

    public void setRegional(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetRegional(l10, bl2);
    }

    public void setRegionalFeatherWidth(float f10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetRegionalFeatherWidth(l10, f10);
    }

    public void setRegionalFeatherWidthAtTime(float f10, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        this.nativeSetRegionalFeatherWidthAtTime(l11, f10, l10);
    }

    public void setStringVal(String string2, String string3) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.getInternalObject();
        this.nativeSetStringVal(l10, string2, string3, -1);
    }

    public void setStringValAtTime(String string2, String string3, long l10) {
        NvsUtils.checkFunctionInMainThread();
        long l11 = this.getInternalObject();
        this.nativeSetStringVal(l11, string2, string3, l10);
    }
}

