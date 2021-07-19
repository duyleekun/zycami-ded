/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewParent
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.widget.MediaConstrainLayout$a;
import d.v.c.w0.ob;
import d.v.h.e.a;

public class MediaConstrainLayout
extends ConstraintLayout {
    private Context a;
    private ob b;
    private boolean c;
    private boolean d;
    private float e;
    private float f;
    private int[] g;
    private a h;
    private View i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private ObservableBoolean n;
    private MediaConstrainLayout$a o;

    public MediaConstrainLayout(Context context) {
        this(context, null);
    }

    public MediaConstrainLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaConstrainLayout(Context context, AttributeSet object, int n10) {
        super(context, (AttributeSet)object, n10);
        super();
        this.n = object;
        this.a = context;
    }

    private void a(a object, View view) {
        this.n.set(false);
        Object object2 = (ob)DataBindingUtil.inflate(LayoutInflater.from((Context)this.a), 2131558638, this, false);
        this.b = object2;
        ((ob)object2).G((a)object);
        object = this.b;
        object2 = this.n;
        ((ob)object).E((ObservableBoolean)object2);
        object = this.b;
        object2 = Boolean.TRUE;
        ((ob)object).F((Boolean)object2);
        object = this.b.getRoot();
        this.addView((View)object);
        int n10 = 2;
        object2 = new int[n10];
        this.g = (int[])object2;
        view.getLocationOnScreen((int[])object2);
        view = this.b.getRoot();
        float f10 = this.g[0];
        view.setTranslationX(f10);
        view = this.b.getRoot();
        f10 = this.g[1];
        view.setTranslationY(f10);
        this.b.getRoot().setVisibility(8);
        int n11 = (int)this.e;
        int n12 = this.i.getWidth() / n10;
        this.k = n11 -= n12;
        n11 = (int)this.f;
        n12 = this.i.getHeight() / n10;
        this.l = n11 -= n12;
    }

    public void b(boolean bl2, a a10, View view, int n10) {
        this.c = bl2;
        this.h = a10;
        this.i = view;
        this.j = n10;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean bl2 = this.c;
        if (bl2 && !(bl2 = this.d)) {
            ViewParent viewParent = this.getParent();
            boolean bl3 = true;
            viewParent.requestDisallowInterceptTouchEvent(bl3);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onInterceptTouchEvent(MotionEvent var1_1) {
        block6: {
            block4: {
                block5: {
                    var2_2 = var1_1 /* !! */ .getAction();
                    var3_3 = 1;
                    var4_4 = 1.4E-45f;
                    if (var2_2 == 0) break block4;
                    if (var2_2 == var3_3) break block5;
                    var5_5 = 2;
                    var6_6 = 2.8E-45f;
                    if (var2_2 != var5_5) break block6;
                    var7_7 = ViewConfiguration.get((Context)this.a);
                    var2_2 = var7_7.getScaledTouchSlop();
                    var6_6 = var1_1 /* !! */ .getX();
                    var8_8 = var1_1 /* !! */ .getY();
                    var9_10 = this.f;
                    cfr_temp_0 = (var8_8 = Math.abs(var8_8 - var9_10)) - (var10_11 = (float)var2_2);
                    var11_13 /* !! */  = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1));
                    if (var11_13 /* !! */  <= 0) ** GOTO lbl-1000
                    var8_8 = this.e;
                    cfr_temp_1 = (var8_8 = Math.abs(var6_6 -= var8_8)) - var10_11;
                    var11_13 /* !! */  = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1));
                    if (var11_13 /* !! */  < 0) {
                        var11_13 /* !! */  = 0;
                        var1_1 /* !! */  = null;
                        var8_8 = 0.0f;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var11_13 /* !! */  = var3_3;
                        var8_8 = var4_4;
                    }
                    this.d = var11_13 /* !! */ ;
                    break block6;
                }
                this.c = false;
                this.d = false;
                break block6;
            }
            this.e = var10_12 = var1_1 /* !! */ .getX();
            this.f = var8_9 = var1_1 /* !! */ .getY();
        }
        var11_13 /* !! */  = this.c;
        if (var11_13 /* !! */  == 0 || (var11_13 /* !! */  = this.d) != 0) {
            var3_3 = 0;
            var4_4 = 0.0f;
        }
        if (var3_3 != 0) {
            var1_1 /* !! */  = this.h;
            var7_7 = this.i;
            this.a((a)var1_1 /* !! */ , (View)var7_7);
        }
        return (boolean)var3_3;
    }

    public boolean onTouchEvent(MotionEvent object) {
        Object object2 = object.getAction();
        int n10 = 1;
        int n11 = 0;
        if (object2 != n10) {
            int n12 = 2;
            float f10 = 2.8E-45f;
            if (object2 == n12) {
                Object object3 = this.b;
                if (object3 == null) {
                    return false;
                }
                object3 = ((ViewDataBinding)object3).getRoot();
                n12 = object3.getVisibility();
                int n13 = 8;
                float f11 = 1.1E-44f;
                if (n12 == n13) {
                    object3.setVisibility(0);
                    MediaConstrainLayout$a mediaConstrainLayout$a = this.o;
                    if (mediaConstrainLayout$a != null) {
                        n13 = this.j;
                        mediaConstrainLayout$a.a(n13);
                    }
                }
                n12 = (int)object.getX();
                n13 = (int)object.getY();
                int n14 = this.k + n12;
                f10 = n14;
                float f12 = this.e;
                object3.setTranslationX(f10 -= f12);
                n12 = this.l + n13;
                f10 = n12;
                f11 = this.f;
                object3.setTranslationY(f10 -= f11);
                object3 = this.g;
                object2 = object3[n10];
                float f13 = object2;
                float f14 = object.getRawY();
                f13 -= f14;
                f14 = this.i.getHeight();
                f13 -= f14;
                f14 = 0.0f;
                object = null;
                float f15 = f13 - 0.0f;
                float f16 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
                if (f16 > 0) {
                    n11 = n10;
                }
                this.m = n11;
                object = this.n;
                ((ObservableBoolean)object).set(n11 != 0);
            }
        } else {
            this.c = false;
            this.d = false;
            object = this.b;
            if (object == null) {
                return false;
            }
            object = ((ViewDataBinding)object).getRoot();
            this.removeView((View)object);
            object = this.o;
            if (object != null) {
                object2 = this.m;
                n11 = this.j;
                a a10 = this.b.w();
                object.b((boolean)object2, n11, a10);
            }
        }
        return n10 != 0;
    }

    public void setOnTouchUpListener(MediaConstrainLayout$a mediaConstrainLayout$a) {
        this.o = mediaConstrainLayout$a;
    }
}

