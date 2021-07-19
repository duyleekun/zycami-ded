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
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.b.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
extends a {
    public d(Context context, boolean bl2) {
        int n10;
        this.e = bl2;
        String string2 = GrsApp.getInstance().getAppConfigName();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("appConfigName is");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        String string3 = "LocalManagerV2";
        Logger.i(string3, charSequence);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (bl3) {
            string2 = "grs_app_global_route_config.json";
        }
        if ((n10 = this.a(string2, context, bl3 = true)) == 0) {
            this.d = bl3;
        }
    }

    public int a(String string2) {
        int n10;
        block13: {
            block14: {
                JSONObject jSONObject;
                com.huawei.hms.framework.network.grs.local.model.a a10;
                String string3 = "customservices";
                this.a = a10 = new com.huawei.hms.framework.network.grs.local.model.a();
                n10 = -1;
                try {
                    jSONObject = new JSONObject(string2);
                    string2 = "applications";
                }
                catch (JSONException jSONException) {
                    Logger.w("LocalManagerV2", "parse appbean failed maybe json style is wrong.", jSONException);
                    return n10;
                }
                string2 = jSONObject.getJSONArray(string2);
                jSONObject = null;
                string2 = string2.getJSONObject(0);
                String string4 = "name";
                string4 = string2.getString(string4);
                com.huawei.hms.framework.network.grs.local.model.a a11 = this.a;
                a11.b(string4);
                string4 = "services";
                string4 = string2.getJSONArray(string4);
                if (string4 == null) break block13;
                int n11 = string4.length();
                if (n11 == 0) break block13;
                n11 = (int)(string2.has(string3) ? 1 : 0);
                if (n11 == 0) break block14;
                string2 = string2.getJSONArray(string3);
                this.b((JSONArray)string2);
            }
            return 0;
        }
        return n10;
    }

    public int b(String string2) {
        block37: {
            int n10;
            Object object;
            JSONObject jSONObject;
            int n11;
            int n12;
            String string3;
            String string4;
            String string5;
            block36: {
                boolean bl2;
                block35: {
                    block34: {
                        ArrayList arrayList;
                        string5 = "countriesOrAreas";
                        string4 = "countryOrAreaGroups";
                        string3 = "LocalManagerV2";
                        n12 = 16;
                        this.b = arrayList = new ArrayList(n12);
                        n11 = -1;
                        jSONObject = new JSONObject(string2);
                        bl2 = jSONObject.has(string4);
                        object = "countryGroups";
                        if (bl2) break block34;
                        bl2 = jSONObject.has((String)object);
                        if (!bl2) break block35;
                        string4 = object;
                    }
                    string2 = jSONObject.getJSONArray(string4);
                    break block36;
                }
                string2 = "maybe local config json is wrong because the default countryOrAreaGroups isn't config.";
                Logger.e(string3, string2);
                bl2 = false;
                string2 = null;
            }
            if (string2 == null) {
                return n11;
            }
            try {
                n10 = string2.length();
                jSONObject = null;
                if (n10 == 0) break block37;
                n10 = 0;
                string4 = null;
            }
            catch (JSONException jSONException) {
                Logger.w(string3, "parse countrygroup failed maybe json style is wrong.", jSONException);
                return n11;
            }
            while (true) {
                String string6;
                HashSet<Object> hashSet;
                b b10;
                block41: {
                    int n13;
                    block40: {
                        block39: {
                            boolean bl3;
                            block38: {
                                n13 = string2.length();
                                if (n10 >= n13) break block37;
                                object = string2.getJSONObject(n10);
                                b10 = new b();
                                hashSet = "id";
                                hashSet = object.getString((String)((Object)hashSet));
                                b10.b((String)((Object)hashSet));
                                hashSet = "name";
                                hashSet = object.getString((String)((Object)hashSet));
                                b10.c((String)((Object)hashSet));
                                hashSet = "description";
                                hashSet = object.getString((String)((Object)hashSet));
                                b10.a((String)((Object)hashSet));
                                bl3 = object.has(string5);
                                string6 = "countries";
                                if (!bl3) break block38;
                                string6 = string5;
                                break block39;
                            }
                            bl3 = object.has(string6);
                            if (!bl3) break block40;
                        }
                        object = object.getJSONArray(string6);
                        break block41;
                    }
                    object = "current country or area group has not config countries or areas.";
                    Logger.w(string3, object);
                    n13 = 0;
                    object = null;
                }
                hashSet = new HashSet<Object>(n12);
                if (object == null) break;
                int n14 = object.length();
                if (n14 == 0) break;
                n14 = 0;
                string6 = null;
                while (true) {
                    int n15 = object.length();
                    if (n14 >= n15) break;
                    Object object2 = object.get(n14);
                    object2 = (String)object2;
                    hashSet.add(object2);
                    ++n14;
                    continue;
                    break;
                }
                b10.a(hashSet);
                object = this.b;
                object.add(b10);
                ++n10;
                continue;
                break;
            }
            return n11;
        }
        return 0;
    }

    public int e(String string2) {
        return this.d(string2);
    }
}

