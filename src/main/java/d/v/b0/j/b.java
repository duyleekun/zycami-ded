/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.v.b0.j;

import android.util.Log;

public class b {
    public static final String a = "RenderEngine";
    private static boolean b = false;

    public static void a(String string2) {
        boolean bl2 = b;
        if (bl2) {
            String string3 = a;
            Log.d((String)string3, (String)string2);
        }
    }

    public static void b(String string2) {
        boolean bl2 = b;
        if (bl2) {
            String string3 = a;
            Log.e((String)string3, (String)string2);
        }
    }

    public static void c(String string2) {
        boolean bl2 = b;
        if (bl2) {
            String string3 = a;
            Log.i((String)string3, (String)string2);
        }
    }

    public static void d(boolean bl2) {
        b = bl2;
    }
}

