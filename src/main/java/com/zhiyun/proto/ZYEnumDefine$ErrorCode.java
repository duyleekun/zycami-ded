/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode$a;
import com.zhiyun.proto.ZYEnumDefine$ErrorCode$b;

public final class ZYEnumDefine$ErrorCode
extends Enum
implements Internal$EnumLite {
    public static final /* enum */ ZYEnumDefine$ErrorCode ErrorCodeNon;
    public static final int ErrorCodeNon_VALUE = 0;
    public static final /* enum */ ZYEnumDefine$ErrorCode ErrorCodePara;
    public static final int ErrorCodePara_VALUE = 1;
    public static final /* enum */ ZYEnumDefine$ErrorCode UNRECOGNIZED;
    private static final Internal$EnumLiteMap a;
    private static final /* synthetic */ ZYEnumDefine$ErrorCode[] b;
    private final int value;

    static {
        ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode;
        ZYEnumDefine$ErrorCode zYEnumDefine$ErrorCode2;
        Object object = new ZYEnumDefine$ErrorCode("ErrorCodeNon", 0, 0);
        ErrorCodeNon = object;
        int n10 = 1;
        ErrorCodePara = zYEnumDefine$ErrorCode2 = new ZYEnumDefine$ErrorCode("ErrorCodePara", n10, n10);
        int n11 = 2;
        UNRECOGNIZED = zYEnumDefine$ErrorCode = new ZYEnumDefine$ErrorCode("UNRECOGNIZED", n11, -1);
        ZYEnumDefine$ErrorCode[] zYEnumDefine$ErrorCodeArray = new ZYEnumDefine$ErrorCode[3];
        zYEnumDefine$ErrorCodeArray[0] = object;
        zYEnumDefine$ErrorCodeArray[n10] = zYEnumDefine$ErrorCode2;
        zYEnumDefine$ErrorCodeArray[n11] = zYEnumDefine$ErrorCode;
        b = zYEnumDefine$ErrorCodeArray;
        a = object = new ZYEnumDefine$ErrorCode$a();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ZYEnumDefine$ErrorCode() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static ZYEnumDefine$ErrorCode forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return null;
            }
            return ErrorCodePara;
        }
        return ErrorCodeNon;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return a;
    }

    public static Internal$EnumVerifier internalGetVerifier() {
        return ZYEnumDefine$ErrorCode$b.a;
    }

    public static ZYEnumDefine$ErrorCode valueOf(int n10) {
        return ZYEnumDefine$ErrorCode.forNumber(n10);
    }

    public static ZYEnumDefine$ErrorCode valueOf(String string2) {
        return Enum.valueOf(ZYEnumDefine$ErrorCode.class, string2);
    }

    public static ZYEnumDefine$ErrorCode[] values() {
        return (ZYEnumDefine$ErrorCode[])b.clone();
    }

    public final int getNumber() {
        Object object = UNRECOGNIZED;
        if (this != object) {
            return this.value;
        }
        object = new IllegalArgumentException("Can't get the number of an unknown enum value.");
        throw object;
    }
}

