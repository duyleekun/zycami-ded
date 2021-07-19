/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.a.i.a;

import android.widget.CompoundButton;
import com.zhiyun.account.me.account.LoginFragment;

public final class k
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ LoginFragment a;

    public /* synthetic */ k(LoginFragment loginFragment) {
        this.a = loginFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        this.a.u(compoundButton, bl2);
    }
}

