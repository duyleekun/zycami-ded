/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.remoteprotocol.constant;

import d.v.z.k.c;
import d.v.z.o.f;
import d.v.z.o.i;
import java.util.Optional;

public final class ProtoType
extends Enum
implements c {
    public static final /* enum */ ProtoType CONNECT;
    public static final /* enum */ ProtoType DEVICE_INFO;
    public static final /* enum */ ProtoType EVENT;
    public static final /* enum */ ProtoType HEARTBEAT;
    public static final int LENGTH = 2;
    public static final /* enum */ ProtoType NO_PROTO;
    public static final /* enum */ ProtoType STATE_INFO;
    private static final /* synthetic */ ProtoType[] a;
    private final int mCode;
    private final byte[] mCodeByte;

    static {
        ProtoType protoType;
        ProtoType protoType2;
        ProtoType protoType3;
        ProtoType protoType4;
        ProtoType protoType5;
        ProtoType protoType6;
        NO_PROTO = protoType6 = new ProtoType("NO_PROTO", 0, 0);
        int n10 = 1;
        EVENT = protoType5 = new ProtoType("EVENT", n10, n10);
        int n11 = 2;
        STATE_INFO = protoType4 = new ProtoType("STATE_INFO", n11, n11);
        int n12 = 3;
        DEVICE_INFO = protoType3 = new ProtoType("DEVICE_INFO", n12, n12);
        int n13 = 4;
        CONNECT = protoType2 = new ProtoType("CONNECT", n13, n13);
        int n14 = 5;
        HEARTBEAT = protoType = new ProtoType("HEARTBEAT", n14, n14);
        ProtoType[] protoTypeArray = new ProtoType[6];
        protoTypeArray[0] = protoType6;
        protoTypeArray[n10] = protoType5;
        protoTypeArray[n11] = protoType4;
        protoTypeArray[n12] = protoType3;
        protoTypeArray[n13] = protoType2;
        protoTypeArray[n14] = protoType;
        a = protoTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ProtoType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mCode = var3_1;
        byte[] byArray = f.q((int)var3_1, 2, true);
        this.mCodeByte = byArray;
    }

    public static ProtoType getValue(int n10) {
        Optional optional = i.c(ProtoType.values(), n10);
        ProtoType protoType = NO_PROTO;
        return optional.orElse(protoType);
    }

    public static ProtoType getValue(byte[] object) {
        object = i.d(ProtoType.values(), (byte[])object);
        ProtoType protoType = NO_PROTO;
        return ((Optional)object).orElse(protoType);
    }

    public static ProtoType valueOf(String string2) {
        return Enum.valueOf(ProtoType.class, string2);
    }

    public static ProtoType[] values() {
        return (ProtoType[])a.clone();
    }

    public int getCode() {
        return this.mCode;
    }

    public byte[] getCodeByte() {
        return this.mCodeByte;
    }
}

