/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.RectF
 */
package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.airbnb.lottie.animation.content.Content;

public interface DrawingContent
extends Content {
    public void draw(Canvas var1, Matrix var2, int var3);

    public void getBounds(RectF var1, Matrix var2, boolean var3);
}

