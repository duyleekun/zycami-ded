/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.s0.h7.u0;

import android.view.MotionEvent;
import android.view.View;
import d.v.c.s0.h7.u0.j;
import d.v.c.w0.yh;

public final class a
implements View.OnTouchListener {
    public final /* synthetic */ j a;
    public final /* synthetic */ yh b;

    public /* synthetic */ a(j j10, yh yh2) {
        this.a = j10;
        this.b = yh2;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        j j10 = this.a;
        yh yh2 = this.b;
        return j10.h(yh2, view, motionEvent);
    }
}

