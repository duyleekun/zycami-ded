/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.o.l.i;

public final class j$b
implements i {
    private final String a;

    public j$b(String string2) {
        this.a = string2;
    }

    public String a() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof j$b;
        if (bl2) {
            object = (j$b)object;
            String string2 = this.a;
            object = ((j$b)object).a;
            return string2.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StringHeaderFactory{value='");
        String string2 = this.a;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

