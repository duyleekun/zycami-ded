/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.network.grs.local.model;

import com.huawei.hms.framework.network.grs.local.model.c;
import java.util.HashMap;
import java.util.Map;

public class a {
    private String a;
    private long b;
    private Map c;

    public a() {
        HashMap hashMap;
        this.c = hashMap = new HashMap(16);
    }

    public c a(String string2) {
        return (c)this.c.get(string2);
    }

    public void a() {
        Map map = this.c;
        if (map != null) {
            map.clear();
        }
    }

    public void a(long l10) {
        this.b = l10;
    }

    public void a(String string2, c c10) {
        this.c.put(string2, c10);
    }

    public String b() {
        return this.a;
    }

    public void b(String string2) {
        this.a = string2;
    }
}

