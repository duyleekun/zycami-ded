/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.c;
import com.huawei.hms.hatool.f;
import com.huawei.hms.hatool.g0;
import com.huawei.hms.hatool.h;
import com.huawei.hms.hatool.i;
import com.huawei.hms.hatool.j0;
import com.huawei.hms.hatool.k0;
import com.huawei.hms.hatool.l;
import com.huawei.hms.hatool.m0;
import com.huawei.hms.hatool.n0;
import com.huawei.hms.hatool.s0;
import com.huawei.hms.hatool.u0;
import com.huawei.hms.hatool.y;
import java.util.HashMap;
import org.json.JSONObject;

public class h0 {
    public static h0 b;
    public Context a;

    static {
        new HashMap();
    }

    public static h0 a() {
        return h0.b();
    }

    public static h0 b() {
        Class<h0> clazz = h0.class;
        synchronized (clazz) {
            h0 h02 = b;
            if (h02 == null) {
                b = h02 = new h0();
            }
            h02 = b;
            return h02;
        }
    }

    public void a(Context object) {
        this.a = object;
        this.b((Context)object);
        object = i.c().b();
        String string2 = f.a();
        ((l)object).e(string2);
    }

    public void a(String string2, int n10) {
        Object object = this.a;
        String string3 = "hmsSdk";
        if (object == null) {
            y.e(string3, "onReport() null context or SDK was not init.");
            return;
        }
        y.c(string3, "onReport: Before calling runtaskhandler()");
        String string4 = s0.a(n10);
        object = com.huawei.hms.hatool.b.d();
        this.a(string2, string4, (String)object);
    }

    public void a(String string2, int n10, String string3, JSONObject jSONObject) {
        j0 j02;
        Object object;
        long l10 = System.currentTimeMillis();
        int n11 = 2;
        if (n11 == n10) {
            object = "yyyy-MM-dd";
            l10 = s0.a((String)object, l10);
        }
        String string4 = s0.a(n10);
        object = j02;
        j02 = new j0(string3, jSONObject, string2, string4, l10);
        n0.b().a(j02);
    }

    public void a(String string2, String charSequence) {
        Object object = c.a(string2, (String)charSequence);
        String string3 = "hmsSdk";
        if (object != 0) {
            long l10;
            long l11 = c.j(string2, (String)charSequence);
            long l12 = System.currentTimeMillis();
            l11 = l12 - l11;
            long l13 = l11 - (l10 = 30000L);
            object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object > 0) {
                y.a(string3, "begin to call onReport!");
                c.a(string2, (String)charSequence, l12);
                String string4 = com.huawei.hms.hatool.b.d();
                this.a(string2, (String)charSequence, string4);
            } else {
                string2 = "autoReport timeout. interval < 30s ";
                y.f(string3, string2);
            }
        } else {
            charSequence = new StringBuilder();
            String string5 = "auto report is closed tag:";
            ((StringBuilder)charSequence).append(string5);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            y.c(string3, string2);
        }
    }

    public void a(String object, String string2, String string3) {
        boolean bl2;
        String string4;
        Object object2 = this.a;
        String string5 = "hmsSdk";
        if (object2 == null) {
            y.e(string5, "onReport() null context or SDK was not init.");
            return;
        }
        object2 = h.a(object2);
        boolean bl3 = c.e((String)object, string2);
        if (bl3 && !(bl3 = (string4 = "WIFI").equals(object2))) {
            object = new StringBuilder();
            ((StringBuilder)object).append("strNetworkType is :");
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            y.c(string5, (String)object);
            return;
        }
        bl3 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl3 && !(bl2 = (string4 = "2G").equals(object2))) {
            object2 = new k0((String)object, string2, string3);
            object = n0.b();
            ((n0)object).a((m0)object2);
        } else {
            object = "The network is bad.";
            y.e(string5, (String)object);
        }
    }

    public final void b(Context object) {
        block4: {
            String string2;
            block3: {
                block1: {
                    boolean bl2;
                    String string3;
                    String string4;
                    String string5;
                    block2: {
                        string5 = f.d((Context)object);
                        com.huawei.hms.hatool.b.a(string5);
                        Object object2 = u0.b();
                        boolean bl3 = ((u0)object2).a();
                        string2 = "hmsSdk";
                        if (!bl3) break block1;
                        object2 = "global_v2";
                        String string6 = "app_ver";
                        string4 = "";
                        string3 = g0.a((Context)object, (String)object2, string6, string4);
                        g0.b((Context)object, (String)object2, string6, string5);
                        com.huawei.hms.hatool.b.b(string3);
                        bl2 = TextUtils.isEmpty((CharSequence)string3);
                        if (!bl2) break block2;
                        object = "app ver is first save!";
                        break block3;
                    }
                    bl2 = string3.equals(string5);
                    if (!bl2) {
                        y.c(string2, "the appVers are different!");
                        object = h0.a();
                        string5 = "alltype";
                        ((h0)object).a(string4, string5, string3);
                    }
                    break block4;
                }
                object = "userManager.isUserUnlocked() == false";
            }
            y.c(string2, (String)object);
        }
    }
}

