/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package com.zhiyun.zyplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import com.zhiyun.zyplayer.GestureView$a;
import com.zhiyun.zyplayer.GestureView$b;
import com.zhiyun.zyplayer.GestureView$c;

public class GestureView
extends View {
    private static final int g = 0;
    private static final int h = 1;
    private static final int i = 2;
    private static final int j = 3;
    private int a = 0;
    private GestureView$c b;
    private GestureDetector c;
    private GestureView$b d;
    private int e = 1;
    private boolean f = false;

    public GestureView(Context context) {
        super(context);
        this.h(context);
    }

    public GestureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h(context);
    }

    public static /* synthetic */ boolean a(GestureView gestureView) {
        return gestureView.f;
    }

    public static /* synthetic */ boolean b(GestureView gestureView, boolean bl2) {
        gestureView.f = bl2;
        return bl2;
    }

    public static /* synthetic */ GestureView$b c(GestureView gestureView) {
        return gestureView.d;
    }

    public static /* synthetic */ GestureDetector d(GestureView gestureView) {
        return gestureView.c;
    }

    public static /* synthetic */ int e(GestureView gestureView) {
        return gestureView.a;
    }

    public static /* synthetic */ int f(GestureView gestureView, int n10) {
        gestureView.a = n10;
        return n10;
    }

    public static /* synthetic */ int g(GestureView gestureView) {
        return gestureView.e;
    }

    private void h(Context object) {
        GestureView$c gestureView$c;
        GestureView$c gestureView$c2 = this.b = (gestureView$c = new GestureView$c(this, this));
        gestureView$c = new GestureDetector(object, (GestureDetector.OnGestureListener)gestureView$c2);
        this.c = gestureView$c;
        gestureView$c.setIsLongpressEnabled(false);
        object = new GestureView$a(this);
        this.setOnTouchListener((View.OnTouchListener)object);
    }

    public void setVideoGestureListener(GestureView$b gestureView$b) {
        this.d = gestureView$b;
    }
}

