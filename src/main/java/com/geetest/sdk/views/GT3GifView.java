/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.DrawFilter
 *  android.graphics.Movie
 *  android.graphics.PaintFlagsDrawFilter
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package com.geetest.sdk.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Movie;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Build;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import java.io.InputStream;

public class GT3GifView
extends View {
    private int a;
    private Movie b;
    private long c;
    private int d;
    private float e;
    private float f;
    private float g;
    private int h;
    private int i;
    private volatile boolean j;
    private boolean k = true;

    public GT3GifView(Context context) {
        this(context, null);
    }

    public GT3GifView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GT3GifView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.a(context, attributeSet, n10);
    }

    private void a(Context context, AttributeSet attributeSet, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 11;
        if (n11 >= n12) {
            n11 = 1;
            n12 = 0;
            this.setLayerType(n11, null);
        }
        this.a = n11 = -1;
        this.j = false;
        n12 = this.a;
        if (n12 != n11) {
            context = this.getResources();
            n12 = this.a;
            context = Movie.decodeStream((InputStream)context.openRawResource(n12));
            this.b = context;
        }
    }

    private void a(Canvas canvas) {
        Movie movie = this.b;
        int n10 = this.d;
        movie.setTime(n10);
        canvas.save();
        movie = new PaintFlagsDrawFilter(0, 3);
        canvas.setDrawFilter((DrawFilter)movie);
        float f10 = this.g;
        canvas.scale(f10, f10);
        movie = this.b;
        float f11 = this.e;
        float f12 = this.g;
        float f13 = this.f / f12;
        movie.draw(canvas, f11 /= f12, f13);
        canvas.restore();
    }

    private void b() {
        int n10 = this.k;
        if (n10 != 0) {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 16;
            if (n10 >= n11) {
                this.postInvalidateOnAnimation();
            } else {
                this.invalidate();
            }
        }
    }

    private void c() {
        int n10;
        Movie movie;
        long l10 = SystemClock.uptimeMillis();
        long l11 = this.c;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            this.c = l10;
        }
        if ((object = (Object)(movie = this.b).duration()) == false) {
            object = 1000;
        }
        long l14 = this.c;
        l11 = object;
        this.d = n10 = (int)((l10 -= l14) % l11);
    }

    public void a() {
        boolean bl2 = this.j;
        if (bl2) {
            bl2 = false;
            this.j = false;
            long l10 = SystemClock.uptimeMillis();
            int n10 = this.d;
            long l11 = n10;
            this.c = l10 -= l11;
            this.invalidate();
        }
    }

    public int getGifResource() {
        return this.a;
    }

    public void onDraw(Canvas canvas) {
        Movie movie = this.b;
        if (movie != null) {
            boolean bl2 = this.j;
            if (!bl2) {
                this.c();
                this.a(canvas);
                this.b();
            } else {
                this.a(canvas);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        void var1_7;
        void var5_11;
        void var4_10;
        int n14;
        int n15;
        super.onLayout(bl2, n15, n14, (int)var4_10, (int)var5_11);
        int n16 = this.getWidth();
        n15 = this.h;
        float f10 = n16 - n15;
        n15 = 0x40000000;
        float f11 = 2.0f;
        this.e = f10 /= f11;
        int n17 = this.getHeight();
        n14 = this.i;
        this.f = f10 = (float)(n17 - n14) / f11;
        int n18 = this.getVisibility();
        if (n18 == 0) {
            boolean bl3 = true;
            f10 = Float.MIN_VALUE;
        } else {
            boolean bl4 = false;
            f10 = 0.0f;
        }
        this.k = var1_7;
    }

    public void onMeasure(int n10, int n11) {
        Movie movie = this.b;
        if (movie != null) {
            float f10;
            float f11;
            float f12;
            int n12 = movie.width();
            Movie movie2 = this.b;
            int n13 = movie2.height();
            int n14 = View.MeasureSpec.getMode((int)n10);
            int n15 = 1065353216;
            float f13 = 1.0f;
            if (n14 != 0 && n12 > (n10 = View.MeasureSpec.getSize((int)n10))) {
                f12 = n12;
                f11 = n10;
                f12 /= f11;
            } else {
                n14 = n15;
                f12 = f13;
            }
            n10 = View.MeasureSpec.getMode((int)n11);
            if (n10 != 0 && n13 > (n10 = View.MeasureSpec.getSize((int)n11))) {
                f10 = n13;
                f11 = n10;
                f10 /= f11;
            } else {
                n11 = n15;
                f10 = f13;
            }
            f11 = Math.max(f12, f10);
            this.g = f13 /= f11;
            f11 = (float)n12 * f13;
            this.h = n10 = (int)f11;
            f10 = (float)n13 * f13;
            this.i = n11 = (int)f10;
            this.setMeasuredDimension(n10, n11);
        } else {
            n10 = this.getSuggestedMinimumWidth();
            n11 = this.getSuggestedMinimumHeight();
            this.setMeasuredDimension(n10, n11);
        }
    }

    public void onScreenStateChanged(int n10) {
        super.onScreenStateChanged(n10);
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        this.k = n11;
        this.b();
    }

    public void onVisibilityChanged(View view, int n10) {
        boolean bl2;
        super.onVisibilityChanged(view, n10);
        if (n10 == 0) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        this.k = bl2;
        this.b();
    }

    public void onWindowVisibilityChanged(int n10) {
        super.onWindowVisibilityChanged(n10);
        n10 = n10 == 0 ? 1 : 0;
        this.k = n10;
        this.b();
    }

    public void setGifResource(int n10) {
        this.a = n10;
        Resources resources = this.getResources();
        int n11 = this.a;
        resources = Movie.decodeStream((InputStream)resources.openRawResource(n11));
        this.b = resources;
        this.requestLayout();
    }
}

