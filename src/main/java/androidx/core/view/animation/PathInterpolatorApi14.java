/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.view.animation.Interpolator
 */
package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

public class PathInterpolatorApi14
implements Interpolator {
    private static final float PRECISION = 0.002f;
    private final float[] mX;
    private final float[] mY;

    public PathInterpolatorApi14(float f10, float f11) {
        Path path = PathInterpolatorApi14.createQuad(f10, f11);
        this(path);
    }

    public PathInterpolatorApi14(float f10, float f11, float f12, float f13) {
        Path path = PathInterpolatorApi14.createCubic(f10, f11, f12, f13);
        this(path);
    }

    public PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float f10 = pathMeasure.getLength();
        float f11 = f10 / 0.002f;
        int n10 = (int)f11;
        int n11 = 1;
        float[] fArray = new float[n10 += n11];
        this.mX = fArray;
        fArray = new float[n10];
        this.mY = fArray;
        int n12 = 2;
        fArray = new float[n12];
        for (int i10 = 0; i10 < n10; ++i10) {
            float f12 = (float)i10 * f10;
            float f13 = n10 + -1;
            pathMeasure.getPosTan(f12 /= f13, fArray, null);
            float[] fArray2 = this.mX;
            fArray2[i10] = f13 = fArray[0];
            fArray2 = this.mY;
            fArray2[i10] = f13 = fArray[n11];
        }
    }

    private static Path createCubic(float f10, float f11, float f12, float f13) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f10, f11, f12, f13, 1.0f, 1.0f);
        return path;
    }

    private static Path createQuad(float f10, float f11) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        float f12 = 1.0f;
        path.quadTo(f10, f11, f12, f12);
        return path;
    }

    public float getInterpolation(float f10) {
        float f11;
        float f12;
        Object object = false;
        float f13 = 0.0f;
        float[] fArray = null;
        float f14 = f10 - 0.0f;
        Object object2 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object2 <= 0) {
            return 0.0f;
        }
        object2 = 1065353216;
        float f15 = 1.0f;
        float f16 = f10 - f15;
        Object object3 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
        if (object3 >= 0) {
            return f15;
        }
        object2 = false;
        f15 = 0.0f;
        float[] fArray2 = this.mX;
        object3 = fArray2.length;
        boolean bl2 = true;
        object3 -= bl2;
        while ((f12 = object3 - object2) > bl2) {
            float[] fArray3 = this.mX;
            f12 = (object2 + object3) / 2;
            f11 = fArray3[f12];
            float f17 = f10 - f11;
            Object object4 = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
            if (object4 < 0) {
                object3 = f12;
                continue;
            }
            object2 = f12;
        }
        float[] fArray4 = this.mX;
        float f18 = fArray4[object3];
        f11 = fArray4[object2];
        float f19 = (f18 -= f11) - 0.0f;
        object = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
        if (!object) {
            return this.mY[object2];
        }
        f13 = fArray4[object2];
        f10 = (f10 - f13) / f18;
        fArray = this.mY;
        f15 = fArray[object2];
        f13 = fArray[object3] - f15;
        return f15 + (f10 *= f13);
    }
}

