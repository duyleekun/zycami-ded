/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import androidx.lifecycle.Observer;
import com.zhiyun.account.me.account.AccountMainFragment;

public final class d
implements Observer {
    public final /* synthetic */ AccountMainFragment a;

    public /* synthetic */ d(AccountMainFragment accountMainFragment) {
        this.a = accountMainFragment;
    }

    public final void onChanged(Object object) {
        AccountMainFragment accountMainFragment = this.a;
        object = (Boolean)object;
        accountMainFragment.v((Boolean)object);
    }
}

