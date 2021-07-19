/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.Log
 */
package d.v.e0.oe;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import d.v.e0.oe.q$a;
import d.v.y.d.a;
import java.io.File;

public class q {
    private static final String a = "ZYLog";
    private static boolean b;
    private static q$a c;

    public static void a(String string2) {
        boolean bl2 = b;
        if (bl2) {
            Log.d((String)a, (String)string2);
            q$a q$a = c;
            q$a.a(string2);
        }
    }

    public static void b(String string2, byte[] object) {
        boolean bl2 = b;
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("  ");
            string2 = d.v.y.d.a.h((byte[])object);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            Log.d((String)a, (String)string2);
            object = (Object)c;
            ((q$a)((Object)object)).a(string2);
        }
    }

    public static void c(String string2) {
        boolean bl2 = b;
        if (bl2) {
            Log.e((String)a, (String)string2);
            q$a q$a = c;
            q$a.a(string2);
        }
    }

    public static void d(String object, Throwable throwable) {
        boolean bl2 = b;
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append((String)object);
            charSequence.append("  ");
            charSequence.append(throwable);
            charSequence = charSequence.toString();
            String string2 = a;
            Log.e((String)string2, (String)object, (Throwable)throwable);
            object = c;
            ((q$a)((Object)object)).a((String)charSequence);
        }
    }

    public static void e(Throwable object) {
        boolean bl2 = b;
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "";
            charSequence.append(string2);
            charSequence.append(object);
            charSequence = charSequence.toString();
            String string3 = ((Throwable)object).getMessage();
            if (string3 != null) {
                string2 = ((Throwable)object).getMessage();
            }
            string3 = a;
            Log.e((String)string3, (String)string2, (Throwable)object);
            object = c;
            ((q$a)((Object)object)).a((String)charSequence);
        }
    }

    public static void f(String string2) {
        boolean bl2 = b;
        if (bl2) {
            Log.i((String)a, (String)string2);
            q$a q$a = c;
            q$a.a(string2);
        }
    }

    public static void g(String string2, byte[] object) {
        boolean bl2 = b;
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("  ");
            string2 = d.v.y.d.a.h((byte[])object);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            Log.i((String)a, (String)string2);
            object = (Object)c;
            ((q$a)((Object)object)).a(string2);
        }
    }

    public static void h(Context object, boolean bl2) {
        b = bl2;
        if (bl2) {
            q$a q$a;
            object = object.getCacheDir();
            HandlerThread handlerThread = new HandlerThread(a);
            handlerThread.start();
            handlerThread = handlerThread.getLooper();
            c = q$a = new q$a((File)object, (Looper)handlerThread);
        }
    }

    public static void i(String string2) {
        boolean bl2 = b;
        if (bl2) {
            Log.v((String)a, (String)string2);
            q$a q$a = c;
            q$a.a(string2);
        }
    }

    public static void j(String string2) {
        boolean bl2 = b;
        if (bl2) {
            Log.w((String)a, (String)string2);
            q$a q$a = c;
            q$a.a(string2);
        }
    }

    public static void k(String object, Throwable object2) {
        boolean bl2 = b;
        if (bl2) {
            Log.w((String)a, (String)object, (Throwable)object2);
            object = c;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "";
            stringBuilder.append(string2);
            stringBuilder.append(object2);
            object2 = stringBuilder.toString();
            ((q$a)((Object)object)).a((String)object2);
        }
    }

    public static void l(Throwable object) {
        boolean bl2 = b;
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "";
            charSequence.append(string2);
            charSequence.append(object);
            charSequence = charSequence.toString();
            String string3 = ((Throwable)object).getMessage();
            if (string3 != null) {
                string2 = ((Throwable)object).getMessage();
            }
            string3 = a;
            Log.w((String)string3, (String)string2, (Throwable)object);
            object = c;
            ((q$a)((Object)object)).a((String)charSequence);
        }
    }
}

