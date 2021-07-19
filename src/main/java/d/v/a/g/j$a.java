/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.a.g;

import android.view.View;
import com.zhiyun.account.me.account.AccountMainFragment$b;

public class j$a
implements View.OnClickListener {
    private AccountMainFragment$b a;

    public j$a b(AccountMainFragment$b object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.a(view);
    }
}

