/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.b7;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.DynamicZoomViewModel$TargetModel;
import d.v.c.s0.b7.k;

public final class c
implements Observer {
    public final /* synthetic */ k a;

    public /* synthetic */ c(k k10) {
        this.a = k10;
    }

    public final void onChanged(Object object) {
        k k10 = this.a;
        object = (DynamicZoomViewModel$TargetModel)((Object)object);
        k10.z((DynamicZoomViewModel$TargetModel)((Object)object));
    }
}

