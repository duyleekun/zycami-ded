/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c.f;

import androidx.lifecycle.Observer;
import d.v.c.x0.c.f.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class h
implements Observer {
    public final /* synthetic */ l a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ AtomicBoolean d;

    public /* synthetic */ h(l l10, AtomicReference atomicReference, AtomicReference atomicReference2, AtomicBoolean atomicBoolean) {
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

