/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package com.geetest.sdk.views;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.geetest.sdk.GT3GeetestUtils;
import com.geetest.sdk.b;
import com.geetest.sdk.model.beans.GT3ViewColor;
import com.geetest.sdk.model.beans.d;
import com.geetest.sdk.model.beans.i;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.o;
import com.geetest.sdk.utils.p;
import com.geetest.sdk.views.GT3GeetestButton$a;
import com.geetest.sdk.views.GT3GeetestButton$b;
import com.geetest.sdk.views.GT3GeetestView;
import java.util.ArrayList;
import java.util.List;

public class GT3GeetestButton
extends LinearLayout {
    private boolean ajaxisfinish;
    private boolean canDownTime;
    private boolean canTouch;
    private boolean candodododo;
    private Context context;
    private boolean downTime;
    private GT3GeetestUtils geetestUnbindHolder;
    private GT3GeetestView geetestView;
    private boolean gogogogo;
    private boolean islogo;
    private ImageView ivGeetestLogo;
    private final List list;
    private GT3GeetestButton$b listenerImpl;
    private boolean sensorAvailable;
    private boolean touch;
    private TextView tvTestGeetest;
    private TextView tverror;
    private TextView tverrorcode;

    public GT3GeetestButton(Context context) {
        super(context);
        ArrayList arrayList;
        boolean bl2;
        this.sensorAvailable = bl2 = true;
        this.touch = bl2;
        this.downTime = false;
        this.list = arrayList = new ArrayList();
        this.canTouch = false;
        this.canDownTime = false;
        this.candodododo = false;
        this.gogogogo = bl2;
        this.ajaxisfinish = bl2;
        this.init(context);
    }

    public GT3GeetestButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ArrayList arrayList;
        boolean bl2;
        this.sensorAvailable = bl2 = true;
        this.touch = bl2;
        this.downTime = false;
        this.list = arrayList = new ArrayList();
        this.canTouch = false;
        this.canDownTime = false;
        this.candodododo = false;
        this.gogogogo = bl2;
        this.ajaxisfinish = bl2;
        this.init(context);
    }

    public GT3GeetestButton(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        ArrayList arrayList;
        boolean bl2;
        this.sensorAvailable = bl2 = true;
        this.touch = bl2;
        this.downTime = false;
        this.list = arrayList = new ArrayList();
        this.canTouch = false;
        this.canDownTime = false;
        this.candodododo = false;
        this.gogogogo = bl2;
        this.ajaxisfinish = bl2;
        this.init(context);
    }

    public static /* synthetic */ boolean access$002(GT3GeetestButton gT3GeetestButton, boolean bl2) {
        gT3GeetestButton.candodododo = bl2;
        return bl2;
    }

    public static /* synthetic */ boolean access$100(GT3GeetestButton gT3GeetestButton) {
        return gT3GeetestButton.sensorAvailable;
    }

    public static /* synthetic */ boolean access$1002(GT3GeetestButton gT3GeetestButton, boolean bl2) {
        gT3GeetestButton.touch = bl2;
        return bl2;
    }

    public static /* synthetic */ TextView access$1100(GT3GeetestButton gT3GeetestButton) {
        return gT3GeetestButton.tverror;
    }

    public static /* synthetic */ boolean access$1202(GT3GeetestButton gT3GeetestButton, boolean bl2) {
        gT3GeetestButton.canDownTime = bl2;
        return bl2;
    }

    public static /* synthetic */ TextView access$1300(GT3GeetestButton gT3GeetestButton) {
        return gT3GeetestButton.tverrorcode;
    }

    public static /* synthetic */ boolean access$202(GT3GeetestButton gT3GeetestButton, boolean bl2) {
        gT3GeetestButton.downTime = bl2;
        return bl2;
    }

    public static /* synthetic */ Context access$300(GT3GeetestButton gT3GeetestButton) {
        return gT3GeetestButton.context;
    }

    public static /* synthetic */ Activity access$400(Context context) {
        return GT3GeetestButton.scanForActivity(context);
    }

    public static /* synthetic */ GT3GeetestView access$500(GT3GeetestButton gT3GeetestButton) {
        return gT3GeetestButton.geetestView;
    }

    public static /* synthetic */ boolean access$600(GT3GeetestButton gT3GeetestButton) {
        return gT3GeetestButton.islogo;
    }

    public static /* synthetic */ boolean access$602(GT3GeetestButton gT3GeetestButton, boolean bl2) {
        gT3GeetestButton.islogo = bl2;
        return bl2;
    }

    public static /* synthetic */ ImageView access$700(GT3GeetestButton gT3GeetestButton) {
        return gT3GeetestButton.ivGeetestLogo;
    }

    public static /* synthetic */ TextView access$800(GT3GeetestButton gT3GeetestButton) {
        return gT3GeetestButton.tvTestGeetest;
    }

    public static /* synthetic */ boolean access$902(GT3GeetestButton gT3GeetestButton, boolean bl2) {
        gT3GeetestButton.ajaxisfinish = bl2;
        return bl2;
    }

    private void init(Context object) {
        Object object2;
        this.context = object;
        String string2 = i.a();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            i.a((Context)object);
        }
        string2 = (LayoutInflater)object.getApplicationContext().getSystemService("layout_inflater");
        int n10 = o.c((Context)object, "gt3_ll_geetest_view");
        string2 = string2.inflate(n10, (ViewGroup)this);
        n10 = o.b((Context)object, "geetest_view");
        this.geetestView = object2 = (GT3GeetestView)string2.findViewById(n10);
        n10 = o.b((Context)object, "tv_test_geetest_cof");
        object2 = (TextView)string2.findViewById(n10);
        this.tverror = object2;
        n10 = o.b((Context)object, "tv_test_geetest_cord");
        object2 = (TextView)string2.findViewById(n10);
        this.tverrorcode = object2;
        n10 = o.b((Context)object, "tv_test_geetest");
        object2 = (TextView)string2.findViewById(n10);
        this.tvTestGeetest = object2;
        n10 = o.b((Context)object, "iv_geetest_logo");
        string2 = (ImageView)string2.findViewById(n10);
        this.ivGeetestLogo = string2;
        object2 = new GT3GeetestButton$a(this, (Context)object);
        string2.setOnClickListener((View.OnClickListener)object2);
        this.geetestView.a();
        int n11 = o.a((Context)object, "gt3_lin_bg_shape");
        this.setBackgroundResource(n11);
        object = new GT3GeetestButton$b(this);
        this.listenerImpl = object;
        ((GT3GeetestButton$b)object).j();
    }

    private String noTrueMsg() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.clear();
        Integer n10 = 0;
        arrayList.add(n10);
        arrayList.add(n10);
        arrayList.add(n10);
        arrayList.add(n10);
        return ((Object)arrayList).toString();
    }

    private static Activity scanForActivity(Context context) {
        if (context == null) {
            return null;
        }
        boolean bl2 = context instanceof Activity;
        if (bl2) {
            return (Activity)context;
        }
        bl2 = context instanceof ContextWrapper;
        if (bl2) {
            return GT3GeetestButton.scanForActivity(((ContextWrapper)context).getBaseContext());
        }
        return null;
    }

    public void onDraw(Canvas canvas) {
        int n10;
        Object object;
        Context context = this.context;
        d d10 = new d();
        float f10 = d10.b();
        int n11 = g.a(context, f10);
        this.postInvalidate();
        super.onDraw(canvas);
        d10 = this.context;
        boolean bl2 = p.a((Context)d10);
        int n12 = 1065353216;
        float f11 = 1.0f;
        int n13 = 1;
        if (!bl2) {
            bl2 = false;
            f10 = 0.0f;
            d10 = null;
            this.gogogogo = false;
            this.geetestView.b();
            object = this.context;
            String string2 = "gt3_lin_file_shape";
            int n14 = o.a((Context)object, string2);
            this.setBackgroundResource(n14);
            n14 = (int)(this.islogo ? 1 : 0);
            if (n14 != 0) {
                object = this.ivGeetestLogo;
                string2 = this.context;
                String string3 = "gt3logogray";
                n10 = o.d((Context)string2, string3);
                object.setImageResource(n10);
            }
            object = this.tvTestGeetest;
            string2 = i.d();
            object.setText((CharSequence)string2);
            object = this.tverrorcode;
            string2 = "201";
            object.setText((CharSequence)string2);
            this.tverrorcode.setVisibility(0);
            this.tverror.setVisibility(0);
            d10 = this.tverror;
            object = i.j();
            d10.setText((CharSequence)object);
            d10 = this.tvTestGeetest;
            n14 = -13092808;
            d10.setTextColor(n14);
            d10 = this.tvTestGeetest;
            d10.setAlpha(f11);
        } else {
            this.gogogogo = n13;
        }
        bl2 = this.downTime;
        if (bl2) {
            d10 = new Path();
            n10 = 1536;
            object = new Paint(n10);
            object.setAntiAlias(n13 != 0);
            GT3ViewColor gT3ViewColor = new GT3ViewColor();
            n13 = gT3ViewColor.getDownColor();
            object.setColor(n13);
            gT3ViewColor = Paint.Style.FILL;
            object.setStyle((Paint.Style)gT3ViewColor);
            object.setStrokeWidth(f11);
            f11 = this.getWidth() - n11;
            n13 = 0;
            gT3ViewColor = null;
            d10.moveTo(f11, 0.0f);
            f11 = this.getWidth();
            d10.lineTo(f11, 0.0f);
            n12 = this.getWidth();
            f11 = n12;
            float f12 = n11;
            d10.lineTo(f11, f12);
            d10.close();
            canvas.drawPath((Path)d10, object);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        if (n10 == 0 && (n10 = (int)(this.touch ? 1 : 0)) != 0) {
            n10 = 0;
            this.touch = false;
            Object object = this.tverrorcode;
            int bl2 = 8;
            object.setVisibility(bl2);
            object = this.tverror;
            String string2 = i.j();
            object.setText((CharSequence)string2);
            this.tverror.setVisibility(bl2);
            object = this.geetestUnbindHolder.getHolder().d();
            boolean bl3 = true;
            ((b)object).a(bl3);
            object = this.geetestUnbindHolder.getHolder().d();
            ((b)object).l();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setGeetestUtils(GT3GeetestUtils object) {
        this.geetestUnbindHolder = object;
        object = ((GT3GeetestUtils)object).getHolder().d();
        GT3GeetestButton$b gT3GeetestButton$b = this.listenerImpl;
        ((b)object).setButtonListener(gT3GeetestButton$b);
    }
}

