/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ay;

public class aw
implements ay {
    private final String a;
    private final String b;

    public aw(String object, String string2) {
        if (object != null) {
            this.a = object;
            this.b = string2;
            return;
        }
        object = new IllegalArgumentException("Name may not be null");
        throw object;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}

