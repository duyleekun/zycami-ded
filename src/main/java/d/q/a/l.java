/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import com.uber.autodispose.AutoDisposingObserverImpl;
import d.q.a.y;
import e.a.e0;
import e.a.g;
import e.a.g0;
import e.a.z;

public final class l
extends z
implements y {
    private final e0 a;
    private final g b;

    public l(e0 e02, g g10) {
        this.a = e02;
        this.b = g10;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        g g10 = this.b;
        AutoDisposingObserverImpl autoDisposingObserverImpl = new AutoDisposingObserverImpl(g10, g02);
        e02.subscribe(autoDisposingObserverImpl);
    }
}

