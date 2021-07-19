/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.f1.a;

import android.view.MotionEvent;
import android.view.View;
import d.v.c.f1.a.o$a;

public final class o
implements View.OnTouchListener {
    public final o$a a;
    public final int b;

    public o(o$a o$a, int n10) {
        this.a = o$a;
        this.b = n10;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        o$a o$a = this.a;
        int n10 = this.b;
        return o$a.p(n10, view, motionEvent);
    }
}

