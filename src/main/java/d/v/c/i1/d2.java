/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.i1;

import android.view.MotionEvent;
import android.view.View;
import d.v.c.i1.q2;

public final class d2
implements View.OnTouchListener {
    public final /* synthetic */ q2 a;

    public /* synthetic */ d2(q2 q22) {
        this.a = q22;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.q(view, motionEvent);
    }
}

