/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.a.g;

import android.view.View;
import com.zhiyun.account.set.privacy.BindSuccessFragment$a;

public class d0$c
implements View.OnClickListener {
    private BindSuccessFragment$a a;

    public d0$c b(BindSuccessFragment$a object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.b(view);
    }
}

