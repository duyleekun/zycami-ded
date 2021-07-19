/*
 * Decompiled with CFR 0.151.
 */
package d.v.f.i;

import l.a.c$b;
import l.a.o.e;

public final class g$a
implements c$b {
    public final /* synthetic */ c$b a;

    public g$a(c$b c$b) {
        this.a = c$b;
    }

    public void onFailed(String string2) {
        c$b c$b = this.a;
        if (c$b != null) {
            c$b.onFailed(string2);
        }
    }

    public void onStart() {
        c$b c$b = this.a;
        if (c$b != null) {
            c$b.onStart();
        }
    }

    public void onSuccess() {
        Object object = e.b();
        String string2 = "";
        ((e)object).g(string2).a();
        object = this.a;
        if (object != null) {
            object.onSuccess();
        }
    }
}

