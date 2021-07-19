/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.u1.m;

import android.view.MotionEvent;
import android.view.View;
import d.v.c.u1.m.d1;

public final class x0
implements View.OnTouchListener {
    public final /* synthetic */ d1 a;
    public final /* synthetic */ int b;

    public /* synthetic */ x0(d1 d12, int n10) {
        this.a = d12;
        this.b = n10;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        d1 d12 = this.a;
        int n10 = this.b;
        return d12.p(n10, view, motionEvent);
    }
}

