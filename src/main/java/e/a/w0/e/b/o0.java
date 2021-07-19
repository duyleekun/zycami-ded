/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.n;
import e.a.w0.e.b.a;
import i.g.d;

public final class o0
extends a {
    public final n c;

    public o0(j j10, n n10) {
        super(j10);
        this.c = n10;
    }

    public void m6(d object) {
        Object object2;
        block12: {
            object2 = this.c;
            object = object2.a((d)object);
            if (object == null) break block12;
            object2 = this.b;
            ((j)object2).subscribe((d)object);
            return;
        }
        object2 = new StringBuilder();
        Object object3 = "Operator ";
        ((StringBuilder)object2).append((String)object3);
        object3 = this.c;
        ((StringBuilder)object2).append(object3);
        object3 = " returned a null Subscriber";
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        try {
            object = new NullPointerException((String)object2);
            throw object;
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
    }
}

