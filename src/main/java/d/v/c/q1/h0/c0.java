/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.q1.h0;

import android.view.View;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.set.bind.MyDeviceFragment;
import d.v.f.f.b;

public final class c0
implements b {
    public final /* synthetic */ MyDeviceFragment a;

    public /* synthetic */ c0(MyDeviceFragment myDeviceFragment) {
        this.a = myDeviceFragment;
    }

    public final void a(View view, int n10, Object object) {
        MyDeviceFragment myDeviceFragment = this.a;
        object = (BindDeviceInfo)object;
        myDeviceFragment.F(view, n10, (BindDeviceInfo)object);
    }
}

