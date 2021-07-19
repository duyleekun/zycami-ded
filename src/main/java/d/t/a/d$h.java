/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package d.t.a;

import android.net.Uri;
import d.t.a.d;
import d.t.a.d$j;
import d.t.a.e;
import d.t.a.f.a;

public class d$h
implements a {
    public final /* synthetic */ d a;

    public d$h(d d10) {
        this.a = d10;
    }

    public void a(Uri object, int n10, int n11, int n12, int n13) {
        e e10 = d.l(this.a);
        d d10 = this.a;
        float f10 = d.m(d10).getTargetAspectRatio();
        object = d10.v((Uri)object, f10, n10, n11, n12, n13);
        e10.a((d$j)object);
        d.l(this.a).b(false);
    }

    public void b(Throwable object) {
        e e10 = d.l(this.a);
        object = this.a.u((Throwable)object);
        e10.a((d$j)object);
    }
}

