/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import d.v.e0.ce;
import e.a.v0.r;

public final class d9
implements r {
    public final /* synthetic */ int[] a;

    public /* synthetic */ d9(int[] nArray) {
        this.a = nArray;
    }

    public final boolean test(Object object) {
        int[] nArray = this.a;
        object = (WifiStatus)((Object)object);
        return ce.K2(nArray, (WifiStatus)((Object)object));
    }
}

