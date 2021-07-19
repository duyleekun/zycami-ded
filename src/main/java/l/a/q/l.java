/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.widget.ImageView
 */
package l.a.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.ImageViewCompat;
import l.a.j.a.d;
import l.a.j.a.h;
import l.a.q.j;
import skin.support.R$styleable;

public class l
extends j {
    private static final String g = "l";
    private final ImageView c;
    private int d = 0;
    private int e = 0;
    private int f = 0;

    public l(ImageView imageView) {
        this.c = imageView;
    }

    public void a() {
        ImageView imageView;
        int n10;
        Context context;
        int n11;
        this.e = n11 = j.b(this.e);
        if (n11 != 0) {
            context = this.c.getContext();
            n10 = this.e;
            if ((context = h.a(context, n10)) != null) {
                imageView = this.c;
                imageView.setImageDrawable((Drawable)context);
            }
        } else {
            this.d = n11 = j.b(this.d);
            if (n11 != 0) {
                context = this.c.getContext();
                n10 = this.d;
                if ((context = h.a(context, n10)) != null) {
                    imageView = this.c;
                    imageView.setImageDrawable((Drawable)context);
                }
            }
        }
        this.f = n11 = j.b(this.f);
        if (n11 != 0) {
            context = this.c.getContext();
            n10 = this.f;
            context = l.a.j.a.d.e(context, n10);
            imageView = this.c;
            ImageViewCompat.setImageTintList(imageView, (ColorStateList)context);
        }
    }

    public void c(AttributeSet attributeSet, int n10) {
        TypedArray typedArray;
        block17: {
            typedArray = null;
            ImageView imageView = this.c;
            imageView = imageView.getContext();
            int[] nArray = R$styleable.SkinCompatImageView;
            typedArray = imageView.obtainStyledAttributes(attributeSet, nArray, n10, 0);
            int n11 = R$styleable.SkinCompatImageView_android_src;
            n11 = typedArray.getResourceId(n11, 0);
            this.d = n11;
            n11 = R$styleable.SkinCompatImageView_srcCompat;
            n11 = typedArray.getResourceId(n11, 0);
            this.e = n11;
            n11 = R$styleable.SkinCompatImageView_tint;
            n11 = typedArray.getResourceId(n11, 0);
            this.f = n11;
            if (n11 != 0) break block17;
            n11 = R$styleable.SkinCompatImageView_android_tint;
            this.f = n11 = typedArray.getResourceId(n11, 0);
        }
        this.a();
        return;
        finally {
            if (typedArray != null) {
                typedArray.recycle();
            }
        }
    }

    public void d(int n10) {
        this.d = n10;
        this.e = 0;
        this.a();
    }
}

