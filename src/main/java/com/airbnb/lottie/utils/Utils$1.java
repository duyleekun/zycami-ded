/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PathMeasure
 */
package com.airbnb.lottie.utils;

import android.graphics.PathMeasure;

public class Utils$1
extends ThreadLocal {
    public PathMeasure initialValue() {
        PathMeasure pathMeasure = new PathMeasure();
        return pathMeasure;
    }
}

