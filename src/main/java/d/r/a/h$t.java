/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.o;

public class h$t
extends o {
    public String c = null;
    public int d = 0;

    public h$t(int n10) {
        super(n10);
    }

    public void d(g g10) {
        String string2 = this.c;
        g10.f("req_id", string2);
        int n10 = this.d;
        g10.c("status_msg_code", n10);
    }

    public void e(g g10) {
        int n10;
        String string2;
        this.c = string2 = g10.b("req_id");
        int n11 = this.d;
        this.d = n10 = g10.h("status_msg_code", n11);
    }

    public String toString() {
        return "OnReceiveCommand";
    }
}

