/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1.h0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.set.bind.DeviceDetailFragment;

public final class r
implements Observer {
    public final /* synthetic */ DeviceDetailFragment a;

    public /* synthetic */ r(DeviceDetailFragment deviceDetailFragment) {
        this.a = deviceDetailFragment;
    }

    public final void onChanged(Object object) {
        DeviceDetailFragment deviceDetailFragment = this.a;
        object = (Boolean)object;
        deviceDetailFragment.C((Boolean)object);
    }
}

