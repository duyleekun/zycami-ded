/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.e;

import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.prime.web.PrimeWebFragment;

public final class k
implements Observer {
    public final /* synthetic */ PrimeWebFragment a;

    public /* synthetic */ k(PrimeWebFragment primeWebFragment) {
        this.a = primeWebFragment;
    }

    public final void onChanged(Object object) {
        PrimeWebFragment primeWebFragment = this.a;
        object = (Pair)object;
        primeWebFragment.c0((Pair)object);
    }
}

