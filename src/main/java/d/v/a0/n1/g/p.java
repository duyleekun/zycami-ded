/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0.n1.g;

import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import d.v.a0.h1;
import d.v.a0.n1.g.x;

public final class p
implements Runnable {
    public final /* synthetic */ x a;
    public final /* synthetic */ h1 b;
    public final /* synthetic */ ZYEnumDefine$ConnectAction c;

    public /* synthetic */ p(x x10, h1 h12, ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        this.a = x10;
        this.b = h12;
        this.c = zYEnumDefine$ConnectAction;
    }

    public final void run() {
        x x10 = this.a;
        h1 h12 = this.b;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = this.c;
        x10.k(h12, zYEnumDefine$ConnectAction);
    }
}

