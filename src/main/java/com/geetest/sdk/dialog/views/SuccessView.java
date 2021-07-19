/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Path$FillType
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.RelativeLayout
 *  android.widget.TextView
 */
package com.geetest.sdk.dialog.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.dialog.views.SuccessView$a;
import com.geetest.sdk.g;
import com.geetest.sdk.model.beans.f;
import com.geetest.sdk.model.beans.i;
import com.geetest.sdk.utils.o;
import com.geetest.sdk.views.GT3View;
import com.geetest.sdk.views.GT3View$b;

public class SuccessView
extends RelativeLayout {
    private RelativeLayout a;
    private View b;
    private GT3ConfigBean c;
    private int d;
    private int e;
    private int f;
    private Paint g;
    private Path h;
    private RectF i;

    public SuccessView(Context context, AttributeSet attributeSet, int n10, g g10, GT3ConfigBean gT3ConfigBean) {
        super(context, attributeSet, n10);
        this.a(context, g10, gT3ConfigBean);
    }

    public SuccessView(Context context, g g10, GT3ConfigBean gT3ConfigBean) {
        this(context, null, 0, g10, gT3ConfigBean);
    }

    private void a() {
        Paint paint;
        this.g = paint = new Paint();
        paint.setColor(0);
        paint = this.g;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        this.g.setAntiAlias(true);
        paint = this.g;
        PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
        style2 = new PorterDuffXfermode(mode);
        paint.setXfermode((Xfermode)style2);
    }

    private void a(Context context, g object, GT3ConfigBean object2) {
        this.c = object2;
        this.a();
        object2 = LayoutInflater.from((Context)context);
        int n10 = o.c(context, "gt3_success_progressdialog");
        boolean bl2 = true;
        object2.inflate(n10, (ViewGroup)this, bl2);
        int n11 = o.b(context, "gt3_success_view2");
        object2 = this.findViewById(n11);
        this.b = object2;
        n11 = o.b(context, "gt3_success_lll");
        object2 = (RelativeLayout)this.findViewById(n11);
        this.a = object2;
        n11 = o.b(context, "gt3_success_tv1");
        object2 = (TextView)this.findViewById(n11);
        n10 = o.b(context, "gt3_success_tvvv");
        Object object3 = (TextView)this.findViewById(n10);
        String string2 = com.geetest.sdk.model.beans.i.g();
        object2.setText((CharSequence)string2);
        object2 = com.geetest.sdk.model.beans.i.i();
        object3.setText((CharSequence)object2);
        n11 = (int)(com.geetest.sdk.model.beans.f.a() ? 1 : 0);
        if (n11 != 0) {
            object2 = this.a;
            n10 = 0;
            object3 = null;
            object2.setVisibility(0);
            object2 = this.b;
            object2.setVisibility(0);
        } else {
            object2 = this.a;
            n10 = 4;
            object2.setVisibility(n10);
            object2 = this.b;
            object2.setVisibility(n10);
        }
        n11 = o.b(context, "gt3_success_iv");
        object2 = (GT3View)this.findViewById(n11);
        ((GT3View)((Object)object2)).a();
        object3 = new SuccessView$a(this, (g)object);
        ((GT3View)((Object)object2)).setGtListener((GT3View$b)object3);
        object = "gt3_dialog_shape";
        int n12 = o.a(context, (String)object);
        try {
            this.setBackgroundResource(n12);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.h;
        Paint paint = this.g;
        try {
            canvas.drawPath(path, paint);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        float f10;
        GT3ConfigBean gT3ConfigBean;
        GT3ConfigBean gT3ConfigBean2;
        block20: {
            super.onSizeChanged(n10, n11, n12, n13);
            this.d = n10;
            this.e = n11;
            gT3ConfigBean2 = this.c;
            if (gT3ConfigBean2 == null) break block20;
            gT3ConfigBean2 = this.getContext();
            gT3ConfigBean = this.c;
            n11 = gT3ConfigBean.getCorners();
            f10 = n11;
            n10 = com.geetest.sdk.utils.g.a((Context)gT3ConfigBean2, f10);
            this.f = n10;
        }
        n11 = this.d;
        f10 = n11;
        n12 = this.e;
        float f11 = n12;
        n13 = 0;
        float f12 = 0.0f;
        gT3ConfigBean2 = new RectF(0.0f, 0.0f, f10, f11);
        this.i = gT3ConfigBean2;
        gT3ConfigBean2 = new Path();
        this.h = gT3ConfigBean2;
        gT3ConfigBean = Path.FillType.INVERSE_WINDING;
        gT3ConfigBean2.setFillType((Path.FillType)gT3ConfigBean);
        gT3ConfigBean2 = this.h;
        gT3ConfigBean = this.i;
        n12 = this.f;
        f12 = n12;
        f11 = n12;
        Path.Direction direction = Path.Direction.CW;
        try {
            gT3ConfigBean2.addRoundRect((RectF)gT3ConfigBean, f12, f11, direction);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

