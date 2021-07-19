/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.d0;
import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;

public final class w0
extends a {
    public final d0 b;

    public w0(e0 e02, d0 d02) {
        super(e02);
        this.b = d02;
    }

    public void K5(g0 object) {
        Object object2 = this.b;
        object = object2.a((g0)object);
        object2 = new StringBuilder();
        Object object3 = "Operator ";
        ((StringBuilder)object2).append((String)object3);
        object3 = this.b;
        ((StringBuilder)object2).append(object3);
        object3 = " returned a null Observer";
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        object = e.a.w0.b.a.g(object, (String)object2);
        try {
            object = (g0)object;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
            object2 = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            ((Throwable)object2).initCause(throwable);
            throw object2;
        }
        catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        }
        this.a.subscribe((g0)object);
        return;
    }
}

