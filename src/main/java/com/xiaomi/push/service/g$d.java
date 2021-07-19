/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.service.g$b;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class g$d {
    public int a;
    public long a;
    public g$b a;
    public final Object a;
    public boolean a;
    private long b;

    public g$d() {
        Object object;
        this.a = object = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(long l10) {
        Object object = this.a;
        synchronized (object) {
            this.b = l10;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a() {
        Object object = this.a;
        synchronized (object) {
            long l10;
            long l11;
            long l12;
            int n10 = this.a;
            int n11 = 1;
            if (!n10 && (n10 = (l12 = (l11 = this.a) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                n10 = n11;
            } else {
                n10 = 0;
                Object var8_6 = null;
            }
            this.a = n11;
            return n10;
        }
    }
}

