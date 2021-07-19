/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.GestureDetector
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.s0.e7;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import d.v.c.s0.e7.q;

public final class e
implements View.OnTouchListener {
    public final /* synthetic */ q a;
    public final /* synthetic */ GestureDetector b;

    public /* synthetic */ e(q q10, GestureDetector gestureDetector) {
        this.a = q10;
        this.b = gestureDetector;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        q q10 = this.a;
        GestureDetector gestureDetector = this.b;
        return q10.u(gestureDetector, view, motionEvent);
    }
}

