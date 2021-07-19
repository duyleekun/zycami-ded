/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package l.a.o;

import android.util.Log;

public class f {
    public static boolean a = false;
    private static final String b = "skin-support";

    public static void a(String string2) {
        boolean bl2 = a;
        if (bl2) {
            String string3 = b;
            Log.i((String)string3, (String)string2);
        }
    }

    public static void b(String string2, String string3) {
        boolean bl2 = a;
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(": ");
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
            string3 = b;
            Log.i((String)string3, (String)string2);
        }
    }

    public static void c(String string2) {
        Log.i((String)b, (String)string2);
    }

    public static void d(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(": ");
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        Log.i((String)b, (String)string2);
    }
}

