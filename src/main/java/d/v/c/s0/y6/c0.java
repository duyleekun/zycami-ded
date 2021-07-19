/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.stabilizer.Stabilizer;
import e.a.v0.o;

public final class c0
implements o {
    public final /* synthetic */ boolean a;

    public /* synthetic */ c0(boolean bl2) {
        this.a = bl2;
    }

    public final Object apply(Object object) {
        boolean bl2 = this.a;
        object = (Stabilizer)object;
        return BleViewModel.s0(bl2, (Stabilizer)object);
    }
}

