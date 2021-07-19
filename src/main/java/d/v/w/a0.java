/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import d.v.w.a0$a;
import d.v.w.a0$b;
import d.v.w.c0.d;
import java.util.Observable;

public class a0
extends Observable {
    private a0() {
    }

    public /* synthetic */ a0(a0$a a0$a) {
        this();
    }

    public static a0 a() {
        return a0$b.a();
    }

    public void b(d d10) {
        this.setChanged();
        this.notifyObservers(d10);
    }
}

