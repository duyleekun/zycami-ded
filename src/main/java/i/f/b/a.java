/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.net.Uri
 *  android.util.Log
 */
package i.f.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.util.Log;
import i.f.b.a$a;
import i.f.b.a$b;
import i.f.b.a$c;
import i.f.b.m;
import java.io.File;
import java.util.StringTokenizer;

public class a {
    public static final String f = "OpenCVManager/Helper";
    public static final int g = 2;
    public static boolean h = false;
    public static boolean i = false;
    public static final String j = "market://details?id=org.opencv.engine";
    public i.f.d.a a;
    public m b;
    public String c;
    public Context d;
    public ServiceConnection e;

    public a(String string2, Context context, m m10) {
        a$c a$c = new a$c(this);
        this.e = a$c;
        this.c = string2;
        this.b = m10;
        this.d = context;
    }

    public static void a(Context context, m m10) {
        boolean bl2 = h;
        String string2 = f;
        if (!bl2) {
            Log.d((String)string2, (String)"Request new service installation");
            a$a a$a = new a$a(m10, context);
            boolean bl3 = false;
            context = null;
            m10.a(0, a$a);
        } else {
            Log.d((String)string2, (String)"Waiting current installation process");
            a$b a$b = new a$b(m10, context);
            int n10 = 1;
            m10.a(n10, a$b);
        }
    }

    public static boolean b(Context context) {
        boolean bl2;
        String string2 = "android.intent.action.VIEW";
        String string3 = j;
        string3 = Uri.parse((String)string3);
        Intent intent = new Intent(string2, (Uri)string3);
        int n10 = 0x10000000;
        intent.addFlags(n10);
        try {
            context.startActivity(intent);
            bl2 = true;
        }
        catch (Exception exception) {
            bl2 = false;
            context = null;
        }
        return bl2;
    }

    public static /* synthetic */ boolean c(a a10, String string2, String string3) {
        return a10.e(string2, string3);
    }

    public static boolean d(String string2, Context context, m m10) {
        a a10 = new a(string2, context, m10);
        string2 = new Intent("org.opencv.engine.BIND");
        string2.setPackage("org.opencv.engine");
        ServiceConnection serviceConnection = a10.e;
        boolean bl2 = true;
        boolean bl3 = context.bindService((Intent)string2, serviceConnection, (int)(bl2 ? 1 : 0));
        if (bl3) {
            return bl2;
        }
        string2 = a10.e;
        context.unbindService((ServiceConnection)string2);
        i.f.b.a.a(context, m10);
        return false;
    }

    private boolean e(String string2, String charSequence) {
        boolean bl2;
        Object object = f;
        String string3 = "Trying to init OpenCV libs";
        Log.d((String)object, (String)string3);
        if (string2 != null && (bl2 = string2.length())) {
            int n10;
            bl2 = true;
            if (charSequence != null && (n10 = ((String)charSequence).length()) != 0) {
                boolean bl3;
                Log.d((String)object, (String)"Trying to load libs by dependency list");
                String string4 = ";";
                object = new StringTokenizer((String)charSequence, string4);
                while (bl3 = ((StringTokenizer)object).hasMoreTokens()) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string2);
                    string4 = File.separator;
                    ((StringBuilder)charSequence).append(string4);
                    string4 = ((StringTokenizer)object).nextToken();
                    ((StringBuilder)charSequence).append(string4);
                    charSequence = ((StringBuilder)charSequence).toString();
                    bl3 = this.f((String)charSequence);
                    bl2 &= bl3;
                }
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string2);
                string2 = File.separator;
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append("libopencv_java4.so");
                string2 = ((StringBuilder)charSequence).toString();
                bl2 = this.f(string2);
            }
            return bl2;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Library path \"");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("\" is empty");
        string2 = ((StringBuilder)charSequence).toString();
        Log.d((String)object, (String)string2);
        return false;
    }

    private boolean f(String string2) {
        boolean bl2;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Trying to load library ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        String string3 = f;
        Log.d((String)string3, (String)charSequence);
        System.load(string2);
        charSequence = "OpenCV libs init was ok!";
        try {
            Log.d((String)string3, (String)charSequence);
            bl2 = true;
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "Cannot load library \"";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            stringBuilder.append("\"");
            string2 = stringBuilder.toString();
            Log.d((String)string3, (String)string2);
            unsatisfiedLinkError.printStackTrace();
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }
}

