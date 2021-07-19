/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.a.g;

import android.view.View;
import com.zhiyun.account.set.privacy.SetNewPassFragment$a;

public class l0$b
implements View.OnClickListener {
    private SetNewPassFragment$a a;

    public l0$b b(SetNewPassFragment$a object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.b(view);
    }
}

