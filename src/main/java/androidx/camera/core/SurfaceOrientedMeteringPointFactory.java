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
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.UseCase;

public class SurfaceOrientedMeteringPointFactory
extends MeteringPointFactory {
    private final float mHeight;
    private final float mWidth;

    public SurfaceOrientedMeteringPointFactory(float f10, float f11) {
        this.mWidth = f10;
        this.mHeight = f11;
    }

    public SurfaceOrientedMeteringPointFactory(float f10, float f11, UseCase useCase) {
        useCase = SurfaceOrientedMeteringPointFactory.getUseCaseAspectRatio(useCase);
        super((Rational)useCase);
        this.mWidth = f10;
        this.mHeight = f11;
    }

    private static Rational getUseCaseAspectRatio(UseCase object) {
        if (object == null) {
            return null;
        }
        Object object2 = ((UseCase)object).getAttachedSurfaceResolution();
        if (object2 != null) {
            int n10 = object2.getWidth();
            int n11 = object2.getHeight();
            object = new Rational(n10, n11);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UseCase ");
        stringBuilder.append(object);
        stringBuilder.append(" is not bound.");
        object = stringBuilder.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public PointF convertPoint(float f10, float f11) {
        float f12 = this.mWidth;
        f10 /= f12;
        f12 = this.mHeight;
        PointF pointF = new PointF(f10, f11 /= f12);
        return pointF;
    }
}

