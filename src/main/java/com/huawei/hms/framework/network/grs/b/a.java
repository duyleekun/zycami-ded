/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b.f;
import com.huawei.hms.framework.network.grs.d.c;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a {
    public com.huawei.hms.framework.network.grs.local.model.a a;
    public List b;
    public Map c;
    public boolean d;
    public boolean e;
    public Set f;

    public a() {
        Serializable serializable;
        int n10 = 16;
        this.c = serializable = new Serializable(n10);
        this.d = false;
        this.e = false;
        super(n10);
        this.f = serializable;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int a(Context object) {
        String string2 = "AbstractLocalManager";
        String[] stringArray = object.getAssets();
        String string3 = "";
        int n10 = -1;
        stringArray = stringArray.list(string3);
        if (stringArray == null) return n10;
        int n11 = stringArray.length;
        if (n11 <= 0) return n10;
        n11 = stringArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            String string4;
            String string5;
            try {
                string5 = stringArray[i10];
                string4 = "^grs_sdk_global_route_config_[a-zA-Z]+\\.json$";
            }
            catch (IOException iOException) {
                String string6 = "list assets files fail,please check if according to our standard config json files.";
                Logger.w(string2, string6);
                return n10;
            }
            boolean bl2 = Pattern.matches(string4, string5);
            if (!bl2) continue;
            string5 = com.huawei.hms.framework.network.grs.d.c.a(string5, object);
            int n12 = this.g(string5);
            if (n12 != 0) continue;
            string5 = "load SDK_CONFIG_FILE sucess.";
            Logger.i(string2, string5);
            n10 = 0;
        }
        return n10;
    }

    private int a(String string2, Context object) {
        int n10 = this.f(string2 = com.huawei.hms.framework.network.grs.d.c.a(string2, object));
        if (n10 == 0) {
            object = "load APP_CONFIG_FILE success.";
            Logger.i("AbstractLocalManager", object);
            n10 = 0;
            string2 = null;
        } else {
            n10 = -1;
        }
        return n10;
    }

    private Map a(List object, GrsBaseInfo grsBaseInfo, String string2) {
        int n10 = 16;
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<Object, Object>(n10);
        Object object2 = "no_route_country";
        Object object3 = "no-country";
        concurrentHashMap.put(object2, object3);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            String string3;
            object2 = (b)object.next();
            object3 = ((b)object2).a();
            boolean bl2 = object3.contains(string3 = grsBaseInfo.getIssueCountry());
            if (bl2) {
                object3 = grsBaseInfo.getIssueCountry();
                string3 = ((b)object2).b();
                concurrentHashMap.put(object3, string3);
            }
            if (bl2 = (object3 = ((b)object2).a()).contains(string3 = grsBaseInfo.getRegCountry())) {
                object3 = grsBaseInfo.getRegCountry();
                string3 = ((b)object2).b();
                concurrentHashMap.put(object3, string3);
            }
            if (bl2 = (object3 = ((b)object2).a()).contains(string3 = grsBaseInfo.getSerCountry())) {
                object3 = grsBaseInfo.getSerCountry();
                string3 = ((b)object2).b();
                concurrentHashMap.put(object3, string3);
            }
            if (!(bl2 = (object3 = ((b)object2).a()).contains(string2))) continue;
            object3 = "AbstractLocalManager";
            string3 = "get countryGroupID from geoIp";
            Logger.v((String)object3, string3);
            object2 = ((b)object2).b();
            concurrentHashMap.put(string2, object2);
        }
        return concurrentHashMap;
    }

    private int f(String string2) {
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            return -1;
        }
        n10 = this.e;
        if (n10 != 0 && (n10 = this.b(string2)) != 0) {
            return n10;
        }
        n10 = this.a(string2);
        if (n10 != 0) {
            return n10;
        }
        return this.e(string2);
    }

    private int g(String string2) {
        List list;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 != 0) {
            return -1;
        }
        n10 = this.e;
        if (n10 != 0 && ((list = this.b) == null || (n10 = list.isEmpty()) != 0) && (n10 = this.c(string2)) != 0) {
            return n10;
        }
        return this.d(string2);
    }

    public abstract int a(String var1);

    public int a(String string2, Context context, boolean bl2) {
        int n10 = this.a(string2, context);
        if (n10 != 0 && bl2) {
            return -1;
        }
        this.a(context);
        return 0;
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.a;
    }

    public String a(Context objectArray, com.huawei.hms.framework.network.grs.a.a a10, GrsBaseInfo grsBaseInfo, String string2, String string3, boolean bl2) {
        if ((objectArray = this.a((Context)objectArray, a10, grsBaseInfo, string2, bl2)) == null) {
            objectArray = new Object[]{string2};
            Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", objectArray);
            return null;
        }
        return (String)objectArray.get(string3);
    }

    public List a(JSONArray object) {
        int n10;
        String string2 = "countriesOrAreas";
        String string3 = "AbstractLocalManager";
        if (object != null && (n10 = object.length()) != 0) {
            ArrayList<b> arrayList;
            block30: {
                int n11 = 16;
                arrayList = new ArrayList<b>(n11);
                int n12 = 0;
                while (true) {
                    Object object2;
                    int n13;
                    String string4;
                    b b10;
                    Object object3;
                    block32: {
                        block31: {
                            int n14 = object.length();
                            if (n12 >= n14) break block30;
                            object3 = object.getJSONObject(n12);
                            b10 = new b();
                            string4 = "id";
                            string4 = object3.getString(string4);
                            b10.b(string4);
                            string4 = "name";
                            string4 = object3.getString(string4);
                            b10.c(string4);
                            string4 = "description";
                            string4 = object3.getString(string4);
                            b10.a(string4);
                            string4 = null;
                            n13 = object3.has(string2);
                            object2 = "countries";
                            if (n13 == 0) break block31;
                            object2 = string2;
                        }
                        n13 = object3.has((String)object2);
                        if (n13 == 0) break block32;
                        string4 = object3.getJSONArray((String)object2);
                    }
                    object3 = "current country or area group has not config countries or areas.";
                    Logger.w(string3, object3);
                    object3 = new HashSet(n11);
                    if (string4 == null) break;
                    n13 = string4.length();
                    if (n13 == 0) break;
                    n13 = 0;
                    while (true) {
                        int n15 = string4.length();
                        if (n13 >= n15) break;
                        object2 = string4.get(n13);
                        object2 = (String)object2;
                        object3.add(object2);
                        ++n13;
                        continue;
                        break;
                    }
                    b10.a((Set)object3);
                    arrayList.add(b10);
                    ++n12;
                    continue;
                    break;
                }
                try {
                    object = new ArrayList();
                    return object;
                }
                catch (JSONException jSONException) {
                    Logger.w(string3, "parse countrygroup failed maybe json style is wrong.", jSONException);
                    ArrayList arrayList2 = new ArrayList();
                    return arrayList2;
                }
            }
            return arrayList;
        }
        object = new ArrayList();
        return object;
    }

    public Map a(Context object, com.huawei.hms.framework.network.grs.a.a object2, GrsBaseInfo grsBaseInfo, String string2, boolean bl2) {
        int n10;
        boolean bl3 = this.d;
        if (!bl3) {
            return null;
        }
        Object object3 = this.a;
        String string3 = "AbstractLocalManager";
        if (object3 == null) {
            Logger.w(string3, "application data is null.");
            return null;
        }
        object3 = ((com.huawei.hms.framework.network.grs.local.model.a)object3).a(string2);
        int n11 = 1;
        if (object3 == null) {
            object = new Object[n11];
            object[0] = string2;
            Logger.w(string3, "service not found in local config{%s}", (Object[])object);
            return null;
        }
        string2 = ((com.huawei.hms.framework.network.grs.local.model.c)object3).b();
        if ((object = com.huawei.hms.framework.network.grs.b.f.a((Context)object, (com.huawei.hms.framework.network.grs.a.a)object2, string2, grsBaseInfo, bl2)) == null) {
            object = new Object[n11];
            object[0] = object2 = ((com.huawei.hms.framework.network.grs.local.model.c)object3).b();
            Logger.w(string3, "country not found by routeby in local config{%s}", (Object[])object);
            return null;
        }
        object2 = ((com.huawei.hms.framework.network.grs.local.model.c)object3).a();
        object2 = object2 != null && (n10 = object2.size()) != 0 ? this.a((List)object2, grsBaseInfo, (String)object) : this.c;
        object = (String)object2.get(object);
        if ((object = ((com.huawei.hms.framework.network.grs.local.model.c)object3).a((String)object)) == null) {
            return null;
        }
        return ((d)object).a();
    }

    public void a(GrsBaseInfo grsBaseInfo) {
        boolean bl2;
        Iterator iterator2 = this.c;
        Object object = "no_route_country";
        Object object2 = "no-country";
        iterator2.put(object, object2);
        iterator2 = this.b;
        if (iterator2 != null && !(bl2 = iterator2.isEmpty())) {
            boolean bl3;
            iterator2 = this.b.iterator();
            while (bl3 = iterator2.hasNext()) {
                String string2;
                String string3;
                object = (b)iterator2.next();
                object2 = ((b)object).a();
                boolean bl4 = object2.contains(string3 = grsBaseInfo.getIssueCountry());
                if (bl4) {
                    object2 = this.c;
                    string3 = grsBaseInfo.getIssueCountry();
                    string2 = ((b)object).b();
                    object2.put(string3, string2);
                }
                if (bl4 = (object2 = ((b)object).a()).contains(string3 = grsBaseInfo.getRegCountry())) {
                    object2 = this.c;
                    string3 = grsBaseInfo.getRegCountry();
                    string2 = ((b)object).b();
                    object2.put(string3, string2);
                }
                if (!(bl4 = (object2 = ((b)object).a()).contains(string3 = grsBaseInfo.getSerCountry()))) continue;
                object2 = this.c;
                string3 = grsBaseInfo.getSerCountry();
                object = ((b)object).b();
                object2.put(string3, object);
            }
            grsBaseInfo = null;
            this.b = null;
        }
    }

    public abstract int b(String var1);

    public Set b() {
        return this.f;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void b(JSONArray jSONArray) {
        int n10;
        if (jSONArray == null) return;
        int n11 = jSONArray.length();
        if (n11 == 0) {
            return;
        }
        n11 = 0;
        int n12 = 0;
        while (n12 < (n10 = jSONArray.length())) {
            Object object = jSONArray.getJSONObject(n12);
            com.huawei.hms.framework.network.grs.local.model.c c10 = new com.huawei.hms.framework.network.grs.local.model.c();
            String string2 = object.getString("name");
            c10.b(string2);
            Object object2 = this.f;
            boolean bl2 = object2.contains(string2);
            if (!bl2) {
                object2 = this.f;
                object2.add(string2);
                bl2 = this.e;
                if (bl2) {
                    HashMap<String, String> hashMap;
                    int n13;
                    object2 = object.getString("routeBy");
                    c10.c((String)object2);
                    object2 = object.getJSONArray("servings");
                    int n14 = 0;
                    String string3 = null;
                    while (true) {
                        n13 = object2.length();
                        hashMap = "AbstractLocalManager";
                        if (n14 >= n13) break;
                        JSONObject jSONObject = (JSONObject)object2.get(n14);
                        d d10 = new d();
                        Object object3 = "countryOrAreaGroup";
                        boolean bl3 = jSONObject.has((String)object3);
                        if (bl3 || (bl3 = jSONObject.has((String)(object3 = "countryGroup")))) {
                            hashMap = jSONObject.getString((String)object3);
                        } else {
                            object3 = "maybe this service routeBy is unconditional.";
                            Logger.v((String)((Object)hashMap), object3);
                            hashMap = "no-country";
                        }
                        d10.a((String)((Object)hashMap));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("addresses");
                        int n15 = 16;
                        hashMap = new HashMap<String, String>(n15);
                        object3 = jSONObject2.keys();
                        while (bl3 = object3.hasNext()) {
                            String string4 = (String)object3.next();
                            String string5 = jSONObject2.getString(string4);
                            hashMap.put(string4, string5);
                        }
                        d10.a(hashMap);
                        String string6 = d10.b();
                        c10.a(string6, d10);
                        ++n14;
                    }
                    bl2 = false;
                    object2 = null;
                    string3 = "countryOrAreaGroups";
                    n13 = (int)(object.has(string3) ? 1 : 0);
                    if (n13 != 0 || (n13 = (int)(object.has(string3 = "countryGroups") ? 1 : 0)) != 0) {
                        object = object.getJSONArray(string3);
                        object2 = this.a((JSONArray)object);
                    } else {
                        object = "service use default countryOrAreaGroup";
                        Logger.i((String)((Object)hashMap), object);
                    }
                    c10.a((List)object2);
                    object = this.a;
                    if (object == null) {
                        object = new com.huawei.hms.framework.network.grs.local.model.a();
                        this.a = object;
                    }
                    object = this.a;
                    ((com.huawei.hms.framework.network.grs.local.model.a)object).a(string2, c10);
                }
            }
            ++n12;
        }
    }

    public int c(String object) {
        int n10;
        Object object2;
        block13: {
            String string2;
            block12: {
                JSONObject jSONObject;
                block11: {
                    ArrayList arrayList;
                    object2 = "countryOrAreaGroups";
                    string2 = "AbstractLocalManager";
                    int n11 = 16;
                    this.b = arrayList = new ArrayList(n11);
                    n10 = -1;
                    try {
                        jSONObject = new JSONObject((String)object);
                        object = null;
                    }
                    catch (JSONException jSONException) {
                        Logger.w(string2, "parse countrygroup failed maybe json style is wrong.", jSONException);
                        return n10;
                    }
                    boolean bl2 = jSONObject.has((String)object2);
                    String string3 = "countryGroups";
                    if (bl2) break block11;
                    boolean bl3 = jSONObject.has(string3);
                    if (!bl3) break block12;
                    object2 = string3;
                }
                object = jSONObject.getJSONArray((String)object2);
                break block13;
            }
            object2 = "maybe local config json is wrong because the default countryOrAreaGroups isn't config.";
            Logger.e(string2, object2);
        }
        if (object == null) {
            return n10;
        }
        object2 = this.b;
        object = this.a((JSONArray)object);
        object2.addAll(object);
        return 0;
    }

    public boolean c() {
        return this.d;
    }

    public int d(String string2) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(string2);
            string2 = "services";
        }
        catch (JSONException jSONException) {
            Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check!", jSONException);
            return -1;
        }
        string2 = jSONObject.getJSONArray(string2);
        this.b((JSONArray)string2);
        return 0;
    }

    public abstract int e(String var1);
}

