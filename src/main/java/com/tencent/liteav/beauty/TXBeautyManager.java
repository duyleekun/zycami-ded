/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.liteav.beauty;

import android.graphics.Bitmap;
import com.tencent.liteav.beauty.d;

public interface TXBeautyManager {
    public void enableSharpnessEnhancement(boolean var1);

    public void setBeautyLevel(float var1);

    public void setBeautyStyle(int var1);

    public void setChinLevel(float var1);

    public void setEyeAngleLevel(float var1);

    public void setEyeDistanceLevel(float var1);

    public void setEyeLightenLevel(float var1);

    public void setEyeScaleLevel(float var1);

    public void setFaceBeautyLevel(float var1);

    public void setFaceShortLevel(float var1);

    public void setFaceSlimLevel(float var1);

    public void setFaceVLevel(float var1);

    public void setFilter(Bitmap var1);

    public void setFilterStrength(float var1);

    public void setForeheadLevel(float var1);

    public void setGreenScreenFile(String var1);

    public void setLipsThicknessLevel(float var1);

    public void setMotionMute(boolean var1);

    public void setMotionTmpl(String var1);

    public void setMouthShapeLevel(float var1);

    public void setNosePositionLevel(float var1);

    public void setNoseSlimLevel(float var1);

    public void setNoseWingLevel(float var1);

    public void setPounchRemoveLevel(float var1);

    public void setPreprocessor(d var1);

    public void setRuddyLevel(float var1);

    public void setSmileLinesRemoveLevel(float var1);

    public void setToothWhitenLevel(float var1);

    public void setWhitenessLevel(float var1);

    public void setWrinkleRemoveLevel(float var1);
}

