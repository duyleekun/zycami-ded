/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.SceneMode;
import e.a.v0.g;

public final class a0
implements g {
    public final /* synthetic */ SceneMode a;

    public /* synthetic */ a0(SceneMode sceneMode) {
        this.a = sceneMode;
    }

    public final void accept(Object object) {
        SceneMode sceneMode = this.a;
        object = (Throwable)object;
        BleViewModel.M0(sceneMode, (Throwable)object);
    }
}

