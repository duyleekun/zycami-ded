/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.e;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.prime.web.PrimeWebFragment;
import com.zhiyun.pay.data.PayFlowResult;

public final class s
implements Observer {
    public final /* synthetic */ PrimeWebFragment a;

    public /* synthetic */ s(PrimeWebFragment primeWebFragment) {
        this.a = primeWebFragment;
    }

    public final void onChanged(Object object) {
        PrimeWebFragment primeWebFragment = this.a;
        object = (PayFlowResult)((Object)object);
        primeWebFragment.a0((PayFlowResult)((Object)object));
    }
}

