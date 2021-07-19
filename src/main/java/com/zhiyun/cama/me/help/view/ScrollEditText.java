/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.Layout
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.ViewParent
 */
package com.zhiyun.cama.me.help.view;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import l.a.q.h;

public class ScrollEditText
extends h {
    private int c;
    private boolean d = false;
    private boolean e;

    public ScrollEditText(Context context) {
        super(context);
        this.b();
    }

    public ScrollEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b();
    }

    public ScrollEditText(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.b();
    }

    private boolean a() {
        int n10 = this.getScrollY();
        Layout layout2 = this.getLayout();
        int n11 = layout2.getHeight();
        int n12 = this.getHeight();
        int n13 = this.getCompoundPaddingTop();
        n12 -= n13;
        n13 = this.getCompoundPaddingBottom();
        this.c = n11 -= (n12 -= n13);
        n12 = 0;
        if (n11 == 0) {
            return false;
        }
        n13 = 1;
        if (n10 > 0 || n10 < (n11 -= n13)) {
            n12 = n13;
        }
        return n12 != 0;
    }

    private void b() {
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        if (n10 == 0) {
            n10 = 0;
            this.d = false;
        }
        if ((n10 = (int)(this.d ? 1 : 0)) != 0) {
            n10 = 3;
            motionEvent.setAction(n10);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        n10 = (int)(this.a() ? 1 : 0);
        this.e = n10;
    }

    public void onScrollChanged(int n10, int n11, int n12, int n13) {
        super.onScrollChanged(n10, n11, n12, n13);
        n10 = this.c;
        if (n11 == n10 || n11 == 0) {
            ViewParent viewParent = this.getParent();
            n11 = 0;
            viewParent.requestDisallowInterceptTouchEvent(false);
            n10 = 1;
            this.d = n10;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl2 = super.onTouchEvent(motionEvent);
        boolean bl3 = this.e;
        if (bl3) {
            bl3 = this.d;
            if (!bl3) {
                ViewParent viewParent = this.getParent();
                boolean bl4 = true;
                viewParent.requestDisallowInterceptTouchEvent(bl4);
            }
        } else {
            ViewParent viewParent = this.getParent();
            boolean bl5 = false;
            viewParent.requestDisallowInterceptTouchEvent(false);
        }
        return bl2;
    }
}

