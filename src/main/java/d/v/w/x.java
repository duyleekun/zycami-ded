/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import d.v.w.c0.a;
import d.v.w.x$a;
import d.v.w.x$b;
import java.util.Observable;

public class x
extends Observable {
    private x() {
    }

    public /* synthetic */ x(x$a x$a) {
        this();
    }

    public static x a() {
        return x$b.a();
    }

    public void b(a a10) {
        this.setChanged();
        this.notifyObservers(a10);
    }
}

