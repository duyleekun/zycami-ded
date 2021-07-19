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
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class k
implements Observer {
    public final /* synthetic */ u a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ AtomicReference d;
    public final /* synthetic */ AtomicReference e;
    public final /* synthetic */ AtomicReference f;

    public /* synthetic */ k(u u10, AtomicReference atomicReference, Context context, AtomicReference atomicReference2, AtomicReference atomicReference3, AtomicReference atomicReference4) {
        this.a = u10;
        this.b = atomicReference;
        this.c = context;
        this.d = atomicReference2;
        this.e = atomicReference3;
        this.f = atomicReference4;
    }

    public final void onChanged(Object object) {
        u u10 = this.a;
        AtomicReference atomicReference = this.b;
        Context context = this.c;
        AtomicReference atomicReference2 = this.d;
        AtomicReference atomicReference3 = this.e;
        AtomicReference atomicReference4 = this.f;
        Object object2 = object;
        object2 = (List)object;
        u10.P(atomicReference, context, atomicReference2, atomicReference3, atomicReference4, (List)object2);
    }
}

