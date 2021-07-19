/*
 * Decompiled with CFR 0.151.
 */
package f.d2.q;

import f.d2.k;
import f.h2.t.f0;
import f.x1.n;
import java.util.List;

public class a
extends k {
    public void a(Throwable throwable, Throwable throwable2) {
        f0.p(throwable, "cause");
        f0.p(throwable2, "exception");
        throwable.addSuppressed(throwable2);
    }

    public List d(Throwable objectArray) {
        f0.p(objectArray, "exception");
        objectArray = objectArray.getSuppressed();
        f0.o(objectArray, "exception.suppressed");
        return n.t(objectArray);
    }
}

