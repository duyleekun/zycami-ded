/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import d.b.a.b.e;
import d.b.a.b.e$b;
import d.b.a.b.m;
import d.b.a.b.p0;
import java.util.concurrent.Callable;

public final class q0
implements Callable {
    private final /* synthetic */ String a;
    public final /* synthetic */ m b;
    private final /* synthetic */ e c;

    public q0(e e10, String string2, m m10) {
        this.c = e10;
        this.a = string2;
        this.b = m10;
    }

    public final /* synthetic */ Object call() {
        Object object = this.c;
        Object object2 = this.a;
        object = e.H((e)object, (String)object2);
        object2 = this.c;
        p0 p02 = new p0(this, (e$b)object);
        e.B((e)object2, p02);
        return null;
    }
}

