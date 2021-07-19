/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ae;
import e.a.v0.c;

public final class n
implements c {
    public final /* synthetic */ boolean a;

    public /* synthetic */ n(boolean bl2) {
        this.a = bl2;
    }

    public final Object apply(Object object, Object object2) {
        boolean bl2 = this.a;
        object = (Stabilizer)object;
        object2 = (ae)object2;
        return BleViewModel.w0(bl2, (Stabilizer)object, (ae)object2);
    }
}

