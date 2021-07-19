/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1.e;

import androidx.lifecycle.Observer;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.prime.web.PrimeWebFragment;

public final class w
implements Observer {
    public final /* synthetic */ PrimeWebFragment a;

    public /* synthetic */ w(PrimeWebFragment primeWebFragment) {
        this.a = primeWebFragment;
    }

    public final void onChanged(Object object) {
        PrimeWebFragment primeWebFragment = this.a;
        object = (UserInfo)object;
        primeWebFragment.C((UserInfo)object);
    }
}

