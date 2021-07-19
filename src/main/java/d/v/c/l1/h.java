/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1;

import d.v.c.l1.b0;
import java.util.Observable;
import java.util.Observer;

public final class h
implements Observer {
    public final /* synthetic */ b0 a;

    public /* synthetic */ h(b0 b02) {
        this.a = b02;
    }

    public final void update(Observable observable, Object object) {
        this.a.i(observable, object);
    }
}

