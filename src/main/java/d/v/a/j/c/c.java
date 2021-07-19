/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c;

import androidx.lifecycle.Observer;
import com.zhiyun.account.set.privacy.BindSuccessFragment;

public final class c
implements Observer {
    public final /* synthetic */ BindSuccessFragment a;

    public /* synthetic */ c(BindSuccessFragment bindSuccessFragment) {
        this.a = bindSuccessFragment;
    }

    public final void onChanged(Object object) {
        BindSuccessFragment bindSuccessFragment = this.a;
        object = (Integer)object;
        bindSuccessFragment.p((Integer)object);
    }
}

