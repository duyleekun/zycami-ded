/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 */
package d.v.c.k1.a;

import android.view.MotionEvent;
import android.view.View;
import d.v.c.k1.a.v;

public final class n
implements View.OnTouchListener {
    public final /* synthetic */ v a;
    public final /* synthetic */ int b;

    public /* synthetic */ n(v v10, int n10) {
        this.a = v10;
        this.b = n10;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        v v10 = this.a;
        int n10 = this.b;
        return v10.p(n10, view, motionEvent);
    }
}

