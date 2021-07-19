/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.LinearTransformation;
import com.google.common.math.LinearTransformation$1;
import com.google.common.math.LinearTransformation$RegularLinearTransformation;
import com.google.common.math.LinearTransformation$VerticalLinearTransformation;

public final class LinearTransformation$LinearTransformationBuilder {
    private final double x1;
    private final double y1;

    private LinearTransformation$LinearTransformationBuilder(double d10, double d11) {
        this.x1 = d10;
        this.y1 = d11;
    }

    public /* synthetic */ LinearTransformation$LinearTransformationBuilder(double d10, double d11, LinearTransformation$1 linearTransformation$1) {
        this(d10, d11);
    }

    public LinearTransformation and(double d10, double d11) {
        boolean bl2 = DoubleUtils.isFinite(d10);
        boolean bl3 = true;
        bl2 = bl2 && (bl2 = DoubleUtils.isFinite(d11)) ? bl3 : false;
        Preconditions.checkArgument(bl2);
        double d12 = this.x1;
        bl2 = d10 == d12 ? 0 : (d10 > d12 ? 1 : -1);
        if (!bl2) {
            d10 = this.y1;
            double d13 = d11 - d10;
            Object object = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
            if (object == false) {
                bl3 = false;
            }
            Preconditions.checkArgument(bl3);
            double d14 = this.x1;
            LinearTransformation$VerticalLinearTransformation linearTransformation$VerticalLinearTransformation = new LinearTransformation$VerticalLinearTransformation(d14);
            return linearTransformation$VerticalLinearTransformation;
        }
        double d15 = this.y1;
        d11 -= d15;
        return this.withSlope(d11 /= (d10 -= d12));
    }

    public LinearTransformation withSlope(double d10) {
        Preconditions.checkArgument(Double.isNaN(d10) ^ true);
        boolean bl2 = DoubleUtils.isFinite(d10);
        if (bl2) {
            double d11 = this.y1;
            double d12 = this.x1 * d10;
            LinearTransformation$RegularLinearTransformation linearTransformation$RegularLinearTransformation = new LinearTransformation$RegularLinearTransformation(d10, d11 -= d12);
            return linearTransformation$RegularLinearTransformation;
        }
        double d13 = this.x1;
        LinearTransformation$VerticalLinearTransformation linearTransformation$VerticalLinearTransformation = new LinearTransformation$VerticalLinearTransformation(d13);
        return linearTransformation$VerticalLinearTransformation;
    }
}

