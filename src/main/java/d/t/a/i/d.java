/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 */
package d.t.a.i;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class d
extends Drawable {
    private final Paint a;
    private Bitmap b;
    private int c;
    private int d;
    private int e;

    public d(Bitmap bitmap) {
        Paint paint;
        this.a = paint = new Paint(2);
        this.c = 255;
        this.b(bitmap);
    }

    public Bitmap a() {
        return this.b;
    }

    public void b(Bitmap bitmap) {
        this.b = bitmap;
        if (bitmap != null) {
            int n10;
            this.d = n10 = bitmap.getWidth();
            bitmap = this.b;
            this.e = n10 = bitmap.getHeight();
        } else {
            boolean bl2 = false;
            bitmap = null;
            this.e = 0;
            this.d = 0;
        }
    }

    public void draw(Canvas canvas) {
        boolean bl2;
        Bitmap bitmap = this.b;
        if (bitmap != null && !(bl2 = bitmap.isRecycled())) {
            bitmap = this.b;
            Rect rect = this.getBounds();
            Paint paint = this.a;
            canvas.drawBitmap(bitmap, null, rect, paint);
        }
    }

    public int getAlpha() {
        return this.c;
    }

    public int getIntrinsicHeight() {
        return this.e;
    }

    public int getIntrinsicWidth() {
        return this.d;
    }

    public int getMinimumHeight() {
        return this.e;
    }

    public int getMinimumWidth() {
        return this.d;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int n10) {
        this.c = n10;
        this.a.setAlpha(n10);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.a.setColorFilter(colorFilter);
    }

    public void setFilterBitmap(boolean bl2) {
        this.a.setFilterBitmap(bl2);
    }
}

