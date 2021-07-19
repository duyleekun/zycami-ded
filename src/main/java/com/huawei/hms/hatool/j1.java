/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.hatool;

import android.content.Context;
import com.huawei.hms.hatool.h1;
import com.huawei.hms.hatool.m1;
import com.huawei.hms.hatool.u0;
import com.huawei.hms.hatool.y;
import java.util.LinkedHashMap;

public abstract class j1 {
    public static h1 a;

    public static h1 a() {
        Class<j1> clazz = j1.class;
        synchronized (clazz) {
            Object object = a;
            if (object == null) {
                object = m1.c();
                a = object = ((m1)object).b();
            }
            object = a;
            return object;
        }
    }

    public static void a(int n10, String charSequence, LinkedHashMap object) {
        int n11;
        Object object2 = j1.a();
        if (object2 != null && (n11 = ((u0)(object2 = u0.b())).a()) != 0) {
            n11 = 1;
            if (n10 != n11 && n10 != 0) {
                charSequence = new StringBuilder();
                object = "Data type no longer collects range.type: ";
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(n10);
                String string2 = ((StringBuilder)charSequence).toString();
                charSequence = "hmsSdk";
                y.d((String)charSequence, string2);
            } else {
                object2 = a;
                ((h1)object2).a(n10, (String)charSequence, (LinkedHashMap)object);
            }
        }
    }

    public static void a(Context context, String string2, String string3) {
        h1 h12 = j1.a();
        if (h12 != null) {
            h12 = a;
            h12.a(context, string2, string3);
        }
    }

    public static boolean b() {
        return m1.c().a();
    }

    public static void c() {
        boolean bl2;
        Object object = j1.a();
        if (object != null && (bl2 = ((u0)(object = u0.b())).a())) {
            object = a;
            int n10 = -1;
            ((h1)object).a(n10);
        }
    }
}

