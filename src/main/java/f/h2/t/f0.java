/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class f0 {
    private f0() {
    }

    private static Throwable A(Throwable throwable) {
        String string2 = f0.class.getName();
        return f0.B(throwable, string2);
    }

    public static Throwable B(Throwable throwable, String stackTraceElementArray) {
        StackTraceElement[] stackTraceElementArray2 = throwable.getStackTrace();
        int n10 = stackTraceElementArray2.length;
        int n11 = -1;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = stackTraceElementArray2[i10].getClassName();
            boolean bl2 = stackTraceElementArray.equals(string2);
            if (!bl2) continue;
            n11 = i10;
        }
        stackTraceElementArray = Arrays.copyOfRange(stackTraceElementArray2, ++n11, n10);
        throwable.setStackTrace(stackTraceElementArray);
        return throwable;
    }

    public static String C(String string2, Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(object);
        return stringBuilder.toString();
    }

    public static void D() {
        AssertionError assertionError = new AssertionError();
        throw (AssertionError)((Object)f0.A((Throwable)((Object)assertionError)));
    }

    public static void E(String string2) {
        AssertionError assertionError = new AssertionError((Object)string2);
        throw (AssertionError)((Object)f0.A((Throwable)((Object)assertionError)));
    }

    public static void F() {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw (IllegalArgumentException)f0.A(illegalArgumentException);
    }

    public static void G(String string2) {
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw (IllegalArgumentException)f0.A(illegalArgumentException);
    }

    public static void H() {
        IllegalStateException illegalStateException = new IllegalStateException();
        throw (IllegalStateException)f0.A(illegalStateException);
    }

    public static void I(String string2) {
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw (IllegalStateException)f0.A(illegalStateException);
    }

    public static void J() {
        NullPointerException nullPointerException = new NullPointerException();
        throw (NullPointerException)f0.A(nullPointerException);
    }

    public static void K(String string2) {
        NullPointerException nullPointerException = new NullPointerException(string2);
        throw (NullPointerException)f0.A(nullPointerException);
    }

    public static void L() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        throw (KotlinNullPointerException)f0.A(kotlinNullPointerException);
    }

    public static void M(String string2) {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(string2);
        throw (KotlinNullPointerException)f0.A(kotlinNullPointerException);
    }

    private static void N(String string2) {
        string2 = f0.v(string2);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw (IllegalArgumentException)f0.A(illegalArgumentException);
    }

    private static void O(String string2) {
        string2 = f0.v(string2);
        NullPointerException nullPointerException = new NullPointerException(string2);
        throw (NullPointerException)f0.A(nullPointerException);
    }

    public static void P() {
        f0.Q("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void Q(String string2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(string2);
        throw unsupportedOperationException;
    }

    public static void R(String string2) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(string2);
        throw (UninitializedPropertyAccessException)f0.A(uninitializedPropertyAccessException);
    }

    public static void S(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("lateinit property ");
        stringBuilder.append(string2);
        stringBuilder.append(" has not been initialized");
        f0.R(stringBuilder.toString());
    }

    public static boolean a(double d10, Double d11) {
        double d12;
        double d13;
        boolean bl2;
        bl2 = d11 != null && !(bl2 = (d13 = d10 - (d12 = d11.doubleValue())) == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1));
        return bl2;
    }

    public static boolean b(float f10, Float f11) {
        float f12;
        float f13;
        boolean bl2;
        if (f11 != null && !(bl2 = (f13 = f10 - (f12 = f11.floatValue())) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) {
            bl2 = true;
            f10 = Float.MIN_VALUE;
        } else {
            bl2 = false;
            f10 = 0.0f;
        }
        return bl2;
    }

    public static boolean c(Double d10, double d11) {
        double d12;
        double d13;
        boolean bl2;
        if (d10 != null && !(bl2 = (d13 = (d12 = d10.doubleValue()) - d11) == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1))) {
            bl2 = true;
        } else {
            bl2 = false;
            d10 = null;
        }
        return bl2;
    }

    public static boolean d(Double d10, Double d11) {
        double d12;
        double d13;
        double d14;
        double d15;
        boolean bl2 = true;
        if (!(d10 == null ? d11 == null : d11 != null && (d15 = (d14 = (d13 = d10.doubleValue()) - (d12 = d11.doubleValue())) == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1)) == false)) {
            bl2 = false;
        }
        return bl2;
    }

    public static boolean e(Float f10, float f11) {
        float f12;
        float f13;
        boolean bl2;
        if (f10 != null && !(bl2 = (f13 = (f12 = f10.floatValue()) - f11) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) {
            bl2 = true;
            f12 = Float.MIN_VALUE;
        } else {
            bl2 = false;
            f12 = 0.0f;
            f10 = null;
        }
        return bl2;
    }

    public static boolean f(Float f10, Float f11) {
        float f12;
        float f13;
        float f14;
        float f15;
        boolean bl2 = true;
        if (!(f10 == null ? f11 == null : f11 != null && (f15 = (f14 = (f13 = f10.floatValue()) - (f12 = f11.floatValue())) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) == false)) {
            bl2 = false;
        }
        return bl2;
    }

    public static boolean g(Object object, Object object2) {
        boolean bl2;
        if (object == null) {
            if (object2 == null) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
        } else {
            bl2 = object.equals(object2);
        }
        return bl2;
    }

    public static void h(Object object, String string2) {
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" must not be null");
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw (IllegalStateException)f0.A((Throwable)object);
    }

    public static void i(Object object, String string2) {
        if (object != null) {
            return;
        }
        object = new IllegalStateException(string2);
        throw (IllegalStateException)f0.A((Throwable)object);
    }

    public static void j(Object object, String string2, String string3) {
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Field specified as non-null is null: ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw (IllegalStateException)f0.A((Throwable)object);
    }

    public static void k(String string2) {
        char c10 = '/';
        char c11 = '.';
        string2 = string2.replace(c10, c11);
        try {
            Class.forName(string2);
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class ");
            stringBuilder.append(string2);
            stringBuilder.append(" is not found. Please update the Kotlin runtime to the latest version");
            string2 = stringBuilder.toString();
            ClassNotFoundException classNotFoundException2 = new ClassNotFoundException(string2, classNotFoundException);
            throw (ClassNotFoundException)f0.A(classNotFoundException2);
        }
    }

    public static void l(String string2, String string3) {
        char c10 = '/';
        char c11 = '.';
        string2 = string2.replace(c10, c11);
        try {
            Class.forName(string2);
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Class ");
            stringBuilder.append(string2);
            stringBuilder.append(" is not found: this code requires the Kotlin runtime of version at least ");
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
            ClassNotFoundException classNotFoundException2 = new ClassNotFoundException(string2, classNotFoundException);
            throw (ClassNotFoundException)f0.A(classNotFoundException2);
        }
    }

    public static void m(Object object) {
        if (object == null) {
            f0.J();
        }
    }

    public static void n(Object object, String string2) {
        if (object == null) {
            f0.K(string2);
        }
    }

    public static void o(Object object, String string2) {
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" must not be null");
        string2 = stringBuilder.toString();
        object = new NullPointerException(string2);
        throw (NullPointerException)f0.A((Throwable)object);
    }

    public static void p(Object object, String string2) {
        if (object == null) {
            f0.O(string2);
        }
    }

    public static void q(Object object, String string2) {
        if (object == null) {
            f0.N(string2);
        }
    }

    public static void r(Object object, String string2) {
        if (object != null) {
            return;
        }
        object = new IllegalStateException(string2);
        throw (IllegalStateException)f0.A((Throwable)object);
    }

    public static void s(Object object, String string2, String string3) {
        if (object != null) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Method specified as non-null returned null: ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw (IllegalStateException)f0.A((Throwable)object);
    }

    public static int t(int n10, int n11) {
        n10 = n10 < n11 ? -1 : (n10 == n11 ? 0 : 1);
        return n10;
    }

    public static int u(long l10, long l11) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        object = object < 0 ? (Object)-1 : (object == false ? (Object)0 : (Object)1);
        return (int)object;
    }

    private static String v(String string2) {
        Object object = Thread.currentThread().getStackTrace()[4];
        String string3 = ((StackTraceElement)object).getClassName();
        object = ((StackTraceElement)object).getMethodName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Parameter specified as non-null is null: method ");
        stringBuilder.append(string3);
        stringBuilder.append(".");
        stringBuilder.append((String)object);
        stringBuilder.append(", parameter ");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static void w() {
        f0.P();
    }

    public static void x(String string2) {
        f0.Q(string2);
    }

    public static void y(int n10, String string2) {
        f0.P();
    }

    public static void z(int n10, String string2, String string3) {
        f0.Q(string3);
    }
}

