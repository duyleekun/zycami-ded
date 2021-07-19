/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.f0;
import java.util.HashMap;
import java.util.Map;

public final class e0 {
    public static e0 b;
    public volatile Map a;

    public e0() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
    }

    public static e0 a() {
        e0 e02 = b;
        if (e02 == null) {
            e0.b();
        }
        return b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void b() {
        Class<e0> clazz = e0.class;
        synchronized (clazz) {
            e0 e02 = b;
            if (e02 == null) {
                b = e02 = new e0();
            }
            return;
        }
    }

    public final f0 a(String string2) {
        Object object = this.a;
        boolean bl2 = object.containsKey(string2);
        if (!bl2) {
            object = new f0();
            Map map = this.a;
            map.put(string2, object);
        }
        return (f0)this.a.get(string2);
    }

    public f0 a(String object, long l10) {
        object = this.a((String)object);
        ((f0)object).a(l10);
        return object;
    }
}

