/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.SceneMode;

public final class g
implements e.a.v0.g {
    public final /* synthetic */ BleViewModel a;

    public /* synthetic */ g(BleViewModel bleViewModel) {
        this.a = bleViewModel;
    }

    public final void accept(Object object) {
        BleViewModel bleViewModel = this.a;
        object = (SceneMode)((Object)object);
        bleViewModel.g0((SceneMode)((Object)object));
    }
}

