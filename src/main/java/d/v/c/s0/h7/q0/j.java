/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.q0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.data.MoreDevice;
import d.v.c.s0.h7.q0.y;

public final class j
implements Observer {
    public final /* synthetic */ y a;

    public /* synthetic */ j(y y10) {
        this.a = y10;
    }

    public final void onChanged(Object object) {
        y y10 = this.a;
        object = (MoreDevice)((Object)object);
        y10.a0((MoreDevice)((Object)object));
    }
}

