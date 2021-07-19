/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.h2.t.u;
import java.util.Collection;

public final class c$a {
    private c$a() {
    }

    public /* synthetic */ c$a(u u10) {
        this();
    }

    public final void a(int n10, int n11, int n12) {
        String string2 = "startIndex: ";
        if (n10 >= 0 && n11 <= n12) {
            if (n10 <= n11) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            stringBuilder.append(" > endIndex: ");
            stringBuilder.append(n11);
            String string3 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        stringBuilder.append(", endIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        stringBuilder.append(n12);
        String string4 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string4);
        throw indexOutOfBoundsException;
    }

    public final void b(int n10, int n11) {
        if (n10 >= 0 && n10 < n11) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index: ");
        stringBuilder.append(n10);
        stringBuilder.append(", size: ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final void c(int n10, int n11) {
        if (n10 >= 0 && n10 <= n11) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("index: ");
        stringBuilder.append(n10);
        stringBuilder.append(", size: ");
        stringBuilder.append(n11);
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public final void d(int n10, int n11, int n12) {
        String string2 = "fromIndex: ";
        if (n10 >= 0 && n11 <= n12) {
            if (n10 <= n11) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            stringBuilder.append(" > toIndex: ");
            stringBuilder.append(n11);
            String string3 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        stringBuilder.append(", toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        stringBuilder.append(n12);
        String string4 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string4);
        throw indexOutOfBoundsException;
    }

    public final boolean e(Collection object, Collection object2) {
        int n10;
        block2: {
            Object e10;
            f0.p(object, "c");
            String string2 = "other";
            f0.p(object2, string2);
            int n11 = object.size();
            n10 = object2.size();
            if (n11 != n10) {
                return false;
            }
            object2 = object2.iterator();
            object = object.iterator();
            do {
                n11 = (int)(object.hasNext() ? 1 : 0);
                n10 = 1;
                if (n11 == 0) break block2;
            } while ((n11 = f0.g(string2 = object.next(), e10 = object2.next()) ^ n10) == 0);
            return false;
        }
        return n10 != 0;
    }

    public final int f(Collection object) {
        int n10;
        String string2 = "c";
        f0.p(object, string2);
        object = object.iterator();
        int n11 = 1;
        while ((n10 = object.hasNext()) != 0) {
            Object e10 = object.next();
            n11 *= 31;
            if (e10 != null) {
                n10 = e10.hashCode();
            } else {
                n10 = 0;
                e10 = null;
            }
            n11 += n10;
        }
        return n11;
    }
}

