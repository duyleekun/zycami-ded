/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.q0;

import android.view.View;
import d.v.c.q0.c$b;
import d.v.c.q0.d;

public class d$a
extends c$b {
    public final /* synthetic */ d b;

    public d$a(d d10) {
        this.b = d10;
        super(d10);
    }

    public void b(View object) {
        int n10;
        int n11 = object.getId();
        if (n11 == (n10 = 2131362630)) {
            boolean bl2 = false;
            object = null;
            this.g(0);
        } else {
            int n12 = object.getId();
            if (n12 == (n11 = 2131362241)) {
                object = this.b;
                n11 = 1;
                object.c = n11;
                this.e();
            }
        }
    }

    public void g(int n10) {
        this.b.b = n10;
        this.d();
        this.b.u();
    }
}

