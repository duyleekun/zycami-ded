/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.ao;

public class al {
    public long a;
    public String b;
    public String c;
    public ao d;

    public boolean a() {
        long l10;
        long l11;
        long l12;
        int n10;
        ao ao2 = this.d;
        if (ao2 != null || (n10 = (l12 = (l11 = this.a) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            ao2 = null;
        }
        return n10 != 0;
    }
}

