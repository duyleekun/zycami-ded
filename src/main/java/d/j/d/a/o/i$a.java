/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.l;
import d.j.d.a.o.i;
import java.util.concurrent.Callable;

public final class i$a
implements Runnable {
    public final /* synthetic */ l a;
    public final /* synthetic */ Callable b;
    public final /* synthetic */ i c;

    public i$a(i i10, l l10, Callable callable) {
        this.c = i10;
        this.a = l10;
        this.b = callable;
    }

    public final void run() {
        l l10;
        try {
            l10 = this.a;
        }
        catch (Exception exception) {
            this.a.c(exception);
            return;
        }
        Callable callable = this.b;
        callable = callable.call();
        l10.d(callable);
    }
}

