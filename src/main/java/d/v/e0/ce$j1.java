/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.ie.d;
import d.v.e0.oe.q;
import e.a.v0.o;

public class ce$j1
implements o {
    public final /* synthetic */ d a;
    public final /* synthetic */ int[] b;
    public final /* synthetic */ ce c;

    public ce$j1(ce ce2, d d10, int[] nArray) {
        this.c = ce2;
        this.a = d10;
        this.b = nArray;
    }

    public Integer a(Integer n10) {
        Object object = this.a;
        if (object != null) {
            q.a("[send callback uploadStarted]");
            object = this.a;
            object.b();
        }
        object = this.b;
        int n11 = n10;
        object[2] = n11;
        return n10;
    }
}

