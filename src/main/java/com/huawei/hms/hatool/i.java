/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.l;
import com.huawei.hms.hatool.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class i {
    public static Map b;
    public static i c;
    public l a;

    static {
        HashMap hashMap;
        b = hashMap = new HashMap();
    }

    public i() {
        l l10;
        this.a = l10 = new l();
    }

    public static i c() {
        i i10 = c;
        if (i10 == null) {
            i.d();
        }
        return c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void d() {
        Class<i> clazz = i.class;
        synchronized (clazz) {
            i i10 = c;
            if (i10 == null) {
                c = i10 = new i();
            }
            return;
        }
    }

    public m a(String string2) {
        return (m)b.get(string2);
    }

    public Set a() {
        return b.keySet();
    }

    public void a(String string2, m m10) {
        b.put(string2, m10);
    }

    public l b() {
        return this.a;
    }
}

