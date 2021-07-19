/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import d.b.a.b.e;
import java.util.concurrent.Callable;

public final class t
implements Callable {
    private final /* synthetic */ String a;
    private final /* synthetic */ e b;

    public t(e e10, String string2) {
        this.b = e10;
        this.a = string2;
    }

    public final /* synthetic */ Object call() {
        e e10 = this.b;
        String string2 = this.a;
        return e.t(e10, string2);
    }
}

