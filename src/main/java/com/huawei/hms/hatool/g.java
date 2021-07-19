/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.hatool.a;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.c;
import com.huawei.hms.hatool.f;
import com.huawei.hms.hatool.i;
import com.huawei.hms.hatool.l;
import com.huawei.hms.hatool.q0;
import com.huawei.hms.hatool.y;

public abstract class g {
    public static String a(Context context, String string2, String string3) {
        String string4 = a.a(string2, string3);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (!bl2) {
            return a.a(string2, string3);
        }
        y.c("hmsSdk", "getAndroidId(): to getConfigByType()");
        return g.c(context, string2, string3);
    }

    public static String b(Context object, String string2, String string3) {
        String string4 = "oper";
        boolean bl2 = string3.equals(string4);
        if (bl2) {
            return g.d((Context)object, string2, string3);
        }
        string4 = "maint";
        bl2 = string3.equals(string4);
        if (bl2) {
            return g.d((Context)object, string2, string3);
        }
        string4 = "diffprivacy";
        bl2 = string3.equals(string4);
        if (bl2) {
            return g.d((Context)object, string2, string3);
        }
        string4 = "preins";
        bl2 = string3.equals(string4);
        if (bl2) {
            return g.d((Context)object, string2, string3);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("getChannel(): Invalid type: ");
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        y.f("hmsSdk", (String)object);
        return "";
    }

    public static String c(Context object, String object2, String string2) {
        boolean bl2 = a.b((String)object2, string2);
        if (bl2) {
            object2 = b.b();
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2) {
                object = f.a(object);
                object2 = i.c().b();
                ((l)object2).b((String)object);
            }
            return b.b();
        }
        return "";
    }

    public static String d(Context object, String object2, String string2) {
        String string3 = c.d((String)object2, string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            return c.d((String)object2, string2);
        }
        object2 = i.c().b();
        string2 = ((l)object2).g();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) {
            string3 = "channel";
            bl3 = q0.a(string3, (String)(object = f.b(object)), 256);
            if (!bl3) {
                object = "";
            }
            ((l)object2).d((String)object);
        }
        return ((l)object2).g();
    }
}

