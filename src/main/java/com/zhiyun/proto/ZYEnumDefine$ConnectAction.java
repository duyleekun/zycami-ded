/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;
import com.zhiyun.proto.ZYEnumDefine$ConnectAction$a;
import com.zhiyun.proto.ZYEnumDefine$ConnectAction$b;

public final class ZYEnumDefine$ConnectAction
extends Enum
implements Internal$EnumLite {
    public static final /* enum */ ZYEnumDefine$ConnectAction ConnectActionAgree;
    public static final int ConnectActionAgree_VALUE = 3;
    public static final /* enum */ ZYEnumDefine$ConnectAction ConnectActionCanecl;
    public static final int ConnectActionCanecl_VALUE = 2;
    public static final /* enum */ ZYEnumDefine$ConnectAction ConnectActionConnect;
    public static final int ConnectActionConnect_VALUE = 0;
    public static final /* enum */ ZYEnumDefine$ConnectAction ConnectActionDisconnect;
    public static final int ConnectActionDisconnect_VALUE = 1;
    public static final /* enum */ ZYEnumDefine$ConnectAction ConnectActionReject;
    public static final int ConnectActionReject_VALUE = 4;
    public static final /* enum */ ZYEnumDefine$ConnectAction UNRECOGNIZED;
    private static final Internal$EnumLiteMap a;
    private static final /* synthetic */ ZYEnumDefine$ConnectAction[] b;
    private final int value;

    static {
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction2;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction3;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction4;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction5;
        Object object = new ZYEnumDefine$ConnectAction("ConnectActionConnect", 0, 0);
        ConnectActionConnect = object;
        int n10 = 1;
        ConnectActionDisconnect = zYEnumDefine$ConnectAction5 = new ZYEnumDefine$ConnectAction("ConnectActionDisconnect", n10, n10);
        int n11 = 2;
        ConnectActionCanecl = zYEnumDefine$ConnectAction4 = new ZYEnumDefine$ConnectAction("ConnectActionCanecl", n11, n11);
        int n12 = 3;
        ConnectActionAgree = zYEnumDefine$ConnectAction3 = new ZYEnumDefine$ConnectAction("ConnectActionAgree", n12, n12);
        int n13 = 4;
        ConnectActionReject = zYEnumDefine$ConnectAction2 = new ZYEnumDefine$ConnectAction("ConnectActionReject", n13, n13);
        int n14 = 5;
        UNRECOGNIZED = zYEnumDefine$ConnectAction = new ZYEnumDefine$ConnectAction("UNRECOGNIZED", n14, -1);
        ZYEnumDefine$ConnectAction[] zYEnumDefine$ConnectActionArray = new ZYEnumDefine$ConnectAction[6];
        zYEnumDefine$ConnectActionArray[0] = object;
        zYEnumDefine$ConnectActionArray[n10] = zYEnumDefine$ConnectAction5;
        zYEnumDefine$ConnectActionArray[n11] = zYEnumDefine$ConnectAction4;
        zYEnumDefine$ConnectActionArray[n12] = zYEnumDefine$ConnectAction3;
        zYEnumDefine$ConnectActionArray[n13] = zYEnumDefine$ConnectAction2;
        zYEnumDefine$ConnectActionArray[n14] = zYEnumDefine$ConnectAction;
        b = zYEnumDefine$ConnectActionArray;
        a = object = new ZYEnumDefine$ConnectAction$a();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ZYEnumDefine$ConnectAction() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static ZYEnumDefine$ConnectAction forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            return null;
                        }
                        return ConnectActionReject;
                    }
                    return ConnectActionAgree;
                }
                return ConnectActionCanecl;
            }
            return ConnectActionDisconnect;
        }
        return ConnectActionConnect;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return a;
    }

    public static Internal$EnumVerifier internalGetVerifier() {
        return ZYEnumDefine$ConnectAction$b.a;
    }

    public static ZYEnumDefine$ConnectAction valueOf(int n10) {
        return ZYEnumDefine$ConnectAction.forNumber(n10);
    }

    public static ZYEnumDefine$ConnectAction valueOf(String string2) {
        return Enum.valueOf(ZYEnumDefine$ConnectAction.class, string2);
    }

    public static ZYEnumDefine$ConnectAction[] values() {
        return (ZYEnumDefine$ConnectAction[])b.clone();
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

