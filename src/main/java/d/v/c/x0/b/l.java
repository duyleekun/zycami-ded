/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.b;

import androidx.lifecycle.Observer;
import d.v.c.x0.b.q;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class l
implements Observer {
    public final /* synthetic */ q a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ AtomicBoolean d;

    public /* synthetic */ l(q q10, AtomicReference atomicReference, AtomicReference atomicReference2, AtomicBoolean atomicBoolean) {
        this.a = q10;
        this.b = atomicReference;
        this.c = atomicReference2;
        this.d = atomicBoolean;
    }

    public final void onChanged(Object object) {
        q q10 = this.a;
        AtomicReference atomicReference = this.b;
        AtomicReference atomicReference2 = this.c;
        AtomicBoolean atomicBoolean = this.d;
        object = (List)object;
        q10.G(atomicReference, atomicReference2, atomicBoolean, (List)object);
    }
}

