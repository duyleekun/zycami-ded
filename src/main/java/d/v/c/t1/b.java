/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.splash.SplashActivity;

public final class b
implements Observer {
    public final /* synthetic */ SplashActivity a;

    public /* synthetic */ b(SplashActivity splashActivity) {
        this.a = splashActivity;
    }

    public final void onChanged(Object object) {
        SplashActivity splashActivity = this.a;
        object = (Boolean)object;
        splashActivity.j((Boolean)object);
    }
}

