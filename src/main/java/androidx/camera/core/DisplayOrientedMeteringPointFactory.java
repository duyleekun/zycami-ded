/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.view.Display
 */
package androidx.camera.core;

import android.graphics.PointF;
import android.view.Display;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.CameraInfoInternal;

public final class DisplayOrientedMeteringPointFactory
extends MeteringPointFactory {
    private final CameraInfo mCameraInfo;
    private final Display mDisplay;
    private final float mHeight;
    private final float mWidth;

    public DisplayOrientedMeteringPointFactory(Display display, CameraInfo cameraInfo, float f10, float f11) {
        this.mWidth = f10;
        this.mHeight = f11;
        this.mDisplay = display;
        this.mCameraInfo = cameraInfo;
    }

    private Integer getLensFacing() {
        CameraInfo cameraInfo = this.mCameraInfo;
        boolean bl2 = cameraInfo instanceof CameraInfoInternal;
        if (bl2) {
            return ((CameraInfoInternal)cameraInfo).getLensFacing();
        }
        return null;
    }

    private int getRelativeCameraOrientation(boolean bl2) {
        int n10;
        block6: {
            Display display = this.mDisplay;
            n10 = display.getRotation();
            CameraInfo cameraInfo = this.mCameraInfo;
            n10 = cameraInfo.getSensorRotationDegrees(n10);
            if (!bl2) break block6;
            int n11 = 360 - n10;
            try {
                n10 = n11 % 360;
            }
            catch (Exception exception) {
                n10 = 0;
                display = null;
            }
        }
        return n10;
    }

    /*
     * Unable to fully structure code
     */
    public PointF convertPoint(float var1_1, float var2_2) {
        var3_3 = this.mWidth;
        var4_4 = this.mHeight;
        var5_5 = this.getLensFacing();
        if (var5_5 != null && !(var6_6 = var5_5.intValue())) {
            var6_6 = true;
        } else {
            var6_6 = false;
            var5_5 = null;
        }
        var7_7 = this.getRelativeCameraOrientation(var6_6);
        var8_8 = 270;
        var9_9 = 90;
        if (var7_7 != var9_9 && var7_7 != var8_8) {
            var10_10 = var2_2;
            var2_2 = var1_1;
            var1_1 = var10_10;
            var11_11 = var4_4;
            var4_4 = var3_3;
            var3_3 = var11_11;
        }
        if (var7_7 == var9_9) ** GOTO lbl26
        var9_9 = 180;
        if (var7_7 != var9_9) {
            if (var7_7 == var8_8) {
                var2_2 = var4_4 - var2_2;
            }
        } else {
            var2_2 = var4_4 - var2_2;
lbl26:
            // 2 sources

            var1_1 = var3_3 - var1_1;
        }
        if (var6_6) {
            var2_2 = var4_4 - var2_2;
        }
        var12_12 = new PointF(var2_2 /= var4_4, var1_1 /= var3_3);
        return var12_12;
    }
}

