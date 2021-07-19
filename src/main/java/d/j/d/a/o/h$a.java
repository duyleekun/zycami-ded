/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.g;
import d.j.d.a.i;
import d.j.d.a.j;
import d.j.d.a.k;
import d.j.d.a.o.h;
import d.j.d.a.o.h$a$a;

public final class h$a
implements i {
    public final /* synthetic */ j a;
    public final /* synthetic */ h b;
    public final /* synthetic */ h c;

    public h$a(h h10, j j10, h h11) {
        this.c = h10;
        this.a = j10;
        this.b = h11;
    }

    public final void onSuccess(Object object) {
        Object object2;
        try {
            object2 = this.a;
        }
        catch (Exception exception) {
            this.b.z(exception);
            return;
        }
        object = object2.then(object);
        if (object == null) {
            object = this.b;
            object2 = new NullPointerException("SuccessContinuation returned null");
            ((h)object).z((Exception)object2);
            return;
        }
        object2 = new h$a$a(this);
        ((k)object).e((g)object2);
    }
}

