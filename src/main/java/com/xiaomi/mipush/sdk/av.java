/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.mipush.sdk;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class av
extends Enum {
    public static final /* enum */ av a;
    private static final /* synthetic */ av[] a;
    public static final /* enum */ av b;
    public static final /* enum */ av c;
    public static final /* enum */ av d;
    public static final /* enum */ av e;
    public static final /* enum */ av f;

    static {
        av av2;
        av av3;
        av av4;
        av av5;
        av av6;
        av av7;
        a = av7 = new av("DISABLE_PUSH", 0);
        int n10 = 1;
        b = av6 = new av("ENABLE_PUSH", n10);
        int n11 = 2;
        c = av5 = new av("UPLOAD_HUAWEI_TOKEN", n11);
        int n12 = 3;
        d = av4 = new av("UPLOAD_FCM_TOKEN", n12);
        int n13 = 4;
        e = av3 = new av("UPLOAD_COS_TOKEN", n13);
        int n14 = 5;
        f = av2 = new av("UPLOAD_FTOS_TOKEN", n14);
        av[] avArray = new av[6];
        avArray[0] = av7;
        avArray[n10] = av6;
        avArray[n11] = av5;
        avArray[n12] = av4;
        avArray[n13] = av3;
        avArray[n14] = av2;
        a = avArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private av() {
        void var2_-1;
        void var1_-1;
    }

    public static av valueOf(String string2) {
        return Enum.valueOf(av.class, string2);
    }

    public static av[] values() {
        return (av[])a.clone();
    }
}

