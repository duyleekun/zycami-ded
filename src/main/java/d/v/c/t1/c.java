/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnSystemUiVisibilityChangeListener
 */
package d.v.c.t1;

import android.view.View;
import com.zhiyun.cama.splash.SplashFragment;

public final class c
implements View.OnSystemUiVisibilityChangeListener {
    public final /* synthetic */ View a;

    public /* synthetic */ c(View view) {
        this.a = view;
    }

    public final void onSystemUiVisibilityChange(int n10) {
        SplashFragment.S(this.a, n10);
    }
}

