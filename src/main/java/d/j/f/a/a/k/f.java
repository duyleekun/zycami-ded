/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  android.util.Log
 */
package d.j.f.a.a.k;

import android.util.Base64;
import android.util.Log;

public class f {
    private static final String a = "f";

    private f() {
    }

    public static byte[] a(String string2, int n10) {
        try {
            return Base64.decode((String)string2, (int)n10);
        }
        catch (Exception exception) {
            String string3 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = exception.getClass().getSimpleName();
            stringBuilder.append(string4);
            stringBuilder.append(" , message2 : ");
            String string5 = exception.getMessage();
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
            Log.e((String)string3, (String)string5);
            return new byte[0];
        }
    }

    public static byte[] b(byte[] byArray, int n10) {
        try {
            return Base64.decode((byte[])byArray, (int)n10);
        }
        catch (Exception exception) {
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = exception.getClass().getSimpleName();
            stringBuilder.append(string3);
            stringBuilder.append(" , message0 : ");
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            Log.e((String)string2, (String)string4);
            return new byte[0];
        }
    }

    public static byte[] c(byte[] byArray, int n10, int n11, int n12) {
        try {
            return Base64.decode((byte[])byArray, (int)n10, (int)n11, (int)n12);
        }
        catch (Exception exception) {
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = exception.getClass().getSimpleName();
            stringBuilder.append(string3);
            stringBuilder.append(" , message1 : ");
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            Log.e((String)string2, (String)string4);
            return new byte[0];
        }
    }

    public static byte[] d(byte[] byArray, int n10) {
        try {
            return Base64.encode((byte[])byArray, (int)n10);
        }
        catch (Exception exception) {
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = exception.getClass().getSimpleName();
            stringBuilder.append(string3);
            stringBuilder.append(" , message3 : ");
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            Log.e((String)string2, (String)string4);
            return new byte[0];
        }
    }

    public static byte[] e(byte[] byArray, int n10, int n11, int n12) {
        try {
            return Base64.encode((byte[])byArray, (int)n10, (int)n11, (int)n12);
        }
        catch (Exception exception) {
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = exception.getClass().getSimpleName();
            stringBuilder.append(string3);
            stringBuilder.append(" , message4 : ");
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            Log.e((String)string2, (String)string4);
            return new byte[0];
        }
    }

    public static String f(byte[] byArray, int n10) {
        try {
            return Base64.encodeToString((byte[])byArray, (int)n10);
        }
        catch (Exception exception) {
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = exception.getClass().getSimpleName();
            stringBuilder.append(string3);
            stringBuilder.append(" , message5 : ");
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            Log.e((String)string2, (String)string4);
            return "";
        }
    }

    public static String g(byte[] byArray, int n10, int n11, int n12) {
        try {
            return Base64.encodeToString((byte[])byArray, (int)n10, (int)n11, (int)n12);
        }
        catch (Exception exception) {
            String string2 = a;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = exception.getClass().getSimpleName();
            stringBuilder.append(string3);
            stringBuilder.append(" , message6 : ");
            String string4 = exception.getMessage();
            stringBuilder.append(string4);
            string4 = stringBuilder.toString();
            Log.e((String)string2, (String)string4);
            return "";
        }
    }
}

