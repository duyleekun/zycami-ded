/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1.h0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.set.bind.MyDeviceFragment;
import java.util.List;

public final class y
implements Observer {
    public final /* synthetic */ MyDeviceFragment a;

    public /* synthetic */ y(MyDeviceFragment myDeviceFragment) {
        this.a = myDeviceFragment;
    }

    public final void onChanged(Object object) {
        MyDeviceFragment myDeviceFragment = this.a;
        object = (List)object;
        myDeviceFragment.N((List)object);
    }
}

