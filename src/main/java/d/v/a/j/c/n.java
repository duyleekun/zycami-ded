/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c;

import androidx.lifecycle.Observer;
import com.zhiyun.account.set.privacy.SetNewPassFragment;

public final class n
implements Observer {
    public final /* synthetic */ SetNewPassFragment a;

    public /* synthetic */ n(SetNewPassFragment setNewPassFragment) {
        this.a = setNewPassFragment;
    }

    public final void onChanged(Object object) {
        SetNewPassFragment setNewPassFragment = this.a;
        object = (Boolean)object;
        setNewPassFragment.v((Boolean)object);
    }
}

