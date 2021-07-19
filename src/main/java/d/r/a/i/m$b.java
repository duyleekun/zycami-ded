/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.i;

import android.content.Context;
import d.r.a.i.m;
import d.r.a.s.c;

public final class m$b
implements Runnable {
    public final /* synthetic */ d.r.a.r.c a;
    public final /* synthetic */ m b;

    public m$b(m m10, d.r.a.r.c c10) {
        this.b = m10;
        this.a = c10;
    }

    public final void run() {
        m m10 = this.b;
        c c10 = m10.d;
        if (c10 != null) {
            m10 = m.f(m10);
            d.r.a.r.c c11 = this.a;
            c10.onNotificationMessageClicked((Context)m10, c11);
        }
    }
}

