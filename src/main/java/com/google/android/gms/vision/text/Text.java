/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 *  android.graphics.Rect
 */
package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import java.util.List;

public interface Text {
    public Rect getBoundingBox();

    public List getComponents();

    public Point[] getCornerPoints();

    public String getLanguage();

    public String getValue();
}

