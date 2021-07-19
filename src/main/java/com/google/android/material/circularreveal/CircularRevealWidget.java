/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.drawable.Drawable
 */
package com.google.android.material.circularreveal;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.material.circularreveal.CircularRevealHelper$Delegate;
import com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo;

public interface CircularRevealWidget
extends CircularRevealHelper$Delegate {
    public void buildCircularRevealCache();

    public void destroyCircularRevealCache();

    public void draw(Canvas var1);

    public Drawable getCircularRevealOverlayDrawable();

    public int getCircularRevealScrimColor();

    public CircularRevealWidget$RevealInfo getRevealInfo();

    public boolean isOpaque();

    public void setCircularRevealOverlayDrawable(Drawable var1);

    public void setCircularRevealScrimColor(int var1);

    public void setRevealInfo(CircularRevealWidget$RevealInfo var1);
}

