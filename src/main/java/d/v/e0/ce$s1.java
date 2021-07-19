/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.oe.q;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class ce$s1
implements o {
    public final /* synthetic */ ce a;

    public ce$s1(ce ce2) {
        this.a = ce2;
    }

    public e0 a(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SystemReset result = ");
        object = object.toString();
        stringBuilder.append((String)object);
        q.i(stringBuilder.toString());
        q.i("[Ready loop addr for scan nodes .range(1, 4)]");
        return z.u4(1, 4);
    }
}

