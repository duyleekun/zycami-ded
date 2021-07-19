/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.a.g;

import android.view.View;
import com.zhiyun.account.set.privacy.PrivateBindFragment$a;

public class b0$b
implements View.OnClickListener {
    private PrivateBindFragment$a a;

    public b0$b b(PrivateBindFragment$a object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.c(view);
    }
}

