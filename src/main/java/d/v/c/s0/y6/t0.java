/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.SceneMode;
import e.a.v0.g;

public final class t0
implements g {
    public final /* synthetic */ BleViewModel a;
    public final /* synthetic */ SceneMode b;

    public /* synthetic */ t0(BleViewModel bleViewModel, SceneMode sceneMode) {
        this.a = bleViewModel;
        this.b = sceneMode;
    }

    public final void accept(Object object) {
        BleViewModel bleViewModel = this.a;
        SceneMode sceneMode = this.b;
        object = (Boolean)object;
        bleViewModel.L0(sceneMode, (Boolean)object);
    }
}

