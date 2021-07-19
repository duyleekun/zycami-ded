/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Pair
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.hatool.a;
import com.huawei.hms.hatool.a1;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.g;
import com.huawei.hms.hatool.g0;
import com.huawei.hms.hatool.i;
import com.huawei.hms.hatool.l;
import com.huawei.hms.hatool.v0;
import com.huawei.hms.hatool.x0$a;
import com.huawei.hms.hatool.z0;
import java.util.UUID;

public class x0 {
    public static x0 b;
    public Context a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static x0 a() {
        Class<x0> clazz = x0.class;
        synchronized (clazz) {
            x0 x02 = b;
            if (x02 != null) return b;
            b = x02 = new x0();
            return b;
        }
    }

    public String a(String string2, String string3) {
        return g.a(this.a, string2, string3);
    }

    public String a(boolean bl2) {
        String string2 = "";
        if (!bl2) {
            return string2;
        }
        String string3 = com.huawei.hms.hatool.b.j();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (bl3) {
            string3 = this.a;
            String string4 = "global_v2";
            String string5 = "uuid";
            boolean bl4 = TextUtils.isEmpty((CharSequence)(string3 = g0.a((Context)string3, string4, string5, string2)));
            if (bl4) {
                string3 = UUID.randomUUID().toString();
                String string6 = "-";
                string3 = string3.replace(string6, string2);
                string2 = this.a;
                g0.b((Context)string2, string4, string5, string3);
            }
            com.huawei.hms.hatool.b.c(string3);
        }
        return string3;
    }

    public void a(Context context) {
        Context context2 = this.a;
        if (context2 == null) {
            this.a = context;
        }
    }

    public String b(String string2, String string3) {
        return g.b(this.a, string2, string3);
    }

    public v0 c(String string2, String string3) {
        x0$a x0$a = new x0$a(string2, string3);
        string2 = this.a;
        return x0$a.a((Context)string2);
    }

    public String d(String string2, String string3) {
        return a1.b(string2, string3);
    }

    public Pair e(String string2, String object) {
        boolean bl2 = com.huawei.hms.hatool.a.f(string2, (String)object);
        if (bl2) {
            string2 = i.c().b().n();
            object = i.c().b().o();
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl3 && !(bl3 = TextUtils.isEmpty((CharSequence)object))) {
                Pair pair = new Pair((Object)string2, object);
                return pair;
            }
            string2 = z0.e(this.a);
            object = i.c().b();
            String string3 = (String)((Pair)string2).first;
            ((l)object).i(string3);
            object = i.c().b();
            string3 = (String)((Pair)string2).second;
            ((l)object).j(string3);
            return string2;
        }
        object = "";
        string2 = new Pair(object, object);
        return string2;
    }

    public String f(String string2, String string3) {
        return a1.a(string2, string3);
    }
}

