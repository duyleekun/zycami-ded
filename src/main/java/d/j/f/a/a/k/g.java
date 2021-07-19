/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.j.f.a.a.k;

import android.text.TextUtils;
import android.util.Log;

public abstract class g {
    private static boolean a(String string2) {
        int n10;
        String string3 = "java.security.acl.NotOwnerException";
        String string4 = "java.util.ConcurrentModificationException";
        String string5 = "javax.naming.InsufficientResourcesException";
        String string6 = "java.net.BindException";
        String string7 = "java.lang.OutOfMemoryError";
        String string8 = "java.lang.StackOverflowError";
        String string9 = "java.sql.SQLException";
        String[] stringArray = new String[]{"java.io.FileNotFoundException", "java.util.jar.JarException", "java.util.MissingResourceException", string3, string4, string5, string6, string7, string8, string9};
        for (int i10 = 0; i10 < (n10 = 10); ++i10) {
            string3 = stringArray[i10];
            n10 = (int)(string2.contains(string3) ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public static String b(String string2, Throwable object) {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0) {
            stringBuilder.append(string2);
            string2 = " ";
            stringBuilder.append(string2);
        }
        stringBuilder.append("Exception: ");
        string2 = object.getClass().getName();
        stringBuilder.append(string2);
        char c10 = '\n';
        stringBuilder.append(c10);
        String string3 = object.getClass().getCanonicalName();
        n10 = g.a(string3);
        if (n10 == 0) {
            if ((object = object.getStackTrace()) == null) {
                object = "Stack trace is NULL!";
                stringBuilder.append((String)object);
                stringBuilder.append(c10);
            } else {
                n10 = ((StackTraceElement[])object).length;
                for (int i10 = 0; i10 < n10; ++i10) {
                    String string4 = object[i10].toString();
                    stringBuilder.append(string4);
                    stringBuilder.append(c10);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void c(String string2, String string3, Throwable throwable) {
        if (throwable == null) {
            return;
        }
        string3 = g.b(string3, throwable);
        Log.w((String)string2, (String)string3);
    }
}

