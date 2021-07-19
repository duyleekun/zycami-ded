/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1.t2;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.me.MeFragment;
import com.zhiyun.common.viewmodel.DeviceViewModel$NetWorkEvent;

public final class d
implements Observer {
    public final /* synthetic */ MeFragment a;

    public /* synthetic */ d(MeFragment meFragment) {
        this.a = meFragment;
    }

    public final void onChanged(Object object) {
        MeFragment meFragment = this.a;
        object = (DeviceViewModel$NetWorkEvent)((Object)object);
        meFragment.F((DeviceViewModel$NetWorkEvent)((Object)object));
    }
}

