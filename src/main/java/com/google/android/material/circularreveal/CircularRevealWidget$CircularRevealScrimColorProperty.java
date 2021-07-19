/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Property
 */
package com.google.android.material.circularreveal;

import android.util.Property;
import com.google.android.material.circularreveal.CircularRevealWidget;

public class CircularRevealWidget$CircularRevealScrimColorProperty
extends Property {
    public static final Property CIRCULAR_REVEAL_SCRIM_COLOR;

    static {
        CircularRevealWidget$CircularRevealScrimColorProperty circularRevealWidget$CircularRevealScrimColorProperty = new CircularRevealWidget$CircularRevealScrimColorProperty("circularRevealScrimColor");
        CIRCULAR_REVEAL_SCRIM_COLOR = circularRevealWidget$CircularRevealScrimColorProperty;
    }

    private CircularRevealWidget$CircularRevealScrimColorProperty(String string2) {
        super(Integer.class, string2);
    }

    public Integer get(CircularRevealWidget circularRevealWidget) {
        return circularRevealWidget.getCircularRevealScrimColor();
    }

    public void set(CircularRevealWidget circularRevealWidget, Integer n10) {
        int n11 = n10;
        circularRevealWidget.setCircularRevealScrimColor(n11);
    }
}

