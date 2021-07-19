/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v1;

import androidx.lifecycle.Observer;
import d.v.c.v1.o;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class k
implements Observer {
    public final /* synthetic */ o a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ AtomicReference d;

    public /* synthetic */ k(o o10, AtomicBoolean atomicBoolean, AtomicReference atomicReference, AtomicReference atomicReference2) {
        this.a = o10;
        this.b = atomicBoolean;
        this.c = atomicReference;
        this.d = atomicReference2;
    }

    public final void onChanged(Object object) {
        o o10 = this.a;
        AtomicBoolean atomicBoolean = this.b;
        AtomicReference atomicReference = this.c;
        AtomicReference atomicReference2 = this.d;
        object = (d.v.j.e.h.k)object;
        o10.J(atomicBoolean, atomicReference, atomicReference2, (d.v.j.e.h.k)object);
    }
}

