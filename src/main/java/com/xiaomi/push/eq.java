/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.push.ai;
import com.xiaomi.push.em;
import com.xiaomi.push.ep;
import com.xiaomi.push.er;
import com.xiaomi.push.es;
import com.xiaomi.push.et;
import com.xiaomi.push.eu;
import com.xiaomi.push.ew;
import com.xiaomi.push.service.aa;
import java.util.HashMap;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class eq {
    private static volatile eq a;
    private int a;
    private Context a;
    private eu a;
    private String a;
    private HashMap a;
    private String b;

    private eq(Context object) {
        Object object2;
        this.a = object2 = new Object();
        this.a = object;
        object = es.b;
        et et2 = new ew();
        object2.put((Context)object, et2);
        object = this.a;
        object2 = es.c;
        ((HashMap)object).put(object2, et2);
        object = this.a;
        object2 = es.a;
        super();
        ((HashMap)object).put(object2, et2);
        object = this.a;
        object2 = es.d;
        super();
        ((HashMap)object).put(object2, et2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static eq a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = eq.class;
        synchronized (object) {
            eq eq2 = a;
            if (eq2 != null) return a;
            a = eq2 = new eq(context);
            return a;
        }
    }

    public static /* synthetic */ void a(eq eq2, es es2, Context context, ep ep2) {
        eq2.a(es2, context, ep2);
    }

    private void a(es es2, Context context, ep ep2) {
        ((et)this.a.get((Object)es2)).a(context, ep2);
    }

    public static boolean a(Context context) {
        String string2 = context.getPackageName();
        return aa.a(context, string2);
    }

    public int a() {
        return this.a;
    }

    public eu a() {
        return this.a;
    }

    public String a() {
        return this.a;
    }

    public void a(int n10) {
        this.a = n10;
    }

    public void a(Context context, String string2, int n10, String string3, String string4) {
        boolean bl2;
        if (!(context == null || (bl2 = TextUtils.isEmpty((CharSequence)string2)) || (bl2 = TextUtils.isEmpty((CharSequence)string3)) || (bl2 = TextUtils.isEmpty((CharSequence)string4)))) {
            this.a(n10);
            ai ai2 = ai.a(this.a);
            er er2 = new er(this, string2, context, string3, string4);
            ai2.a(er2);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        em.a(context, string2, 1008, "A receive a incorrect message");
    }

    public void a(es object, Context context, Intent object2, String string2) {
        if (object != null) {
            HashMap hashMap = this.a;
            object = (et)hashMap.get(object);
            object.a(context, (Intent)object2, string2);
        } else {
            int n10 = 1008;
            object2 = "null";
            string2 = "A receive a incorrect message with empty type";
            em.a(context, (String)object2, n10, string2);
        }
    }

    public void a(eu eu2) {
        this.a = eu2;
    }

    public void a(String string2) {
        this.a = string2;
    }

    public void a(String string2, String string3, int n10, eu eu2) {
        this.a(string2);
        this.b(string3);
        this.a(n10);
        this.a(eu2);
    }

    public String b() {
        return this.b;
    }

    public void b(String string2) {
        this.b = string2;
    }
}

