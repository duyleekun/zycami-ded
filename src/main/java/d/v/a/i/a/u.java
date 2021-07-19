/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import androidx.lifecycle.Observer;
import com.zhiyun.account.me.account.LoginQuickFragment;

public final class u
implements Observer {
    public final /* synthetic */ LoginQuickFragment a;

    public /* synthetic */ u(LoginQuickFragment loginQuickFragment) {
        this.a = loginQuickFragment;
    }

    public final void onChanged(Object object) {
        LoginQuickFragment loginQuickFragment = this.a;
        object = (String)object;
        loginQuickFragment.w((String)object);
    }
}

