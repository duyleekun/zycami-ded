/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.me.MeFragment;
import com.zhiyun.cama.prime.model.PrimeInfo;

public final class f
implements Observer {
    public final /* synthetic */ MeFragment a;

    public /* synthetic */ f(MeFragment meFragment) {
        this.a = meFragment;
    }

    public final void onChanged(Object object) {
        MeFragment meFragment = this.a;
        object = (PrimeInfo)object;
        meFragment.D((PrimeInfo)object);
    }
}

