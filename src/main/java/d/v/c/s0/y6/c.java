/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.constants.SceneMode;
import com.zhiyun.stabilizer.Stabilizer;
import e.a.v0.o;

public final class c
implements o {
    public final /* synthetic */ SceneMode a;

    public /* synthetic */ c(SceneMode sceneMode) {
        this.a = sceneMode;
    }

    public final Object apply(Object object) {
        SceneMode sceneMode = this.a;
        object = (Stabilizer)object;
        return BleViewModel.J0(sceneMode, (Stabilizer)object);
    }
}

