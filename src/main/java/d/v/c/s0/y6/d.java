/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import e.a.v0.g;

public final class d
implements g {
    public final /* synthetic */ BleViewModel a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ d(BleViewModel bleViewModel, boolean bl2) {
        this.a = bleViewModel;
        this.b = bl2;
    }

    public final void accept(Object object) {
        BleViewModel bleViewModel = this.a;
        boolean bl2 = this.b;
        object = (Boolean)object;
        bleViewModel.n0(bl2, (Boolean)object);
    }
}

