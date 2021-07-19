/*
 * Decompiled with CFR 0.151.
 */
package d.v.a.i.a;

import androidx.lifecycle.Observer;
import com.zhiyun.account.me.account.LoginFragment;

public final class j
implements Observer {
    public final /* synthetic */ LoginFragment a;

    public /* synthetic */ j(LoginFragment loginFragment) {
        this.a = loginFragment;
    }

    public final void onChanged(Object object) {
        LoginFragment loginFragment = this.a;
        object = (Boolean)object;
        loginFragment.I((Boolean)object);
    }
}

