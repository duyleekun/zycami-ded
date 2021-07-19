/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package d.s.a;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class e
implements Cloneable {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private HashMap i;

    public e() {
        HashMap hashMap = "";
        this.b = hashMap;
        this.c = hashMap;
        this.d = hashMap;
        this.e = hashMap;
        this.f = hashMap;
        this.g = hashMap;
        this.h = hashMap;
        this.i = hashMap = new HashMap();
    }

    private String t(String string2) {
        String string3 = "utf-8";
        try {
            return URLEncoder.encode(string2, string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return "";
        }
    }

    public void a(String string2, String string3) {
        this.i.put(string2, string3);
    }

    public String b(boolean bl2) {
        if (bl2) {
            String string2 = this.b;
            return this.t(string2);
        }
        return this.b;
    }

    public Context c() {
        return this.a;
    }

    public Object clone() {
        Object object = super.clone();
        object = (e)object;
        HashMap hashMap = new HashMap();
        Iterator iterator2 = ((e)object).i;
        iterator2 = ((HashMap)((Object)iterator2)).entrySet();
        iterator2 = iterator2.iterator();
        while (true) {
            boolean bl2 = iterator2.hasNext();
            if (!bl2) break;
            Object object2 = iterator2.next();
            object2 = (Map.Entry)object2;
            Object k10 = object2.getKey();
            object2 = object2.getValue();
            hashMap.put(k10, object2);
            continue;
            break;
        }
        try {
            ((e)object).i = hashMap;
            return object;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public String d(boolean bl2) {
        boolean bl3;
        HashMap hashMap = this.i;
        boolean bl4 = hashMap.isEmpty();
        String string2 = "";
        if (bl4) {
            return string2;
        }
        hashMap = new JSONObject();
        Iterator iterator2 = this.i.entrySet().iterator();
        while (bl3 = iterator2.hasNext()) {
            Object object;
            Map.Entry entry = iterator2.next();
            try {
                object = entry.getKey();
            }
            catch (JSONException jSONException) {
                return string2;
            }
            object = (String)object;
            entry = entry.getValue();
            hashMap.put((String)object, entry);
        }
        if (bl2) {
            String string3 = hashMap.toString();
            return this.t(string3);
        }
        return hashMap.toString();
    }

    public String e(boolean bl2) {
        if (bl2) {
            String string2 = this.d;
            return this.t(string2);
        }
        return this.d;
    }

    public String f(boolean bl2) {
        if (bl2) {
            String string2 = this.f;
            return this.t(string2);
        }
        return this.f;
    }

    public String g() {
        return this.h;
    }

    public String i(boolean bl2) {
        if (bl2) {
            String string2 = this.c;
            return this.t(string2);
        }
        return this.c;
    }

    public String j(boolean bl2) {
        if (bl2) {
            String string2 = this.g;
            return this.t(string2);
        }
        return this.g;
    }

    public String k(boolean bl2) {
        if (bl2) {
            String string2 = this.e;
            return this.t(string2);
        }
        return this.e;
    }

    public void l(String string2) {
        this.b = string2;
    }

    public void m(Context context) {
        this.a = context = context.getApplicationContext();
    }

    public void n(String string2) {
        this.d = string2;
    }

    public void o(String string2) {
        this.f = string2;
    }

    public void p(String string2) {
        this.h = string2;
    }

    public void q(String string2) {
        this.c = string2;
    }

    public void r(String string2) {
        this.g = string2;
    }

    public void s(String string2) {
        this.e = string2;
    }

    public boolean u() {
        boolean bl2;
        Object object = this.a;
        return object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.b))) && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.d))) && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.e)));
    }
}

