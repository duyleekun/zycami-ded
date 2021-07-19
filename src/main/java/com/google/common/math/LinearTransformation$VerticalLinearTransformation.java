/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.math;

import com.google.common.math.LinearTransformation;
import com.google.common.math.LinearTransformation$RegularLinearTransformation;

public final class LinearTransformation$VerticalLinearTransformation
extends LinearTransformation {
    public LinearTransformation inverse;
    public final double x;

    public LinearTransformation$VerticalLinearTransformation(double d10) {
        this.x = d10;
        this.inverse = null;
    }

    public LinearTransformation$VerticalLinearTransformation(double d10, LinearTransformation linearTransformation) {
        this.x = d10;
        this.inverse = linearTransformation;
    }

    private LinearTransformation createInverse() {
        double d10 = this.x;
        LinearTransformation$RegularLinearTransformation linearTransformation$RegularLinearTransformation = new LinearTransformation$RegularLinearTransformation(0.0, d10, this);
        return linearTransformation$RegularLinearTransformation;
    }

    public LinearTransformation inverse() {
        LinearTransformation linearTransformation = this.inverse;
        if (linearTransformation == null) {
            this.inverse = linearTransformation = this.createInverse();
        }
        return linearTransformation;
    }

    public boolean isHorizontal() {
        return false;
    }

    public boolean isVertical() {
        return true;
    }

    public double slope() {
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    public String toString() {
        Object[] objectArray = new Object[1];
        Double d10 = this.x;
        objectArray[0] = d10;
        return String.format("x = %g", objectArray);
    }

    public double transform(double d10) {
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }
}

