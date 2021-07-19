/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONArray
 *  org.json.JSONException
 */
package com.huawei.hms.hatool;

import android.content.Context;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.g0;
import com.huawei.hms.hatool.m0;
import com.huawei.hms.hatool.p0;
import com.huawei.hms.hatool.q;
import com.huawei.hms.hatool.s0;
import com.huawei.hms.hatool.w;
import com.huawei.hms.hatool.y;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class l0
implements m0 {
    public String a;
    public String b;
    public String c;
    public List d;

    public l0(List list, String string2, String string3, String string4) {
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = list;
    }

    public final void a() {
        String string2 = this.a;
        String string3 = this.c;
        String[] stringArray = this.b;
        string2 = s0.a(string2, string3, (String)stringArray);
        string3 = com.huawei.hms.hatool.b.f();
        stringArray = new String[]{string2};
        g0.a((Context)string3, "backup_event", stringArray);
    }

    public void run() {
        int n10;
        Object object = this.d;
        String string2 = "hmsSdk";
        if (object != null && (n10 = object.size()) != 0) {
            int n11;
            Object object2;
            int n12;
            n10 = com.huawei.hms.hatool.b.h();
            Object object3 = com.huawei.hms.hatool.b.f();
            int n13 = 0x100000;
            n10 *= n13;
            String string3 = "cached_v2_1";
            if ((n10 = (int)(p0.a((Context)object3, string3, n10) ? 1 : 0)) != 0) {
                object = new StringBuilder();
                ((StringBuilder)object).append("The cacheFile is full,Can not writing data! reqID:");
                object3 = this.b;
                ((StringBuilder)object).append((String)object3);
                object = ((StringBuilder)object).toString();
                y.e(string2, (String)object);
                return;
            }
            object = this.a;
            object3 = this.c;
            object = s0.a((String)object, (String)object3);
            object3 = (List)w.b(com.huawei.hms.hatool.b.f(), string3, (String)object).get(object);
            if (object3 != null && (n12 = object3.size()) != 0) {
                object2 = this.d;
                object2.addAll(object3);
            }
            object3 = new JSONArray();
            object2 = this.d.iterator();
            while ((n11 = object2.hasNext()) != 0) {
                Object object4 = (q)object2.next();
                object4 = ((q)object4).d();
                try {
                    object3.put(object4);
                }
                catch (JSONException jSONException) {
                    object4 = "event to json error";
                    y.e(string2, (String)object4);
                }
            }
            object3 = object3.toString();
            n12 = com.huawei.hms.hatool.b.e();
            n11 = ((String)object3).length();
            if (n11 > (n12 *= n13)) {
                y.e(string2, "this failed data is too long,can not writing it");
                this.d = null;
                return;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("data send failed, write to cache file...reqID:");
            object2 = this.b;
            charSequence.append((String)object2);
            charSequence = charSequence.toString();
            y.d(string2, (String)charSequence);
            g0.b(com.huawei.hms.hatool.b.f(), string3, (String)object, (String)object3);
            this.a();
            return;
        }
        y.d(string2, "failed events is empty");
    }
}

