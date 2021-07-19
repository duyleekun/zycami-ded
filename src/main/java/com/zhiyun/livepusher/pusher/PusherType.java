/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.livepusher.pusher;

public final class PusherType
extends Enum {
    public static final /* enum */ PusherType TENCENT_PUSHER;
    private static final /* synthetic */ PusherType[] a;
    private final String description;
    private final int type;

    static {
        PusherType pusherType;
        int n10 = 1;
        TENCENT_PUSHER = pusherType = new PusherType("TENCENT_PUSHER", 0, n10, "livePusher implements by tencent sdk.");
        PusherType[] pusherTypeArray = new PusherType[n10];
        pusherTypeArray[0] = pusherType;
        a = pusherTypeArray;
    }

    /*
     * WARNING - void declaration
     */
    private PusherType() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.type = var3_1;
        this.description = var4_2;
    }

    public static PusherType valueOf(String string2) {
        return Enum.valueOf(PusherType.class, string2);
    }

    public static PusherType[] values() {
        return (PusherType[])a.clone();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PusherType{pusherType=");
        int n10 = this.type;
        stringBuilder.append(n10);
        stringBuilder.append(", description='");
        String string2 = this.description;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

