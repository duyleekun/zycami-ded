/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import k.d;
import k.e;
import k.i;
import k.i$b;

public class i$a
implements e {
    public final /* synthetic */ Type a;
    public final /* synthetic */ Executor b;
    public final /* synthetic */ i c;

    public i$a(i i10, Type type, Executor executor) {
        this.c = i10;
        this.a = type;
        this.b = executor;
    }

    public Type a() {
        return this.a;
    }

    public d c(d d10) {
        Executor executor = this.b;
        if (executor != null) {
            i$b i$b = new i$b(executor, d10);
            d10 = i$b;
        }
        return d10;
    }
}

