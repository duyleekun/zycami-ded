/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.s.a;
import f.j0;

public class k0
extends j0 {
    private static final void c(boolean bl2) {
        if (bl2) {
            return;
        }
        String string2 = "Check failed.".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    private static final void d(boolean bl2, a object) {
        if (bl2) {
            return;
        }
        Object object2 = object.invoke();
        object2 = object2.toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    private static final Object e(Object object) {
        if (object != null) {
            return object;
        }
        String string2 = "Required value was null.".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    private static final Object f(Object object, a object2) {
        if (object != null) {
            return object;
        }
        object = object2.invoke();
        object = object.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    private static final Void g(Object object) {
        object = object.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    private static final void h(boolean bl2) {
        if (bl2) {
            return;
        }
        String string2 = "Failed requirement.".toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    private static final void i(boolean bl2, a object) {
        if (bl2) {
            return;
        }
        Object object2 = object.invoke();
        object2 = object2.toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    private static final Object j(Object object) {
        if (object != null) {
            return object;
        }
        String string2 = "Required value was null.".toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    private static final Object k(Object object, a object2) {
        if (object != null) {
            return object;
        }
        object = object2.invoke();
        object = object.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }
}

