/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.text.Layout
 *  android.text.TextPaint
 *  android.util.AttributeSet
 */
package com.zhiyun.common.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import d.v.e.l.h2;

public class RotateTextView
extends AppCompatTextView {
    private int a = 3;
    private Bitmap b;
    private int c;
    private Rect d;

    public RotateTextView(Context context) {
        super(context);
    }

    public RotateTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getDirection() {
        return this.a;
    }

    public void onDraw(Canvas canvas) {
        float f10;
        int n10;
        float f11;
        TextPaint textPaint = this.getPaint();
        int n11 = this.getCurrentTextColor();
        textPaint.setColor(n11);
        Object object = this.getDrawableState();
        textPaint.drawableState = object;
        canvas.save();
        n11 = this.a;
        int n12 = 2;
        if (n11 == 0) {
            f11 = this.getHeight();
            canvas.translate(0.0f, f11);
            n11 = -1028390912;
            f11 = -90.0f;
            canvas.rotate(f11);
        } else {
            n10 = 1;
            f10 = Float.MIN_VALUE;
            if (n11 == n10) {
                f11 = this.getWidth();
                n10 = this.getHeight();
                f10 = n10;
                canvas.translate(f11, f10);
                n11 = 0x43340000;
                f11 = 180.0f;
                canvas.rotate(f11);
            } else if (n11 == n12) {
                f11 = this.getWidth();
                canvas.translate(f11, 0.0f);
                n11 = 1119092736;
                f11 = 90.0f;
                canvas.rotate(f11);
            }
        }
        n11 = this.getCompoundPaddingLeft();
        f11 = n11;
        n10 = this.getExtendedPaddingTop();
        f10 = n10;
        canvas.translate(f11, f10);
        object = this.b;
        if (object != null) {
            Bitmap bitmap;
            object = this.getLayout();
            n10 = 0;
            f10 = 0.0f;
            n11 = object.getLineBaseline(0);
            Layout layout2 = this.getLayout();
            Rect rect = this.d;
            layout2.getLineBounds(n11, rect);
            n11 = this.a;
            if (n11 != 0 && n11 != n12) {
                object = this.d;
                n11 = object.top;
                bitmap = this.b;
                n12 = bitmap.getHeight();
            } else {
                object = this.d;
                n11 = object.top;
                bitmap = this.b;
                n12 = bitmap.getWidth();
            }
            bitmap = this.b;
            f11 = n11 -= n12;
            canvas.drawBitmap(bitmap, 0.0f, f11, (Paint)textPaint);
            int n13 = this.c;
            float f12 = n13;
            canvas.translate(f12, 0.0f);
        }
        this.getLayout().draw(canvas);
        canvas.restore();
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        int n13 = this.a;
        if (n13 != 0 && n13 != (n12 = 2)) {
            super.onMeasure(n10, n11);
            n10 = this.getMeasuredWidth();
            n11 = this.c;
            n10 += n11;
            n11 = this.getMeasuredHeight();
            this.setMeasuredDimension(n10, n11);
        } else {
            super.onMeasure(n11, n10);
            n10 = this.getMeasuredHeight();
            n11 = this.getMeasuredWidth();
            n13 = this.c;
            this.setMeasuredDimension(n10, n11 += n13);
        }
    }

    public void setDirection(int n10) {
        this.a = n10;
        this.postInvalidate();
    }

    public void setLeftCompoundDrawables(int n10) {
        int n11;
        Bitmap bitmap;
        this.b = bitmap = ((BitmapDrawable)this.getResources().getDrawable(n10)).getBitmap();
        n10 = h2.b(6.0f);
        this.c = n11 = this.b.getWidth() + n10;
        bitmap = new Rect();
        this.d = bitmap;
    }
}

