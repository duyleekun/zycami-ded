/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.math.LinearTransformation;
import com.google.common.math.LinearTransformation$VerticalLinearTransformation;

public final class LinearTransformation$RegularLinearTransformation
extends LinearTransformation {
    public LinearTransformation inverse;
    public final double slope;
    public final double yIntercept;

    public LinearTransformation$RegularLinearTransformation(double d10, double d11) {
        this.slope = d10;
        this.yIntercept = d11;
        this.inverse = null;
    }

    public LinearTransformation$RegularLinearTransformation(double d10, double d11, LinearTransformation linearTransformation) {
        this.slope = d10;
        this.yIntercept = d11;
        this.inverse = linearTransformation;
    }

    private LinearTransformation createInverse() {
        double d10 = this.slope;
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object != false) {
            double d13 = 1.0 / d10;
            double d14 = this.yIntercept * -1.0 / d10;
            LinearTransformation$RegularLinearTransformation linearTransformation$RegularLinearTransformation = new LinearTransformation$RegularLinearTransformation(d13, d14, this);
            return linearTransformation$RegularLinearTransformation;
        }
        double d15 = this.yIntercept;
        LinearTransformation$VerticalLinearTransformation linearTransformation$VerticalLinearTransformation = new LinearTransformation$VerticalLinearTransformation(d15, this);
        return linearTransformation$VerticalLinearTransformation;
    }

    public LinearTransformation inverse() {
        LinearTransformation linearTransformation = this.inverse;
        if (linearTransformation == null) {
            this.inverse = linearTransformation = this.createInverse();
        }
        return linearTransformation;
    }

    public boolean isHorizontal() {
        double d10 = this.slope;
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        object = object == false ? (Object)true : (Object)false;
        return (boolean)object;
    }

    public boolean isVertical() {
        return false;
    }

    public double slope() {
        return this.slope;
    }

    public String toString() {
        Object[] objectArray = new Object[2];
        Double d10 = this.slope;
        objectArray[0] = d10;
        d10 = this.yIntercept;
        objectArray[1] = d10;
        return String.format("y = %g * x + %g", objectArray);
    }

    public double transform(double d10) {
        double d11 = this.slope;
        d10 *= d11;
        d11 = this.yIntercept;
        return d10 + d11;
    }
}

