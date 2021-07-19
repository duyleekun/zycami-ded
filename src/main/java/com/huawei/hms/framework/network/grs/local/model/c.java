/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.network.grs.local.model;

import com.huawei.hms.framework.network.grs.local.model.d;
import java.util.List;
import java.util.Map;

public class c {
    private String a;
    private String b;
    private Map c;
    private List d;

    public c() {
        Cloneable cloneable;
        int n10 = 16;
        this.c = cloneable = new Cloneable(n10);
        super(n10);
        this.d = cloneable;
    }

    public d a(String string2) {
        return (d)this.c.get(string2);
    }

    public List a() {
        return this.d;
    }

    public void a(String string2, d d10) {
        this.c.put(string2, d10);
    }

    public void a(List list) {
        this.d = list;
    }

    public String b() {
        return this.b;
    }

    public void b(String string2) {
        this.a = string2;
    }

    public void c(String string2) {
        this.b = string2;
    }
}

