/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.BitmapShader
 *  android.graphics.ColorFilter
 *  android.graphics.Rect
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.AnimationDrawable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.ClipDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ShapeDrawable
 *  android.graphics.drawable.shapes.RoundRectShape
 *  android.graphics.drawable.shapes.Shape
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.widget.ProgressBar
 */
package l.a.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import l.a.j.a.d;
import l.a.j.a.h;
import l.a.o.b;
import l.a.q.j;
import skin.support.appcompat.R$styleable;

public class q
extends j {
    private final ProgressBar c;
    private Bitmap d;
    private int e = 0;
    private int f = 0;
    private int g = 0;

    public q(ProgressBar progressBar) {
        this.c = progressBar;
    }

    private int c(int n10) {
        return j.b(n10);
    }

    private Shape d() {
        float[] fArray;
        float[] fArray2 = fArray = new float[8];
        float[] fArray3 = fArray;
        fArray2[0] = 5.0f;
        fArray3[1] = 5.0f;
        fArray2[2] = 5.0f;
        fArray3[3] = 5.0f;
        fArray2[4] = 5.0f;
        fArray3[5] = 5.0f;
        fArray2[6] = 5.0f;
        fArray3[7] = 5.0f;
        RoundRectShape roundRectShape = new RoundRectShape(fArray, null, null);
        return roundRectShape;
    }

    private Drawable f(Drawable drawable2, boolean n10) {
        int n11 = l.a.o.b.h(drawable2);
        if (n11 != 0) {
            Drawable drawable3 = l.a.o.b.b(drawable2);
            if (drawable3 != null) {
                Drawable drawable4 = this.f(drawable3, n10 != 0);
                l.a.o.b.k(drawable2, drawable4);
            }
        } else {
            n11 = l.a.o.b.g(drawable2);
            if (n11 != 0) {
                Drawable drawable5 = l.a.o.b.a(drawable2);
                if (drawable5 != null) {
                    Drawable drawable6 = this.f(drawable5, n10 != 0);
                    l.a.o.b.j(drawable2, drawable6);
                }
            } else {
                n11 = drawable2 instanceof LayerDrawable;
                int n12 = 1;
                if (n11 != 0) {
                    drawable2 = (LayerDrawable)drawable2;
                    n10 = drawable2.getNumberOfLayers();
                    Drawable[] drawableArray = new Drawable[n10];
                    int n13 = 0;
                    Object var8_12 = null;
                    Object var10_15 = null;
                    for (int i10 = 0; i10 < n10; ++i10) {
                        Drawable drawable7;
                        int n14 = drawable2.getId(i10);
                        Drawable drawable8 = drawable2.getDrawable(i10);
                        int n15 = 16908301;
                        if (n14 != n15 && n14 != (n15 = 16908303)) {
                            n14 = 0;
                            drawable7 = null;
                        } else {
                            n14 = n12;
                        }
                        drawableArray[i10] = drawable7 = this.f(drawable8, n14 != 0);
                    }
                    LayerDrawable layerDrawable = new LayerDrawable(drawableArray);
                    while (n13 < n10) {
                        n11 = drawable2.getId(n13);
                        layerDrawable.setId(n13, n11);
                        ++n13;
                    }
                    return layerDrawable;
                }
                n11 = drawable2 instanceof BitmapDrawable;
                if (n11 != 0) {
                    drawable2 = (BitmapDrawable)drawable2;
                    Bitmap bitmap = drawable2.getBitmap();
                    Bitmap bitmap2 = this.d;
                    if (bitmap2 == null) {
                        this.d = bitmap;
                    }
                    Shape shape = this.d();
                    bitmap2 = new ShapeDrawable(shape);
                    Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                    Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
                    shape = new BitmapShader(bitmap, tileMode, tileMode2);
                    bitmap2.getPaint().setShader((Shader)shape);
                    bitmap = bitmap2.getPaint();
                    drawable2 = drawable2.getPaint().getColorFilter();
                    bitmap.setColorFilter((ColorFilter)drawable2);
                    if (n10) {
                        n10 = 3;
                        drawable2 = new ClipDrawable((Drawable)bitmap2, n10, n12);
                        bitmap2 = drawable2;
                    }
                    return bitmap2;
                }
            }
        }
        return drawable2;
    }

    private Drawable g(Drawable drawable2) {
        int n10 = drawable2 instanceof AnimationDrawable;
        if (n10 != 0) {
            int n11;
            drawable2 = (AnimationDrawable)drawable2;
            n10 = drawable2.getNumberOfFrames();
            AnimationDrawable animationDrawable = new AnimationDrawable();
            int n12 = drawable2.isOneShot();
            animationDrawable.setOneShot(n12 != 0);
            n12 = 0;
            while (true) {
                n11 = 10000;
                if (n12 >= n10) break;
                Drawable drawable3 = drawable2.getFrame(n12);
                boolean bl2 = true;
                drawable3 = this.f(drawable3, bl2);
                drawable3.setLevel(n11);
                n11 = drawable2.getDuration(n12);
                animationDrawable.addFrame(drawable3, n11);
                ++n12;
            }
            animationDrawable.setLevel(n11);
            drawable2 = animationDrawable;
        }
        return drawable2;
    }

    public void a() {
        int n10;
        Rect rect;
        int n11;
        Context context;
        int n12;
        this.e = n12 = j.b(this.e);
        if (n12 != 0) {
            context = this.c.getContext();
            n11 = this.e;
            context = h.a(context, n11);
            rect = this.c.getIndeterminateDrawable().getBounds();
            context.setBounds(rect);
            rect = this.c;
            context = this.g((Drawable)context);
            rect.setIndeterminateDrawable((Drawable)context);
        }
        n12 = this.f;
        this.f = n12 = this.c(n12);
        if (n12 != 0) {
            context = this.c.getContext();
            n11 = this.f;
            context = h.a(context, n11);
            rect = this.c;
            n10 = 0;
            context = this.f((Drawable)context, false);
            rect.setProgressDrawable((Drawable)context);
        }
        if ((n12 = Build.VERSION.SDK_INT) > (n11 = 21)) {
            this.g = n12 = j.b(this.g);
            if (n12 != 0) {
                context = this.c;
                rect = context.getContext();
                n10 = this.g;
                rect = l.a.j.a.d.e((Context)rect, n10);
                context.setIndeterminateTintList((ColorStateList)rect);
            }
        }
    }

    public void e(AttributeSet attributeSet, int n10) {
        Context context = this.c.getContext();
        int[] nArray = R$styleable.SkinCompatProgressBar;
        context = context.obtainStyledAttributes(attributeSet, nArray, n10, 0);
        int n11 = R$styleable.SkinCompatProgressBar_android_indeterminateDrawable;
        this.e = n11 = context.getResourceId(n11, 0);
        n11 = R$styleable.SkinCompatProgressBar_android_progressDrawable;
        this.f = n11 = context.getResourceId(n11, 0);
        context.recycle();
        int n12 = Build.VERSION.SDK_INT;
        n11 = 21;
        if (n12 > n11) {
            int n13;
            context = this.c.getContext();
            n11 = 1;
            nArray = new int[n11];
            nArray[0] = n13 = 16843881;
            attributeSet = context.obtainStyledAttributes(attributeSet, nArray, n10, 0);
            this.g = n10 = attributeSet.getResourceId(0, 0);
            attributeSet.recycle();
        }
        this.a();
    }
}

