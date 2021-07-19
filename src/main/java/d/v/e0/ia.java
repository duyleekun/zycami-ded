/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import d.v.e0.ce;
import e.a.v0.g;

public final class ia
implements g {
    public final /* synthetic */ int[] a;

    public /* synthetic */ ia(int[] nArray) {
        this.a = nArray;
    }

    public final void accept(Object object) {
        int[] nArray = this.a;
        object = (WifiStatus)((Object)object);
        ce.M2(nArray, (WifiStatus)((Object)object));
    }
}

