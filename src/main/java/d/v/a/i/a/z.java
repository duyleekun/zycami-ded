/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import androidx.lifecycle.Observer;
import com.zhiyun.account.me.account.LoginQuickFragment;

public final class z
implements Observer {
    public final /* synthetic */ LoginQuickFragment a;

    public /* synthetic */ z(LoginQuickFragment loginQuickFragment) {
        this.a = loginQuickFragment;
    }

    public final void onChanged(Object object) {
        LoginQuickFragment loginQuickFragment = this.a;
        object = (Boolean)object;
        loginQuickFragment.E((Boolean)object);
    }
}

