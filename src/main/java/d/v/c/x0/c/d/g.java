/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c.d;

import androidx.lifecycle.Observer;
import d.v.c.x0.c.d.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class g
implements Observer {
    public final /* synthetic */ l a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ AtomicBoolean d;

    public /* synthetic */ g(l l10, AtomicReference atomicReference, AtomicReference atomicReference2, AtomicBoolean atomicBoolean) {
        this.a = l10;
        this.b = atomicReference;
        this.c = atomicReference2;
        this.d = atomicBoolean;
    }

    public final void onChanged(Object object) {
        l l10 = this.a;
        AtomicReference atomicReference = this.b;
        AtomicReference atomicReference2 = this.c;
        AtomicBoolean atomicBoolean = this.d;
        object = (List)object;
        l10.w(atomicReference, atomicReference2, atomicBoolean, (List)object);
    }
}

