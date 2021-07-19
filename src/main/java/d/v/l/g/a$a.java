/*
 * Decompiled with CFR 0.151.
 */
package d.v.l.g;

import d.v.l.e;
import d.v.l.g.a$b;
import d.v.l.g.a$c;

public class a$a
implements e {
    public final /* synthetic */ a$c a;
    public final /* synthetic */ a$b b;

    public a$a(a$c a$c, a$b a$b) {
        this.a = a$c;
        this.b = a$b;
    }

    public void a() {
        a$b a$b = this.b;
        if (a$b != null) {
            a$b.onFailure();
        }
    }

    public void onSuccess() {
        a$c a$c = this.a;
        if (a$c != null) {
            a$c.onSuccess();
        }
    }
}

