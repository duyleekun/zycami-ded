/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.b;

import androidx.lifecycle.Observer;
import d.v.c.x0.b.q;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class k
implements Observer {
    public final /* synthetic */ q a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ AtomicReference d;

    public /* synthetic */ k(q q10, AtomicBoolean atomicBoolean, AtomicReference atomicReference, AtomicReference atomicReference2) {
        this.a = q10;
        this.b = atomicBoolean;
        this.c = atomicReference;
        this.d = atomicReference2;
    }

    public final void onChanged(Object object) {
        q q10 = this.a;
        AtomicBoolean atomicBoolean = this.b;
        AtomicReference atomicReference = this.c;
        AtomicReference atomicReference2 = this.d;
        object = (d.v.j.e.h.k)object;
        q10.A(atomicBoolean, atomicReference, atomicReference2, (d.v.j.e.h.k)object);
    }
}

