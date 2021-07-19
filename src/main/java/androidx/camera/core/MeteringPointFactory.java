/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Rational
 */
package androidx.camera.core;

import android.graphics.PointF;
import android.util.Rational;
import androidx.camera.core.MeteringPoint;

public abstract class MeteringPointFactory {
    private Rational mSurfaceAspectRatio;

    public MeteringPointFactory() {
        this(null);
    }

    public MeteringPointFactory(Rational rational) {
        this.mSurfaceAspectRatio = rational;
    }

    public static float getDefaultPointSize() {
        return 0.15f;
    }

    public abstract PointF convertPoint(float var1, float var2);

    public final MeteringPoint createPoint(float f10, float f11) {
        float f12 = MeteringPointFactory.getDefaultPointSize();
        return this.createPoint(f10, f11, f12);
    }

    public final MeteringPoint createPoint(float f10, float f11, float f12) {
        PointF pointF = this.convertPoint(f10, f11);
        float f13 = pointF.x;
        f10 = pointF.y;
        Rational rational = this.mSurfaceAspectRatio;
        MeteringPoint meteringPoint = new MeteringPoint(f13, f10, f12, rational);
        return meteringPoint;
    }
}

