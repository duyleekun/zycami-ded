/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import d.v.c.s0.h7.o0.w0;
import java.io.File;
import java.util.function.Predicate;

public final class c0
implements Predicate {
    public final /* synthetic */ w0 a;

    public /* synthetic */ c0(w0 w02) {
        this.a = w02;
    }

    public final boolean test(Object object) {
        w0 w02 = this.a;
        object = (File)object;
        return w0.m(w02, (File)object);
    }
}

