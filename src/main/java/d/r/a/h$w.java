/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.h$t;

public abstract class h$w
extends h$t {
    public String e;
    public long f;

    public h$w(int n10) {
        super(n10);
    }

    public void d(g g10) {
        super.d(g10);
        String string2 = this.e;
        g10.f("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", string2);
        long l10 = this.f;
        g10.d("notify_id", l10);
    }

    public void e(g g10) {
        long l10;
        String string2;
        super.e(g10);
        this.e = string2 = g10.b("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f = l10 = g10.i("notify_id", -1);
    }
}

