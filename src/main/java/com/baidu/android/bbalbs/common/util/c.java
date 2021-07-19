/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.util.a;
import com.baidu.android.bbalbs.common.util.b;
import com.baidu.android.bbalbs.common.util.d;

public final class c {
    private static b b;
    private static String c = "";
    private static volatile String d = "";
    private final Context a;

    private c(Context context) {
        this.a = context = context.getApplicationContext();
    }

    public static String a() {
        String string2 = c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            c = string2 = "0newiqr3mini0";
        }
        return c;
    }

    public static String a(Context context) {
        return com.baidu.android.bbalbs.common.util.c.b(context).a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(String object) {
        String string2;
        int n10 = 5;
        int n11 = com.baidu.android.bbalbs.common.util.d.a((String)object, n10);
        if (n11 == 0) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("expect src only letter or number , less than ");
            charSequence.append(6);
            charSequence = charSequence.toString();
            object = new IllegalArgumentException((String)charSequence);
            throw object;
        }
        Object object2 = b.class;
        synchronized (object2) {
            string2 = d;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                return;
            }
            d = object;
        }
        n11 = ((String)object).length();
        object2 = new StringBuffer();
        string2 = "0newiqr3";
        ((StringBuffer)object2).append(string2);
        ((StringBuffer)object2).append((String)object);
        int n12 = 0;
        object = null;
        while (true) {
            if (n12 >= (n10 -= n11)) {
                c = ((StringBuffer)object2).toString().trim();
                return;
            }
            string2 = "0";
            ((StringBuffer)object2).append(string2);
            ++n12;
        }
    }

    private b b() {
        Context context;
        boolean bl2;
        Object object = com.baidu.android.bbalbs.common.util.b.b(this.a);
        if (object == null) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        if (object == null) {
            object = com.baidu.android.bbalbs.common.util.a.b(this.a);
            if (object == null) {
                object = this.a;
                String string2 = com.baidu.android.bbalbs.common.util.c.a();
                object = com.baidu.android.bbalbs.common.util.b.a((Context)object, string2);
            } else {
                ((a)object).c();
                object = com.baidu.android.bbalbs.common.util.b.a((a)object);
            }
        }
        if (bl2) {
            context = this.a;
            ((b)object).a(context);
        }
        com.baidu.android.bbalbs.common.util.a.a(this.a);
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static b b(Context object) {
        Object object2 = b;
        if (object2 != null) return b;
        object2 = b.class;
        synchronized (object2) {
            Object object3 = b;
            if (object3 != null) return b;
            object3 = new c((Context)object);
            object = super.b();
            b = object;
            return b;
        }
    }
}

