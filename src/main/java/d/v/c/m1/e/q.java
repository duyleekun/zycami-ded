/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.e;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.prime.web.PrimeWebFragment;
import d.v.c.l1.e0.d;

public final class q
implements Observer {
    public final /* synthetic */ PrimeWebFragment a;

    public /* synthetic */ q(PrimeWebFragment primeWebFragment) {
        this.a = primeWebFragment;
    }

    public final void onChanged(Object object) {
        PrimeWebFragment primeWebFragment = this.a;
        object = (d)object;
        primeWebFragment.e0((d)object);
    }
}

