/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import androidx.lifecycle.Observer;
import com.zhiyun.account.me.account.SetPassFragment;

public final class k0
implements Observer {
    public final /* synthetic */ SetPassFragment a;

    public /* synthetic */ k0(SetPassFragment setPassFragment) {
        this.a = setPassFragment;
    }

    public final void onChanged(Object object) {
        SetPassFragment setPassFragment = this.a;
        object = (String)object;
        setPassFragment.A((String)object);
    }
}

