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

public class df$g
implements View.OnClickListener {
    private MeFragment$b a;

    public df$g b(MeFragment$b object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.i(view);
    }
}

