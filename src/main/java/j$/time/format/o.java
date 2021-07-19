/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.format.f;
import j$.time.format.v;

final class o
implements f {
    private final String a;

    o(String string2) {
        this.a = string2;
    }

    public boolean m(v object, StringBuilder stringBuilder) {
        object = this.a;
        stringBuilder.append((String)object);
        return true;
    }

    public String toString() {
        String string2 = this.a;
        String string3 = "'";
        string2 = string2.replace(string3, "''");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }
}

