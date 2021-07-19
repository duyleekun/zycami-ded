/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.ie.d;
import d.v.e0.oe.q;
import e.a.v0.o;

public class ce$v1
implements o {
    public final /* synthetic */ boolean[] a;
    public final /* synthetic */ d b;
    public final /* synthetic */ ce c;

    public ce$v1(ce ce2, boolean[] blArray, d d10) {
        this.c = ce2;
        this.a = blArray;
        this.b = d10;
    }

    public Boolean a(Boolean bl2) {
        boolean bl3;
        Object object = this.a;
        object[0] = bl3 = bl2.booleanValue();
        object = this.b;
        if (object != null) {
            object = new StringBuilder;
            ((StringBuilder)object)();
            String string2 = "startConnectAndScan, needWait=";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(bl2);
            q.a(((StringBuilder)object).toString());
            object = this.b;
            boolean bl4 = bl2;
            object.h(bl4);
        }
        return Boolean.TRUE;
    }
}

