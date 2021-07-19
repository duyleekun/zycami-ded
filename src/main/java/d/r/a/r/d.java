/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package d.r.a.r;

import android.text.TextUtils;
import d.r.a.u.p;
import d.r.a.u.s;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d {
    private static final String f = "UnvarnishedMessage";
    private int a;
    private String b;
    private String c;
    private Map d;
    private long e;

    public d() {
        HashMap hashMap;
        this.d = hashMap = new HashMap();
    }

    public d(String string2) {
        HashMap hashMap;
        this.d = hashMap = new HashMap();
        this.f(string2);
    }

    private void f(String object) {
        block14: {
            String string2 = f;
            try {
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) break block14;
                object = "unvarnishedMsg pack to obj is null";
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
                s.b(string2, "unvarnishedMsg pack to obj error", jSONException);
                return;
            }
            s.a(string2, (String)object);
            return;
        }
        JSONArray jSONArray = new JSONArray((String)object);
        int n10 = 0;
        object = null;
        n10 = jSONArray.optInt(0);
        this.a = n10;
        n10 = 1;
        object = jSONArray.getString(n10);
        this.b = object;
        n10 = 2;
        object = jSONArray.getString(n10);
        this.c = object;
        n10 = 3;
        object = jSONArray.getString(n10);
        jSONArray = new JSONObject((String)object);
        object = p.a((JSONObject)jSONArray);
        this.d = object;
    }

    public String a() {
        return this.c;
    }

    public long b() {
        return this.e;
    }

    public Map c() {
        return this.d;
    }

    public int d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public void g(String string2) {
        this.c = string2;
    }

    public void h(long l10) {
        this.e = l10;
    }

    public void i(Map map) {
        this.d = map;
    }

    public void j(int n10) {
        this.a = n10;
    }

    public void k(String string2) {
        this.b = string2;
    }

    public String l() {
        JSONArray jSONArray = new JSONArray();
        int n10 = this.a;
        jSONArray.put(n10);
        HashMap hashMap = this.b;
        jSONArray.put((Object)hashMap);
        hashMap = this.c;
        jSONArray.put((Object)hashMap);
        hashMap = this.d;
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        jSONArray.put((Object)hashMap);
        return jSONArray.toString();
    }
}

