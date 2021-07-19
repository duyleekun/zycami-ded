/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.e1;

import android.content.Context;
import androidx.lifecycle.Observer;
import d.v.c.e1.u;
import d.v.j.e.h.k;
import java.util.concurrent.atomic.AtomicReference;

public final class o
implements Observer {
    public final /* synthetic */ u a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ AtomicReference c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ AtomicReference e;
    public final /* synthetic */ AtomicReference f;

    public /* synthetic */ o(u u10, AtomicReference atomicReference, AtomicReference atomicReference2, Context context, AtomicReference atomicReference3, AtomicReference atomicReference4) {
        this.a = u10;
        this.b = atomicReference;
        this.c = atomicReference2;
        this.d = context;
        this.e = atomicReference3;
        this.f = atomicReference4;
    }

    public final void onChanged(Object object) {
        u u10 = this.a;
        AtomicReference atomicReference = this.b;
        AtomicReference atomicReference2 = this.c;
        Context context = this.d;
        AtomicReference atomicReference3 = this.e;
        AtomicReference atomicReference4 = this.f;
        Object object2 = object;
        object2 = (k)object;
        u10.M(atomicReference, atomicReference2, context, atomicReference3, atomicReference4, (k)object2);
    }
}

