/*
 * Decompiled with CFR 0.151.
 */
package d.r.a.r;

public final class e {
    public String a;
    public String b;

    public e(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    public final boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        if (object == null) {
            return false;
        }
        Object object2 = e.class;
        Class<?> clazz = object.getClass();
        if (object2 != clazz) {
            return false;
        }
        object = (e)object;
        object2 = this.a;
        if (object2 == null ? (object = ((e)object).a) != null : !(bl2 = ((String)object2).equals(object = ((e)object).a))) {
            return false;
        }
        return bl3;
    }

    public final int hashCode() {
        int n10;
        String string2 = this.a;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        return n10 + 31;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConfigItem{mKey='");
        String string2 = this.a;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", mValue='");
        String string3 = this.b;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

