/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import androidx.lifecycle.Observer;
import com.zhiyun.account.me.account.SetPassFragment;

public final class f0
implements Observer {
    public final /* synthetic */ SetPassFragment a;

    public /* synthetic */ f0(SetPassFragment setPassFragment) {
        this.a = setPassFragment;
    }

    public final void onChanged(Object object) {
        SetPassFragment setPassFragment = this.a;
        object = (Boolean)object;
        setPassFragment.G((Boolean)object);
    }
}

