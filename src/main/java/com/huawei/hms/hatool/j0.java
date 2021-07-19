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
package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.hatool.a;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.c;
import com.huawei.hms.hatool.e0;
import com.huawei.hms.hatool.f0;
import com.huawei.hms.hatool.g0;
import com.huawei.hms.hatool.h0;
import com.huawei.hms.hatool.m0;
import com.huawei.hms.hatool.p0;
import com.huawei.hms.hatool.q;
import com.huawei.hms.hatool.s0;
import com.huawei.hms.hatool.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class j0
implements m0 {
    public Context a;
    public String b;
    public JSONObject c;
    public String d;
    public String e;
    public String f;
    public String g;
    public Boolean h;

    public j0(String object, JSONObject object2, String string2, String string3, long l10) {
        Context context;
        this.a = context = com.huawei.hms.hatool.b.f();
        this.b = object;
        this.c = object2;
        this.d = string2;
        this.e = string3;
        object = String.valueOf(l10);
        this.f = object;
        object = "oper";
        boolean bl2 = com.huawei.hms.hatool.a.i(string2, (String)object);
        if (bl2) {
            object = e0.a().a(string2, l10);
            object2 = ((f0)object).a();
            this.g = object2;
            bl2 = ((f0)object).b();
            this.h = object = Boolean.valueOf(bl2);
        }
    }

    public void run() {
        String string2;
        Object object;
        String string3;
        String string4;
        String string5;
        Object object2;
        Object object3;
        block9: {
            object3 = "hmsSdk";
            object2 = "Begin to run EventRecordTask...";
            y.c((String)object3, (String)object2);
            int n10 = com.huawei.hms.hatool.b.e();
            string5 = this.d;
            string4 = this.e;
            int n11 = com.huawei.hms.hatool.c.k(string5, string4);
            string4 = this.a;
            int n12 = 0x100000;
            n10 *= n12;
            string3 = "stat_v2_1";
            n10 = (int)(p0.a((Context)string4, string3, n10) ? 1 : 0);
            string4 = "";
            if (n10 != 0) {
                y.c((String)object3, "stat sp file reach max limited size, discard new event");
                h0.a().a(string4, "alltype");
                return;
            }
            object2 = new q();
            object = this.b;
            ((q)object2).b((String)object);
            object = this.c.toString();
            ((q)object2).a((String)object);
            object = this.e;
            ((q)object2).d((String)object);
            object = this.f;
            ((q)object2).c((String)object);
            object = this.g;
            ((q)object2).f((String)object);
            object = this.h;
            object = object == null ? null : String.valueOf(object);
            ((q)object2).e((String)object);
            try {
                object2 = ((q)object2).d();
                object = this.d;
                string2 = this.e;
            }
            catch (JSONException jSONException) {
                y.e((String)object3, "eventRecord toJson error! The record failed.");
                return;
            }
            object = s0.a((String)object, string2);
            string2 = this.a;
            string4 = g0.a((Context)string2, string3, (String)object, string4);
            boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
            if (bl2) break block9;
            string2 = new JSONArray(string4);
        }
        try {
            string2 = new JSONArray();
        }
        catch (JSONException jSONException) {
            string4 = "Cached data corrupted: stat_v2_1";
            y.d((String)object3, string4);
            string2 = new JSONArray();
        }
        string2.put(object2);
        object3 = this.a;
        object2 = string2.toString();
        g0.b((Context)object3, string3, (String)object, (String)object2);
        object3 = string2.toString();
        int n13 = ((String)object3).length();
        if (n13 > (n11 *= 1024)) {
            object3 = h0.a();
            object2 = this.d;
            string5 = this.e;
            ((h0)object3).a((String)object2, string5);
        }
    }
}

