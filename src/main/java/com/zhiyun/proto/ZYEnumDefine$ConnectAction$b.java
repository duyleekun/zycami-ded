/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.Internal$EnumVerifier;
import com.zhiyun.proto.ZYEnumDefine$ConnectAction;

public final class ZYEnumDefine$ConnectAction$b
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier a;

    static {
        ZYEnumDefine$ConnectAction$b zYEnumDefine$ConnectAction$b = new ZYEnumDefine$ConnectAction$b();
        a = zYEnumDefine$ConnectAction$b;
    }

    private ZYEnumDefine$ConnectAction$b() {
    }

    public boolean isInRange(int n10) {
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.forNumber(n10);
        if (zYEnumDefine$ConnectAction != null) {
            n10 = 1;
        } else {
            n10 = 0;
            zYEnumDefine$ConnectAction = null;
        }
        return n10 != 0;
    }
}

