/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.text.TextUtils
 *  android.util.AttributeSet
 */
package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R$color;
import com.yalantis.ucrop.R$dimen;
import com.yalantis.ucrop.R$styleable;
import d.t.a.g.a;
import java.util.Locale;

public class AspectRatioTextView
extends AppCompatTextView {
    private final float a;
    private final Rect b;
    private Paint c;
    private int d;
    private float e;
    private String f;
    private float g;
    private float h;

    public AspectRatioTextView(Context context) {
        this(context, null);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        Object object;
        this.a = 1.5f;
        this.b = object = new Rect();
        object = R$styleable.ucrop_AspectRatioTextView;
        context = context.obtainStyledAttributes(attributeSet, (int[])object);
        this.d((TypedArray)context);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10);
        Object object;
        this.a = 1.5f;
        this.b = object = new Rect();
        object = R$styleable.ucrop_AspectRatioTextView;
        context = context.obtainStyledAttributes(attributeSet, (int[])object);
        this.d((TypedArray)context);
    }

    private void b(int n10) {
        Paint paint = this.c;
        if (paint != null) {
            paint.setColor(n10);
        }
        int n11 = 2;
        int[][] nArrayArray = new int[n11][];
        int n12 = 1;
        int[] nArray = new int[n12];
        nArray[0] = 0x10100A1;
        nArrayArray[0] = nArray;
        nArray = new int[n12];
        nArray[0] = 0;
        nArrayArray[n12] = nArray;
        int[] nArray2 = new int[n11];
        nArray2[0] = n10;
        Context context = this.getContext();
        int n13 = R$color.ucrop_color_widget;
        nArray2[n12] = n10 = ContextCompat.getColor(context, n13);
        paint = new ColorStateList((int[][])nArrayArray, nArray2);
        this.setTextColor((ColorStateList)paint);
    }

    private void d(TypedArray typedArray) {
        float f10;
        float f11;
        String string2;
        int n10 = 1;
        this.setGravity(n10);
        int n11 = R$styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_title;
        this.f = string2 = typedArray.getString(n11);
        n11 = R$styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_x;
        int n12 = 0;
        this.g = f11 = typedArray.getFloat(n11, 0.0f);
        n11 = R$styleable.ucrop_AspectRatioTextView_ucrop_artv_ratio_y;
        this.h = f11 = typedArray.getFloat(n11, 0.0f);
        float f12 = this.g;
        float f13 = f12 - 0.0f;
        float f14 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        this.e = f14 != false && (f14 = (f10 = f11 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) != false ? (f12 /= f11) : 0.0f;
        string2 = this.getContext().getResources();
        n12 = R$dimen.ucrop_size_dot_scale_text_view;
        this.d = n11 = string2.getDimensionPixelSize(n12);
        string2 = new Paint(n10);
        this.c = string2;
        Paint.Style style2 = Paint.Style.FILL;
        string2.setStyle(style2);
        this.f();
        style2 = this.getResources();
        n11 = R$color.ucrop_color_widget_active;
        n10 = style2.getColor(n11);
        this.b(n10);
        typedArray.recycle();
    }

    private void f() {
        Object object = this.f;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object = this.f;
            this.setText((CharSequence)object);
        } else {
            object = Locale.US;
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            Integer n11 = (int)this.g;
            objectArray[0] = n11;
            int n12 = 1;
            float f10 = this.h;
            int n13 = (int)f10;
            n11 = n13;
            objectArray[n12] = n11;
            String string2 = "%d:%d";
            object = String.format((Locale)object, string2, objectArray);
            this.setText((CharSequence)object);
        }
    }

    private void g() {
        float f10 = this.e;
        float f11 = 0.0f;
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            f10 = this.g;
            this.g = f11 = this.h;
            this.h = f10;
            this.e = f11 /= f10;
        }
    }

    public float c(boolean bl2) {
        if (bl2) {
            this.g();
            this.f();
        }
        return this.e;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int n10 = this.isSelected();
        if (n10 != 0) {
            Rect rect = this.b;
            canvas.getClipBounds(rect);
            rect = this.b;
            int n11 = rect.right;
            int n12 = rect.left;
            float f10 = n11 -= n12;
            n12 = 0x40000000;
            float f11 = 2.0f;
            int n13 = rect.bottom;
            float f12 = n13;
            float f13 = (float)rect.top / f11;
            f12 -= f13;
            n10 = this.d;
            float f14 = n10;
            float f15 = 1.5f;
            f13 = (float)n10 / f11;
            Paint paint = this.c;
            canvas.drawCircle(f10 /= f11, f12 -= (f14 *= f15), f13, paint);
        }
    }

    public void setActiveColor(int n10) {
        this.b(n10);
        this.invalidate();
    }

    public void setAspectRatio(a a10) {
        float f10;
        float f11;
        float f12;
        String string2;
        this.f = string2 = a10.a();
        this.g = f12 = a10.b();
        this.h = f11 = a10.c();
        f12 = this.g;
        float f13 = f12 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        this.e = object != false && (object = (f10 = f11 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) != false ? (f12 /= f11) : 0.0f;
        this.f();
    }
}

