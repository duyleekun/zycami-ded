/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b$a;
import com.xiaomi.push.g;
import com.xiaomi.push.i;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b {
    private static volatile b a;
    private Context a;
    private b$a a;
    public String a;
    private Map a;

    private b(Context context) {
        this.a = context;
        this.c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = b.class;
        synchronized (object) {
            b b10 = a;
            if (b10 != null) return a;
            a = b10 = new b(context);
            return a;
        }
    }

    private void c() {
        int n10;
        String string2;
        String string3;
        Object object = this.a;
        Object object2 = new b$a((Context)object);
        this.a = object2;
        this.a = object2 = new HashMap();
        object2 = b.a(this.a);
        object = this.a;
        object.a = string3 = object2.getString("appId", null);
        object = this.a;
        object.b = string3 = object2.getString("appToken", null);
        object = this.a;
        object.c = string3 = object2.getString("regId", null);
        object = this.a;
        object.d = string3 = object2.getString("regSec", null);
        object = this.a;
        string3 = "devId";
        object.f = string2 = object2.getString(string3, null);
        object = this.a.f;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && (bl2 = i.a((String)(object = this.a.f)))) {
            object = this.a;
            object.f = string2 = i.l(this.a);
            object = object2.edit();
            string2 = this.a.f;
            object = object.putString(string3, string2);
            object.commit();
        }
        object = this.a;
        object.e = string3 = object2.getString("vName", null);
        object = this.a;
        int n11 = 1;
        object.a = n10 = object2.getBoolean("valid", n11 != 0);
        object = this.a;
        object.b = n10 = object2.getBoolean("paused", false);
        object = this.a;
        object.a = n10 = object2.getInt("envType", n11);
        object = this.a;
        object.g = string3 = object2.getString("regResource", null);
        object = this.a;
        object2 = object2.getString("appRegion", null);
        object.h = object2;
    }

    public int a() {
        return this.a.a;
    }

    public b$a a(String string2) {
        Object object = this.a;
        boolean bl2 = object.containsKey(string2);
        if (bl2) {
            return (b$a)this.a.get(string2);
        }
        object = new StringBuilder();
        String string3 = "hybrid_app_info_";
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        object = b.a(this.a);
        boolean bl3 = object.contains(string2);
        if (!bl3) {
            return null;
        }
        object = object.getString(string2, "");
        object = b$a.a(this.a, (String)object);
        this.a.put(string2, object);
        return object;
    }

    public String a() {
        return this.a.a;
    }

    public void a() {
        this.a.a();
    }

    public void a(int n10) {
        this.a.a(n10);
        b.a(this.a).edit().putInt("envType", n10).commit();
    }

    public void a(String string2) {
        SharedPreferences.Editor editor = b.a(this.a).edit();
        editor.putString("vName", string2);
        editor.commit();
        this.a.e = string2;
    }

    public void a(String string2, b$a object) {
        this.a.put(string2, object);
        object = b$a.a((b$a)object);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hybrid_app_info_");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        b.a(this.a).edit().putString(string2, (String)object).commit();
    }

    public void a(String string2, String string3, String string4) {
        this.a.a(string2, string3, string4);
    }

    public void a(boolean bl2) {
        this.a.a(bl2);
        b.a(this.a).edit().putBoolean("paused", bl2).commit();
    }

    public boolean a() {
        Object object = this.a;
        String string2 = object.getPackageName();
        object = g.a(object, string2);
        string2 = this.a.e;
        return TextUtils.equals((CharSequence)object, (CharSequence)string2) ^ true;
    }

    public boolean a(String string2, String string3) {
        return this.a.a(string2, string3);
    }

    public boolean a(String string2, String string3, String object) {
        String string4;
        boolean bl2;
        if ((object = this.a((String)object)) != null && (bl2 = TextUtils.equals((CharSequence)string2, (CharSequence)(string4 = ((b$a)object).a))) && (bl2 = TextUtils.equals((CharSequence)string3, (CharSequence)(string2 = ((b$a)object).b)))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public String b() {
        return this.a.b;
    }

    public void b() {
        this.a.b();
    }

    public void b(String string2) {
        this.a.remove(string2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hybrid_app_info_");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        b.a(this.a).edit().remove(string2).commit();
    }

    public void b(String string2, String string3, String string4) {
        this.a.b(string2, string3, string4);
    }

    public boolean b() {
        b$a b$a = this.a;
        boolean bl2 = b$a.a();
        if (!bl2) {
            com.xiaomi.channel.commonutils.logger.b.a("Don't send message before initialization succeeded!");
            return false;
        }
        return true;
    }

    public String c() {
        return this.a.c;
    }

    public boolean c() {
        return this.a.a();
    }

    public String d() {
        return this.a.d;
    }

    public boolean d() {
        return this.a.b;
    }

    public String e() {
        return this.a.g;
    }

    public boolean e() {
        return this.a.a ^ true;
    }

    public String f() {
        return this.a.h;
    }
}

