/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.s.a;
import f.h2.s.l;
import f.h2.t.f0;
import kotlin.Result;
import kotlin.Result$Failure;

public final class o0 {
    public static final Object a(Throwable throwable) {
        f0.p(throwable, "exception");
        Result$Failure result$Failure = new Result$Failure(throwable);
        return result$Failure;
    }

    private static final Object b(Object object, l l10, l l11) {
        Throwable throwable = Result.exceptionOrNull-impl(object);
        object = throwable == null ? l10.invoke(object) : l11.invoke(throwable);
        return object;
    }

    private static final Object c(Object object, Object object2) {
        boolean bl2 = Result.isFailure-impl(object);
        if (bl2) {
            return object2;
        }
        return object;
    }

    private static final Object d(Object object, l l10) {
        Throwable throwable = Result.exceptionOrNull-impl(object);
        if (throwable != null) {
            object = l10.invoke(throwable);
        }
        return object;
    }

    private static final Object e(Object object) {
        o0.n(object);
        return object;
    }

    private static final Object f(Object object, l l10) {
        boolean bl2 = Result.isSuccess-impl(object);
        object = bl2 ? Result.constructor-impl(l10.invoke(object)) : Result.constructor-impl(object);
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final Object g(Object object, l object2) {
        boolean bl2 = Result.isSuccess-impl(object);
        if (!bl2) return Result.constructor-impl(object);
        try {}
        catch (Throwable throwable) {
            object2 = Result.Companion;
            return Result.constructor-impl(o0.a(throwable));
        }
        object = object2.invoke(object);
        return Result.constructor-impl(object);
    }

    private static final Object h(Object object, l l10) {
        Throwable throwable = Result.exceptionOrNull-impl(object);
        if (throwable != null) {
            l10.invoke(throwable);
        }
        return object;
    }

    private static final Object i(Object object, l l10) {
        boolean bl2 = Result.isSuccess-impl(object);
        if (bl2) {
            l10.invoke(object);
        }
        return object;
    }

    private static final Object j(Object object, l l10) {
        Throwable throwable = Result.exceptionOrNull-impl(object);
        if (throwable != null) {
            object = Result.Companion;
            object = Result.constructor-impl(l10.invoke(throwable));
        }
        return object;
    }

    private static final Object k(Object object, l object2) {
        Throwable throwable = Result.exceptionOrNull-impl(object);
        if (throwable != null) {
            object = Result.Companion;
            object = object2.invoke(throwable);
            try {
                object = Result.constructor-impl(object);
            }
            catch (Throwable throwable2) {
                object2 = Result.Companion;
                object = Result.constructor-impl(o0.a(throwable2));
            }
        }
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final Object l(Object object, l object2) {
        try {}
        catch (Throwable throwable) {
            object2 = Result.Companion;
            return Result.constructor-impl(o0.a(throwable));
        }
        object = object2.invoke(object);
        return Result.constructor-impl(object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final Object m(a object) {
        try {}
        catch (Throwable throwable) {
            return Result.constructor-impl(o0.a(throwable));
        }
        object = object.invoke();
        return Result.constructor-impl(object);
    }

    public static final void n(Object object) {
        boolean bl2 = object instanceof Result$Failure;
        if (!bl2) {
            return;
        }
        throw ((Result$Failure)object).exception;
    }
}

