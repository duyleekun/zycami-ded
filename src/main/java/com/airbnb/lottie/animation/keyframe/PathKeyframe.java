/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.view.animation.Interpolator
 */
package com.airbnb.lottie.animation.keyframe;

import android.graphics.Path;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;

public class PathKeyframe
extends Keyframe {
    private Path path;
    private final Keyframe pointKeyFrame;

    public PathKeyframe(LottieComposition lottieComposition, Keyframe keyframe) {
        Object object = keyframe.startValue;
        Object object2 = keyframe.endValue;
        Interpolator interpolator2 = keyframe.interpolator;
        float f10 = keyframe.startFrame;
        Float f11 = keyframe.endFrame;
        super(lottieComposition, object, object2, interpolator2, f10, f11);
        this.pointKeyFrame = keyframe;
        this.createPath();
    }

    /*
     * Unable to fully structure code
     */
    public void createPath() {
        var1_1 = this.endValue;
        if (var1_1 == null || (var2_2 = this.startValue) == null) ** GOTO lbl-1000
        var2_2 = (PointF)var2_2;
        var3_3 = var1_1;
        var3_3 = (PointF)var1_1;
        var4_4 = var3_3.x;
        var1_1 = (PointF)var1_1;
        var5_5 = var1_1.y;
        var6_6 = var2_2.equals(var4_4, var5_5);
        if (var6_6) {
            var6_6 = true;
            var5_5 = 1.4E-45f;
        } else lbl-1000:
        // 2 sources

        {
            var6_6 = false;
            var5_5 = 0.0f;
            var1_1 = null;
        }
        var2_2 = this.endValue;
        if (var2_2 != null && !var6_6) {
            var1_1 = (PointF)this.startValue;
            var2_2 = (PointF)var2_2;
            var3_3 = this.pointKeyFrame;
            var7_7 = var3_3.pathCp1;
            var3_3 = var3_3.pathCp2;
            var1_1 = Utils.createPath((PointF)var1_1, (PointF)var2_2, var7_7, (PointF)var3_3);
            this.path = var1_1;
        }
    }

    public Path getPath() {
        return this.path;
    }
}

