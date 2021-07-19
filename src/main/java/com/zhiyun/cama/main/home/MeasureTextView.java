/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.widget.TextView
 */
package com.zhiyun.cama.main.home;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import d.v.e.l.h2;

public class MeasureTextView
extends AppCompatTextView {
    private int a;
    private Paint b;
    private float c;

    public MeasureTextView(Context context) {
        this(context, null);
    }

    public MeasureTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MeasureTextView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        float f10;
        this.c = f10 = (float)h2.g(12.0f);
        this.f();
    }

    private String b(TextView textView) {
        String string2 = textView.getText().toString();
        textView = textView.getPaint();
        String[] stringArray = string2.replaceAll("\r", "");
        String string3 = "\n";
        stringArray = stringArray.split(string3);
        StringBuilder stringBuilder = new StringBuilder();
        for (String string4 : stringArray) {
            int n10;
            float f10;
            float f11 = textView.measureText(string4);
            float f12 = f11 - (f10 = (float)(n10 = this.a));
            Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object <= 0) {
                stringBuilder.append(string4);
            } else {
                char c10;
                object = false;
                f11 = 0.0f;
                f10 = 0.0f;
                float f13 = 0.0f;
                for (n10 = 0; n10 != (c10 = string4.length()); ++n10) {
                    c10 = string4.charAt(n10);
                    String string5 = String.valueOf(c10);
                    float f14 = textView.measureText(string5);
                    float f15 = (f13 += f14) - (f14 = (float)this.a);
                    Object object2 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
                    if (object2 <= 0) {
                        stringBuilder.append(c10);
                        continue;
                    }
                    stringBuilder.append(string3);
                    n10 += -1;
                    f13 = 0.0f;
                }
            }
            stringBuilder.append(string3);
        }
        int n11 = string2.endsWith(string3);
        if (n11 == 0) {
            n11 = stringBuilder.length() + -1;
            stringBuilder.deleteCharAt(n11);
        }
        return stringBuilder.toString();
    }

    private float c(String string2, float f10) {
        this.b.setTextSize(f10);
        return this.b.measureText(string2);
    }

    private void d() {
        int n10 = this.getMeasuredWidth();
        int n11 = this.getCompoundPaddingStart();
        n10 -= n11;
        n11 = this.getCompoundPaddingEnd();
        this.a = n10 -= n11;
    }

    private void f() {
        Paint paint;
        this.b = paint = new Paint();
    }

    private float g(float f10, int n10, String string2) {
        float f11 = 0.0f;
        float f12 = f10 - 0.0f;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            return this.c;
        }
        int n11 = this.a * n10;
        float f13 = n11;
        f11 = this.c(string2, f10);
        float f14 = f13 - f11;
        object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object < 0) {
            object = 1065353216;
            f11 = 1.0f;
            f10 -= f11;
            f10 = this.g(f10, n10, string2);
        }
        return f10;
    }

    public void onDraw(Canvas object) {
        boolean bl2;
        super.onDraw(object);
        float f10 = this.getTextSize();
        String string2 = this.getText().toString();
        int n10 = this.getMaxLines();
        f10 = this.g(f10, n10, string2);
        float f11 = this.c;
        float f12 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        f12 = f12 < 0 ? 1.0f : 0.0f;
        f10 = Math.max(f10, f11);
        this.setTextSize(0, f10);
        if (f12 != false) {
            int n11 = 100;
            f10 = 1.4E-43f;
            this.setMaxLines(n11);
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.b(this))) ? 1 : 0)) == 0 && !(bl2 = string2.equals(object))) {
            this.setText((CharSequence)object);
        }
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        this.d();
    }

    public void setMinSize(float f10) {
        this.c = f10;
    }
}

