/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import d.v.e0.ce;
import e.a.v0.r;

public final class e7
implements r {
    public final /* synthetic */ ce a;
    public final /* synthetic */ int[] b;

    public /* synthetic */ e7(ce ce2, int[] nArray) {
        this.a = ce2;
        this.b = nArray;
    }

    public final boolean test(Object object) {
        ce ce2 = this.a;
        int[] nArray = this.b;
        object = (WifiStatus)((Object)object);
        return ce2.O2(nArray, (WifiStatus)((Object)object));
    }
}

