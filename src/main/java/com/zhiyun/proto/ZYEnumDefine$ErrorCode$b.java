/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.Internal$EnumVerifier;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode;

public final class ZYEnumDefine$ErrorCode$b
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier a;

    static {
        ZYEnumDefine$ErrorCode$b zYEnumDefine$ErrorCode$b = new ZYEnumDefine$ErrorCode$b();
        a = zYEnumDefine$ErrorCode$b;
    }

    private ZYEnumDefine$ErrorCode$b() {
    }

    public boolean isInRange(int n10) {
        ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode = ZYEnumDefine$ErrorCode.forNumber(n10);
        if (zYEnumDefine$ErrorCode != null) {
            n10 = 1;
        } else {
            n10 = 0;
            zYEnumDefine$ErrorCode = null;
        }
        return n10 != 0;
    }
}

