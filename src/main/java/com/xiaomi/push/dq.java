/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.dp;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class dq {
    private static volatile dq a;
    private dp a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static dq a() {
        Object object = a;
        if (object != null) return a;
        object = dq.class;
        synchronized (object) {
            dq dq2 = a;
            if (dq2 != null) return a;
            a = dq2 = new dq();
            return a;
        }
    }

    public dp a() {
        return this.a;
    }

    public void a(dp dp2) {
        this.a = dp2;
    }
}

