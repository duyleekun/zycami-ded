/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package d.i.a.a.c;

import android.text.TextUtils;
import com.heytap.mcssdk.f.c;
import org.json.JSONObject;

public class d {
    private static final String h = "globalID";
    private static final String i = "taskID";
    private static final String j = "appPackage";
    private static final String k = "eventID";
    private static final String l = "property";
    private static final String m = "messageType";
    private static final String n = "eventTime";
    private int a = 4096;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private long g;

    public d() {
        long l10;
        this.g = l10 = System.currentTimeMillis();
    }

    public d(int n10, String string2, String string3, String string4) {
        this(n10, string2, null, null, string3, string4);
    }

    public d(int n10, String string2, String string3, String string4, String string5, String string6) {
        long l10;
        this.g = l10 = System.currentTimeMillis();
        this.p(n10);
        this.i(string2);
        this.l(string3);
        this.o(string4);
        this.j(string5);
        this.m(string6);
    }

    public d(String string2, String string3) {
        this(4096, string2, null, null, string3, "");
    }

    public d(String string2, String string3, String string4) {
        this(4096, string2, null, null, string3, string4);
    }

    public static d h(String string2) {
        JSONObject jSONObject;
        String string3 = "";
        d d10 = new d();
        try {
            jSONObject = new JSONObject(string2);
            string2 = m;
        }
        catch (Exception exception) {
            com.heytap.mcssdk.f.c.e(exception.getLocalizedMessage());
            return null;
        }
        int n10 = jSONObject.optInt(string2, 0);
        d10.p(n10);
        string2 = j;
        string2 = jSONObject.optString(string2);
        d10.i(string2);
        string2 = k;
        string2 = jSONObject.optString(string2);
        d10.j(string2);
        string2 = h;
        string2 = jSONObject.optString(string2, string3);
        d10.l(string2);
        string2 = i;
        string2 = jSONObject.optString(string2, string3);
        d10.o(string2);
        string2 = l;
        string2 = jSONObject.optString(string2, string3);
        d10.m(string2);
        string2 = n;
        long l10 = System.currentTimeMillis();
        long l11 = jSONObject.optLong(string2, l10);
        d10.k(l11);
        return d10;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public long c() {
        return this.g;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.e;
    }

    public int g() {
        return this.a;
    }

    public void i(String string2) {
        this.b = string2;
    }

    public void j(String string2) {
        this.c = string2;
    }

    public void k(long l10) {
        this.g = l10;
    }

    public void l(String string2) {
        this.d = string2;
    }

    public void m(String string2) {
        this.f = string2;
    }

    public void n(int n10) {
        String string2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        stringBuilder.append("");
        this.e = string2 = stringBuilder.toString();
    }

    public void o(String string2) {
        this.e = string2;
    }

    public void p(int n10) {
        this.a = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String q() {
        JSONObject jSONObject = new JSONObject();
        String string2 = m;
        try {
            int n10 = this.a;
            Object object = n10;
            jSONObject.putOpt(string2, object);
            string2 = k;
            object = this.c;
            jSONObject.putOpt(string2, object);
            string2 = j;
            object = this.b;
            jSONObject.putOpt(string2, object);
            string2 = n;
            long l10 = this.g;
            object = l10;
            jSONObject.putOpt(string2, object);
            string2 = this.d;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                string2 = h;
                object = this.d;
                jSONObject.putOpt(string2, object);
            }
            if (!(bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.e)))) {
                string2 = i;
                object = this.e;
                jSONObject.putOpt(string2, object);
            }
            if (bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.f))) return jSONObject.toString();
            string2 = l;
            object = this.f;
            jSONObject.putOpt(string2, object);
            return jSONObject.toString();
        }
        catch (Exception exception) {
            string2 = exception.getLocalizedMessage();
            com.heytap.mcssdk.f.c.e(string2);
        }
        return jSONObject.toString();
    }
}

