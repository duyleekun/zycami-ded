/*
 * Decompiled with CFR 0.151.
 */
package j.a.a;

import j.a.a.e$a;
import java.util.Arrays;

public final class e {
    private final j.a.a.i.e a;
    private final String[] b;
    private final int c;
    private final String d;
    private final String e;
    private final String f;
    private final int g;

    private e(j.a.a.i.e stringArray, String[] stringArray2, int n10, String string2, String string3, String string4, int n11) {
        this.a = stringArray;
        stringArray = (String[])stringArray2.clone();
        this.b = stringArray;
        this.c = n10;
        this.d = string2;
        this.e = string3;
        this.f = string4;
        this.g = n11;
    }

    public /* synthetic */ e(j.a.a.i.e e10, String[] stringArray, int n10, String string2, String string3, String string4, int n11, e$a e$a) {
        this(e10, stringArray, n10, string2, string3, string4, n11);
    }

    public j.a.a.i.e a() {
        return this.a;
    }

    public String b() {
        return this.f;
    }

    public String[] c() {
        return (String[])this.b.clone();
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.d;
    }

    public boolean equals(Object object) {
        Object[] objectArray;
        Object[] objectArray2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (objectArray2 = e.class) == (objectArray = object.getClass())) {
            int n10;
            object = (e)object;
            objectArray2 = this.b;
            objectArray = ((e)object).b;
            int n11 = Arrays.equals(objectArray2, objectArray);
            if (n11 == 0 || (n11 = this.c) != (n10 = ((e)object).c)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int f() {
        return this.c;
    }

    public int g() {
        return this.g;
    }

    public int hashCode() {
        int n10 = Arrays.hashCode(this.b) * 31;
        int n11 = this.c;
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PermissionRequest{mHelper=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", mPerms=");
        object = Arrays.toString(this.b);
        stringBuilder.append((String)object);
        stringBuilder.append(", mRequestCode=");
        int n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append(", mRationale='");
        object = this.d;
        stringBuilder.append((String)object);
        n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", mPositiveButtonText='");
        String string2 = this.e;
        stringBuilder.append(string2);
        stringBuilder.append((char)n10);
        stringBuilder.append(", mNegativeButtonText='");
        string2 = this.f;
        stringBuilder.append(string2);
        stringBuilder.append((char)n10);
        stringBuilder.append(", mTheme=");
        n10 = this.g;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

