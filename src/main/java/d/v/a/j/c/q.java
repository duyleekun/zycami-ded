/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.j.c;

import androidx.lifecycle.Observer;
import com.zhiyun.account.set.privacy.SetNewPassFragment;

public final class q
implements Observer {
    public final /* synthetic */ SetNewPassFragment a;

    public /* synthetic */ q(SetNewPassFragment setNewPassFragment) {
        this.a = setNewPassFragment;
    }

    public final void onChanged(Object object) {
        SetNewPassFragment setNewPassFragment = this.a;
        object = (String)object;
        setNewPassFragment.x((String)object);
    }
}

