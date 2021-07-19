/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package com.zhiyun.zyplayer;

import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.zyplayer.GestureView;

public class GestureView$a
implements View.OnTouchListener {
    public final /* synthetic */ GestureView a;

    public GestureView$a(GestureView gestureView) {
        this.a = gestureView;
    }

    public boolean onTouch(View object, MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getAction();
        if ((n11 == (n10 = 1) || (n11 = motionEvent.getAction()) == (n10 = 3)) && (n11 = (int)(GestureView.a((GestureView)((Object)(object = this.a))) ? 1 : 0)) != 0) {
            object = GestureView.c(this.a);
            if (object != null) {
                object = GestureView.c(this.a);
                object.d(motionEvent);
            }
            object = this.a;
            n10 = 0;
            GestureView.b((GestureView)((Object)object), false);
        }
        return GestureView.d(this.a).onTouchEvent(motionEvent);
    }
}

