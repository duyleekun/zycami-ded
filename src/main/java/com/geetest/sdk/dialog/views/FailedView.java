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
 *  android.text.TextUtils
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
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.g;
import com.geetest.sdk.g$e;
import com.geetest.sdk.model.beans.f;
import com.geetest.sdk.model.beans.i;
import com.geetest.sdk.utils.o;

public class FailedView
extends RelativeLayout {
    private RelativeLayout a;
    private View b;
    private TextView c;
    private TextView d;
    private GT3ConfigBean e;
    private int f;
    private int g;
    private int h;
    private Paint i;
    private Path j;
    private RectF k;

    public FailedView(Context context, AttributeSet attributeSet, int n10, g g10, GT3ErrorBean gT3ErrorBean, g$e e10, GT3ConfigBean gT3ConfigBean) {
        super(context, attributeSet, n10);
        this.a(context, g10, gT3ErrorBean, e10, gT3ConfigBean);
    }

    public FailedView(Context context, g g10, GT3ErrorBean gT3ErrorBean, g$e e10, GT3ConfigBean gT3ConfigBean) {
        this(context, null, 0, g10, gT3ErrorBean, e10, gT3ConfigBean);
    }

    private void a() {
        Paint paint;
        this.i = paint = new Paint();
        paint.setColor(0);
        paint = this.i;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        this.i.setAntiAlias(true);
        paint = this.i;
        PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
        style2 = new PorterDuffXfermode(mode);
        paint.setXfermode((Xfermode)style2);
    }

    private void a(Context context, g object, GT3ErrorBean object2, g$e g$e, GT3ConfigBean object3) {
        this.e = object3;
        this.a();
        object = LayoutInflater.from((Context)context);
        object3 = "gt3_overtime_progressdialog";
        int n10 = o.c(context, (String)object3);
        boolean bl2 = true;
        object.inflate(n10, (ViewGroup)this, bl2);
        int n11 = o.b(context, "gt3_ot_view3");
        object = this.findViewById(n11);
        this.b = object;
        n11 = o.b(context, "gt3_ot_llll");
        object = (RelativeLayout)this.findViewById(n11);
        this.a = object;
        n11 = o.b(context, "tv_test_geetest_cord");
        object = (TextView)this.findViewById(n11);
        this.c = object;
        n11 = o.b(context, "gt3_ot_tv1");
        object = (TextView)this.findViewById(n11);
        this.d = object;
        object = ((GT3ErrorBean)object2).errorCode;
        n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n11 == 0) {
            object = this.c;
            object3 = ((GT3ErrorBean)object2).errorCode;
            object.setText((CharSequence)object3);
        }
        if ((n11 = (int)(TextUtils.isEmpty((CharSequence)(object = ((GT3ErrorBean)object2).errorCode)) ? 1 : 0)) == 0 && (n11 = (int)(((String)(object = ((GT3ErrorBean)object2).errorCode)).startsWith((String)(object3 = "_")) ? 1 : 0)) != 0 && (n11 = (int)(TextUtils.isEmpty((CharSequence)(object = ((GT3ErrorBean)object2).errorDesc)) ? 1 : 0)) == 0) {
            object = this.d;
            object2 = ((GT3ErrorBean)object2).errorDesc;
            object.setText((CharSequence)object2);
        } else {
            object = this.d;
            object2 = com.geetest.sdk.model.beans.i.f();
            object.setText((CharSequence)object2);
        }
        n11 = o.b(context, "gt3_ot_tvvv");
        object = (TextView)this.findViewById(n11);
        object2 = com.geetest.sdk.model.beans.i.i();
        object.setText((CharSequence)object2);
        n11 = (int)(com.geetest.sdk.model.beans.f.a() ? 1 : 0);
        if (n11 != 0) {
            object = this.a;
            boolean bl3 = false;
            object2 = null;
            object.setVisibility(0);
            object = this.b;
            object.setVisibility(0);
        } else {
            object = this.a;
            int n12 = 4;
            object.setVisibility(n12);
            object = this.b;
            object.setVisibility(n12);
        }
        long l10 = 1200L;
        this.postDelayed(g$e, l10);
        object = "gt3_dialog_shape";
        int n13 = o.a(context, (String)object);
        try {
            this.setBackgroundResource(n13);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.j;
        Paint paint = this.i;
        canvas.drawPath(path, paint);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        float f10;
        GT3ConfigBean gT3ConfigBean;
        super.onSizeChanged(n10, n11, n12, n13);
        this.f = n10;
        this.g = n11;
        GT3ConfigBean gT3ConfigBean2 = this.e;
        if (gT3ConfigBean2 != null) {
            gT3ConfigBean2 = this.getContext();
            gT3ConfigBean = this.e;
            n11 = gT3ConfigBean.getCorners();
            f10 = n11;
            this.h = n10 = com.geetest.sdk.utils.g.a((Context)gT3ConfigBean2, f10);
        }
        f10 = this.f;
        float f11 = this.g;
        gT3ConfigBean2 = new RectF(0.0f, 0.0f, f10, f11);
        this.k = gT3ConfigBean2;
        gT3ConfigBean2 = new Path();
        this.j = gT3ConfigBean2;
        gT3ConfigBean = Path.FillType.INVERSE_WINDING;
        gT3ConfigBean2.setFillType((Path.FillType)gT3ConfigBean);
        gT3ConfigBean2 = this.j;
        gT3ConfigBean = this.k;
        f11 = this.h;
        Path.Direction direction = Path.Direction.CW;
        gT3ConfigBean2.addRoundRect((RectF)gT3ConfigBean, f11, f11, direction);
    }
}

