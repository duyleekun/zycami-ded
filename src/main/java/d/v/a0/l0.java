/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import d.v.a0.i1;
import d.v.z.n.b;
import e.a.v0.g;

public final class l0
implements g {
    public final /* synthetic */ i1 a;
    public final /* synthetic */ ZYEnumDefine$ConnectAction b;
    public final /* synthetic */ String c;
    public final /* synthetic */ b d;

    public /* synthetic */ l0(i1 i12, ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction, String string2, b b10) {
        this.a = i12;
        this.b = zYEnumDefine$ConnectAction;
        this.c = string2;
        this.d = b10;
    }

    public final void accept(Object object) {
        i1 i12 = this.a;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = this.b;
        String string2 = this.c;
        b b10 = this.d;
        object = (Throwable)object;
        i12.g0(zYEnumDefine$ConnectAction, string2, b10, (Throwable)object);
    }
}

