/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Property
 */
package com.google.android.material.circularreveal;

import android.util.Property;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo;

public class CircularRevealWidget$CircularRevealProperty
extends Property {
    public static final Property CIRCULAR_REVEAL;

    static {
        CircularRevealWidget$CircularRevealProperty circularRevealWidget$CircularRevealProperty = new CircularRevealWidget$CircularRevealProperty("circularReveal");
        CIRCULAR_REVEAL = circularRevealWidget$CircularRevealProperty;
    }

    private CircularRevealWidget$CircularRevealProperty(String string2) {
        super(CircularRevealWidget$RevealInfo.class, string2);
    }

    public CircularRevealWidget$RevealInfo get(CircularRevealWidget circularRevealWidget) {
        return circularRevealWidget.getRevealInfo();
    }

    public void set(CircularRevealWidget circularRevealWidget, CircularRevealWidget$RevealInfo circularRevealWidget$RevealInfo) {
        circularRevealWidget.setRevealInfo(circularRevealWidget$RevealInfo);
    }
}

