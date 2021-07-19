/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.q1.h0;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.set.bind.MyDeviceFragment;
import d.v.f.f.a;

public final class d0
implements a {
    public final /* synthetic */ MyDeviceFragment a;
    public final /* synthetic */ BindDeviceInfo b;

    public /* synthetic */ d0(MyDeviceFragment myDeviceFragment, BindDeviceInfo bindDeviceInfo) {
        this.a = myDeviceFragment;
        this.b = bindDeviceInfo;
    }

    public final void a(DialogFragment dialogFragment) {
        MyDeviceFragment myDeviceFragment = this.a;
        BindDeviceInfo bindDeviceInfo = this.b;
        myDeviceFragment.R(bindDeviceInfo, dialogFragment);
    }
}

