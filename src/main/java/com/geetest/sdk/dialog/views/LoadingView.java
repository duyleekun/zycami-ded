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
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
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
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3LoadImageView;
import com.geetest.sdk.model.beans.e;
import com.geetest.sdk.model.beans.f;
import com.geetest.sdk.model.beans.i;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.o;
import com.geetest.sdk.views.GT3GifView;

public class LoadingView
extends RelativeLayout {
    private RelativeLayout a;
    private View b;
    public GT3ConfigBean c;
    private int d;
    private int e;
    private int f;
    private Paint g;
    private Path h;
    private RectF i;

    public LoadingView(Context context, AttributeSet attributeSet, int n10, GT3LoadImageView gT3LoadImageView, GT3ConfigBean gT3ConfigBean) {
        super(context, attributeSet, n10);
        this.a(context, gT3LoadImageView, gT3ConfigBean);
    }

    public LoadingView(Context context, GT3LoadImageView gT3LoadImageView, GT3ConfigBean gT3ConfigBean) {
        this(context, null, 0, gT3LoadImageView, gT3ConfigBean);
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

    private void a(Context context, GT3LoadImageView object, GT3ConfigBean gT3ConfigBean) {
        int n10;
        this.c = gT3ConfigBean;
        this.a();
        gT3ConfigBean = LayoutInflater.from((Context)context);
        int n11 = o.c(context, "gt3_wait_progressdialog");
        int n12 = 1;
        gT3ConfigBean.inflate(n11, (ViewGroup)this, n12 != 0);
        int n13 = o.b(context, "gt3_wait_ll");
        gT3ConfigBean = (RelativeLayout)this.findViewById(n13);
        this.a = gT3ConfigBean;
        n13 = o.b(context, "gt3_wait_iv");
        gT3ConfigBean = (FrameLayout)this.findViewById(n13);
        String string2 = "LoadingView";
        if (object == null) {
            object = new GT3GifView(context);
            Object object2 = new e();
            n12 = ((e)object2).a();
            if (n12 != 0) {
                object.setGifResource(n12);
            } else {
                object2 = "gt3_new_bind_logo";
                n12 = o.a(context, (String)object2);
                object.setGifResource(n12);
            }
            object.a();
            float f10 = 24.0f;
            int n14 = com.geetest.sdk.utils.g.a(context, f10);
            int n15 = com.geetest.sdk.utils.g.a(context, f10);
            object2 = new FrameLayout.LayoutParams(n14, n15);
            gT3ConfigBean.addView((View)object, (ViewGroup.LayoutParams)object2);
            object = "custom view is null";
            l.b(string2, (String)object);
        } else {
            n12 = object.isGif();
            if (n12 != 0) {
                GT3GifView gT3GifView = new GT3GifView(context);
                int n16 = object.getIconRes();
                gT3GifView.setGifResource(n16);
                gT3GifView.a();
                int n17 = object.getLoadViewWidth();
                n10 = object.getLoadViewHeight();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n17, n10);
                gT3ConfigBean.addView(gT3GifView, (ViewGroup.LayoutParams)layoutParams);
                object = "custom gif res";
                l.b(string2, (String)object);
            } else {
                object.execute();
                int n18 = object.getLoadViewWidth();
                int n19 = object.getLoadViewHeight();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n18, n19);
                ViewParent viewParent = object.getParent();
                if (viewParent != null) {
                    viewParent = (ViewGroup)object.getParent();
                    viewParent.removeView(object);
                }
                gT3ConfigBean.addView((View)object, (ViewGroup.LayoutParams)layoutParams);
                object = "custom view";
                l.b(string2, (String)object);
            }
        }
        n10 = o.b(context, "gt3_wait_tv2");
        object = (TextView)this.findViewById(n10);
        n13 = o.b(context, "gt3_wait_tvvv");
        gT3ConfigBean = (TextView)this.findViewById(n13);
        string2 = com.geetest.sdk.model.beans.i.c();
        object.setText((CharSequence)string2);
        object = com.geetest.sdk.model.beans.i.i();
        gT3ConfigBean.setText((CharSequence)object);
        n10 = o.b(context, "gt3_wait_view1");
        this.b = object = this.findViewById(n10);
        n10 = (int)(com.geetest.sdk.model.beans.f.a() ? 1 : 0);
        if (n10 != 0) {
            object = this.a;
            n13 = 0;
            gT3ConfigBean = null;
            object.setVisibility(0);
            object = this.b;
            object.setVisibility(0);
        } else {
            object = this.a;
            n13 = 4;
            object.setVisibility(n13);
            object = this.b;
            object.setVisibility(n13);
        }
        object = "gt3_dialog_shape";
        int n20 = o.a(context, (String)object);
        try {
            this.setBackgroundResource(n20);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.h;
        Paint paint = this.g;
        canvas.drawPath(path, paint);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        float f10;
        GT3ConfigBean gT3ConfigBean;
        super.onSizeChanged(n10, n11, n12, n13);
        this.d = n10;
        this.e = n11;
        GT3ConfigBean gT3ConfigBean2 = this.c;
        if (gT3ConfigBean2 != null) {
            gT3ConfigBean2 = this.getContext();
            gT3ConfigBean = this.c;
            n11 = gT3ConfigBean.getCorners();
            f10 = n11;
            this.f = n10 = com.geetest.sdk.utils.g.a((Context)gT3ConfigBean2, f10);
        }
        f10 = this.d;
        float f11 = this.e;
        gT3ConfigBean2 = new RectF(0.0f, 0.0f, f10, f11);
        this.i = gT3ConfigBean2;
        gT3ConfigBean2 = new Path();
        this.h = gT3ConfigBean2;
        gT3ConfigBean = Path.FillType.INVERSE_WINDING;
        gT3ConfigBean2.setFillType((Path.FillType)gT3ConfigBean);
        gT3ConfigBean2 = this.h;
        gT3ConfigBean = this.i;
        f11 = this.f;
        Path.Direction direction = Path.Direction.CW;
        gT3ConfigBean2.addRoundRect((RectF)gT3ConfigBean, f11, f11, direction);
    }
}

