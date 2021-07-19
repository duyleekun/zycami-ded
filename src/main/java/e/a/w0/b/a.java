/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.b;

import e.a.v0.d;
import e.a.w0.b.a$a;
import java.util.Objects;

public final class a {
    public static final d a;

    static {
        a$a a$a = new a$a();
        a = a$a;
    }

    private a() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static int a(int n10, int n11) {
        n10 = n10 < n11 ? -1 : (n10 > n11 ? 1 : 0);
        return n10;
    }

    public static int b(long l10, long l11) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        object = object < 0 ? (Object)-1 : (object > 0 ? (Object)1 : (Object)0);
        return (int)object;
    }

    public static boolean c(Object object, Object object2) {
        boolean bl2;
        if (!(object == object2 || object != null && (bl2 = object.equals(object2)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static d d() {
        return a;
    }

    public static int e(Object object) {
        int n10;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    public static long f(long l10, String string2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Null check on a primitive: ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        InternalError internalError = new InternalError((String)charSequence);
        throw internalError;
    }

    public static Object g(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }

    public static int h(int n10, String string2) {
        if (n10 > 0) {
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public static long i(long l10, String string2) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return l10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" > 0 required but it was ");
        stringBuilder.append(l10);
        String string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }
}

