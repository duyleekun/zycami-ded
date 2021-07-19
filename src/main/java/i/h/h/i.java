/*
 * Decompiled with CFR 0.151.
 */
package i.h.h;

import i.h.h.i$b;
import java.io.PrintStream;

public final class i {
    private static i$b a;
    private static boolean b = false;

    private i() {
    }

    public static Class a() {
        String string2;
        int n10;
        int n11;
        Object object = i.b();
        if (object == null) {
            return null;
        }
        object = object.getClassContext();
        String string3 = i.class.getName();
        for (n11 = 0; n11 < (n10 = ((Class[])object).length) && (n10 = (int)(string3.equals(string2 = object[n11].getName()) ? 1 : 0)) == 0; ++n11) {
        }
        int n12 = ((Class[])object).length;
        if (n11 < n12 && (n11 += 2) < (n12 = ((Class[])object).length)) {
            return object[n11];
        }
        object = new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        throw object;
    }

    private static i$b b() {
        i$b i$b = a;
        if (i$b != null) {
            return i$b;
        }
        boolean bl2 = b;
        if (bl2) {
            return null;
        }
        a = i$b = i.e();
        b = true;
        return i$b;
    }

    public static final void c(String string2) {
        PrintStream printStream = System.err;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SLF4J: ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        printStream.println(string2);
    }

    public static final void d(String string2, Throwable throwable) {
        System.err.println(string2);
        System.err.println("Reported exception:");
        throwable.printStackTrace();
    }

    private static i$b e() {
        try {
            i$b i$b = new i$b(null);
            return i$b;
        }
        catch (SecurityException securityException) {
            return null;
        }
    }

    public static boolean f(String string2) {
        if ((string2 = i.g(string2)) == null) {
            return false;
        }
        return string2.equalsIgnoreCase("true");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String g(String object) {
        if (object == null) {
            object = new IllegalArgumentException("null input");
            throw object;
        }
        String string2 = null;
        try {
            return System.getProperty((String)object);
        }
        catch (SecurityException securityException) {
            return string2;
        }
    }
}

