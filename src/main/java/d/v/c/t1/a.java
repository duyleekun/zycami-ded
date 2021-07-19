/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.t1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.splash.SplashActivity;
import com.zhiyun.common.viewmodel.DeviceViewModel$NetWorkEvent;

public final class a
implements Observer {
    public final /* synthetic */ SplashActivity a;

    public /* synthetic */ a(SplashActivity splashActivity) {
        this.a = splashActivity;
    }

    public final void onChanged(Object object) {
        SplashActivity splashActivity = this.a;
        object = (DeviceViewModel$NetWorkEvent)((Object)object);
        splashActivity.l((DeviceViewModel$NetWorkEvent)((Object)object));
    }
}

