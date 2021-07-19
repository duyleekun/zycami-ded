/*
 * Decompiled with CFR 0.151.
 */
package f.d2;

import f.d2.k;
import f.h2.t.f0;
import f.r;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;

public final class l {
    public static final k a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        block22: {
            Object object2 = k.class;
            int n10 = l.c();
            String string2 = "ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)";
            String string3 = ", base type classloader: ";
            String string4 = "Instance classloader: ";
            String string5 = "null cannot be cast to non-null type kotlin.internal.PlatformImplementations";
            Object object3 = "Class.forName(\"kotlin.in\u2026entations\").newInstance()";
            int n11 = 65544;
            if (n10 >= n11) {
                object = "f.d2.r.a";
                try {
                    ClassCastException classCastException2;
                    block23: {
                        object = Class.forName((String)object);
                        object = ((Class)object).newInstance();
                        f0.o(object, (String)object3);
                        if (object != null) {
                            try {
                                object = (k)object;
                                break block22;
                            }
                            catch (ClassCastException classCastException2) {
                                break block23;
                            }
                        }
                        NullPointerException nullPointerException = new NullPointerException(string5);
                        throw nullPointerException;
                    }
                    object = object.getClass();
                    object = ((Class)object).getClassLoader();
                    ClassLoader classLoader = ((Class)object2).getClassLoader();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string4);
                    stringBuilder.append(object);
                    stringBuilder.append(string3);
                    stringBuilder.append(classLoader);
                    object = stringBuilder.toString();
                    ClassCastException classCastException3 = new ClassCastException((String)object);
                    object = classCastException3.initCause(classCastException2);
                    f0.o(object, string2);
                    throw object;
                }
                catch (ClassNotFoundException classNotFoundException) {}
                object = "kotlin.internal.JRE8PlatformImplementations";
                try {
                    ClassCastException classCastException4;
                    block24: {
                        object = Class.forName((String)object);
                        object = ((Class)object).newInstance();
                        f0.o(object, (String)object3);
                        if (object != null) {
                            try {
                                object = (k)object;
                                break block22;
                            }
                            catch (ClassCastException classCastException4) {
                                break block24;
                            }
                        }
                        NullPointerException nullPointerException = new NullPointerException(string5);
                        throw nullPointerException;
                    }
                    object = object.getClass();
                    object = ((Class)object).getClassLoader();
                    ClassLoader classLoader = ((Class)object2).getClassLoader();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string4);
                    stringBuilder.append(object);
                    stringBuilder.append(string3);
                    stringBuilder.append(classLoader);
                    object = stringBuilder.toString();
                    ClassCastException classCastException5 = new ClassCastException((String)object);
                    object = classCastException5.initCause(classCastException4);
                    f0.o(object, string2);
                    throw object;
                }
                catch (ClassNotFoundException classNotFoundException) {}
            }
            if (n10 >= (n11 = 65543)) {
                Object object4 = "f.d2.q.a";
                try {
                    ClassCastException classCastException6;
                    block25: {
                        object4 = Class.forName((String)object4);
                        object4 = ((Class)object4).newInstance();
                        f0.o(object4, (String)object3);
                        if (object4 != null) {
                            object = object4;
                            try {
                                object = (k)object4;
                                break block22;
                            }
                            catch (ClassCastException classCastException6) {
                                break block25;
                            }
                        }
                        object = new NullPointerException(string5);
                        throw object;
                    }
                    object4 = object4.getClass();
                    object4 = ((Class)object4).getClassLoader();
                    ClassLoader classLoader = ((Class)object2).getClassLoader();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string4);
                    stringBuilder.append(object4);
                    stringBuilder.append(string3);
                    stringBuilder.append(classLoader);
                    object4 = stringBuilder.toString();
                    ClassCastException classCastException7 = new ClassCastException((String)object4);
                    object4 = classCastException7.initCause(classCastException6);
                    f0.o(object4, string2);
                    throw object4;
                }
                catch (ClassNotFoundException classNotFoundException) {}
                object4 = "kotlin.internal.JRE7PlatformImplementations";
                try {
                    ClassCastException classCastException8;
                    block26: {
                        object4 = Class.forName((String)object4);
                        object4 = ((Class)object4).newInstance();
                        f0.o(object4, (String)object3);
                        if (object4 != null) {
                            object = object4;
                            try {
                                object = (k)object4;
                                break block22;
                            }
                            catch (ClassCastException classCastException8) {
                                break block26;
                            }
                        }
                        object3 = new NullPointerException(string5);
                        throw object3;
                    }
                    object4 = object4.getClass();
                    object4 = ((Class)object4).getClassLoader();
                    object2 = ((Class)object2).getClassLoader();
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string4);
                    ((StringBuilder)object).append(object4);
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(object2);
                    object2 = ((StringBuilder)object).toString();
                    object3 = new ClassCastException((String)object2);
                    object2 = ((Throwable)object3).initCause(classCastException8);
                    f0.o(object2, string2);
                    throw object2;
                }
                catch (ClassNotFoundException classNotFoundException) {}
            }
            object = new k();
        }
        a = object;
    }

    public static final boolean a(int n10, int n11, int n12) {
        return r.f.f(n10, n11, n12);
    }

    private static final /* synthetic */ Object b(Object object) {
        Object object2 = "T";
        int n10 = 1;
        try {
            f0.y(n10, (String)object2);
            return object;
        }
        catch (ClassCastException classCastException) {
            object = object.getClass().getClassLoader();
            f0.y(4, (String)object2);
            object2 = Object.class.getClassLoader();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Instance classloader: ");
            stringBuilder.append(object);
            stringBuilder.append(", base type classloader: ");
            stringBuilder.append(object2);
            object = stringBuilder.toString();
            ClassCastException classCastException2 = new ClassCastException((String)object);
            object = classCastException2.initCause(classCastException);
            f0.o(object, "ClassCastException(\"Inst\u2026baseTypeCL\").initCause(e)");
            throw object;
        }
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final int c() {
        String string2 = System.getProperty("java.specification.version");
        int n10 = 65542;
        if (string2 == null) return n10;
        char c10 = '.';
        String string3 = null;
        String string4 = null;
        int n11 = 6;
        int n12 = StringsKt__StringsKt.i3(string2, c10, 0, false, n11, null);
        int n13 = 65536;
        if (n12 < 0) {
            int n14 = Integer.parseInt(string2);
            return n14 * n13;
        }
        c10 = '.';
        int n15 = n12 + 1;
        string4 = null;
        n11 = 4;
        int n16 = StringsKt__StringsKt.i3(string2, c10, n15, false, n11, null);
        if (n16 < 0) {
            n16 = string2.length();
        }
        c10 = '\u0000';
        string3 = "null cannot be cast to non-null type java.lang.String";
        Objects.requireNonNull(string2, string3);
        String string5 = string2.substring(0, n12);
        string4 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
        f0.o(string5, string4);
        Objects.requireNonNull(string2, string3);
        string2 = string2.substring(n15, n16);
        f0.o(string2, string4);
        try {
            n16 = Integer.parseInt(string5) * n13;
        }
        catch (NumberFormatException numberFormatException) {
            return n10;
        }
        int n17 = Integer.parseInt(string2);
        return n16 + n17;
        catch (NumberFormatException numberFormatException) {
            return n10;
        }
    }
}

