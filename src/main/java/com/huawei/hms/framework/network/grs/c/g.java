/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.network.grs.c.b.a;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.h;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ JSONArray d;

    public g(long l10, Context context, ArrayList arrayList, JSONArray jSONArray) {
        this.a = l10;
        this.b = context;
        this.c = arrayList;
        this.d = jSONArray;
    }

    public void run() {
        int n10;
        int n11;
        Object object;
        Object object2;
        int n12;
        Object object3;
        block6: {
            block5: {
                boolean bl2;
                object3 = new a();
                long l10 = this.a;
                ((HianalyticsBaseData)object3).put("total_time", l10);
                n12 = NetworkUtil.getNetworkType(this.b);
                l10 = n12;
                String string2 = "network_type";
                ((HianalyticsBaseData)object3).put(string2, l10);
                object2 = this.c.iterator();
                do {
                    n11 = object2.hasNext();
                    string2 = null;
                    n10 = 1;
                    if (n11 == 0) break block5;
                } while (!(bl2 = ((f)(object = (f)object2.next())).m()));
                object = h.a((f)object);
                ((HianalyticsBaseData)object3).put((LinkedHashMap)object);
                object2.remove();
                n12 = n10;
                break block6;
            }
            n12 = 0;
            object2 = null;
        }
        if (n12 == 0 && (n12 = ((ArrayList)(object2 = this.c)).size()) > 0) {
            object2 = this.c;
            n11 = ((ArrayList)object2).size() - n10;
            object2 = (f)((ArrayList)object2).get(n11);
            object = h.a((f)object2);
            ((HianalyticsBaseData)object3).put((LinkedHashMap)object);
            object = this.c;
            ((ArrayList)object).remove(object2);
        }
        if ((n12 = ((ArrayList)(object2 = this.c)).size()) > 0) {
            object2 = this.c.iterator();
            while ((n11 = object2.hasNext()) != 0) {
                object = (f)object2.next();
                object = h.a((f)object);
                JSONObject jSONObject = new JSONObject((Map)object);
                object = this.d;
                object.put((Object)jSONObject);
            }
        }
        if ((n12 = (object2 = this.d).length()) > 0) {
            object2 = this.d.toString();
            object = "failed_info";
            ((HianalyticsBaseData)object3).put((String)object, (String)object2);
        }
        object2 = new Object[n10];
        LinkedHashMap linkedHashMap = ((HianalyticsBaseData)object3).get();
        object2[0] = object = new JSONObject((Map)linkedHashMap);
        Logger.d("HaReportHelper", "grssdk report data to aiops is: %s", (Object[])object2);
        object2 = HianalyticsHelper.getInstance();
        object3 = ((HianalyticsBaseData)object3).get();
        ((HianalyticsHelper)object2).onEvent((LinkedHashMap)object3, "networkkit_grs");
    }
}

