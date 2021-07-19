/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c;

import androidx.lifecycle.Observer;
import com.zhiyun.account.data.NetworkState;
import com.zhiyun.account.set.privacy.BindThirdFragment;

public final class i
implements Observer {
    public final /* synthetic */ BindThirdFragment a;

    public /* synthetic */ i(BindThirdFragment bindThirdFragment) {
        this.a = bindThirdFragment;
    }

    public final void onChanged(Object object) {
        BindThirdFragment bindThirdFragment = this.a;
        object = (NetworkState)object;
        bindThirdFragment.n((NetworkState)object);
    }
}

