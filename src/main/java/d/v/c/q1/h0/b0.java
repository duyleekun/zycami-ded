/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1.h0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.set.bind.MyDeviceFragment;

public final class b0
implements Observer {
    public final /* synthetic */ MyDeviceFragment a;

    public /* synthetic */ b0(MyDeviceFragment myDeviceFragment) {
        this.a = myDeviceFragment;
    }

    public final void onChanged(Object object) {
        MyDeviceFragment myDeviceFragment = this.a;
        object = (Boolean)object;
        myDeviceFragment.J((Boolean)object);
    }
}

