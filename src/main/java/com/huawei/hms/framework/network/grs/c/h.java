/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONArray
 */
package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.g;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.json.JSONArray;

public class h {
    public static /* synthetic */ LinkedHashMap a(f f10) {
        return h.b(f10);
    }

    public static void a(ArrayList arrayList, long l10, JSONArray jSONArray, Context context) {
        Object object;
        int n10;
        if (context != null && arrayList != null && (n10 = arrayList.size()) > 0 && (n10 = (int)(((HianalyticsHelper)(object = HianalyticsHelper.getInstance())).isEnableReportNoSeed(context) ? 1 : 0)) != 0) {
            object = HianalyticsHelper.getInstance().getReportExecutor();
            g g10 = new g(l10, context, arrayList, jSONArray);
            object.submit(g10);
        }
    }

    private static LinkedHashMap b(f f10) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Object object = f10.d();
        Object object2 = "exception_name";
        String string2 = "error_code";
        if (object != null) {
            int n10 = ExceptionCode.getErrorCodeFromException((Exception)object);
            long l10 = n10;
            linkedHashMapPack.put(string2, l10);
            string2 = object.getClass().getSimpleName();
            linkedHashMapPack.put((String)object2, string2);
            object = StringUtils.anonymizeMessage(((Throwable)object).getMessage());
            object2 = "message";
            linkedHashMapPack.put((String)object2, (String)object);
        } else {
            long l11 = f10.b();
            linkedHashMapPack.put(string2, l11);
            int n11 = f10.c();
            long l12 = n11;
            linkedHashMapPack.put((String)object2, l12);
        }
        object = "domain";
        string2 = f10.k();
        object2 = new URL(string2);
        object2 = ((URL)object2).getHost();
        try {
            linkedHashMapPack.put((String)object, (String)object2);
        }
        catch (MalformedURLException malformedURLException) {
            object2 = "HaReportHelper";
            string2 = "report host MalformedURLException";
            Logger.w((String)object2, string2, malformedURLException);
        }
        long l13 = f10.g();
        linkedHashMapPack.put("req_start_time", l13);
        l13 = f10.f();
        linkedHashMapPack.put("req_end_time", l13);
        l13 = f10.h();
        linkedHashMapPack.put("req_total_time", l13);
        return linkedHashMapPack.getAll();
    }
}

