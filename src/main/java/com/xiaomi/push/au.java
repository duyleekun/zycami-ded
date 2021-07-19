/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ar;
import com.xiaomi.push.at;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class au
implements ar {
    private static volatile au a;
    private ar a;

    private au(Context object) {
        object = at.a((Context)object);
        this.a = object;
        ((StringBuilder)object).append("create id manager is: ");
        ar ar2 = this.a;
        ((StringBuilder)object).append(ar2);
        b.a(((StringBuilder)object).toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static au a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = au.class;
        synchronized (object) {
            au au2 = a;
            if (au2 != null) return a;
            context = context.getApplicationContext();
            a = au2 = new au(context);
            return a;
        }
    }

    private String a(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    public String a() {
        String string2 = this.a.a();
        return this.a(string2);
    }

    public void a(Map map) {
        String string2;
        if (map == null) {
            return;
        }
        String string3 = this.a();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            string2 = "udid";
            map.put(string2, string3);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string3 = this.b())))) {
            string2 = "oaid";
            map.put(string2, string3);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string3 = this.c())))) {
            string2 = "vaid";
            map.put(string2, string3);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(string3 = this.d())))) {
            string2 = "aaid";
            map.put(string2, string3);
        }
    }

    public boolean a() {
        return this.a.a();
    }

    public String b() {
        String string2 = this.a.b();
        return this.a(string2);
    }

    public String c() {
        String string2 = this.a.c();
        return this.a(string2);
    }

    public String d() {
        String string2 = this.a.d();
        return this.a(string2);
    }
}

