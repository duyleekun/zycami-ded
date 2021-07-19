/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.opendevice;

public final class d$a
extends Enum {
    public static final /* enum */ d$a a;
    public static final /* enum */ d$a b;
    public static final /* synthetic */ d$a[] c;
    public String d;

    static {
        d$a d$a;
        Object object = "GET";
        a = d$a = new d$a(object, 0, object);
        d$a[] d$aArray = "POST";
        int n10 = 1;
        object = new d$a((String)d$aArray, n10, (String)d$aArray);
        b = object;
        d$aArray = new d$a[2];
        d$aArray[0] = d$a;
        d$aArray[n10] = object;
        c = d$aArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public d$a() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.d = var3_1;
    }

    public static d$a valueOf(String string2) {
        return Enum.valueOf(d$a.class, string2);
    }

    public static d$a[] values() {
        return (d$a[])c.clone();
    }

    public String a() {
        return this.d;
    }
}

