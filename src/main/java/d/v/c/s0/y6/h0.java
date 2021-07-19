/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.y6;

import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import com.zhiyun.stabilizer.Stabilizer;
import e.a.v0.o;

public final class h0
implements o {
    public final /* synthetic */ BleViewModel a;
    public final /* synthetic */ KeyFunc b;

    public /* synthetic */ h0(BleViewModel bleViewModel, KeyFunc keyFunc) {
        this.a = bleViewModel;
        this.b = keyFunc;
    }

    public final Object apply(Object object) {
        BleViewModel bleViewModel = this.a;
        KeyFunc keyFunc = this.b;
        object = (Stabilizer)object;
        return bleViewModel.G0(keyFunc, (Stabilizer)object);
    }
}

