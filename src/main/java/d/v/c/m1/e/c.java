/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.e;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.prime.web.PrimeWebFragment;

public final class c
implements Observer {
    public final /* synthetic */ PrimeWebFragment a;

    public /* synthetic */ c(PrimeWebFragment primeWebFragment) {
        this.a = primeWebFragment;
    }

    public final void onChanged(Object object) {
        PrimeWebFragment primeWebFragment = this.a;
        object = (String)object;
        primeWebFragment.W((String)object);
    }
}

