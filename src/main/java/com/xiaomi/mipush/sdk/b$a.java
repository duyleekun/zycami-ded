/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.g;
import com.xiaomi.push.i;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b$a {
    public int a;
    private Context a;
    public String a;
    public boolean a;
    public String b;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    public b$a(Context context) {
        boolean bl2;
        this.a = bl2 = true;
        this.b = false;
        this.a = (int)(bl2 ? 1 : 0);
        this.a = context;
    }

    public static b$a a(Context object, String object2) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject((String)object2);
        }
        catch (Throwable throwable) {
            com.xiaomi.channel.commonutils.logger.b.a(throwable);
            return null;
        }
        object2 = new b$a((Context)object);
        object = "appId";
        object = jSONObject.getString((String)object);
        ((b$a)object2).a = object;
        object = "appToken";
        object = jSONObject.getString((String)object);
        ((b$a)object2).b = object;
        object = "regId";
        object = jSONObject.getString((String)object);
        ((b$a)object2).c = object;
        object = "regSec";
        object = jSONObject.getString((String)object);
        ((b$a)object2).d = object;
        object = "devId";
        object = jSONObject.getString((String)object);
        ((b$a)object2).f = object;
        object = "vName";
        object = jSONObject.getString((String)object);
        ((b$a)object2).e = object;
        object = "valid";
        int n10 = jSONObject.getBoolean((String)object);
        ((b$a)object2).a = n10;
        object = "paused";
        n10 = jSONObject.getBoolean((String)object);
        ((b$a)object2).b = n10;
        object = "envType";
        n10 = jSONObject.getInt((String)object);
        ((b$a)object2).a = n10;
        object = "regResource";
        object = jSONObject.getString((String)object);
        ((b$a)object2).g = object;
        return object2;
    }

    private String a() {
        Context context = this.a;
        String string2 = context.getPackageName();
        return com.xiaomi.push.g.a(context, string2);
    }

    public static String a(b$a object) {
        String string2;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            string2 = "appId";
        }
        catch (Throwable throwable) {
            com.xiaomi.channel.commonutils.logger.b.a(throwable);
            return null;
        }
        String string3 = ((b$a)object).a;
        jSONObject.put(string2, (Object)string3);
        string2 = "appToken";
        string3 = ((b$a)object).b;
        jSONObject.put(string2, (Object)string3);
        string2 = "regId";
        string3 = ((b$a)object).c;
        jSONObject.put(string2, (Object)string3);
        string2 = "regSec";
        string3 = ((b$a)object).d;
        jSONObject.put(string2, (Object)string3);
        string2 = "devId";
        string3 = ((b$a)object).f;
        jSONObject.put(string2, (Object)string3);
        string2 = "vName";
        string3 = ((b$a)object).e;
        jSONObject.put(string2, (Object)string3);
        string2 = "valid";
        int n10 = ((b$a)object).a;
        jSONObject.put(string2, n10 != 0);
        string2 = "paused";
        n10 = ((b$a)object).b;
        jSONObject.put(string2, n10 != 0);
        string2 = "envType";
        n10 = ((b$a)object).a;
        jSONObject.put(string2, n10);
        string2 = "regResource";
        object = ((b$a)object).g;
        jSONObject.put(string2, object);
        return jSONObject.toString();
    }

    public void a() {
        com.xiaomi.mipush.sdk.b.a(this.a).edit().clear().commit();
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = null;
        this.e = null;
        this.a = false;
        this.b = false;
        this.h = null;
        this.a = 1;
    }

    public void a(int n10) {
        this.a = n10;
    }

    public void a(String string2, String string3) {
        this.c = string2;
        this.d = string3;
        this.f = string2 = i.l(this.a);
        this.e = string2 = this.a();
        this.a = true;
    }

    public void a(String string2, String string3, String string4) {
        this.a = string2;
        this.b = string3;
        this.g = string4;
        string2 = com.xiaomi.mipush.sdk.b.a(this.a).edit();
        String string5 = this.a;
        string2.putString("appId", string5);
        string2.putString("appToken", string3);
        string2.putString("regResource", string4);
        string2.commit();
    }

    public void a(boolean bl2) {
        this.b = bl2;
    }

    public boolean a() {
        String string2 = this.a;
        String string3 = this.b;
        return this.a(string2, string3);
    }

    public boolean a(String string2, String string3) {
        String string4 = this.a;
        boolean bl2 = TextUtils.equals((CharSequence)string4, (CharSequence)string2);
        if (bl2 && (bl2 = TextUtils.equals((CharSequence)(string2 = this.b), (CharSequence)string3)) && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.c))) && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.d))) && ((bl2 = TextUtils.equals((CharSequence)(string2 = this.f), (CharSequence)(string3 = i.l(this.a)))) || (bl2 = TextUtils.equals((CharSequence)(string2 = this.f), (CharSequence)(string3 = i.k(this.a)))))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public void b() {
        this.a = false;
        SharedPreferences.Editor editor = com.xiaomi.mipush.sdk.b.a(this.a).edit();
        boolean bl2 = this.a;
        editor.putBoolean("valid", bl2).commit();
    }

    public void b(String string2, String string3, String string4) {
        boolean bl2;
        String string5;
        this.c = string2;
        this.d = string3;
        this.f = string5 = i.l(this.a);
        this.e = string5 = this.a();
        this.a = bl2 = true;
        this.h = string4;
        SharedPreferences.Editor editor = com.xiaomi.mipush.sdk.b.a(this.a).edit();
        editor.putString("regId", string2);
        editor.putString("regSec", string3);
        string2 = this.f;
        editor.putString("devId", string2);
        string2 = this.a();
        editor.putString("vName", string2);
        editor.putBoolean("valid", bl2);
        editor.putString("appRegion", string4);
        editor.commit();
    }

    public void c(String string2, String string3, String string4) {
        this.a = string2;
        this.b = string3;
        this.g = string4;
    }
}

