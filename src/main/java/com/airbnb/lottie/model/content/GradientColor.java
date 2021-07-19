/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.model.content;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;

public class GradientColor {
    private final int[] colors;
    private final float[] positions;

    public GradientColor(float[] fArray, int[] nArray) {
        this.positions = fArray;
        this.colors = nArray;
    }

    public int[] getColors() {
        return this.colors;
    }

    public float[] getPositions() {
        return this.positions;
    }

    public int getSize() {
        return this.colors.length;
    }

    public void lerp(GradientColor object, GradientColor gradientColor, float f10) {
        Object object2 = ((GradientColor)object).colors;
        int n10 = ((int[])object2).length;
        Object[] objectArray = gradientColor.colors;
        int n11 = objectArray.length;
        if (n10 == n11) {
            object2 = null;
            for (n10 = 0; n10 < (n11 = (objectArray = ((GradientColor)object).colors).length); ++n10) {
                objectArray = this.positions;
                float f11 = ((GradientColor)object).positions[n10];
                float f12 = gradientColor.positions[n10];
                f11 = MiscUtils.lerp(f11, f12, f10);
                objectArray[n10] = (int)f11;
                objectArray = this.colors;
                int[] nArray = ((GradientColor)object).colors;
                int n12 = nArray[n10];
                int[] nArray2 = gradientColor.colors;
                int n13 = nArray2[n10];
                objectArray[n10] = n12 = GammaEvaluator.evaluate(f10, n12, n13);
            }
            return;
        }
        object2 = new StringBuilder;
        object2();
        object2.append("Cannot interpolate between gradients. Lengths vary (");
        int n14 = ((GradientColor)object).colors.length;
        object2.append(n14);
        object2.append(" vs ");
        n14 = gradientColor.colors.length;
        object2.append(n14);
        object2.append(")");
        object = object2.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

