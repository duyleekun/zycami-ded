/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package d.r.a.u;

import android.text.TextUtils;
import d.r.a.r.a;
import d.r.a.r.c;
import d.r.a.u.p;
import d.r.a.u.s;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a(String object) {
        String string2 = "MessageConvertUtil";
        a a10 = new a();
        try {
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                object = "notify msg pack to obj is null";
                s.a(string2, (String)object);
                return null;
            }
            JSONArray jSONArray = new JSONArray((String)object);
            int n10 = 0;
            object = null;
            n10 = jSONArray.getInt(0);
            a10.G(n10);
            n10 = 1;
            object = jSONArray.getString(n10);
            a10.I((String)object);
            n10 = 2;
            object = jSONArray.getString(n10);
            a10.H((String)object);
            n10 = 3;
            object = jSONArray.getString(n10);
            a10.v((String)object);
            n10 = 4;
            n10 = jSONArray.getInt(n10);
            a10.A(n10);
            n10 = 5;
            object = jSONArray.getString(n10);
            a10.C((String)object);
            n10 = 6;
            object = jSONArray.getString(n10);
            a10.x((String)object);
            n10 = 7;
            object = jSONArray.getString(n10);
            a10.w((String)object);
            n10 = 8;
            object = jSONArray.getString(n10);
            a10.E((String)object);
            n10 = 9;
            n10 = jSONArray.getInt(n10);
            a10.F(n10);
            n10 = 10;
            n10 = (int)(jSONArray.getBoolean(n10) ? 1 : 0);
            a10.D(n10 != 0);
            n10 = jSONArray.length();
            int n11 = 11;
            if (n10 > n11) {
                object = jSONArray.getString(n11);
                JSONObject jSONObject = new JSONObject((String)object);
                object = p.a(jSONObject);
                a10.B((Map)object);
            }
            if ((n10 = jSONArray.length()) > (n11 = 15)) {
                n10 = 12;
                n10 = jSONArray.getInt(n10);
                a10.P(n10);
                n10 = 13;
                object = jSONArray.getString(n10);
                a10.T((String)object);
                n10 = 14;
                n10 = (int)(jSONArray.getBoolean(n10) ? 1 : 0);
                a10.R(n10 != 0);
                object = jSONArray.getString(n11);
                a10.U((String)object);
            }
            if ((n10 = jSONArray.length()) > (n11 = 16)) {
                n10 = jSONArray.getInt(n11);
                a10.S(n10);
            }
            if ((n10 = jSONArray.length()) > (n11 = 18)) {
                n10 = 17;
                n10 = jSONArray.getInt(n10);
                a10.y(n10);
                object = jSONArray.getString(n11);
                a10.t((String)object);
            }
            if ((n10 = jSONArray.length()) > (n11 = 19)) {
                n10 = jSONArray.getInt(n11);
                a10.u(n10);
            }
            if ((n10 = jSONArray.length()) <= (n11 = 20)) return a10;
            n10 = jSONArray.getInt(n11);
            a10.Q(n10);
            return a10;
        }
        catch (JSONException jSONException) {
            String string3 = "notify msg pack to obj error";
            s.b(string2, string3, jSONException);
        }
        return a10;
    }

    public static c b(a object) {
        c c10 = new c();
        int bl2 = ((c)object).o();
        c10.G(bl2);
        String string2 = ((c)object).q();
        c10.I(string2);
        string2 = ((c)object).p();
        c10.H(string2);
        string2 = ((c)object).e();
        c10.v(string2);
        int n10 = ((c)object).j();
        c10.A(n10);
        string2 = ((c)object).l();
        c10.C(string2);
        string2 = ((c)object).g();
        c10.x(string2);
        string2 = ((c)object).f();
        c10.w(string2);
        string2 = ((c)object).m();
        c10.E(string2);
        int n11 = ((c)object).n();
        c10.F(n11);
        boolean bl3 = ((c)object).s();
        c10.D(bl3);
        long l10 = ((c)object).i();
        c10.z(l10);
        object = ((c)object).k();
        c10.B((Map)object);
        return c10;
    }

    public static String c(a a10) {
        JSONArray jSONArray = new JSONArray();
        int n10 = a10.o();
        jSONArray.put(n10);
        Object object = a10.q();
        jSONArray.put(object);
        object = a10.p();
        jSONArray.put(object);
        object = a10.e();
        jSONArray.put(object);
        n10 = a10.j();
        jSONArray.put(n10);
        object = a10.l();
        jSONArray.put(object);
        object = a10.g();
        jSONArray.put(object);
        object = a10.f();
        jSONArray.put(object);
        object = a10.m();
        jSONArray.put(object);
        n10 = a10.n();
        jSONArray.put(n10);
        n10 = (int)(a10.s() ? 1 : 0);
        jSONArray.put(n10 != 0);
        object = a10.k();
        if (object != null) {
            Map map = a10.k();
            object = new JSONObject(map);
            jSONArray.put(object);
        } else {
            object = "{}";
            jSONArray.put(object);
        }
        n10 = a10.J();
        jSONArray.put(n10);
        object = a10.M();
        jSONArray.put(object);
        n10 = (int)(a10.O() ? 1 : 0);
        jSONArray.put(n10 != 0);
        object = a10.N();
        jSONArray.put(object);
        n10 = a10.L();
        jSONArray.put(n10);
        n10 = a10.h();
        jSONArray.put(n10);
        object = a10.c();
        jSONArray.put(object);
        n10 = a10.d();
        jSONArray.put(n10);
        int n11 = a10.K();
        jSONArray.put(n11);
        return jSONArray.toString();
    }
}

