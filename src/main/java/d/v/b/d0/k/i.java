/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 */
package d.v.b.d0.k;

import android.view.MotionEvent;
import d.v.b.c0.b;
import d.v.d.h.f;

public class i
extends b {
    public i() {
        super(null);
    }

    public void o(MotionEvent motionEvent) {
        boolean bl2 = this.j();
        if (!bl2) {
            d.v.d.h.f.a("current is not support");
            return;
        }
        super.set(motionEvent);
    }
}

