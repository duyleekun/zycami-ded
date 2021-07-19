/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.g;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.a;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.d;
import com.xiaomi.push.t;
import java.lang.reflect.Field;
import java.util.Locale;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class k {
    public final int a;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public k(String string2, String string3, String string4, String string5, String string6, String string7, int n10) {
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = string5;
        this.e = string6;
        this.f = string7;
        this.a = n10;
    }

    public static boolean a() {
        String string2;
        Object object = "miui.os.Build";
        try {
            object = t.a(null, (String)object);
            string2 = "IS_ALPHA_BUILD";
        }
        catch (Exception exception) {
            return false;
        }
        object = ((Class)object).getField(string2);
        return ((Field)object).getBoolean(null);
    }

    public static boolean a(Context object) {
        String string2 = "com.xiaomi.xmsf";
        boolean bl2 = string2.equals(object = object.getPackageName());
        if (bl2 && (bl2 = k.a())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public ap$b a(XMPushService xMPushService) {
        ap$b ap$b = new ap$b(xMPushService);
        d d10 = xMPushService.b();
        this.a(ap$b, (Context)xMPushService, d10, "c");
        return ap$b;
    }

    public ap$b a(ap$b ap$b, Context object, d d10, String string2) {
        String string3;
        ap$b.a = string3 = object.getPackageName();
        ap$b.b = string3 = this.a;
        ap$b.h = string3 = this.c;
        ap$b.c = string3 = this.b;
        ap$b.g = "5";
        ap$b.d = "XMPUSH-PASS";
        string3 = null;
        ap$b.a = false;
        boolean bl2 = k.b((Context)object);
        Object object2 = bl2 ? g.b((Context)object) : "";
        int n10 = 12;
        Object object3 = new Object[n10];
        object3[0] = "sdk_ver";
        Object object4 = 39;
        int n11 = 1;
        object3[n11] = object4;
        int n12 = 2;
        object3[n12] = "cpvn";
        int n13 = 3;
        object3[n13] = "3_7_5";
        int n14 = 4;
        object3[n14] = "cpvc";
        object4 = 30705;
        int n15 = 5;
        object3[n15] = object4;
        int n16 = 6;
        object3[n16] = "aapn";
        int n17 = 7;
        object3[n17] = object2;
        object3[8] = "country_code";
        object3[9] = object4 = com.xiaomi.push.service.a.a((Context)object).b();
        object3[10] = "region";
        object3[11] = object4 = com.xiaomi.push.service.a.a((Context)object).a();
        object2 = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s:%7$s:%8$s,%9$s:%10$s,%11$s:%12$s", object3);
        ap$b.e = object2;
        bl2 = k.b((Context)object);
        object2 = bl2 ? "1000271" : this.d;
        object3 = new Object[n16];
        object3[0] = object4 = "appid";
        object3[n11] = object2;
        object3[n12] = "locale";
        object2 = Locale.getDefault().toString();
        object3[n13] = object2;
        object3[n14] = "miid";
        object2 = t.a((Context)object);
        object3[n15] = object2;
        object2 = String.format("%1$s:%2$s,%3$s:%4$s,%5$s:%6$s,sync:1", object3);
        ap$b.f = object2;
        boolean bl3 = k.a((Context)object);
        if (bl3) {
            object = new StringBuilder();
            object2 = ap$b.f;
            ((StringBuilder)object).append((String)object2);
            object2 = new Object[n12];
            object2[0] = object3 = "ab";
            object2[n11] = string2;
            string2 = String.format(",%1$s:%2$s", object2);
            ((StringBuilder)object).append(string2);
            ap$b.f = object = ((StringBuilder)object).toString();
        }
        ap$b.a = d10;
        return ap$b;
    }
}

