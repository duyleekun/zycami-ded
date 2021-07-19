/*
 * Decompiled with CFR 0.151.
 */
package d.v.h;

import java.util.UUID;

public class b {
    private String a;

    public b() {
        String string2;
        this.a = string2 = UUID.randomUUID().toString();
    }

    public String a() {
        return this.a;
    }

    public b b(String string2) {
        this.a = string2;
        return this;
    }
}

