/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0.n1.g;

import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import d.v.a0.h1;
import d.v.a0.n1.g.w;
import d.v.a0.n1.g.x;
import java.util.function.Consumer;

public final class r
implements Consumer {
    public final /* synthetic */ h1 a;
    public final /* synthetic */ ZYEnumDefine$ConnectAction b;

    public /* synthetic */ r(h1 h12, ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        this.a = h12;
        this.b = zYEnumDefine$ConnectAction;
    }

    public final void accept(Object object) {
        h1 h12 = this.a;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = this.b;
        object = (w)object;
        x.g(h12, zYEnumDefine$ConnectAction, (w)object);
    }
}

