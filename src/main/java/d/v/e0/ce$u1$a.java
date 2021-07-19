/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce$u1;
import d.v.e0.oe.q;
import e.a.v0.g;

public class ce$u1$a
implements g {
    public final /* synthetic */ ce$u1 a;

    public ce$u1$a(ce$u1 ce$u1) {
        this.a = ce$u1;
    }

    public void a(Throwable object) {
        object = this.a.a;
        if (object != null) {
            q.a("[send callback connectDeviceFailed] ");
            object = this.a.a;
            object.j();
        }
    }
}

