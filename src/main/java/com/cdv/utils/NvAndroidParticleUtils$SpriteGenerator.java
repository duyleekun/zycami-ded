/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Xfermode
 */
package com.cdv.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Xfermode;

public class NvAndroidParticleUtils$SpriteGenerator {
    private Canvas m_canvas;
    private Paint m_paint;
    private int m_spriteImageSize;

    public NvAndroidParticleUtils$SpriteGenerator(Bitmap bitmap, int n10) {
        Canvas canvas;
        this.m_canvas = canvas = new Canvas(bitmap);
        bitmap = PorterDuff.Mode.SRC;
        canvas.drawColor(0, (PorterDuff.Mode)bitmap);
        this.m_paint = bitmap;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC;
        super(mode);
        bitmap.setXfermode((Xfermode)canvas);
        this.m_paint.setAntiAlias(false);
        this.m_paint.setFilterBitmap(false);
        this.m_spriteImageSize = n10;
    }

    public void drawSpriteImage(int n10, int n11, Bitmap bitmap) {
        int n12;
        if (bitmap == null) {
            return;
        }
        int n13 = bitmap.getWidth();
        if (n13 == (n12 = this.m_spriteImageSize) && (n13 = bitmap.getHeight()) == (n12 = this.m_spriteImageSize)) {
            Canvas canvas = this.m_canvas;
            float f10 = n10;
            float f11 = n11;
            Paint paint = this.m_paint;
            canvas.drawBitmap(bitmap, f10, f11, paint);
        } else {
            Canvas canvas = this.m_canvas;
            n12 = 0;
            Object var9_11 = null;
            int n14 = this.m_spriteImageSize;
            int n15 = n10 + n14;
            Rect rect = new Rect(n10, n11, n15, n14 += n11);
            Paint paint = this.m_paint;
            canvas.drawBitmap(bitmap, null, rect, paint);
        }
    }
}

