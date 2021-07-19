/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import d.v.a0.g1;
import e.a.v0.g;

public final class b0
implements g {
    public final /* synthetic */ g1 a;
    public final /* synthetic */ ZYEnumDefine$ConnectAction b;

    public /* synthetic */ b0(g1 g12, ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        this.a = g12;
        this.b = zYEnumDefine$ConnectAction;
    }

    public final void accept(Object object) {
        g1 g12 = this.a;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = this.b;
        object = (Throwable)object;
        g12.e0(zYEnumDefine$ConnectAction, (Throwable)object);
    }
}

