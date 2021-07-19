/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.s.a;
import f.h2.s.l;
import kotlin.NotImplementedError;

public class r0 {
    private static final Void a() {
        NotImplementedError notImplementedError = new NotImplementedError(null, 1, null);
        throw notImplementedError;
    }

    private static final Void b(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("An operation is not implemented: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        NotImplementedError notImplementedError = new NotImplementedError(string2);
        throw notImplementedError;
    }

    private static final Object c(Object object, l l10) {
        l10.invoke(object);
        return object;
    }

    private static final Object d(Object object, l l10) {
        l10.invoke(object);
        return object;
    }

    private static final Object e(Object object, l l10) {
        return l10.invoke(object);
    }

    private static final void f(int n10, l l10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            Integer n11 = i10;
            l10.invoke(n11);
        }
    }

    private static final Object g(Object object, l l10) {
        return l10.invoke(object);
    }

    private static final Object h(a a10) {
        return a10.invoke();
    }

    private static final Object i(Object object, l object2) {
        boolean bl2 = (Boolean)(object2 = (Boolean)object2.invoke(object));
        if (!bl2) {
            object = null;
        }
        return object;
    }

    private static final Object j(Object object, l object2) {
        boolean bl2 = (Boolean)(object2 = (Boolean)object2.invoke(object));
        if (bl2) {
            object = null;
        }
        return object;
    }

    private static final Object k(Object object, l l10) {
        return l10.invoke(object);
    }
}

