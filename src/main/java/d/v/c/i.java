/*
 * Decompiled with CFR 0.151.
 */
package d.v.c;

import d.v.c.i0$b;
import d.v.c.i0$c;
import java.util.function.Consumer;

public final class i
implements Consumer {
    public final /* synthetic */ Throwable a;

    public /* synthetic */ i(Throwable throwable) {
        this.a = throwable;
    }

    public final void accept(Object object) {
        Throwable throwable = this.a;
        object = (i0$b)object;
        i0$c.e(throwable, (i0$b)object);
    }
}

