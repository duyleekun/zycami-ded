/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Rational
 */
package androidx.camera.camera2.internal;

import android.util.Rational;
import java.util.Comparator;

public final class SupportedSurfaceCombination$CompareAspectRatiosByDistanceToTargetRatio
implements Comparator {
    private Rational mTargetRatio;

    public SupportedSurfaceCombination$CompareAspectRatiosByDistanceToTargetRatio(Rational rational) {
        this.mTargetRatio = rational;
    }

    public int compare(Rational object, Rational object2) {
        boolean bl2 = object.equals(object2);
        if (bl2) {
            return 0;
        }
        float f10 = object.floatValue();
        float f11 = this.mTargetRatio.floatValue();
        object = Float.valueOf(Math.abs(f10 - f11));
        float f12 = object2.floatValue();
        f11 = this.mTargetRatio.floatValue();
        object2 = Float.valueOf(Math.abs(f12 - f11));
        f10 = ((Float)object).floatValue();
        f12 = ((Float)object2).floatValue();
        return (int)Math.signum(f10 - f12);
    }
}

