/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.v0.r;
import e.a.w0.c.a;
import i.g.e;

public abstract class c$a
implements a,
e {
    public final r a;
    public e b;
    public boolean c;

    public c$a(r r10) {
        this.a = r10;
    }

    public final void cancel() {
        this.b.cancel();
    }

    public final void onNext(Object object) {
        boolean bl2 = this.tryOnNext(object);
        if (!bl2 && !(bl2 = this.c)) {
            object = this.b;
            long l10 = 1L;
            object.request(l10);
        }
    }

    public final void request(long l10) {
        this.b.request(l10);
    }
}

