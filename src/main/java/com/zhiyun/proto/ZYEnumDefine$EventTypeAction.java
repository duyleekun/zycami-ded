/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.proto;

import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;
import com.zhiyun.proto.ZYEnumDefine$EventTypeAction$a;
import com.zhiyun.proto.ZYEnumDefine$EventTypeAction$b;

public final class ZYEnumDefine$EventTypeAction
extends Enum
implements Internal$EnumLite {
    public static final /* enum */ ZYEnumDefine$EventTypeAction EventTypeActionNoti;
    public static final int EventTypeActionNoti_VALUE = 2;
    public static final /* enum */ ZYEnumDefine$EventTypeAction EventTypeActionRead;
    public static final int EventTypeActionRead_VALUE = 0;
    public static final /* enum */ ZYEnumDefine$EventTypeAction EventTypeActionWrite;
    public static final int EventTypeActionWrite_VALUE = 1;
    public static final /* enum */ ZYEnumDefine$EventTypeAction UNRECOGNIZED;
    private static final Internal$EnumLiteMap a;
    private static final /* synthetic */ ZYEnumDefine$EventTypeAction[] b;
    private final int value;

    static {
        ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction;
        ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction2;
        ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction3;
        Object object = new ZYEnumDefine$EventTypeAction("EventTypeActionRead", 0, 0);
        EventTypeActionRead = object;
        int n10 = 1;
        EventTypeActionWrite = zYEnumDefine$EventTypeAction3 = new ZYEnumDefine$EventTypeAction("EventTypeActionWrite", n10, n10);
        int n11 = 2;
        EventTypeActionNoti = zYEnumDefine$EventTypeAction2 = new ZYEnumDefine$EventTypeAction("EventTypeActionNoti", n11, n11);
        int n12 = 3;
        UNRECOGNIZED = zYEnumDefine$EventTypeAction = new ZYEnumDefine$EventTypeAction("UNRECOGNIZED", n12, -1);
        ZYEnumDefine$EventTypeAction[] zYEnumDefine$EventTypeActionArray = new ZYEnumDefine$EventTypeAction[4];
        zYEnumDefine$EventTypeActionArray[0] = object;
        zYEnumDefine$EventTypeActionArray[n10] = zYEnumDefine$EventTypeAction3;
        zYEnumDefine$EventTypeActionArray[n11] = zYEnumDefine$EventTypeAction2;
        zYEnumDefine$EventTypeActionArray[n12] = zYEnumDefine$EventTypeAction;
        b = zYEnumDefine$EventTypeActionArray;
        a = object = new ZYEnumDefine$EventTypeAction$a();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ZYEnumDefine$EventTypeAction() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static ZYEnumDefine$EventTypeAction forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return EventTypeActionNoti;
            }
            return EventTypeActionWrite;
        }
        return EventTypeActionRead;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return a;
    }

    public static Internal$EnumVerifier internalGetVerifier() {
        return ZYEnumDefine$EventTypeAction$b.a;
    }

    public static ZYEnumDefine$EventTypeAction valueOf(int n10) {
        return ZYEnumDefine$EventTypeAction.forNumber(n10);
    }

    public static ZYEnumDefine$EventTypeAction valueOf(String string2) {
        return Enum.valueOf(ZYEnumDefine$EventTypeAction.class, string2);
    }

    public static ZYEnumDefine$EventTypeAction[] values() {
        return (ZYEnumDefine$EventTypeAction[])b.clone();
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

