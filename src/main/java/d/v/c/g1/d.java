/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.g1;

import d.v.c.g1.i;
import java.io.File;
import java.util.function.Consumer;

public final class d
implements Consumer {
    public final /* synthetic */ i a;

    public /* synthetic */ d(i i10) {
        this.a = i10;
    }

    public final void accept(Object object) {
        i i10 = this.a;
        object = (File)object;
        i.q(i10, (File)object);
    }
}

