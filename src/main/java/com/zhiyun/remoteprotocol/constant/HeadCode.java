/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.remoteprotocol.constant;

import d.v.z.k.c;
import d.v.z.o.f;
import d.v.z.o.i;

public final class HeadCode
extends Enum
implements c {
    public static final int LENGTH = 2;
    public static final /* enum */ HeadCode RECEIVER_CODE;
    public static final /* enum */ HeadCode SENDER_CODE;
    private static final /* synthetic */ HeadCode[] a;
    private final int mCode;
    private final byte[] mCodeByte;

    static {
        HeadCode headCode;
        HeadCode headCode2;
        SENDER_CODE = headCode2 = new HeadCode("SENDER_CODE", 0, 15396);
        int n10 = 1;
        RECEIVER_CODE = headCode = new HeadCode("RECEIVER_CODE", n10, 15908);
        HeadCode[] headCodeArray = new HeadCode[2];
        headCodeArray[0] = headCode2;
        headCodeArray[n10] = headCode;
        a = headCodeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HeadCode() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.mCode = var3_1;
        byte[] byArray = f.q((int)var3_1, 2, true);
        this.mCodeByte = byArray;
    }

    public static HeadCode getValue(int n10) {
        return i.c(HeadCode.values(), n10).orElse(null);
    }

    public static HeadCode getValue(byte[] byArray) {
        return i.d(HeadCode.values(), byArray).orElse(null);
    }

    public static HeadCode valueOf(String string2) {
        return Enum.valueOf(HeadCode.class, string2);
    }

    public static HeadCode[] values() {
        return (HeadCode[])a.clone();
    }

    public int getCode() {
        return this.mCode;
    }

    public byte[] getCodeByte() {
        return this.mCodeByte;
    }
}

