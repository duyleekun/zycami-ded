/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.f;

import e.a.v0.c;
import e.a.v0.r;
import e.a.w0.c.a;
import i.g.e;

public abstract class d$b
implements a,
e {
    public final r a;
    public final c b;
    public e c;
    public boolean d;

    public d$b(r r10, c c10) {
        this.a = r10;
        this.b = c10;
    }

    public final void cancel() {
        this.c.cancel();
    }

    public final void onNext(Object object) {
        boolean bl2 = this.tryOnNext(object);
        if (!bl2 && !(bl2 = this.d)) {
            object = this.c;
            long l10 = 1L;
            object.request(l10);
        }
    }

    public final void request(long l10) {
        this.c.request(l10);
    }
}

