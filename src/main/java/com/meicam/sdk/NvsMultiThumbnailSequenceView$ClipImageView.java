/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.widget.ImageView
 */
package com.meicam.sdk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.ImageView;

public class NvsMultiThumbnailSequenceView$ClipImageView
extends ImageView {
    private int m_clipWidth;

    public NvsMultiThumbnailSequenceView$ClipImageView(Context context, int n10) {
        super(context);
        this.m_clipWidth = n10;
    }

    public void onDraw(Canvas canvas) {
        int n10 = this.m_clipWidth;
        int n11 = this.getHeight();
        Rect rect = new Rect(0, 0, n10, n11);
        canvas.clipRect(rect);
        super.onDraw(canvas);
    }
}

