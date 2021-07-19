/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package com.geetest.sdk.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.geetest.sdk.as;
import com.geetest.sdk.utils.l;

public class CoverFrameLayout
extends FrameLayout {
    private static final String b = CoverFrameLayout.class.getSimpleName();
    private as a;

    public CoverFrameLayout(Context context, ViewGroup viewGroup, as object) {
        super(context);
        this.a = object;
        context = null;
        object = viewGroup.getChildAt(0);
        View view = object.findFocus();
        viewGroup.removeViewAt(0);
        this.addView((View)object);
        object = (ViewGroup)this.getParent();
        if (object != null) {
            object.removeView((View)this);
        }
        object = b;
        Object object2 = this.getParent();
        object2 = object2 != null ? "has parent" : " not parent";
        l.d((String)object, (String)object2);
        viewGroup.addView((View)this, 0);
        if (view != null) {
            view.requestFocus();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        if (n10 != 0) {
            as as2;
            int n11 = 1;
            if (n10 == n11 && (as2 = this.a) != null) {
                as2.b(motionEvent);
            }
        } else {
            as as3 = this.a;
            if (as3 != null) {
                as3.a(motionEvent);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}

