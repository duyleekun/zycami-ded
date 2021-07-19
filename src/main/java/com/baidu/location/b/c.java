/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.baidu.location.b;

import android.os.Bundle;
import com.baidu.location.b.b;

public class c {
    private static Object a;
    private static c b;
    private int c = -1;

    static {
        Object object;
        a = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c a() {
        Object object = a;
        synchronized (object) {
            c c10 = b;
            if (c10 != null) return b;
            b = c10 = new c();
            return b;
        }
    }

    public void a(int n10, int n11, String string2) {
        int n12 = this.c;
        if (n11 != n12) {
            this.c = n11;
            Bundle bundle = new Bundle();
            String string3 = "loctype";
            bundle.putInt(string3, n10);
            bundle.putInt("diagtype", n11);
            Object object = string2.getBytes();
            String string4 = "diagmessage";
            bundle.putByteArray(string4, (byte[])object);
            object = com.baidu.location.b.b.a();
            n11 = 303;
            ((b)object).a(bundle, n11);
        }
    }

    public void b() {
        this.c = -1;
    }
}

