/*
 * Decompiled with CFR 0.151.
 */
package l.a.q.g0;

import java.util.List;

public class r {
    private String a;
    private String b;
    private List c;

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public List c() {
        return this.c;
    }

    public r d(String string2) {
        this.a = string2;
        return this;
    }

    public r e(String string2) {
        this.b = string2;
        return this;
    }

    public r f(List list) {
        this.c = list;
        return this;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StringsData{name='");
        Object object = this.a;
        stringBuilder.append((String)object);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", value='");
        String string2 = this.b;
        stringBuilder.append(string2);
        stringBuilder.append(c10);
        stringBuilder.append(", values=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

