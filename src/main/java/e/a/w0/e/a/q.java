/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a;
import e.a.d;
import e.a.f;
import e.a.g;

public final class q
extends a {
    public final g a;
    public final f b;

    public q(g g10, f f10) {
        this.a = g10;
        this.b = f10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void L0(d d10) {
        try {
            Object object = this.b;
            d10 = object.a(d10);
            object = this.a;
            object.f(d10);
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
            return;
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
    }
}

