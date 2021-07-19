/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0.n1.g;

import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import d.v.a0.n1.g.u;

public final class b
implements Runnable {
    public final /* synthetic */ u a;
    public final /* synthetic */ ZYEnumDefine$ConnectAction b;

    public /* synthetic */ b(u u10, ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        this.a = u10;
        this.b = zYEnumDefine$ConnectAction;
    }

    public final void run() {
        u u10 = this.a;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = this.b;
        u10.g(zYEnumDefine$ConnectAction);
    }
}

