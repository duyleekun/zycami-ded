/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.b.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c
extends a {
    public c(Context context, boolean bl2) {
        this.e = bl2;
        String string2 = "grs_sdk_global_route_config.json";
        int n10 = this.a(string2, context, false);
        if (n10 == 0) {
            n10 = 1;
            this.d = n10;
        }
    }

    public int a(String string2) {
        int n10;
        block11: {
            Object object;
            com.huawei.hms.framework.network.grs.local.model.a a10;
            this.a = a10 = new com.huawei.hms.framework.network.grs.local.model.a();
            n10 = -1;
            try {
                object = new JSONObject(string2);
                string2 = "application";
            }
            catch (JSONException jSONException) {
                Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong.", jSONException);
                return n10;
            }
            string2 = object.getJSONObject(string2);
            object = "name";
            object = string2.getString((String)object);
            String string3 = "cacheControl";
            long l10 = string2.getLong(string3);
            Object object2 = "services";
            string2 = string2.getJSONArray((String)object2);
            object2 = this.a;
            ((com.huawei.hms.framework.network.grs.local.model.a)object2).b((String)object);
            object = this.a;
            ((com.huawei.hms.framework.network.grs.local.model.a)object).a(l10);
            if (string2 == null) break block11;
            int n11 = string2.length();
            if (n11 == 0) break block11;
            return 0;
        }
        return n10;
    }

    public List a(JSONArray object, JSONObject jSONObject) {
        int n10;
        object = "countriesOrAreas";
        String string2 = "LocalManagerV1";
        if (jSONObject != null && (n10 = jSONObject.length()) != 0) {
            ArrayList<b> arrayList;
            block30: {
                int n11 = 16;
                arrayList = new ArrayList<b>(n11);
                Iterator iterator2 = jSONObject.keys();
                while (true) {
                    Object object2;
                    int n12;
                    String string3;
                    b b10;
                    Object object3;
                    block32: {
                        block31: {
                            boolean bl2 = iterator2.hasNext();
                            if (!bl2) break block30;
                            object3 = iterator2.next();
                            object3 = (String)object3;
                            b10 = new b();
                            b10.b((String)object3);
                            object3 = jSONObject.getJSONObject(object3);
                            string3 = "name";
                            string3 = object3.getString(string3);
                            b10.c(string3);
                            string3 = "description";
                            string3 = object3.getString(string3);
                            b10.a(string3);
                            string3 = null;
                            n12 = object3.has((String)object);
                            object2 = "countries";
                            if (n12 == 0) break block31;
                            object2 = object;
                        }
                        n12 = object3.has((String)object2);
                        if (n12 == 0) break block32;
                        string3 = object3.getJSONArray((String)object2);
                    }
                    object3 = "current country or area group has not config countries or areas.";
                    Logger.w(string2, object3);
                    object3 = new HashSet(n11);
                    if (string3 == null) break;
                    n12 = string3.length();
                    if (n12 == 0) break;
                    n12 = 0;
                    while (true) {
                        int n13 = string3.length();
                        if (n12 >= n13) break;
                        object2 = string3.get(n12);
                        object2 = (String)object2;
                        object3.add((Object)object2);
                        ++n12;
                        continue;
                        break;
                    }
                    b10.a((Set)object3);
                    arrayList.add(b10);
                    continue;
                    break;
                }
                try {
                    object = new ArrayList();
                    return object;
                }
                catch (JSONException jSONException) {
                    Logger.w(string2, "parse countryGroups failed maybe json style is wrong.", jSONException);
                    ArrayList arrayList2 = new ArrayList();
                    return arrayList2;
                }
            }
            return arrayList;
        }
        object = new ArrayList();
        return object;
    }

    /*
     * Unable to fully structure code
     */
    public int b(String var1_1) {
        block39: {
            block38: {
                block37: {
                    block36: {
                        var2_3 = "countriesOrAreas";
                        var3_4 = "countryOrAreaGroups";
                        var4_5 = "LocalManagerV1";
                        var6_7 = 16;
                        this.b = var5_6 = new ArrayList<E>(var6_7);
                        var7_8 = -1;
                        var8_9 = new JSONObject(var1_1);
                        var9_10 = var8_9.has((String)var3_4);
                        var10_11 = "countryGroups";
                        if (var9_10) break block36;
                        var9_10 = var8_9.has((String)var10_11);
                        if (!var9_10) break block37;
                        var3_4 = var10_11;
                    }
                    var1_1 = var8_9.getJSONObject((String)var3_4);
                    break block38;
                }
                var1_1 = "maybe local config json is wrong because the default countryOrAreaGroups isn't config.";
                Logger.e(var4_5, var1_1);
                var9_10 = false;
                var1_1 = null;
            }
            if (var1_1 == null) {
                return var7_8;
            }
            var11_12 = var1_1.length();
            var8_9 = null;
            if (var11_12 == 0) break block39;
            try {
                var3_4 = var1_1.keys();
            }
lbl111:
            // 29 sources

            catch (JSONException var1_2) {
                Logger.w(var4_5, "parse countrygroup failed maybe json style is wrong.", var1_2);
                return var7_8;
            }
            while (true) {
                block43: {
                    block42: {
                        block41: {
                            block40: {
                                var12_13 = var3_4.hasNext();
                                if (!var12_13) break block39;
                                var10_11 = var3_4.next();
                                ** try [egrp 10[TRYBLOCK] [10 : 154->159)] { 
lbl44:
                                // 2 sources

                                var13_14 = new b();
                                var13_14.b((String)var10_11);
                                var10_11 = var1_1.getJSONObject((String)var10_11);
                                var14_15 = "name";
                                var14_15 = var10_11.getString((String)var14_15);
                                var13_14.c((String)var14_15);
                                var14_15 = "description";
                                var14_15 = var10_11.getString((String)var14_15);
                                var13_14.a((String)var14_15);
                                var15_16 = var10_11.has(var2_3);
                                var16_17 = "countries";
                                if (!var15_16) break block40;
                                var16_17 = var2_3;
                                break block41;
                            }
                            var15_16 = var10_11.has(var16_17);
                            if (!var15_16) break block42;
                        }
                        var10_11 = var10_11.getJSONArray(var16_17);
                        break block43;
                    }
                    var10_11 = "current country or area group has not config countries or areas.";
                    Logger.w(var4_5, var10_11);
                    var12_13 = false;
                    var10_11 = null;
                }
                var14_15 = new HashSet<Object>(var6_7);
                if (var10_11 == null) break;
                var17_18 = var10_11.length();
                if (var17_18 == 0) break;
                var17_18 = 0;
                var16_17 = null;
                while (true) {
                    var18_19 = var10_11.length();
                    if (var17_18 >= var18_19) break;
                    var19_20 = var10_11.get(var17_18);
                    var19_20 = (String)var19_20;
                    var14_15.add(var19_20);
                    ++var17_18;
                    continue;
                    break;
                }
                var13_14.a(var14_15);
                var10_11 = this.b;
                var10_11.add(var13_14);
                continue;
                break;
            }
            return var7_8;
        }
        return 0;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public int e(String var1_1) {
        var2_2 = this;
        var3_3 = "countryOrAreaGroup";
        var4_5 = "countryGroups";
        var5_6 = "countryOrAreaGroups";
        var6_7 = "LocalManagerV1";
        var8_9 = var1_1;
        var7_8 /* !! */  = new JSONObject(var1_1);
        var8_9 = "services";
        var7_8 /* !! */  = var7_8 /* !! */ .getJSONObject((String)var8_9);
        try {
            var8_9 = var7_8 /* !! */ .keys();
        }
        catch (JSONException var3_4) {
            Logger.w(var6_7, "parse 1.0 services failed maybe because of json style.please check!", var3_4);
            return -1;
        }
        while (true) {
            block59: {
                block58: {
                    block57: {
                        block56: {
                            var9_10 = var8_9.hasNext();
                            var10_11 = 0;
                            if (!var9_10) break;
                            var11_12 /* !! */  = var8_9.next();
                            var11_12 /* !! */  = (String)var11_12 /* !! */ ;
                            var12_13 = new com.huawei.hms.framework.network.grs.local.model.c();
                            var12_13.b((String)var11_12 /* !! */ );
                            var13_14 = var2_2.f;
                            var14_15 = var13_14.contains(var11_12 /* !! */ );
                            if (var14_15) continue;
                            var13_14 = var2_2.f;
                            var13_14.add(var11_12 /* !! */ );
                            var14_15 = var2_2.e;
                            if (!var14_15) continue;
                            var13_14 = var7_8 /* !! */ .getJSONObject(var11_12 /* !! */ );
                            var15_16 = "routeBy";
                            var15_16 = var13_14.getString(var15_16);
                            var12_13.c(var15_16);
                            var15_16 = "servings";
                            var15_16 = var13_14.getJSONArray(var15_16);
                            while (true) {
                                block55: {
                                    block54: {
                                        block53: {
                                            block52: {
                                                var16_17 = var15_16.length();
                                                if (var10_11 >= var16_17) break;
                                                var17_18 = var15_16.get(var10_11);
                                                var17_18 = (JSONObject)var17_18;
                                                var18_19 = new d();
                                                var19_20 = var17_18.has((String)var3_3);
                                                var20_21 = "countryGroup";
                                                if (!var19_20) break block52;
                                                var20_21 = var3_3;
                                                break block53;
                                            }
                                            var19_20 = var17_18.has((String)var20_21);
                                            if (!var19_20) break block54;
                                        }
                                        var21_22 = var17_18.getString((String)var20_21);
                                        break block55;
                                    }
                                    var21_22 = "maybe this service routeBy is unconditional.";
                                    Logger.v(var6_7, var21_22);
                                    var21_22 = "no-country";
                                }
                                var18_19.a((String)var21_22);
                                var21_22 = "addresses";
                                var17_18 = var17_18.getJSONObject((String)var21_22);
                                var22_23 = 16;
                                var21_22 = new HashMap<Object, JSONObject>(var22_23);
                                var20_21 = var17_18.keys();
                                while (true) {
                                    var23_24 = var20_21.hasNext();
                                    if (!var23_24) break;
                                    var24_25 = var20_21.next();
                                    var25_26 = var3_3;
                                    var3_3 = var24_25;
                                    var3_3 = (String)var24_25;
                                    var1_1 = var7_8 /* !! */ ;
                                    var7_8 /* !! */  = var17_18.getString((String)var3_3);
                                    var21_22.put(var3_3, var7_8 /* !! */ );
                                    var7_8 /* !! */  = var1_1;
                                    var3_3 = var25_26;
                                    continue;
                                    break;
                                }
                                var25_26 = var3_3;
                                var1_1 = var7_8 /* !! */ ;
                                var18_19.a(var21_22);
                                var3_3 = var18_19.b();
                                var12_13.a((String)var3_3, var18_19);
                                ++var10_11;
                                var3_3 = var25_26;
                                continue;
                                break;
                            }
                            var25_26 = var3_3;
                            var1_1 = var7_8 /* !! */ ;
                            var26_27 = var13_14.has(var5_6);
                            var7_8 /* !! */  = null;
                            if (!var26_27) break block56;
                            var3_3 = var13_14.getJSONObject(var5_6);
                            break block57;
                        }
                        var26_27 = var13_14.has(var4_5);
                        if (!var26_27) break block58;
                        var3_3 = var13_14.getJSONObject(var4_5);
                    }
                    var7_8 /* !! */  = var2_2.a(null, (JSONObject)var3_3);
                    break block59;
                }
                var3_3 = "service use default countryOrAreaGroup";
                Logger.v(var6_7, var3_3);
            }
            var12_13.a((List)var7_8 /* !! */ );
            var3_3 = var2_2.a;
            if (var3_3 != null) ** GOTO lbl148
            var3_3 = new com.huawei.hms.framework.network.grs.local.model.a();
            var2_2.a = var3_3;
lbl148:
            // 2 sources

            var3_3 = var2_2.a;
            var3_3.a((String)var11_12 /* !! */ , var12_13);
            var7_8 /* !! */  = var1_1;
            var3_3 = var25_26;
            continue;
            break;
        }
        return 0;
    }
}

