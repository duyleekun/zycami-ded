/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Process
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.r.a.u;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import d.r.a.f.a;
import d.r.a.h$o;
import d.r.a.o;
import d.r.a.u.d0;
import d.r.a.u.r;
import d.r.a.u.s;
import d.r.a.u.w;

public final class q
implements r {
    private static final String a;
    private static final String[] b;

    static {
        StringBuilder stringBuilder = new StringBuilder("(");
        int n10 = Process.myPid();
        stringBuilder.append(n10);
        stringBuilder.append(")");
        a = stringBuilder.toString();
        b = new String[]{"com.vivo.pushservice", "com.vivo.sdk.test", "com.vivo.pushdemo.test"};
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void l(Context object, h$o object2, String string2) {
        String string3;
        String string4;
        String string5;
        block20: {
            boolean bl2;
            String string6;
            block22: {
                int n10;
                block21: {
                    block19: {
                        string5 = "\u6d88\u606f\u63a5\u53d7\u8005\u5305\u540d\u4e3a\u7a7a\uff01";
                        string6 = "com.vivo.pushclient.action.RECEIVE";
                        String string7 = "test";
                        bl2 = string4.contains(string7);
                        if (!bl2) {
                            String string8 = "com.vivo.pushservice";
                            boolean bl3 = string4.equals(string8);
                            if (!bl3) return;
                            return;
                        }
                        bl2 = w.d(object, string4, string6);
                        if (bl2) break block19;
                        string6 = "com.vivo.pushservice.action.RECEIVE";
                    }
                    n10 = TextUtils.isEmpty((CharSequence)string4);
                    if (n10 != 0) break block20;
                    boolean bl4 = d.r.a.f.a.c(object, string6, string4);
                    if (!bl4) return;
                    string5 = ((o)string3).b;
                    bl4 = TextUtils.isEmpty((CharSequence)string5);
                    if (!bl4) break block21;
                    string5 = object.getPackageName();
                    ((o)string3).b = string5;
                }
                string5 = new Intent();
                n10 = 0x100000;
                string5.setFlags(n10);
                n10 = (int)(TextUtils.isEmpty((CharSequence)string6) ? 1 : 0);
                if (n10 != 0) break block22;
                string5.setAction(string6);
            }
            string5.setPackage(string4);
            string6 = bl2 ? "com.vivo.push.sdk.service.CommandClientService" : "com.vivo.push.sdk.service.CommandService";
            string5.setClassName(string4, string6);
            ((o)((Object)string3)).a((Intent)string5);
            string3 = "command_type";
            string4 = "reflect_receiver";
            string5.putExtra(string3, string4);
            d.r.a.f.a.a(object, (Intent)string5);
            return;
        }
        s.l(object, string5);
        try {
            Exception exception = new Exception(string5);
            throw exception;
        }
        catch (Exception exception) {
            string3 = "CommandBridge";
            string4 = "CommandBridge sendCommandToClient exception";
            s.b(string3, string4, exception);
        }
    }

    private void m(Context context, String stringArray, int n10) {
        String string2;
        h$o h$o = new h$o();
        h$o.e = stringArray;
        h$o.f = n10;
        if (n10 > 0) {
            string2 = "LogController";
            this.d(string2, (String)stringArray);
        }
        boolean bl2 = d0.g(context);
        string2 = null;
        if (bl2) {
            h$o.g = bl2 = true;
            for (String string3 : b) {
                q.l(context, h$o, string3);
            }
            return;
        }
        h$o.g = false;
        stringArray = context.getPackageName();
        q.l(context, h$o, (String)stringArray);
    }

    public final int a(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder("VivoPush.");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        String string4 = a;
        stringBuilder.append(string4);
        stringBuilder.append(string3);
        string3 = stringBuilder.toString();
        return Log.e((String)string2, (String)string3);
    }

    public final void a(Context context, String string2) {
        boolean bl2 = s.g();
        if (!bl2) {
            return;
        }
        this.m(context, string2, 0);
    }

    public final int b(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder("VivoPush.");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        String string4 = a;
        stringBuilder.append(string4);
        stringBuilder.append(string3);
        string3 = stringBuilder.toString();
        return Log.w((String)string2, (String)string3);
    }

    public final int c(String string2, String string3) {
        boolean bl2 = s.g();
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder("VivoPush.");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            String string4 = a;
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            return Log.v((String)string2, (String)string3);
        }
        return -1;
    }

    public final int d(String string2, String string3) {
        boolean bl2 = s.g();
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder("VivoPush.");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            String string4 = a;
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            return Log.i((String)string2, (String)string3);
        }
        return -1;
    }

    public final int e(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder("VivoPush.");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        String string4 = a;
        stringBuilder.append(string4);
        stringBuilder.append(string3);
        string3 = stringBuilder.toString();
        return Log.d((String)string2, (String)string3);
    }

    public final int f(String string2, Throwable object) {
        StringBuilder stringBuilder = new StringBuilder("VivoPush.");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = Log.getStackTraceString((Throwable)object);
        return Log.e((String)string2, (String)object);
    }

    public final int g(String string2, String string3, Throwable throwable) {
        boolean bl2 = s.g();
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder("VivoPush.");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            String string4 = a;
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            return Log.i((String)string2, (String)string3, (Throwable)throwable);
        }
        return -1;
    }

    public final int h(String string2, String string3, Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder("VivoPush.");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        String string4 = a;
        stringBuilder.append(string4);
        stringBuilder.append(string3);
        string3 = stringBuilder.toString();
        return Log.e((String)string2, (String)string3, (Throwable)throwable);
    }

    public final void i(Context context, String string2) {
        boolean bl2 = s.g();
        if (!bl2) {
            return;
        }
        this.m(context, string2, 2);
    }

    public final void j(Context context, String string2) {
        boolean bl2 = s.g();
        if (!bl2) {
            return;
        }
        this.m(context, string2, 1);
    }

    public final String k(Throwable throwable) {
        return Log.getStackTraceString((Throwable)throwable);
    }
}

