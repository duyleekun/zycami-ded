/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.geetest.sdk.utils;

import android.text.TextUtils;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.n$a;
import com.geetest.sdk.utils.n$b;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import g.a0;
import g.a0$a;
import g.b0;
import g.c0;
import g.d0;
import g.e;
import g.s;
import g.v;
import g.z;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class n {
    private static final String a = "n";
    public static String b = "";
    private static ConcurrentHashMap c;
    private static String d;
    private static String e;
    public static String f;
    public static final v g;

    static {
        Object object = new ConcurrentHashMap();
        c = object;
        d = object = "";
        e = object;
        f = object;
        g = v.j("application/octet-stream");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(String object, boolean bl2, Map object2, byte[] object3, String string2) {
        int n10;
        Object object4;
        int n11;
        int n12;
        String string3;
        String string4;
        Object object5;
        int n13;
        String string5 = " responseCode";
        String string6 = "GT3_Error_Info: request error:";
        Object object6 = new a0$a();
        if (object2 != null && (n13 = object2.size()) > 0) {
            object2 = object2.entrySet().iterator();
            while ((n13 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object5 = (Map.Entry)object2.next();
                string4 = (String)object5.getKey();
                object5 = (String)object5.getValue();
                ((a0$a)object6).n(string4, (String)object5);
            }
        }
        object2 = "Ajax";
        try {
            n12 = TextUtils.equals((CharSequence)string3, (CharSequence)object2);
            object5 = ";";
            string4 = "Cookie";
            n11 = 0;
            if (n12 == 0 && (n12 = TextUtils.equals((CharSequence)string3, (CharSequence)(object2 = "GetCoder"))) == 0) {
                object2 = "API2Coder";
                n12 = TextUtils.equals((CharSequence)string3, (CharSequence)object2);
                if (n12 != 0 && (n12 = TextUtils.isEmpty((CharSequence)(object2 = d))) == 0) {
                    object2 = d;
                    n13 = ((String)object2).indexOf((String)object5);
                    object2 = ((String)object2).substring(0, n13);
                    ((a0$a)object6).a(string4, (String)object2);
                }
            } else {
                object2 = e;
                n12 = TextUtils.isEmpty((CharSequence)object2);
                if (n12 == 0) {
                    object2 = e;
                    n13 = ((String)object2).indexOf((String)object5);
                    object2 = ((String)object2).substring(0, n13);
                    ((a0$a)object6).a(string4, (String)object2);
                }
            }
            if (bl2) {
                object4 = new n$a((byte[])object3);
                ((a0$a)object6).r((b0)object4);
            }
        }
        catch (Exception exception) {
            CharSequence charSequence = a;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("request error, cookie was changed:");
            String string7 = exception.toString();
            ((StringBuilder)object2).append(string7);
            object2 = ((StringBuilder)object2).toString();
            l.b((String)charSequence, (String)object2);
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string6);
            String string8 = exception.toString();
            ((StringBuilder)charSequence).append(string8);
            return ((StringBuilder)charSequence).toString();
        }
        object4 = ((a0$a)object6).B((String)object).b();
        object2 = ((a0)object4).k();
        while (n11 < (n10 = ((s)object2).size())) {
            String string9 = a;
            object6 = new StringBuilder();
            ((StringBuilder)object6).append(string3);
            ((StringBuilder)object6).append(" Header key: ");
            object5 = ((s)object2).h(n11);
            ((StringBuilder)object6).append((String)object5);
            ((StringBuilder)object6).append(" value: ");
            object5 = ((s)object2).n(n11);
            ((StringBuilder)object6).append((String)object5);
            object6 = ((StringBuilder)object6).toString();
            l.b(string9, (String)object6);
            ++n11;
        }
        try {
            object2 = n.b();
            object4 = ((z)object2).a((a0)object4);
            object4 = FirebasePerfOkHttpClient.execute((e)object4);
            n12 = ((c0)object4).v0();
            String string10 = "API1";
            n10 = (int)(TextUtils.equals((CharSequence)string3, (CharSequence)string10) ? 1 : 0);
            object6 = "Set-Cookie";
            if (n10 != 0) {
                String string11;
                d = string11 = ((c0)object4).y0((String)object6);
            } else {
                String string12 = "Gettype";
                n10 = (int)(TextUtils.equals((CharSequence)string3, (CharSequence)string12) ? 1 : 0);
                if (n10 != 0) {
                    String string13;
                    e = string13 = ((c0)object4).y0((String)object6);
                }
            }
            b = object;
            String string14 = a;
            object6 = new StringBuilder();
            ((StringBuilder)object6).append(string3);
            string3 = " responseCode:";
            ((StringBuilder)object6).append(string3);
            ((StringBuilder)object6).append(n12);
            string3 = ((StringBuilder)object6).toString();
            l.b(string14, string3);
            int n14 = 200;
            if (n12 == n14) {
                object = ((c0)object4).r0();
                return ((d0)object).string();
            }
            object4 = new StringBuilder();
            string3 = "url: ";
            ((StringBuilder)object4).append(string3);
            ((StringBuilder)object4).append((String)object);
            ((StringBuilder)object4).append(string5);
            ((StringBuilder)object4).append(n12);
            object4 = ((StringBuilder)object4).toString();
            l.b(string14, (String)object4);
            object4 = new StringBuilder();
            String string15 = "GT3_Error_Info: url: ";
            ((StringBuilder)object4).append(string15);
            ((StringBuilder)object4).append((String)object);
            ((StringBuilder)object4).append(string5);
            ((StringBuilder)object4).append(n12);
            return ((StringBuilder)object4).toString();
        }
        catch (Exception exception) {
            object4 = a;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("request error:");
            String string16 = exception.toString();
            ((StringBuilder)object2).append(string16);
            object2 = ((StringBuilder)object2).toString();
            l.b((String)object4, (String)object2);
            object4 = new StringBuilder();
            ((StringBuilder)object4).append(string6);
            String string17 = exception.toString();
            ((StringBuilder)object4).append(string17);
            return ((StringBuilder)object4).toString();
        }
    }

    public static /* synthetic */ ConcurrentHashMap a() {
        return c;
    }

    public static z b() {
        return n$b.a();
    }
}

