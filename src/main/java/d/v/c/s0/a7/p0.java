/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.s0.a7;

import android.view.MotionEvent;
import android.view.View;
import d.v.c.s0.a7.l1;

public final class p0
implements View.OnTouchListener {
    public final /* synthetic */ l1 a;

    public /* synthetic */ p0(l1 l12) {
        this.a = l12;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.D(view, motionEvent);
    }
}

