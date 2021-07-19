/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.view.View;
import com.zhiyun.cama.main.me.MeFragment$b;

public class df$a
implements View.OnClickListener {
    private MeFragment$b a;

    public df$a b(MeFragment$b object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.d(view);
    }
}

