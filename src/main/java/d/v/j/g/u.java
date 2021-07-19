/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g;

import androidx.lifecycle.MutableLiveData;
import d.v.j.g.c0;
import java.util.function.Supplier;

public final class u
implements Runnable {
    public final /* synthetic */ MutableLiveData a;
    public final /* synthetic */ Supplier b;

    public /* synthetic */ u(MutableLiveData mutableLiveData, Supplier supplier) {
        this.a = mutableLiveData;
        this.b = supplier;
    }

    public final void run() {
        MutableLiveData mutableLiveData = this.a;
        Supplier supplier = this.b;
        c0.e(mutableLiveData, supplier);
    }
}

