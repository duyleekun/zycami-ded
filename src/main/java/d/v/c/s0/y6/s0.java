/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.stabilizer.Stabilizer;
import e.a.v0.o;

public final class s0
implements o {
    public final /* synthetic */ BleViewModel a;

    public /* synthetic */ s0(BleViewModel bleViewModel) {
        this.a = bleViewModel;
    }

    public final Object apply(Object object) {
        BleViewModel bleViewModel = this.a;
        object = (Stabilizer)object;
        return BleViewModel.p0(bleViewModel, (Stabilizer)object);
    }
}

