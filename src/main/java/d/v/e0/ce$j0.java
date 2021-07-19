/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.wifi.device.WifiStatus;
import d.v.e0.ce;
import d.v.e0.oe.q;
import e.a.v0.g;

public class ce$j0
implements g {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ ce b;

    public ce$j0(ce ce2, int[] nArray) {
        this.b = ce2;
        this.a = nArray;
    }

    public void a(WifiStatus object) {
        int n10;
        Object object2 = this.a;
        object2[0] = n10 = object2[0] + 1;
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        object = object.name();
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("  ");
        int n11 = this.a[0];
        ((StringBuilder)object2).append(n11);
        q.a(((StringBuilder)object2).toString());
    }
}

