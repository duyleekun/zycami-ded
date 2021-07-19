/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.view.View;
import com.zhiyun.cama.splash.SplashFragment$c;

public class bh$c
implements View.OnClickListener {
    private SplashFragment$c a;

    public bh$c b(SplashFragment$c object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.e(view);
    }
}

