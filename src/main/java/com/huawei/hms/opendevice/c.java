/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.hms.openid.R$string;
import com.huawei.hms.opendevice.a;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.opendevice.s;
import com.huawei.hms.opendevice.t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import d.j.f.a.a.h.f.b;
import d.j.f.a.a.h.f.e;
import d.j.f.a.a.k.d;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public abstract class c {
    public static final String a = "c";
    public static d.j.f.a.a.h.f.d b;
    public static Map c;
    public static final Object d;

    static {
        Object object = new HashMap();
        c = object;
        d = object = new Object();
    }

    public static String a() {
        return "2A57086C86EF54970C1E6EB37BFC72B1";
    }

    public static String a(String string2) {
        Map map = c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)(string2 = (String)map.get(string2)));
        if (bl2) {
            string2 = "";
        }
        return string2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(String string2, String string3, String object) {
        void var0_4;
        Object object2;
        block6: {
            object2 = a;
            Object object3 = "save local secret key.";
            HMSLog.i((String)object2, (String)object3);
            object2 = null;
            try {
                object3 = new File((String)object);
                s.a((File)object3);
                FileOutputStream fileOutputStream = new FileOutputStream((File)object3);
                object3 = "UTF-8";
                object = new OutputStreamWriter((OutputStream)fileOutputStream, (String)object3);
            }
            catch (Throwable throwable) {
                object = null;
                break block6;
            }
            try {
                object3 = new BufferedWriter((Writer)object);
            }
            catch (Throwable throwable) {
                break block6;
            }
            try {
                ((Writer)object3).write(string3);
                ((BufferedWriter)object3).flush();
                object2 = c;
                object2.put(string2, string3);
            }
            catch (Throwable throwable) {
                object2 = object3;
                break block6;
            }
            IOUtils.closeQuietly((Writer)object);
            IOUtils.closeQuietly((Writer)object3);
            return;
        }
        IOUtils.closeQuietly((Writer)object);
        IOUtils.closeQuietly((Writer)object2);
        throw var0_4;
    }

    public static void a(String string2, String charSequence, String string3, String string4, String string5, Context object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = p.a(object.getApplicationContext())));
        if (!bl2) {
            CharSequence charSequence2 = "m";
            CharSequence charSequence3 = new StringBuilder();
            charSequence3.append((String)object);
            String string6 = "/files/math/m";
            charSequence3.append(string6);
            charSequence3 = charSequence3.toString();
            com.huawei.hms.opendevice.c.a((String)charSequence2, string2, (String)charSequence3);
            string2 = "p";
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)object);
            charSequence3 = "/files/panda/p";
            ((StringBuilder)charSequence2).append((String)charSequence3);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            com.huawei.hms.opendevice.c.a(string2, (String)charSequence, (String)charSequence2);
            string2 = "d";
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            charSequence2 = "/files/panda/d";
            ((StringBuilder)charSequence).append((String)charSequence2);
            charSequence = ((StringBuilder)charSequence).toString();
            com.huawei.hms.opendevice.c.a(string2, string3, (String)charSequence);
            string2 = "t";
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            string3 = "/files/math/t";
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
            com.huawei.hms.opendevice.c.a(string2, string4, (String)charSequence);
            string2 = "s";
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            string3 = "/files/s";
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
            try {
                com.huawei.hms.opendevice.c.a(string2, string5, (String)charSequence);
            }
            catch (IOException iOException) {
                string2 = a;
                charSequence = "save key IOException.";
                HMSLog.e(string2, (String)charSequence);
            }
        }
    }

    public static byte[] a(Context object) {
        int n10 = R$string.push_cat_head;
        byte[] byArray = com.huawei.hms.opendevice.a.a(object.getString(n10));
        int n11 = R$string.push_cat_body;
        object = com.huawei.hms.opendevice.a.a(object.getString(n11));
        byte[] byArray2 = com.huawei.hms.opendevice.a.a(com.huawei.hms.opendevice.c.a());
        return com.huawei.hms.opendevice.c.a(com.huawei.hms.opendevice.c.a(com.huawei.hms.opendevice.c.a(byArray, (byte[])object), byArray2));
    }

    public static byte[] a(byte[] byArray) {
        int n10;
        if (byArray != null && (n10 = byArray.length) != 0) {
            for (int i10 = 0; i10 < (n10 = byArray.length); ++i10) {
                byArray[i10] = n10 = (int)((byte)(byArray[i10] >> 2));
            }
            return byArray;
        }
        return new byte[0];
    }

    public static byte[] a(byte[] byArray, byte[] byArray2) {
        int n10;
        if (byArray != null && byArray2 != null && (n10 = byArray.length) != 0 && (n10 = byArray2.length) != 0) {
            n10 = byArray.length;
            int n11 = byArray2.length;
            if (n10 != n11) {
                return new byte[0];
            }
            byte[] byArray3 = new byte[n10];
            for (int i10 = 0; i10 < n10; ++i10) {
                byte by2 = byArray[i10];
                byte by3 = byArray2[i10];
                byArray3[i10] = by2 = (byte)(by2 ^ by3);
            }
            return byArray3;
        }
        return new byte[0];
    }

    public static d.j.f.a.a.h.f.d b(Context object) {
        Object object2 = b;
        if (object2 == null) {
            boolean bl2 = com.huawei.hms.opendevice.c.g();
            if (bl2) {
                object = com.huawei.hms.opendevice.c.c();
                object2 = com.huawei.hms.opendevice.c.d();
                String string2 = com.huawei.hms.opendevice.c.b();
                String string3 = com.huawei.hms.opendevice.c.f();
                object = d.j.f.a.a.h.f.d.e((String)object, (String)object2, string2, string3);
                b = object;
            } else {
                object2 = a;
                String string4 = "root key util is null, init root key.";
                HMSLog.w((String)object2, string4);
                com.huawei.hms.opendevice.c.d(object);
            }
        }
        return b;
    }

    public static String b() {
        return com.huawei.hms.opendevice.c.a("d");
    }

    public static String c() {
        return com.huawei.hms.opendevice.c.a("m");
    }

    public static String c(Context object) {
        String string2;
        boolean bl2 = com.huawei.hms.opendevice.c.g();
        if (!bl2) {
            string2 = a;
            String string3 = "work key is empty, execute init.";
            HMSLog.i(string2, string3);
            com.huawei.hms.opendevice.c.d(object);
        }
        string2 = com.huawei.hms.opendevice.c.e();
        object = com.huawei.hms.opendevice.c.b(object);
        return e.a(string2, (d.j.f.a.a.h.f.d)object);
    }

    public static String d() {
        return com.huawei.hms.opendevice.c.a("p");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void d(Context object) {
        Object object2 = d;
        synchronized (object2) {
            Object object3 = object.getApplicationContext();
            com.huawei.hms.opendevice.c.e(object3);
            int n10 = com.huawei.hms.opendevice.c.g();
            if (n10 != 0) {
                object = a;
                object3 = "The local secret is already in separate file mode.";
                HMSLog.i((String)object, (String)object3);
                return;
            }
            Object object4 = new StringBuilder();
            Object object5 = object.getApplicationContext();
            object5 = p.a(object5);
            ((StringBuilder)object4).append((String)object5);
            object5 = "/shared_prefs/LocalAvengers.xml";
            ((StringBuilder)object4).append((String)object5);
            object4 = ((StringBuilder)object4).toString();
            object3 = new File((String)object4);
            boolean bl2 = object3.exists();
            if (bl2) {
                d.j.f.a.a.k.d.i((File)object3);
                object3 = a;
                object4 = "destroy C, delete file LocalAvengers.xml.";
                HMSLog.i((String)object3, (String)object4);
            }
            n10 = 32;
            object4 = d.j.f.a.a.h.f.b.e(n10);
            object5 = d.j.f.a.a.h.f.b.e(n10);
            byte[] byArray = d.j.f.a.a.h.f.b.e(n10);
            byte[] byArray2 = d.j.f.a.a.h.f.b.e(n10);
            String string2 = com.huawei.hms.opendevice.a.a((byte[])object4);
            String string3 = com.huawei.hms.opendevice.a.a((byte[])object5);
            String string4 = com.huawei.hms.opendevice.a.a(byArray);
            b = object4 = d.j.f.a.a.h.f.d.f(string2, string3, string4, byArray2);
            object3 = d.j.f.a.a.h.f.b.e(n10);
            object3 = com.huawei.hms.opendevice.a.a((byte[])object3);
            object4 = b;
            String string5 = e.i((String)object3, (d.j.f.a.a.h.f.d)object4);
            String string6 = com.huawei.hms.opendevice.a.a(byArray2);
            com.huawei.hms.opendevice.c.a(string2, string3, string4, string6, string5, object);
            object = a;
            object3 = "generate D.";
            HMSLog.i((String)object, (String)object3);
            return;
        }
    }

    public static String e() {
        return com.huawei.hms.opendevice.c.a("s");
    }

    public static void e(Context object) {
        boolean bl2 = com.huawei.hms.opendevice.c.g();
        if (bl2) {
            HMSLog.i(a, "secretKeyCache not empty.");
            return;
        }
        Object object2 = c;
        object2.clear();
        object = p.a(object);
        bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("/files/math/m");
            object2 = s.a(((StringBuilder)object2).toString());
            CharSequence charSequence = new StringBuilder();
            charSequence.append((String)object);
            charSequence.append("/files/panda/p");
            charSequence = s.a(charSequence.toString());
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append((String)object);
            charSequence2.append("/files/panda/d");
            charSequence2 = s.a(charSequence2.toString());
            CharSequence charSequence3 = new StringBuilder();
            charSequence3.append((String)object);
            charSequence3.append("/files/math/t");
            charSequence3 = s.a(charSequence3.toString());
            Object object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append("/files/s");
            object = s.a(((StringBuilder)object3).toString());
            object3 = new String[5];
            String string2 = null;
            object3[0] = object2;
            object3[1] = charSequence;
            object3[2] = charSequence2;
            object3[3] = charSequence3;
            int n10 = 4;
            object3[n10] = object;
            boolean bl3 = t.a((String[])object3);
            if (bl3) {
                object3 = c;
                string2 = "m";
                object3.put(string2, object2);
                object2 = c;
                object3 = "p";
                object2.put(object3, charSequence);
                c.put("d", charSequence2);
                c.put("t", charSequence3);
                object2 = c;
                charSequence = "s";
                object2.put(charSequence, object);
            }
        }
    }

    public static String f() {
        return com.huawei.hms.opendevice.c.a("t");
    }

    public static boolean g() {
        return TextUtils.isEmpty((CharSequence)com.huawei.hms.opendevice.c.e()) ^ true;
    }
}

