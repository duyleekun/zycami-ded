/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.database.model.SplashAd;
import com.zhiyun.cama.splash.SplashFragment;

public final class h
implements Observer {
    public final /* synthetic */ SplashFragment a;

    public /* synthetic */ h(SplashFragment splashFragment) {
        this.a = splashFragment;
    }

    public final void onChanged(Object object) {
        SplashFragment splashFragment = this.a;
        object = (SplashAd)object;
        splashFragment.C((SplashAd)object);
    }
}

