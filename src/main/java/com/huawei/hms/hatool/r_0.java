/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.huawei.hms.hatool.c1;
import com.huawei.hms.hatool.o;
import com.huawei.hms.hatool.p;
import com.huawei.hms.hatool.q;
import com.huawei.hms.hatool.r0;
import com.huawei.hms.hatool.s;
import com.huawei.hms.hatool.y;
import d.j.f.a.a.h.b.a;
import d.j.f.a.a.h.f.c;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Renamed from com.huawei.hms.hatool.r
 */
public class r_0
implements s {
    public List a;
    public o b;
    public p c;
    public s d;
    public String e = "";
    public String f;

    public r_0(String string2) {
        this.f = string2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public JSONObject a() {
        block20: {
            var1_1 = "events_global_properties";
            var2_2 = this.a;
            var3_3 = "hmsSdk";
            if (var2_2 == null || (var4_4 = var2_2.size()) == 0) break block20;
            var2_2 = this.b;
            if (var2_2 != null && (var2_2 = this.c) != null && (var2_2 = this.d) != null) {
                block19: {
                    var2_2 = new JSONObject();
                    var5_5 /* !! */  = this.b.a();
                    var2_2.put("header", (Object)var5_5 /* !! */ );
                    var5_5 /* !! */  = new JSONObject();
                    var6_6 = this.d.a();
                    var7_7 /* !! */  = this.c.a();
                    var8_8 = "properties";
                    var6_6.put(var8_8, (Object)var7_7 /* !! */ );
                    var8_8 = this.e;
                    var7_7 /* !! */  = new JSONObject(var8_8);
                    try {
                        var6_6.put((String)var1_1, (Object)var7_7 /* !! */ );
                    }
                    catch (JSONException v0) {
                        var7_7 /* !! */  = this.e;
                        var6_6.put((String)var1_1, (Object)var7_7 /* !! */ );
                    }
                    var5_5 /* !! */ .put("events_common", var6_6);
                    var1_1 = new JSONArray();
                    var6_6 = this.a.iterator();
                    while (var9_9 = var6_6.hasNext()) {
                        var7_7 /* !! */  = ((q)var6_6.next()).a();
                        if (var7_7 /* !! */  != null) {
                            var1_1.put((Object)var7_7 /* !! */ );
                            continue;
                        }
                        var7_7 /* !! */  = "custom event is empty,delete this event";
                        y.e(var3_3, (String)var7_7 /* !! */ );
                    }
                    var6_6 = "events";
                    var5_5 /* !! */ .put((String)var6_6, var1_1);
                    var1_1 = var5_5 /* !! */ .toString();
                    var5_5 /* !! */  = "UTF-8";
                    try {
                        var1_1 = var1_1.getBytes((String)var5_5 /* !! */ );
                    }
                    catch (UnsupportedEncodingException v1) {
                        var1_1 = "getBitZip(): Unsupported coding : utf-8";
lbl51:
                        // 3 sources

                        while (true) {
                            y.e(var3_3, (String)var1_1);
                            return null;
                        }
                    }
                    var1_1 = r0.a((byte[])var1_1);
                    var5_5 /* !! */  = this.f;
                    var5_5 /* !! */  = (JSONObject)d.j.f.a.a.h.f.c.c((String)var5_5 /* !! */ );
                    var1_1 = d.j.f.a.a.h.b.a.x((byte[])var1_1, (byte[])var5_5 /* !! */ );
                    var1_1 = d.j.f.a.a.h.f.c.b((byte[])var1_1);
                    var10_10 = TextUtils.isEmpty((CharSequence)var1_1);
                    if (!var10_10) break block19;
                    var1_1 = "eventInfo encrypt failed,report over!";
                    y.e(var3_3, (String)var1_1);
                    return null;
                }
                var5_5 /* !! */  = "event";
                var2_2.put((String)var5_5 /* !! */ , var1_1);
                return var2_2;
            }
            var1_1 = "model in wrong format";
            ** GOTO lbl51
        }
        var1_1 = "Not have actionEvent to send";
        ** while (true)
    }

    public void a(c1 c12) {
        this.d = c12;
    }

    public void a(o o10) {
        this.b = o10;
    }

    public void a(p p10) {
        this.c = p10;
    }

    public void a(String string2) {
        if (string2 != null) {
            this.e = string2;
        }
    }

    public void a(List list) {
        this.a = list;
    }
}

