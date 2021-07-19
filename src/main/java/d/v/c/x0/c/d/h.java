/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c.d;

import androidx.lifecycle.Observer;
import d.v.c.x0.c.d.l;
import d.v.j.e.h.k;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class h
implements Observer {
    public final /* synthetic */ l a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ AtomicReference d;

    public /* synthetic */ h(l l10, AtomicBoolean atomicBoolean, AtomicReference atomicReference, AtomicReference atomicReference2) {
        this.a = l10;
        this.b = atomicBoolean;
        this.c = atomicReference;
        this.d = atomicReference2;
    }

    public final void onChanged(Object object) {
        l l10 = this.a;
        AtomicBoolean atomicBoolean = this.b;
        AtomicReference atomicReference = this.c;
        AtomicReference atomicReference2 = this.d;
        object = (k)object;
        l10.u(atomicBoolean, atomicReference, atomicReference2, (k)object);
    }
}

