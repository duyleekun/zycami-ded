/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.aj;
import com.geetest.sdk.ak;
import com.geetest.sdk.z;

public class ag
implements ak {
    private static ag d;
    private ak a;
    private boolean b;
    private aj c;

    private ag() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ag b() {
        Object object = d;
        if (object != null) return d;
        object = ag.class;
        synchronized (object) {
            ag ag2;
            d = ag2 = new ag();
            return d;
        }
    }

    public void a() {
        ak ak2 = this.a;
        if (ak2 != null) {
            ak2.a();
        }
    }

    public void a(int n10, String string2, long l10, String string3, long l11, boolean bl2) {
        ak ak2 = this.a;
        if (ak2 != null) {
            ak2.a(n10, string2, l10, string3, l11, bl2);
        }
    }

    public void a(aj aj2) {
        this.c = aj2;
    }

    public void a(String string2, String string3, int n10, String string4, String string5) {
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        z z10 = z.c();
        this.a = z10;
        aj aj2 = this.c;
        z10.a(aj2);
        this.a.a(string2, string3, n10, string4, string5);
        this.b = true;
    }

    public void a(boolean bl2) {
        ak ak2 = this.a;
        if (ak2 != null) {
            ak2.a(bl2);
        }
    }
}

