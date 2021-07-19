/*
 * Decompiled with CFR 0.151.
 */
package d.v.c;

import d.v.c.i0;
import java.util.function.Function;

public final class r
implements Function {
    public final /* synthetic */ i0 a;

    public /* synthetic */ r(i0 i02) {
        this.a = i02;
    }

    public final Object apply(Object object) {
        i0 i02 = this.a;
        object = (Throwable)object;
        return i02.z((Throwable)object);
    }
}

