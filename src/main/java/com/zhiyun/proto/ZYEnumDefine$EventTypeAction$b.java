/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.Internal$EnumVerifier;
import com.zhiyun.proto.ZYEnumDefine$EventTypeAction;

public final class ZYEnumDefine$EventTypeAction$b
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier a;

    static {
        ZYEnumDefine$EventTypeAction$b zYEnumDefine$EventTypeAction$b = new ZYEnumDefine$EventTypeAction$b();
        a = zYEnumDefine$EventTypeAction$b;
    }

    private ZYEnumDefine$EventTypeAction$b() {
    }

    public boolean isInRange(int n10) {
        ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction = ZYEnumDefine$EventTypeAction.forNumber(n10);
        if (zYEnumDefine$EventTypeAction != null) {
            n10 = 1;
        } else {
            n10 = 0;
            zYEnumDefine$EventTypeAction = null;
        }
        return n10 != 0;
    }
}

