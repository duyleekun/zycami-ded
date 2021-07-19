/*
 * Decompiled with CFR 0.151.
 */
package i.d.s;

import i.d.s.a;
import java.util.regex.Pattern;

public class b
implements a {
    private static final Pattern b = Pattern.compile(" ");
    private static final Pattern c = Pattern.compile(",");
    private final String a;

    public b(String object) {
        if (object != null) {
            this.a = object;
            return;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public a a() {
        String string2 = this.c();
        b b10 = new b(string2);
        return b10;
    }

    public boolean b(String stringArray) {
        stringArray = b.matcher((CharSequence)stringArray).replaceAll("");
        Pattern pattern = c;
        stringArray = pattern.split((CharSequence)stringArray);
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = this.a;
            String string3 = stringArray[i10];
            boolean bl2 = string2.equals(string3);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public String c() {
        return this.a;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        if (this == object) {
            return true;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            object = (b)object;
            object2 = this.a;
            object = ((b)object).a;
            return ((String)object2).equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return this.c();
    }
}

