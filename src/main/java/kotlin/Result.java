/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

import f.h2.t.f0;
import java.io.Serializable;
import kotlin.Result$Failure;
import kotlin.Result$a;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class Result
implements Serializable {
    public static final Result$a Companion;
    private final Object value;

    static {
        Result$a result$a;
        Companion = result$a = new Result$a(null);
    }

    private /* synthetic */ Result(Object object) {
        this.value = object;
    }

    private static final Object a(Object object) {
        boolean bl2 = Result.isFailure-impl(object);
        if (bl2) {
            object = null;
        }
        return object;
    }

    public static final /* synthetic */ Result box-impl(Object object) {
        Result result2 = new Result(object);
        return result2;
    }

    public static Object constructor-impl(Object object) {
        return object;
    }

    public static boolean equals-impl(Object object, Object object2) {
        boolean bl2;
        boolean bl3 = object2 instanceof Result;
        return bl3 && (bl2 = f0.g(object, object2 = ((Result)object2).unbox-impl()));
    }

    public static final boolean equals-impl0(Object object, Object object2) {
        return f0.g(object, object2);
    }

    public static final Throwable exceptionOrNull-impl(Object object) {
        boolean bl2 = object instanceof Result$Failure;
        object = bl2 ? ((Result$Failure)object).exception : null;
        return object;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    public static int hashCode-impl(Object object) {
        int n10;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    public static final boolean isFailure-impl(Object object) {
        return object instanceof Result$Failure;
    }

    public static final boolean isSuccess-impl(Object object) {
        return object instanceof Result$Failure ^ true;
    }

    public static String toString-impl(Object object) {
        boolean bl2 = object instanceof Result$Failure;
        if (bl2) {
            object = object.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Success(";
            stringBuilder.append(string2);
            stringBuilder.append(object);
            char c10 = ')';
            stringBuilder.append(c10);
            object = stringBuilder.toString();
        }
        return object;
    }

    public boolean equals(Object object) {
        return Result.equals-impl(this.value, object);
    }

    public int hashCode() {
        return Result.hashCode-impl(this.value);
    }

    public String toString() {
        return Result.toString-impl(this.value);
    }

    public final /* synthetic */ Object unbox-impl() {
        return this.value;
    }
}

