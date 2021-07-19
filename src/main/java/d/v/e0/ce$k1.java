/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.ie.d;
import d.v.e0.oe.q;
import e.a.v0.g;

public class ce$k1
implements g {
    public final /* synthetic */ d a;
    public final /* synthetic */ ce b;

    public ce$k1(ce ce2, d d10) {
        this.b = ce2;
        this.a = d10;
    }

    public void a(Throwable object) {
        object = this.a;
        if (object != null) {
            q.a("[send callback connectDeviceFailed before uploadStarted] ");
            object = this.a;
            object.j();
        }
    }
}

