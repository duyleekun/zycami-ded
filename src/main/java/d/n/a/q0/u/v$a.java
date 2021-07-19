/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.u;

import d.n.a.q0.p;
import d.n.a.q0.u.v;
import d.n.a.q0.x.y;
import e.a.v0.f;

public class v$a
implements f {
    public final /* synthetic */ Object a;
    public final /* synthetic */ v b;

    public v$a(v v10, Object object) {
        this.b = v10;
        this.a = object;
    }

    public void cancel() {
        Object object = new Object[]{};
        p.k("Scan operation is requested to stop.", (Object[])object);
        object = this.b;
        y y10 = ((v)object).a;
        Object object2 = this.a;
        ((v)object).f(y10, object2);
    }
}

