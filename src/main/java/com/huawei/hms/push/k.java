/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.n;
import com.huawei.hms.push.w;
import com.huawei.hms.support.log.HMSLog;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
    public String A;
    public int B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public int t;
    public String u;
    public String v;
    public String w;
    public int x;
    public int y;
    public String z;

    public k(byte[] object, byte[] byArray) {
        int n10;
        String string2;
        this.a = string2 = "";
        this.e = string2;
        this.f = string2;
        this.g = string2;
        this.h = string2;
        this.i = string2;
        this.j = string2;
        this.k = string2;
        this.q = string2;
        this.t = n10 = com.huawei.hms.push.n.a.ordinal();
        this.u = string2;
        this.v = string2;
        this.w = string2;
        this.x = 0;
        this.y = 0;
        this.A = string2;
        this.C = string2;
        this.E = string2;
        this.F = string2;
        Charset charset = com.huawei.hms.push.w.a;
        this.r = string2 = new String((byte[])object, charset);
        object = new String;
        super(byArray, charset);
        this.s = object;
    }

    public String a() {
        return this.m;
    }

    public final JSONObject a(JSONObject object) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("msgContent", object);
        object = this.a;
        jSONObject.put("group", object);
        object = this.A;
        jSONObject.put("tag", object);
        int n10 = this.x;
        jSONObject.put("autoCancel", n10);
        n10 = this.y;
        jSONObject.put("visibility", n10);
        object = this.z;
        jSONObject.put("when", object);
        return jSONObject;
    }

    public final JSONObject a(JSONObject object, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        String string2 = this.f;
        jSONObject2.put("dispPkgName", (Object)string2);
        string2 = this.e;
        jSONObject2.put("msgId", (Object)string2);
        string2 = this.d;
        jSONObject2.put("ap", (Object)string2);
        int n10 = this.B;
        jSONObject2.put("notifyId", n10);
        jSONObject2.put("psContent", object);
        jSONObject2.put("notifyDetail", (Object)jSONObject);
        object = this.D;
        jSONObject2.put("ticker", object);
        object = this.C;
        jSONObject2.put("data", object);
        return jSONObject2;
    }

    public void a(int n10) {
        this.B = n10;
    }

    public String b() {
        return this.F;
    }

    public final JSONObject b(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        String string2 = this.g;
        jSONObject2.put("cmd", (Object)string2);
        string2 = this.h;
        jSONObject2.put("content", (Object)string2);
        string2 = this.i;
        jSONObject2.put("notifyIcon", (Object)string2);
        string2 = this.j;
        jSONObject2.put("notifyTitle", (Object)string2);
        string2 = this.k;
        jSONObject2.put("notifySummary", (Object)string2);
        jSONObject2.put("param", (Object)jSONObject);
        return jSONObject2;
    }

    public String c() {
        return this.d;
    }

    public final void c(JSONObject object) {
        CharSequence charSequence = "ap";
        int n10 = object.has((String)charSequence);
        if (n10 != 0) {
            object = object.getString((String)charSequence);
            charSequence = new StringBuilder();
            n10 = TextUtils.isEmpty((CharSequence)object);
            int n11 = 48;
            if (n10 == 0 && (n10 = ((String)object).length()) < n11) {
                n10 = ((String)object).length();
                for (int i10 = 0; i10 < (n11 -= n10); ++i10) {
                    String string2 = "0";
                    ((StringBuilder)charSequence).append(string2);
                }
                ((StringBuilder)charSequence).append((String)object);
                this.d = object = ((StringBuilder)charSequence).toString();
            } else {
                this.d = object = ((String)object).substring(0, n11);
            }
        }
    }

    public String d() {
        return this.l;
    }

    public final boolean d(JSONObject object) {
        if (object == null) {
            return false;
        }
        String string2 = "acn";
        boolean bl2 = object.has(string2);
        if (bl2) {
            this.m = string2 = object.getString(string2);
        }
        if (bl2 = object.has(string2 = "intentUri")) {
            this.c = string2 = object.getString(string2);
        }
        if (bl2 = object.has(string2 = "appPackageName")) {
            object = object.getString(string2);
            this.l = object;
            return true;
        }
        HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    public int e() {
        return this.x;
    }

    public final boolean e(JSONObject object) {
        String string2 = "msgId";
        boolean bl2 = object.has(string2);
        if (bl2) {
            boolean bl3 = (object = object.get(string2)) instanceof String;
            if (bl3) {
                object = (String)object;
                this.e = object;
            } else {
                bl3 = object instanceof Integer;
                if (bl3) {
                    int n10 = (Integer)object;
                    object = String.valueOf(n10);
                    this.e = object;
                }
            }
            return true;
        }
        HMSLog.i("PushSelfShowLog", "msgId == null");
        return false;
    }

    public int f() {
        return this.b;
    }

    public final boolean f(JSONObject object) {
        String string2;
        block11: {
            string2 = "style";
            String string3 = "PushSelfShowLog";
            HMSLog.d(string3, "enter parseNotifyParam");
            String string4 = "notifyDetail";
            try {
                object = object.getJSONObject(string4);
            }
            catch (JSONException jSONException) {
                object = jSONException.toString();
                HMSLog.i(string3, (String)object);
                return false;
            }
            boolean bl2 = object.has(string2);
            if (!bl2) break block11;
            int n10 = object.getInt(string2);
            this.t = n10;
        }
        string2 = "bigTitle";
        string2 = object.optString(string2);
        this.u = string2;
        string2 = "bigContent";
        string2 = object.optString(string2);
        this.v = string2;
        string2 = "icon";
        object = object.optString(string2);
        this.E = object;
        return true;
    }

    public String g() {
        return this.v;
    }

    public final void g(JSONObject object) {
        int n10;
        CharSequence charSequence = object.optString("group");
        this.a = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("NOTIFY_GROUP:");
        String string2 = this.a;
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        string2 = "PushSelfShowLog";
        HMSLog.d(string2, (String)charSequence);
        this.x = n10 = object.optInt("autoCancel", 1);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("autoCancel: ");
        int n11 = this.x;
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        HMSLog.d(string2, (String)charSequence);
        this.y = n10 = object.optInt("visibility", 0);
        charSequence = object.optString("when");
        this.z = charSequence;
        object = object.optString("tag");
        this.A = object;
    }

    public String h() {
        return this.u;
    }

    public final boolean h(JSONObject jSONObject) {
        block21: {
            block19: {
                int n10;
                String string2;
                String string3;
                block20: {
                    block18: {
                        block17: {
                            string3 = "autoClear";
                            string2 = "param";
                            try {
                                jSONObject = jSONObject.getJSONObject(string2);
                            }
                            catch (Exception exception) {
                                HMSLog.e("PushSelfShowLog", "ParseParam error ", exception);
                                return false;
                            }
                            boolean bl2 = jSONObject.has(string3);
                            if (!bl2) break block17;
                            n10 = jSONObject.getInt(string3);
                            this.b = n10;
                            break block18;
                        }
                        this.b = 0;
                    }
                    string3 = "app";
                    string2 = this.g;
                    n10 = (int)(string3.equals(string2) ? 1 : 0);
                    if (n10 != 0) break block19;
                    string3 = "cosa";
                    string2 = this.g;
                    n10 = (int)(string3.equals(string2) ? 1 : 0);
                    if (n10 != 0) break block19;
                    string3 = "url";
                    string2 = this.g;
                    n10 = (int)(string3.equals(string2) ? 1 : 0);
                    if (n10 == 0) break block20;
                    this.k(jSONObject);
                    break block21;
                }
                string3 = "rp";
                string2 = this.g;
                n10 = (int)(string3.equals(string2) ? 1 : 0);
                if (n10 == 0) break block21;
                this.j(jSONObject);
                break block21;
            }
            this.d(jSONObject);
        }
        return true;
    }

    public String i() {
        return this.g;
    }

    public final boolean i(JSONObject jSONObject) {
        String string2 = "psContent";
        boolean bl2 = jSONObject.has(string2);
        if (bl2) {
            jSONObject = jSONObject.getJSONObject(string2);
            this.g = string2 = jSONObject.getString("cmd");
            this.h = string2 = jSONObject.optString("content");
            this.i = string2 = jSONObject.optString("notifyIcon");
            this.j = string2 = jSONObject.optString("notifyTitle");
            this.k = string2 = jSONObject.optString("notifySummary");
            this.D = string2 = jSONObject.optString("ticker");
            string2 = "notifyDetail";
            boolean bl3 = jSONObject.has(string2);
            if (bl3 && !(bl3 = this.f(jSONObject))) {
                return false;
            }
            string2 = "param";
            bl3 = jSONObject.has(string2);
            if (bl3) {
                return this.h(jSONObject);
            }
        }
        return false;
    }

    public String j() {
        return this.h;
    }

    public final boolean j(JSONObject object) {
        String string2;
        boolean bl2;
        String string3 = null;
        if (object == null) {
            return false;
        }
        String string4 = "appPackageName";
        boolean bl3 = object.has(string4);
        if (bl3) {
            this.l = string4 = object.getString(string4);
        }
        if ((bl3 = object.has(string4 = "rpt")) && (bl2 = object.has(string2 = "rpl"))) {
            this.o = string3 = object.getString(string2);
            this.p = string3 = object.getString(string4);
            string3 = "rpct";
            boolean bl4 = object.has(string3);
            if (bl4) {
                object = object.getString(string3);
                this.q = object;
            }
            return true;
        }
        HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
        return false;
    }

    public String k() {
        return this.f;
    }

    public final boolean k(JSONObject object) {
        String string2 = null;
        if (object == null) {
            return false;
        }
        String string3 = "url";
        boolean bl2 = object.has(string3);
        if (bl2) {
            this.n = string2 = object.getString(string3);
            string2 = "appPackageName";
            boolean bl3 = object.has(string2);
            if (bl3) {
                this.l = string2 = object.getString(string2);
            }
            if ((bl3 = object.has(string2 = "rpt")) && (bl2 = object.has(string3 = "rpl"))) {
                this.o = string3 = object.getString(string3);
                this.p = string2 = object.getString(string2);
                string2 = "rpct";
                bl3 = object.has(string2);
                if (bl3) {
                    object = object.getString(string2);
                    this.q = object;
                }
            }
            return true;
        }
        HMSLog.d("PushSelfShowLog", "url is null");
        return false;
    }

    public String l() {
        return this.a;
    }

    public String m() {
        return this.E;
    }

    public String n() {
        return this.c;
    }

    public byte[] o() {
        Object object;
        try {
            object = this.v();
        }
        catch (JSONException jSONException) {
            HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", jSONException);
            return new byte[0];
        }
        object = this.b((JSONObject)object);
        Object object2 = this.r();
        object = this.a((JSONObject)object, (JSONObject)object2);
        object = this.a((JSONObject)object);
        object = object.toString();
        object2 = com.huawei.hms.push.w.a;
        return ((String)object).getBytes((Charset)object2);
    }

    public String p() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("msgId =");
        String string2 = this.e;
        charSequence.append(string2);
        charSequence = charSequence.toString();
        HMSLog.d("PushSelfShowLog", (String)charSequence);
        return this.e;
    }

    public String q() {
        return this.A;
    }

    public final JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        int n10 = this.t;
        jSONObject.put("style", n10);
        String string2 = this.u;
        jSONObject.put("bigTitle", (Object)string2);
        string2 = this.v;
        jSONObject.put("bigContent", (Object)string2);
        string2 = this.w;
        jSONObject.put("bigPic", (Object)string2);
        return jSONObject;
    }

    public int s() {
        return this.B;
    }

    public String t() {
        return this.k;
    }

    public String u() {
        return this.j;
    }

    public final JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        int n10 = this.b;
        jSONObject.put("autoClear", n10);
        String string2 = this.n;
        jSONObject.put("url", (Object)string2);
        string2 = this.o;
        jSONObject.put("rpl", (Object)string2);
        string2 = this.p;
        jSONObject.put("rpt", (Object)string2);
        string2 = this.q;
        jSONObject.put("rpct", (Object)string2);
        string2 = this.l;
        jSONObject.put("appPackageName", (Object)string2);
        string2 = this.m;
        jSONObject.put("acn", (Object)string2);
        string2 = this.c;
        jSONObject.put("intentUri", (Object)string2);
        return jSONObject;
    }

    public int w() {
        return this.t;
    }

    public String x() {
        return this.D;
    }

    public byte[] y() {
        String string2 = this.s;
        Charset charset = com.huawei.hms.push.w.a;
        return string2.getBytes(charset);
    }

    public boolean z() {
        String string2;
        String string3;
        block22: {
            string3 = "PushSelfShowLog";
            string2 = this.r;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) break block22;
            string2 = "msg is null";
            HMSLog.d(string3, string2);
            return false;
        }
        String string4 = this.r;
        string2 = new JSONObject(string4);
        this.g((JSONObject)string2);
        string4 = "msgContent";
        string2 = string2.getJSONObject(string4);
        int n10 = this.e((JSONObject)string2);
        if (n10 == 0) {
            return false;
        }
        string4 = "dispPkgName";
        string4 = string2.optString(string4);
        this.f = string4;
        this.c((JSONObject)string2);
        string4 = "notifyId";
        int n11 = -1;
        n10 = string2.optInt(string4, n11);
        this.B = n10;
        string4 = "data";
        string4 = string2.optString(string4);
        this.C = string4;
        string4 = "analyticInfo";
        string4 = string2.optString(string4);
        this.F = string4;
        try {
            return this.i((JSONObject)string2);
        }
        catch (Exception exception) {
            string2 = exception.toString();
            HMSLog.d(string3, string2);
            return false;
        }
        catch (JSONException jSONException) {
            HMSLog.d(string3, "parse message exception.");
            return false;
        }
    }
}

