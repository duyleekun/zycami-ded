/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.e;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.prime.web.PrimeWebFragment;
import d.v.w.c0.c;

public final class o
implements Observer {
    public final /* synthetic */ PrimeWebFragment a;

    public /* synthetic */ o(PrimeWebFragment primeWebFragment) {
        this.a = primeWebFragment;
    }

    public final void onChanged(Object object) {
        PrimeWebFragment primeWebFragment = this.a;
        object = (c)object;
        primeWebFragment.Y((c)object);
    }
}

