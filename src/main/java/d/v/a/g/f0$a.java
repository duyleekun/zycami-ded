/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.a.g;

import android.view.View;
import com.zhiyun.account.set.privacy.BindThirdFragment$b;

public class f0$a
implements View.OnClickListener {
    private BindThirdFragment$b a;

    public f0$a b(BindThirdFragment$b object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.b(view);
    }
}

