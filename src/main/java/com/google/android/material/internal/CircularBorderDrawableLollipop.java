/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.graphics.Rect
 */
package com.google.android.material.internal;

import android.graphics.Outline;
import android.graphics.Rect;
import com.google.android.material.internal.CircularBorderDrawable;

public class CircularBorderDrawableLollipop
extends CircularBorderDrawable {
    public void getOutline(Outline outline) {
        Rect rect = this.rect;
        this.copyBounds(rect);
        rect = this.rect;
        outline.setOval(rect);
    }
}

