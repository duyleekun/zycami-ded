/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 */
package com.zhiyun.account.me.account.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.account.me.account.widget.SideBar$a;
import d.v.e.l.h2;

public class SideBar
extends View {
    private int a;
    public String[] b;
    private int c;
    public Paint d;
    private SideBar$a e;

    public SideBar(Context paint) {
        super((Context)paint);
        int n10;
        this.a = n10 = h2.b(10.0f);
        paint = new Paint[]{"#"};
        this.b = paint;
        this.c = -1;
        this.d = paint = new Paint();
    }

    public SideBar(Context paint, AttributeSet attributeSet) {
        super((Context)paint, attributeSet);
        int n10;
        this.a = n10 = h2.b(10.0f);
        paint = new Paint[]{"#"};
        this.b = paint;
        this.c = -1;
        this.d = paint = new Paint();
    }

    public SideBar(Context paint, AttributeSet attributeSet, int n10) {
        super((Context)paint, attributeSet, n10);
        int n11;
        this.a = n11 = h2.b(10.0f);
        paint = new Paint[]{"#"};
        this.b = paint;
        this.c = -1;
        this.d = paint = new Paint();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        float f10 = motionEvent.getY();
        int n11 = this.c;
        int n12 = this.getHeight();
        SideBar$a sideBar$a = this.e;
        String[] stringArray = this.b;
        int n13 = stringArray.length;
        float f11 = (float)n13 * f10;
        f10 = n12;
        int n14 = (int)(f11 /= f10);
        n12 = 1;
        if (n10 != n12) {
            if (n11 != n14 && n14 >= 0 && n14 < (n10 = stringArray.length)) {
                if (sideBar$a != null) {
                    String string2 = stringArray[n14];
                    sideBar$a.a(string2);
                }
                this.c = n14;
                this.invalidate();
            }
        } else {
            n14 = -1;
            f10 = 0.0f / 0.0f;
            this.c = n14;
            this.invalidate();
        }
        return n12;
    }

    public void onDraw(Canvas canvas) {
        Paint paint;
        int n10;
        super.onDraw(canvas);
        int n11 = this.getHeight();
        int n12 = this.getWidth();
        String[] stringArray = this.b;
        int n13 = stringArray.length;
        int n14 = this.a;
        n11 -= (n13 *= n14);
        int n15 = stringArray.length;
        n13 = 1;
        n11 /= (n15 += n13);
        n15 = 0;
        stringArray = null;
        for (n14 = 0; n14 < (n10 = ((String[])(paint = this.b)).length); ++n14) {
            this.setPaintColor(false);
            paint = this.d;
            Typeface typeface = Typeface.DEFAULT_BOLD;
            paint.setTypeface(typeface);
            this.d.setAntiAlias(n13 != 0);
            paint = this.d;
            int n16 = 1106247680;
            float f10 = 30.0f;
            paint.setTextSize(f10);
            n10 = this.c;
            if (n14 == n10) {
                this.setPaintColor(n13 != 0);
                paint = this.d;
                paint.setFakeBoldText(n13 != 0);
            }
            n10 = n12 / 2;
            float f11 = n10;
            typeface = this.d;
            String string2 = this.b[n14];
            f10 = typeface.measureText(string2);
            float f12 = 2.0f;
            n16 = n11 * n14;
            int n17 = this.a * n14;
            n16 = n16 + n17 + n11;
            f10 = n16;
            string2 = this.b[n14];
            Paint paint2 = this.d;
            canvas.drawText(string2, f11 -= (f10 /= f12), f10, paint2);
            paint = this.d;
            paint.reset();
        }
    }

    public void setOnTouchingSessionChangedListener(SideBar$a sideBar$a) {
        this.e = sideBar$a;
    }

    public void setPaintColor(boolean bl2) {
        if (bl2) {
            Paint paint = this.d;
            int n10 = 1112014848;
            float f10 = 50.0f;
            paint.setTextSize(f10);
        } else {
            Paint paint = this.d;
            String string2 = "#BBBBBB";
            int n11 = Color.parseColor((String)string2);
            paint.setColor(n11);
        }
    }

    public void setSideBarSessions(String[] stringArray) {
        if (stringArray == null) {
            return;
        }
        this.b = stringArray;
        this.postInvalidate();
    }
}

