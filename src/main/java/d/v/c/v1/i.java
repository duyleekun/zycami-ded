/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v1;

import androidx.lifecycle.Observer;
import d.v.c.v1.o;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class i
implements Observer {
    public final /* synthetic */ o a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ AtomicBoolean d;

    public /* synthetic */ i(o o10, AtomicReference atomicReference, AtomicReference atomicReference2, AtomicBoolean atomicBoolean) {
        this.a = o10;
        this.b = atomicReference;
        this.c = atomicReference2;
        this.d = atomicBoolean;
    }

    public final void onChanged(Object object) {
        o o10 = this.a;
        AtomicReference atomicReference = this.b;
        AtomicReference atomicReference2 = this.c;
        AtomicBoolean atomicBoolean = this.d;
        object = (List)object;
        o10.L(atomicReference, atomicReference2, atomicBoolean, (List)object);
    }
}

