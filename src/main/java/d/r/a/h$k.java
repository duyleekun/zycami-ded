/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.h$t;

public final class h$k
extends h$t {
    public int e;
    public int f;

    public h$k() {
        super(12);
        int n10;
        this.e = n10 = -1;
        this.f = n10;
    }

    public final void d(g g10) {
        super.d(g10);
        int n10 = this.e;
        g10.c("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", n10);
        n10 = this.f;
        g10.c("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", n10);
    }

    public final void e(g g10) {
        int n10;
        super.e(g10);
        int n11 = this.e;
        this.e = n11 = g10.h("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", n11);
        n11 = this.f;
        this.f = n10 = g10.h("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", n11);
    }

    public final String toString() {
        return "OnChangePushStatusCommand";
    }
}

