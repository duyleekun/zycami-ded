/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.splash.SplashFragment;

public final class p
implements Observer {
    public final /* synthetic */ SplashFragment a;

    public /* synthetic */ p(SplashFragment splashFragment) {
        this.a = splashFragment;
    }

    public final void onChanged(Object object) {
        SplashFragment splashFragment = this.a;
        object = (Boolean)object;
        splashFragment.K((Boolean)object);
    }
}

