/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bd;
import com.xiaomi.push.ek$c;
import com.xiaomi.push.fl;
import com.xiaomi.push.fs;
import com.xiaomi.push.service.ap$b;
import java.util.HashMap;

public class fk {
    public static void a(ap$b object, String string2, fs fs2) {
        ek$c ek$c = new ek$c();
        Object object2 = ((ap$b)object).c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            object2 = ((ap$b)object).c;
            ek$c.a((String)object2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((ap$b)object).e)))) {
            object2 = ((ap$b)object).e;
            ek$c.d((String)object2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((ap$b)object).f)))) {
            object2 = ((ap$b)object).f;
            ek$c.e((String)object2);
        }
        bl2 = ((ap$b)object).a;
        String string3 = "1";
        String string4 = "0";
        object2 = bl2 ? string3 : string4;
        ek$c.b((String)object2);
        object2 = ((ap$b)object).d;
        bl2 = TextUtils.isEmpty((CharSequence)object2);
        String string5 = "XIAOMI-SASL";
        if (!bl2) {
            object2 = ((ap$b)object).d;
            ek$c.c((String)object2);
        } else {
            ek$c.c(string5);
        }
        object2 = new fl();
        HashMap<String, String> hashMap = ((ap$b)object).b;
        ((fl)object2).c((String)((Object)hashMap));
        int n10 = Integer.parseInt(((ap$b)object).g);
        ((fl)object2).a(n10);
        hashMap = ((ap$b)object).a;
        ((fl)object2).b((String)((Object)hashMap));
        ((fl)object2).a("BIND", null);
        hashMap = ((fl)object2).e();
        ((fl)object2).a((String)((Object)hashMap));
        hashMap = new HashMap<String, String>();
        ((StringBuilder)((Object)hashMap)).append("[Slim]: bind id=");
        String string6 = ((fl)object2).e();
        ((StringBuilder)((Object)hashMap)).append(string6);
        b.a(((StringBuilder)((Object)hashMap)).toString());
        hashMap = new HashMap<String, String>();
        hashMap.put("challenge", string2);
        string2 = ((ap$b)object).c;
        hashMap.put("token", string2);
        string2 = ((ap$b)object).g;
        hashMap.put("chid", string2);
        string2 = ((ap$b)object).b;
        hashMap.put("from", string2);
        string2 = ((fl)object2).e();
        hashMap.put("id", string2);
        string2 = "to";
        hashMap.put(string2, "xiaomi.com");
        boolean bl3 = ((ap$b)object).a;
        string6 = "kick";
        if (bl3) {
            hashMap.put(string6, string3);
        } else {
            hashMap.put(string6, string4);
        }
        string2 = ((ap$b)object).e;
        bl3 = TextUtils.isEmpty((CharSequence)string2);
        string3 = "";
        string4 = "client_attrs";
        if (!bl3) {
            string2 = ((ap$b)object).e;
            hashMap.put(string4, string2);
        } else {
            hashMap.put(string4, string3);
        }
        string2 = ((ap$b)object).f;
        bl3 = TextUtils.isEmpty((CharSequence)string2);
        string4 = "cloud_attrs";
        if (!bl3) {
            string2 = ((ap$b)object).f;
            hashMap.put(string4, string2);
        } else {
            hashMap.put(string4, string3);
        }
        string2 = ((ap$b)object).d;
        string3 = "XIAOMI-PASS";
        bl3 = string2.equals(string3);
        if (!bl3 && !(bl3 = (string2 = ((ap$b)object).d).equals(string3 = "XMPUSH-PASS"))) {
            ((ap$b)object).d.equals(string5);
            object = null;
        } else {
            string2 = ((ap$b)object).d;
            object = ((ap$b)object).h;
            object = bd.a(string2, null, hashMap, (String)object);
        }
        ek$c.f((String)object);
        object = ek$c.a();
        ((fl)object2).a((byte[])object, null);
        fs2.b((fl)object2);
    }

    public static void a(String string2, String string3, fs fs2) {
        fl fl2 = new fl();
        fl2.c(string3);
        int n10 = Integer.parseInt(string2);
        fl2.a(n10);
        fl2.a("UBND", null);
        fs2.b(fl2);
    }
}

